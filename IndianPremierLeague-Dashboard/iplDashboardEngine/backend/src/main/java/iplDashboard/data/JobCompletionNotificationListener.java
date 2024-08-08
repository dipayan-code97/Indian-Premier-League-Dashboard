package iplDashboard.data;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import iplDashboard.model.Team;

@Component
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {

    private static final Logger JOB_NOTIFICATION_LOGGER = LoggerFactory.getLogger(JobCompletionNotificationListener.class);
    private final EntityManager ENTITY_MANAGER;

    @Autowired
    public JobCompletionNotificationListener(EntityManager ENTITY_MANAGER) {
        this.ENTITY_MANAGER = ENTITY_MANAGER;
    }

    @Override
    @Transactional
    public void afterJob(JobExecution jobExecution) {
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            JOB_NOTIFICATION_LOGGER.info("!!! JOB FINISHED! Time to verify the results");
            Map<String, Team> teamInfoRegistry = fetchTeamInfoRegistry();
            updateTotalMatches(teamInfoRegistry);
            updateTotalWins(teamInfoRegistry);
            persistTeamInfo(teamInfoRegistry);
        }
    }

    private Map<String, Team> fetchTeamInfoRegistry() {
        List<Object[]> team1Results = fetchTeamResults("team1");
        List<Object[]> team2Results = fetchTeamResults("team2");
        List<Object[]> matchWinnerResults = fetchMatchWinnerResults();

        Map<String, Team> teamInfoRegistry = createTeamInfoRegistry(team1Results, team2Results, matchWinnerResults);

        return teamInfoRegistry;
    }

    private List<Object[]> fetchTeamResults(String teamColumnName) {
        return ENTITY_MANAGER.createQuery(
                        "select m." + teamColumnName + ", count(*) from Match m group by m." + teamColumnName, Object[].class)
                .getResultList();
    }

    private List<Object[]> fetchMatchWinnerResults() {
        return ENTITY_MANAGER.createQuery(
                        "select m.matchWinner, count(*) from Match m group by m.matchWinner", Object[].class)
                .getResultList();
    }

    private Map<String, Team> createTeamInfoRegistry(List<Object[]> team1Results,
                                                     List<Object[]> team2Results,
                                                     List<Object[]> matchWinnerResults) {
        Map<String, Team> teamInfoRegistry = new LinkedHashMap<>();

        // Process team1 results
        for (Object[] team1Result : team1Results) {
            String teamName = String.valueOf(team1Result[0]);
            long totalMatches = (long) team1Result[1];
            Team team = new Team(teamName);
            teamInfoRegistry.put(teamName, team);
        }

        // Process team2 results
        for (Object[] team2Result : team2Results) {
            String teamName = String.valueOf(team2Result[0]);
            long matchesCount = (long) team2Result[1];
            Team team = teamInfoRegistry.computeIfAbsent(teamName, key -> new Team(teamName));
            team.setTotalMatches(Math.toIntExact(team.getTotalMatches() + matchesCount));
        }

        // Process match winner results
        for (Object[] matchWinnerResult : matchWinnerResults) {
            String teamName = String.valueOf(matchWinnerResult[0]);
            long totalWins = (long) matchWinnerResult[1];
            Team team = teamInfoRegistry.get(teamName);
            if (team != null) {
                team.setTotalWins(Math.toIntExact(totalWins));
            }
        }
        return teamInfoRegistry;
    }

    private void updateTotalMatches(Map<String, Team> teamInfoRegistry) {
        teamInfoRegistry.values().forEach(teamRef -> {
            long totalMatches = teamInfoRegistry.entrySet().stream()
                    .filter(entry -> entry.getKey().equals(teamRef.getTeamName()))
                    .mapToLong(entry -> entry.getValue().getTotalMatches())
                    .sum();
            teamRef.setTotalMatches(Math.toIntExact(totalMatches));
        });
    }

    private void updateTotalWins(Map<String, Team> teamInfoRegistry) {
        teamInfoRegistry.values().forEach(teamRef -> {
            long totalWins = teamInfoRegistry.entrySet().stream()
                    .filter(entry -> entry.getKey().equals(teamRef.getTeamName()))
                    .mapToLong(entry -> entry.getValue().getTotalWins())
                    .sum();
            teamRef.setTotalWins(Math.toIntExact(totalWins));
        });
    }

    private void persistTeamInfo(Map<String, Team> teamInfoRegistry) {
        teamInfoRegistry.values().forEach(team -> ENTITY_MANAGER.persist(team));
        teamInfoRegistry.values().forEach(System.out::println);
    }
}
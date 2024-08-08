package iplDashboard.data;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.batch.item.ItemProcessor;

import iplDashboard.model.Match;

public class MatchDataProcessor implements ItemProcessor<OfficialMatch, Match> {

    private static final Logger MATCH_LOGGER = LoggerFactory.getLogger(MatchDataProcessor.class);

    @Override
    public Match process(final OfficialMatch officialMatch) throws Exception {
        Match match = new Match();
        match.setRegisteredMatchId(String.valueOf(Long.parseLong(officialMatch.getRegisteredMatchId())));
        match.setCity(officialMatch.getCity());
        match.setDate(LocalDate.parse(officialMatch.getMatchDate()));
        match.setPlayerOfMatch(officialMatch.getPlayerOfMatch());
        match.setVenue(officialMatch.getStadiumVenue());

        String tossSelection1 = "batting";
        String tossSelection2 = "fielding";

        // Determine first and second innings teams based on toss decision
        String firstInningsTeam;
        String secondInningsTeam;
        String tossDecision = officialMatch.getTossDecision();
        if (tossSelection1.equals(tossDecision)) {
            firstInningsTeam = officialMatch.getTossWinner();
            secondInningsTeam = officialMatch.getTossWinner().equals(officialMatch.getOfficialTeam1())
                    ? officialMatch.getOfficialTeam2() : officialMatch.getOfficialTeam1();
        } else if (tossSelection2.equals(tossDecision)) {
            secondInningsTeam = officialMatch.getTossWinner();
            firstInningsTeam = officialMatch.getTossWinner().equals(officialMatch.getOfficialTeam1())
                    ? officialMatch.getOfficialTeam2() : officialMatch.getOfficialTeam1();
        } else {
            throw new IllegalArgumentException("Invalid toss decision: " + tossDecision);
        }

        match.setTeam1(firstInningsTeam);
        match.setTeam2(secondInningsTeam);
        match.setTossWinner(officialMatch.getTossWinner());
        match.setTossDecision(tossDecision);
        match.setMatchWinner(officialMatch.getWinner());
        match.setMatchResult(officialMatch.getMatchResult());
        match.setResultMargin(officialMatch.getMatchResultantMargin());
        match.setOfficialUmpire1(officialMatch.getOfficialUmpire1());
        match.setOfficialUmpire2(officialMatch.getOfficialUmpire2());
        return match;
    }
}
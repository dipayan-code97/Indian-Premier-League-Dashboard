package iplDashboard.model;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String registeredTeamId;
    private String teamName;
    private int totalMatches;
    private int totalWins;
    @Transient
    private Set<Match> matches;

    public Team (String teamName) {
        this.teamName = teamName;
    }

    public Team (String registeredTeamId,
                String teamName,
                int totalMatches,
                int totalWins,
                Set<Match> matches) {
        this.registeredTeamId = registeredTeamId;
        this.teamName = teamName;
        this.totalMatches = totalMatches;
        this.totalWins = totalWins;
        this.matches = matches;
    }


    public String getRegisteredTeamId() {
        return this.registeredTeamId;
    }

    public String getTeamName() {
        return this.teamName;
    }

    public int getTotalMatches() {
        return this.totalMatches;
    }

    public int getTotalWins() {
        return this.totalWins;
    }

    public Set<Match> getMatches() {
        return this.matches;
    }

    public void setRegisteredTeamId(String registeredTeamId) {
        this.registeredTeamId = registeredTeamId;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public void setTotalMatches(int totalMatches) {
        this.totalMatches = totalMatches;
    }

    public void setTotalWins(int totalWins) {
        this.totalWins = totalWins;
    }

    public void setMatches(Set<Match> matches) {
        this.matches = matches;
    }

    @Override
    public boolean equals(Object objRef) {
        if (this == objRef) return true;
        if (!(objRef instanceof Team team)) return false;
        return (getTotalMatches() == team.getTotalMatches()
                && getTotalWins() == team.getTotalWins()
                && Objects.equals(getRegisteredTeamId(), team.getRegisteredTeamId())
                && Objects.equals(getTeamName(), team.getTeamName())
                && Objects.equals(getMatches(), team.getMatches()));
    }

    @Override
    public int hashCode() {
        return (Objects.hash(getRegisteredTeamId(),
                            getTeamName(),
                            getTotalMatches(),
                            getTotalWins(),
                            getMatches()));
    }

    @Override
    public String toString() {
        return ("Team{" +
                "RegisteredTeamId='" + registeredTeamId + '\'' +
                ", TeamName='" + teamName + '\'' +
                ", TotalMatches=" + totalMatches +
                ", TotalWins=" + totalWins +
                ", Matches=" + matches +
                '}');
    }
}

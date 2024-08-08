package iplDashboard.model;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Match {
    @Id
    private String registeredMatchId;
    private String city;
    private LocalDate date;
    private String playerOfMatch;
    private String venue;
    private String team1;
    private String team2;
    private String tossWinner;
    private String tossDecision;
    private String matchWinner;
    private String matchResult;
    private String resultMargin;
    private String officialUmpire1;
    private String officialUmpire2;

    public Match() {
    }

    public Match(String registeredMatchId,
                 String city,
                 LocalDate date,
                 String playerOfMatch,
                 String venue, String team1,
                 String team2, String tossWinner,
                 String tossDecision, String matchWinner,
                 String matchResult, String resultMargin,
                 String officialUmpire1, String officialUmpire2) {
        this.registeredMatchId = registeredMatchId;
        this.city = city;
        this.date = date;
        this.playerOfMatch = playerOfMatch;
        this.venue = venue;
        this.team1 = team1;
        this.team2 = team2;
        this.tossWinner = tossWinner;
        this.tossDecision = tossDecision;
        this.matchWinner = matchWinner;
        this.matchResult = matchResult;
        this.resultMargin = resultMargin;
        this.officialUmpire1 = officialUmpire1;
        this.officialUmpire2 = officialUmpire2;
    }

    public String getRegisteredMatchId() {
        return this.registeredMatchId;
    }

    public String getCity() {
        return this.city;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public String getPlayerOfMatch() {
        return this.playerOfMatch;
    }

    public String getVenue() {
        return this.venue;
    }

    public String getTeam1() {
        return this.team1;
    }

    public String getTeam2() {
        return this.team2;
    }

    public String getTossWinner() {
        return this.tossWinner;
    }

    public String getTossDecision() {
        return this.tossDecision;
    }

    public String getMatchWinner() {
        return this.matchWinner;
    }

    public String getMatchResult() {
        return this.matchResult;
    }

    public String getResultMargin() {
        return this.resultMargin;
    }

    public String getOfficialUmpire1() {
        return this.officialUmpire1;
    }

    public String getOfficialUmpire2() {
        return this.officialUmpire2;
    }

    public void setRegisteredMatchId(String registeredMatchId) {
        this.registeredMatchId = registeredMatchId;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setPlayerOfMatch(String playerOfMatch) {
        this.playerOfMatch = playerOfMatch;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public void setTossWinner(String tossWinner) {
        this.tossWinner = tossWinner;
    }

    public void setTossDecision(String tossDecision) {
        this.tossDecision = tossDecision;
    }

    public void setMatchWinner(String matchWinner) {
        this.matchWinner = matchWinner;
    }

    public void setMatchResult(String matchResult) {
        this.matchResult = matchResult;
    }

    public void setResultMargin(String resultMargin) {
        this.resultMargin = resultMargin;
    }

    public void setOfficialUmpire1(String officialUmpire1) {
        this.officialUmpire1 = officialUmpire1;
    }

    public void setOfficialUmpire2(String officialUmpire2) {
        this.officialUmpire2 = officialUmpire2;
    }

    @Override
    public boolean equals(Object objRef) {
        if (this == objRef) return true;
        if (!(objRef instanceof Match match)) return false;
        return (Objects.equals(getRegisteredMatchId(), match.getRegisteredMatchId())
                && Objects.equals(getCity(), match.getCity())
                && Objects.equals(getDate(), match.getDate())
                && Objects.equals(getPlayerOfMatch(), match.getPlayerOfMatch())
                && Objects.equals(getVenue(), match.getVenue())
                && Objects.equals(getTeam1(), match.getTeam1())
                && Objects.equals(getTeam2(), match.getTeam2())
                && Objects.equals(getTossWinner(), match.getTossWinner())
                && Objects.equals(getTossDecision(), match.getTossDecision())
                && Objects.equals(getMatchWinner(), match.getMatchWinner())
                && Objects.equals(getMatchResult(), match.getMatchResult())
                && Objects.equals(getResultMargin(), match.getResultMargin())
                && Objects.equals(getOfficialUmpire1(), match.getOfficialUmpire1())
                && Objects.equals(getOfficialUmpire2(), match.getOfficialUmpire2()));
    }

    @Override
    public int hashCode() {
        return (Objects.hash(getRegisteredMatchId(), getCity(),
                             getDate(), getPlayerOfMatch(),
                             getVenue(), getTeam1(), getTeam2(),
                             getTossWinner(), getTossDecision(),
                             getMatchWinner(), getMatchResult(),
                             getResultMargin(), getOfficialUmpire1(),
                             getOfficialUmpire2()));
    }

    @Override
    public String toString() {
        return ("Match{" +
                "RegisteredMatchId='" + registeredMatchId + '\'' +
                ", City='" + city + '\'' +
                ", Date=" + date +
                ", PlayerOfMatch='" + playerOfMatch + '\'' +
                ", Venue='" + venue + '\'' +
                ", Team1='" + team1 + '\'' +
                ", Team2='" + team2 + '\'' +
                ", TossWinner='" + tossWinner + '\'' +
                ", TossDecision='" + tossDecision + '\'' +
                ", MatchWinner='" + matchWinner + '\'' +
                ", MatchResult='" + matchResult + '\'' +
                ", ResultMargin='" + resultMargin + '\'' +
                ", OfficialUmpire1='" + officialUmpire1 + '\'' +
                ", OfficialUmpire2='" + officialUmpire2 + '\'' +
                '}');
    }
}

package iplDashboard.data;

import iplDashboard.entity.Pitch;

import java.util.Objects;

public class OfficialMatch {
    private String registeredMatchId;
    private String city;
    private String matchDate;
    private String stadiumVenue;
    private String playerOfMatch;
    private String neutralVenue;
    private String officialTeam1;
    private String officialTeam2;
    private String tossWinner;
    private String tossDecision;
    private String winner;
    private String matchFormat;
    private Pitch pitch;
    private String matchResult;
    private String matchResultantMargin;
    private String eliminator;
    private String officialMethod;
    private String officialUmpire1;
    private String officialUmpire2;

    public OfficialMatch() {
    }

    public OfficialMatch(String registeredMatchId,
                         String city, String matchDate,
                         String stadiumVenue, String playerOfMatch,
                         String neutralVenue, String officialTeam1,
                         String officialTeam2, String tossWinner,
                         String tossDecision, String winner,
                         String matchFormat, Pitch pitch,
                         String matchResult, String matchResultantMargin,
                         String eliminator, String officialMethod,
                         String officialUmpire1, String officialUmpire2) {
        this.registeredMatchId = registeredMatchId;
        this.city = city;
        this.matchDate = matchDate;
        this.stadiumVenue = stadiumVenue;
        this.playerOfMatch = playerOfMatch;
        this.neutralVenue = neutralVenue;
        this.officialTeam1 = officialTeam1;
        this.officialTeam2 = officialTeam2;
        this.tossWinner = tossWinner;
        this.tossDecision = tossDecision;
        this.winner = winner;
        this.matchFormat = matchFormat;
        this.pitch = pitch;
        this.matchResult = matchResult;
        this.matchResultantMargin = matchResultantMargin;
        this.eliminator = eliminator;
        this.officialMethod = officialMethod;
        this.officialUmpire1 = officialUmpire1;
        this.officialUmpire2 = officialUmpire2;
    }

    public String getRegisteredMatchId() {
        return this.registeredMatchId;
    }

    public String getCity() {
        return this.city;
    }

    public String getMatchDate() {
        return this.matchDate;
    }

    public String getStadiumVenue() {
        return this.stadiumVenue;
    }

    public String getPlayerOfMatch() {
        return this.playerOfMatch;
    }

    public String getNeutralVenue() {
        return this.neutralVenue;
    }

    public String getOfficialTeam1() {
        return this.officialTeam1;
    }

    public String getOfficialTeam2() {
        return this.officialTeam2;
    }

    public String getTossWinner() {
        return this.tossWinner;
    }

    public String getTossDecision() {
        return this.tossDecision;
    }

    public String getWinner() {
        return this.winner;
    }

    public String getMatchFormat() {
        return this.matchFormat;
    }

    public Pitch getPitch() {
        return this.pitch;
    }

    public String getMatchResult() {
        return this.matchResult;
    }

    public String getMatchResultantMargin() {
        return this.matchResultantMargin;
    }

    public String getEliminator() {
        return this.eliminator;
    }

    public String getOfficialMethod() {
        return this.officialMethod;
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

    public void setMatchDate(String matchDate) {
        this.matchDate = matchDate;
    }

    public void setStadiumVenue(String stadiumVenue) {
        this.stadiumVenue = stadiumVenue;
    }

    public void setPlayerOfMatch(String playerOfMatch) {
        this.playerOfMatch = playerOfMatch;
    }

    public void setNeutralVenue(String neutralVenue) {
        this.neutralVenue = neutralVenue;
    }

    public void setOfficialTeam1(String officialTeam1) {
        this.officialTeam1 = officialTeam1;
    }

    public void setOfficialTeam2(String officialTeam2) {
        this.officialTeam2 = officialTeam2;
    }

    public void setTossWinner(String tossWinner) {
        this.tossWinner = tossWinner;
    }

    public void setTossDecision(String tossDecision) {
        this.tossDecision = tossDecision;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public void setMatchFormat(String matchFormat) {
        this.matchFormat = matchFormat;
    }

    public void setPitch(Pitch pitch) {
        this.pitch = pitch;
    }

    public void setMatchResult(String matchResult) {
        this.matchResult = matchResult;
    }

    public void setMatchResultantMargin(String matchResultantMargin) {
        this.matchResultantMargin = matchResultantMargin;
    }

    public void setEliminator(String eliminator) {
        this.eliminator = eliminator;
    }

    public void setOfficialMethod(String officialMethod) {
        this.officialMethod = officialMethod;
    }

    public void setOfficialUmpire1(String officialUmpire1) {
        this.officialUmpire1 = officialUmpire1;
    }

    @Override
    public boolean equals(Object objRef) {
        if (this == objRef) return true;
        if (!(objRef instanceof OfficialMatch that)) return false;
        return (Objects.equals(getRegisteredMatchId(), that.getRegisteredMatchId())
                && Objects.equals(getCity(), that.getCity())
                && Objects.equals(getMatchDate(), that.getMatchDate())
                && Objects.equals(getStadiumVenue(), that.getStadiumVenue())
                && Objects.equals(getPlayerOfMatch(), that.getPlayerOfMatch())
                && Objects.equals(getNeutralVenue(), that.getNeutralVenue())
                && Objects.equals(getOfficialTeam1(), that.getOfficialTeam1())
                && Objects.equals(getOfficialTeam2(), that.getOfficialTeam2())
                && Objects.equals(getTossWinner(), that.getTossWinner())
                && Objects.equals(getTossDecision(), that.getTossDecision())
                && Objects.equals(getWinner(), that.getWinner())
                && Objects.equals(getMatchFormat(), that.getMatchFormat())
                && getPitch() == that.getPitch()
                && Objects.equals(getMatchResult(), that.getMatchResult())
                && Objects.equals(getMatchResultantMargin(), that.getMatchResultantMargin())
                && Objects.equals(getEliminator(), that.getEliminator())
                && Objects.equals(getOfficialMethod(), that.getOfficialMethod())
                && Objects.equals(getOfficialUmpire1(), that.getOfficialUmpire1())
                && Objects.equals(getOfficialUmpire2(), that.getOfficialUmpire2()));
    }

    @Override
    public int hashCode() {
        return (Objects.hash(getRegisteredMatchId(), getCity(),
                             getMatchDate(), getStadiumVenue(),
                             getPlayerOfMatch(), getNeutralVenue(),
                             getOfficialTeam1(), getOfficialTeam2(), getTossWinner(),
                             getTossDecision(), getWinner(), getMatchFormat(),
                             getPitch(), getMatchResult(), getMatchResultantMargin(),
                             getEliminator(), getOfficialMethod(),
                             getOfficialUmpire1(), getOfficialUmpire2()));
    }

    @Override
    public String toString() {
        return ("MatchInput{" +
                "RegisteredMatchId='" + registeredMatchId + '\'' +
                ", City='" + city + '\'' +
                ", MatchDate='" + matchDate + '\'' +
                ", StadiumVenue='" + stadiumVenue + '\'' +
                ", PlayerOfMatch='" + playerOfMatch + '\'' +
                ", NeutralVenue='" + neutralVenue + '\'' +
                ", Team1='" + officialTeam1 + '\'' +
                ", Team2='" + officialTeam2 + '\'' +
                ", TossWinner='" + tossWinner + '\'' +
                ", TossDecision='" + tossDecision + '\'' +
                ", Winner='" + winner + '\'' +
                ", MatchFormat='" + matchFormat + '\'' +
                ", Pitch=" + pitch +
                ", MatchResult='" + matchResult + '\'' +
                ", MatchResultantMargin='" + matchResultantMargin + '\'' +
                ", Eliminator='" + eliminator + '\'' +
                ", OfficialMethod='" + officialMethod + '\'' +
                ", OfficialUmpire1='" + officialUmpire1 + '\'' +
                ", OfficialUmpire2='" + officialUmpire2 + '\'' +
                '}');
    }
}

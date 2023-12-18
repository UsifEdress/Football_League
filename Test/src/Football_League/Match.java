package Football_League;

import java.time.LocalDate;
import java.util.*;

// do not forget to make an interface for this class
public class Match {
    private static int nextId = 1;


    private LocalDate matchDate;

    private final int matchId;
    private Team homeTeam;
    private Team awayTeam;
    private String stadium;
    private String referee;

    private boolean simulated = false;
    private int homeTeamScore;
    private int awayTeamScore;

    public Match(Team homeTeam, Team awayTeam, String stadium, String referee, int matchId, LocalDate matchDate) {
        this.matchId = nextId++;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.stadium = stadium;
        this.referee = referee;
        this.matchDate = matchDate;
    }


    public String toString() {
        return (homeTeam.getName() + " vs " + awayTeam.getName() +
                "\nStadium : " + stadium + "\nreferee : " + referee);
    }

    //getters
    public Team getHomeTeam() {
        return homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public String getStadium() {
        return stadium;
    }

    public String getReferee() {
        return referee;
    }

    public int getMatchId() {
        return matchId;
    }

    public LocalDate getMatchDate() {
        return matchDate;
    }

    public int getAwayTeamScore() {
        return awayTeamScore;
    }

    public int getHomeTeamScore() {
        return homeTeamScore;
    }

    public boolean isSimulated() {
        return simulated;
    }


    //setters
    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    public void setReferee(String referee) {
        this.referee = referee;
    }

    public void setMatchDate(LocalDate matchDate) {
        this.matchDate = matchDate;
    }

    public void setHomeTeamScore(int homeTeamScore) {
        this.homeTeamScore = homeTeamScore;
    }


    public void setAwayTeamScore(int awayTeamScore) {
        this.awayTeamScore = awayTeamScore;
    }


    //
    public void setSimulated(boolean simulated) {
        this.simulated = simulated;
    }




//    void Match_Simulation(Team t1, Team t2) {
//        t1.setGoalsScored(t1.Goals_assumption());
//        t2.setGoalsScored(t2.Goals_assumption());
//
//
//        t1.setGoalsReceived(t2.getGoalsScored());
//        t2.setGoalsReceived(t1.getGoalsScored());
//
//
//        t1.setTotalGoalsScored(t1.getGoalsScored());
//        t2.setTotalGoalsScored(t2.getGoalsScored());
//
//
//        t1.setTotalGoalsReceived(t1.getGoalsReceived());
//        t2.setTotalGoalsReceived(t2.getGoalsReceived());
//        if (t1.getGoalsScored() > t2.getGoalsScored()) {
//            t1.setNumberOfWins();
//            t1.setNumberOfPoints(3);
//            t2.setNumberOfLoses();
//        } else if (t1.getGoalsScored() < t2.getGoalsScored()) {
//            t1.setNumberOfLoses();
//            t2.setNumberOfWins();
//            t2.setNumberOfPoints(3);
//        } else {
//            t1.setNumberOfDraws();
//            t1.setNumberOfPoints(1);
//            t2.setNumberOfDraws();
//            t2.setNumberOfPoints(1);
//        }
//
//    }


}

package Football_League;
// do not forget to make an interface for this class
public class Match {

    private Team homeTeam;
    private Team awayTeam;
    private String stadium;
    private String referee;
    public Match(Team home_Team, Team away_Team , String Stadium, String referee) {
        homeTeam = home_Team;
        awayTeam = away_Team;
        this.stadium = Stadium;
        this.referee = referee;

    }
    public String toString() {
        return homeTeam.getName() + " vs " + awayTeam.getName() +
                " at " + stadium + " with referee " + referee;
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

    void Match_Simulation(Team t1 , Team t2){
        t1.setGoalsScored(t1.Goals_assumption());
        t2.setGoalsScored(t2.Goals_assumption());


        t1.setGoalsReceived(t2.getGoalsScored());
        t2.setGoalsReceived(t1.getGoalsScored());


        t1.setTotalGoalsScored(t1.getGoalsScored());
        t2.setTotalGoalsScored(t2.getGoalsScored());


        t1.setTotalGoalsReceived(t1.getGoalsReceived());
        t2.setTotalGoalsReceived(t2.getGoalsReceived());
        if(t1.getGoalsScored()>t2.getGoalsScored())
        {
            t1.setNumberOfWins();
            t1.setNumberOfPoints(3);
            t2.setNumberOfLoses();
        }
        else if (t1.getGoalsScored()<t2.getGoalsScored())
        {
            t1.setNumberOfLoses();
            t2.setNumberOfWins();
            t2.setNumberOfPoints(3);
        }
        else
        {
            t1.setNumberOfDraws();
            t1.setNumberOfPoints(1);
            t2.setNumberOfDraws();
            t2.setNumberOfPoints(1);
        }

    }

}

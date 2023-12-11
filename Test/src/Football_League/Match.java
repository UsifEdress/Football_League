package Football_League;
// do not forget to make an interface for this class
public class Match {
    public Match(Team home_Team, Team away_Team) {
        Home_Team = home_Team;
        Away_Team = away_Team;
    }

    Team Home_Team = new Team("Liverpool",1);
    Team Away_Team = new Team("Man-United",2);

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

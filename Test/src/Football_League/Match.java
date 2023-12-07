package Football_League;
// do not forget to make an interface for this class
public class Match {
    Team Home_Team = new Team("Liverpool",1);
    Team Away_Team = new Team("Man-United",1);

    void Match_Simulation(Team t1 , Team t2){
        t1.Goals_Scored= t1.Goals_assumption();
        t1.Total_Goals_Scored=t1.Total_Goals_Scored+t1.Goals_Scored;
        t2.Goals_Scored=t1.Goals_assumption();
        t2.Total_Goals_Scored=t2.Total_Goals_Scored+t2.Goals_Scored;
        t1.Total_Goals_Recieved=t1.Total_Goals_Recieved+t2.Goals_Scored;
        t2.Total_Goals_Recieved=t2.Total_Goals_Recieved+t1.Goals_Scored;
        if(t1.Goals_Scored>t2.Goals_Scored)
        {
            t1.Number_of_wins=t1.Number_of_wins+1;
            t1.Number_of_Points=t1.Number_of_Points+3;
            t2.Number_of_loses=t2.Number_of_loses+1;
        }
        else if (t1.Goals_Scored<t2.Goals_Scored)
        {
            t1.Number_of_loses=t1.Number_of_loses+1;
            t2.Number_of_wins=t2.Number_of_wins+1;
            t2.Number_of_Points=t2.Number_of_Points+3;
        }
        else
        {
            t1.Number_of_draws=t1.Number_of_draws+1;
            t1.Number_of_Points=t1.Number_of_Points+1;
            t2.Number_of_draws=t2.Number_of_draws+1;
            t1.Number_of_Points=t1.Number_of_Points+1;
        }

    }

}

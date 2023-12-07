package Football_League;

public class Main {
    public static void main(String[] args)
    {
        Team t1= new Team("",1);
        t1.enterTeamInformation();
        t1.displayTeamInformation();
        t1.updateTeam();
        t1.deletePlayerFromTeam();
        t1.displayTeamInformation();

    }

}
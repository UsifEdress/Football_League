package Football_League;

public class Main {
    public static void main(String[] args)
    {
        Team t = new Team("zanager", 1);

        Player p = new Player("ahe",19,9,26,80,80,"zanager");
        t.addPlayerToTeam(p);
        Player.searchPlayer();


    }

}
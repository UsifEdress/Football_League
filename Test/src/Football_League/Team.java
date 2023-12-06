package Football_League;
import java.util.*;
public class Team {
    GoalKeeper goalKeeper = new GoalKeeper() ;
    Defender [] defenders = new Defender[4];
    Midfielder [] midfielders = new Midfielder[3];
    Forward [] forwards = new Forward[3];

    Player [] players= new Player[11];
    private void Make_Team() {
        players[0] = goalKeeper;
        System.arraycopy(defenders, 0, players, 1, defenders.length);
        System.arraycopy(midfielders, 0, players, 5, midfielders.length);
        System.arraycopy(forwards, 0, players, 8, forwards.length);
    }
    String Team_Name;
    int Team_ID;

}

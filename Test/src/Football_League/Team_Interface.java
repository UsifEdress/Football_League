package Football_League;
import  java.util.*;

public interface Team_Interface {
    void enterTeamInformation();
    void updateTeam();
    void displayTeamInformation();
    void displayTeamPlayers();
    void displayTeamMatches();
    void addPlayerToTeam(Player player);
    void deletePlayerFromTeam();

}

package Football_League;
import java.util.*;
public class MatchManager {
    private List<Team> teams;
    private List<Match> matches;

    public MatchManager(List<Team> teams) {
        this.teams = teams;
        this.matches = new ArrayList<>();
        scheduleMatches();
    }

    private void scheduleMatches() {
        for (int i = 0; i < teams.size(); i++) {
            for (int j = i + 1; j < teams.size(); j++) {
                Team team1 = teams.get(i);
                Team team2 = teams.get(j);

                Match homeMatch = new Match(team1, team2);
                matches.add(homeMatch);

                Match awayMatch = new Match(team2, team1);
                matches.add(awayMatch);
            }
        }
    }
}

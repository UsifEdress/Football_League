package Football_League;

import java.util.ArrayList;
import java.util.*;

public class MatchManager {
    private List<Team> teams;
    private List<Match> matches;
    private List<String> referees;

    public MatchManager(List<Team> teams) {
        this.teams = teams;
        this.matches = new ArrayList<>();
        this.referees = initializeReferees();
        scheduleMatches();
    }

    private List<String> initializeReferees() {
        List<String> referees = new ArrayList<>();
        referees.add("Mohammed Hazem");
        referees.add("Abdallah Farouk");
        referees.add("Ahmed Nabil");
        referees.add("Essam Shadi");
        referees.add("Ghassan Al-Kassim");
        return referees;
    }

    public void updateTeams(List<Team> updatedTeams) {
        this.teams = updatedTeams;
        scheduleMatches();
    }

    public void scheduleMatches() {
        matches.clear();
        Random random = new Random();
        for (int i = 0; i < teams.size(); i++) {
            for (int j = i + 1; j < teams.size(); j++) {
                Team team1 = teams.get(i);
                Team team2 = teams.get(j);
                String selectedReferee = referees.get(random.nextInt(referees.size()));

                Match homeMatch = new Match(team1, team2, team1.getStadium(), selectedReferee);
                matches.add(homeMatch);
                selectedReferee = referees.get(random.nextInt(referees.size()));
                Match awayMatch = new Match(team2, team1, team1.getStadium(), selectedReferee);
                matches.add(awayMatch);
            }
        }
    }

    public List<Match> getMatches() {
        return matches;
    }
}



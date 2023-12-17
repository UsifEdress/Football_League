package Football_League;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.*;
import java.time.LocalDate;

public class MatchManager {
    private List<Team> teams;
    List<Match> matches;
    private List<String> referees;



    private static int matchIdCounter = 1;
    public static int getMatchIdCounter() {
        return matchIdCounter;
    }
    public static void setMatchIdCounter(int matchIdCounter) {
        MatchManager.matchIdCounter = matchIdCounter;
    }


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
    public String generateRandomReferee() {

        Random random = new Random();
        int randomIndex = random.nextInt(referees.size());

        return referees.get(randomIndex);
    }

    public void updateTeams(List<Team> updatedTeams) {
        this.teams = updatedTeams;
        scheduleMatches();
    }

    public void scheduleMatches() {
        matches.clear();
        Random random = new Random();
        int matchId = 1;

        LocalDate currentDate = LocalDate.now();
        for (int i = 0; i < teams.size(); i++) {
            for (int j = i + 1; j < teams.size(); j++) {
                Team team1 = teams.get(i);
                Team team2 = teams.get(j);
                String selectedReferee = referees.get(random.nextInt(referees.size()));

                Match homeMatch = new Match(team1, team2, team1.getStadium(), selectedReferee, matchId++, currentDate);
                matchIdCounter++;
                matches.add(homeMatch);

                selectedReferee = referees.get(random.nextInt(referees.size()));
                Match awayMatch = new Match(team2, team1, team2.getStadium(), selectedReferee, matchId++, currentDate.plusDays(1));
                matchIdCounter++;
                matches.add(awayMatch);
            }
            currentDate = currentDate.plusDays(2); // Increment the date for each new round
        }
    }
    public void displayMatchDetails(Match match) {
        System.out.println("Match Details:");
        System.out.println("Match ID: " + match.getMatchId());
        System.out.println("Date: " + match.getMatchDate());
        System.out.println("Teams: " + match.getHomeTeam().getName() + " vs " + match.getAwayTeam().getName());
        System.out.println("Stadium: " + match.getStadium());
        System.out.println("Referee: " + match.getReferee());
        System.out.println("------------------------");
    }


    public List<Match> getMatches() {
        return matches;
    }
    public void displayAllMatches() {
        System.out.println("All Matches:");

        for (int i = 0; i < matches.size(); i++) {
            Match match = matches.get(i);
            System.out.println("Match: " + (i + 1));
            System.out.println("Match ID: " + match.getMatchId());
            System.out.println("Date: " + match.getMatchDate());
            System.out.println("Teams: " + match.getHomeTeam().getName() + " vs " + match.getAwayTeam().getName());
            System.out.println("Stadium: " + match.getStadium());
            System.out.println("Referee: " + match.getReferee());
            System.out.println("------------------------");
        }
    }








}



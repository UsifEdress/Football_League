package Football_League;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class League implements Serializable {
    public List<Team> teams;


    private MatchManager matchManager;

    public League() {
        this.teams = new ArrayList<>();
    }

    public void addTeam(Team team) {
        teams.add(team);
    }


    public void displayLeagueInfo() {
        System.out.println("League Information:");
        for (Team team : teams) {
            team.displayTeamInformation();
        }
    }


//    public void simulateMatches() {
//        // Simulate matches between all pairs of teams
//        for (int i = 0; i < teams.size(); i++) {
//            for (int j = i + 1; j < teams.size(); j++) {
//                Match match = new Match(teams.get(i), teams.get(j));
//                match.Match_Simulation(teams.get(i), teams.get(j));
//            }
//        }
//    }

    // Display league standings based on points and goal difference

    //
    public void viewTeams() {
        System.out.println("Teams in the League:");
        int counter = 1;
        for (Team team : teams) {
            System.out.println(counter + ". " + team.getName());
            counter++;
        }


    }

    public void displayLeagueStandings() {
        Collections.sort(teams);

        System.out.printf("%-20s%-15s%-10s%-10s%-10s%-10s%n",
                "Team", "Played",  "Pts","GF", "GA", "GD");

        for (Team team : teams) {
            System.out.printf("%-20s%-15d%-10d%-10d%-10d%-10d%n",
                    team.getTeamName(),
                    team.getMatchesPlayed(),
                    team.getNumberOfPoints(),
                    team.getTotalGoalsScored(),
                    team.getTotalGoalsReceived(),
                    team.getGoalDifference());

        }
    }


    public void viewPlayers() {
        System.out.println("Players in the League:");

        char teamCounter = 'A';
        int playerCounter = 1; // Cumulative player counter for all teams

        for (Team team : teams) {
            System.out.println(teamCounter + ". " + team.getName());

            for (Player player : team.getPlayers()) {

                System.out.println("  " + playerCounter + ". " + player.getPlayerName());
                playerCounter++;
            }


            System.out.println();


            teamCounter++;
        }

    }


    public void displayAllPlayers() {
        System.out.println("All Players in the League:");

        int playerCounter = 1;
        for (Team team : teams) {
            System.out.println("Team: " + team.getName());

            for (Player player : team.getPlayers()) {
                System.out.println("  - " + playerCounter + ". " + player.getPlayerName() + " (ID: " + player.getID() + ")");
                playerCounter++;
            }
        }
        System.out.println();
    }


    public void searchPlayerByName(String playerName) {
        for (Team team : teams) {
            for (Player player : team.players) {
                if (player.getPlayerName().equalsIgnoreCase(playerName)) {
                    System.out.println("Player found:");
                    player.displayPlayerInformation();
                    return;
                }
            }
        }
        System.out.println("Player not found.");
    }

    public void searchPlayerByNameAndTeam(String playerName, String teamName) {
        for (Team team : teams) {
            if (team.getName().equalsIgnoreCase(teamName)) {
                for (Player player : team.players) {
                    if (player.getPlayerName().equalsIgnoreCase(playerName)) {
                        System.out.println("Player found:");
                        player.displayPlayerInformation();
                        return;
                    }
                }
                System.out.println("Player not found in the specified team.");
                return;
            }
        }
        System.out.println("Team not found.");
    }

}

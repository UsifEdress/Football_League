package Football_League;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.Serializable;
import java.util.*;

public class League implements Serializable {
    public List<Team> teams;

    private transient Scanner scanner = new Scanner(System.in);
    private MatchManager matchManager;

    public League() {
        this.teams = new ArrayList<>();
    }

    public void addTeam(Team team) {
        teams.add(team);
    }
    public void sortTeamsByPoints() {
        Collections.sort(teams);
    }

    public void sortTeamsByAverageAge() {
        teams.sort(new Comparator<Team>() {
            @Override
            public int compare(Team team1, Team team2) {
                return Double.compare(team1.calculateAverageAge(), team2.calculateAverageAge());
            }
        });
    }

    public void sortTeamsByGoals() {

        teams.sort(Comparator.comparingInt(Team::getTotalGoalsScored).reversed());
    }
    void sortTeamsByLeastGoalsReceived() {

        teams.sort(Comparator.comparingInt(Team::getTotalGoalsReceived));
    }
    void sortTeamsByMostGoalsScored() {
        teams.sort(Comparator.comparingInt(Team::getTotalGoalsScored).reversed());
    }

    public List<Player> sortPlayersGoals() {
        List<Player> allPlayers = new ArrayList<>();

        for (Team team : teams) {
            allPlayers.addAll(team.getPlayers());
        }


        allPlayers.sort((player1, player2) -> Integer.compare(player2.getGoalsScored(), player1.getGoalsScored()));

        return allPlayers;
    }

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
    public boolean resetLeague() {
        while (true) {
            System.out.println("Are you sure you want to reset the league? (y/n)");

            try {
                String userInput = scanner.nextLine();

                if (Objects.equals(userInput, "y") || Objects.equals(userInput, "Y")) {
                    resetTeams();
                    resetPlayers();
                    System.out.println("League reset successfully.");
                    return true;
                } else if (Objects.equals(userInput, "n") || Objects.equals(userInput, "N")) {
                    System.out.println("League reset canceled.");
                    return false;
                } else {
                    System.out.println("Invalid input. Please enter 'y' or 'n'.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter 'y' or 'n'.");
                scanner.next();
            }
        }
    }


    public void resetTeams() {
        for (Team team : teams) {
            team.resetStats();
        }
    }


    public void resetPlayers() {
        for (Team team : teams) {
            List<Player> players = team.getPlayers();
            for (Player player : players) {
                player.resetStats();
            }
        }
    }
}

package Football_League;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class League {
    public List<Team> teams;
    public ArrayList<String> Teams_list = new ArrayList<>();

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


    public void simulateMatches() {
        // Simulate matches between all pairs of teams
        for (int i = 0; i < teams.size(); i++) {
            for (int j = i + 1; j < teams.size(); j++) {
                Match match = new Match(teams.get(i), teams.get(j));
                match.Match_Simulation(teams.get(i), teams.get(j));
            }
        }
    }

    // Display league standings based on points and goal difference
    public void displayLeagueStandings() {
        System.out.println("League Standings:");

        // Sort teams based on points and goal difference
        teams.sort((team1, team2) -> {
            int pointsCompare = Integer.compare(team2.getNumberOfPoints(), team1.getNumberOfPoints());
            if (pointsCompare != 0) {
                return pointsCompare;
            }
            return Integer.compare(team2.getTotalGoalsScored() - team2.getTotalGoalsReceived(),
                    team1.getTotalGoalsScored() - team1.getTotalGoalsReceived());
        });

        // Display standings
        int position = 1;
        for (Team team : teams) {
            System.out.println(position + ". " + team.getName() +
                    " - Points: " + team.getNumberOfPoints() +
                    ", Goal Difference: " + (team.getTotalGoalsScored() - team.getTotalGoalsReceived()));
            position++;
        }
    }

    public void viewTeams() {
        System.out.println("Teams in the League:");
        int counter = 1;
        for (Team team : teams) {
            System.out.println(counter + ". " + team.getName());
            counter++;
        }
        System.out.println();
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


    // Display information for all matches in the league
    public void viewMatches() {
        System.out.println("Matches in the League:");
        // Assuming you have a Match class with a displayMatchInfo method
        for (Team team : teams) {
            team.displayTeamMatches();
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


    public void saveTeams() throws IOException {
        for (Team team : teams) {
            Files file = new Files(team.getName());
            file.WriteFiles((ArrayList<Player>) team.players);
        }
    }
    public void readTeams(ArrayList<String>team_list) throws IOException, ClassNotFoundException {
        for (String team : team_list) {
            Files file = new Files(team+".txt");
            ArrayList<Player> players = file.ReadFiles();
        }
    }
    public void saveTeamNames() throws IOException {
        Files file = new Files();

        for (Team team : teams) {
            Teams_list.add(team.getName());
        }
        file.WriteList(Teams_list);
    }

    public ArrayList<String> readTeamsNames() throws IOException, ClassNotFoundException {
        Files file = new Files();
         Teams_list =file.ReadList();
        return Teams_list;
    }
}

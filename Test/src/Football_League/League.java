package Football_League;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class League implements Serializable {
    public List<Team> teams;
    public ArrayList<String> Teams_list = new ArrayList<>();

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


//

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
                    ",  Goal Difference: " + (team.getTotalGoalsScored() - team.getTotalGoalsReceived()));
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


    public void saveTeams() throws IOException , NotSerializableException, FileNotFoundException {
        for (Team team : teams) {
            Files file = new Files(team.getName()+".txt");
            file.WriteFiles(team);
        }
    }
    public void readTeams(ArrayList<String>team_list) throws IOException, ClassNotFoundException , NotSerializableException , FileNotFoundException {
        teams.clear();
        for (String team : team_list) {
            Files file = new Files(team+".txt");
            Team Team = file.ReadFiles();
            teams.add(Team);
        }
    }
    public void saveTeamNames() throws IOException , NotSerializableException , FileNotFoundException{
        Files file = new Files();
        Teams_list.clear();
        for (Team team : teams) {
            Teams_list.add(team.getName());
        }
        file.WriteList(Teams_list);
    }

    public ArrayList<String> readTeamsNames() throws IOException, ClassNotFoundException , NotSerializableException , FileNotFoundException {
        Files file = new Files();
         Teams_list =file.ReadList();
        return Teams_list;
    }

    public void sdada()
    {
        int x = Team.calculateTotalTeams() + Teams_list.size();
        System.out.println("total teams :" + x);
    }



}

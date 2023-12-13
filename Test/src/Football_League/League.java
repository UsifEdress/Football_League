package Football_League;


import java.util.ArrayList;
import java.util.List;

public class League {
    public List<Team> teams;

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
    }



    public void viewPlayers() {
        System.out.println("Players in the League:");

        int teamCounter = 1;
        for (Team team : teams) {
            System.out.println(teamCounter + ". " + team.getName());
            team.displayTeamPlayersWithID();
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
    }


    // Display information for all matches in the league
    public void viewMatches() {
        System.out.println("Matches in the League:");
        // Assuming you have a Match class with a displayMatchInfo method
        for (Team team : teams) {
            team.displayTeamMatches();
        }
    }
}

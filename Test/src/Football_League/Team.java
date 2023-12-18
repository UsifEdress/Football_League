package Football_League;

import java.io.Serializable;
import java.util.*;

public class Team implements Team_Interface, Serializable , Comparable<Team>{
    // Attributes
    private String teamName;
    private int teamId;
    public List<Player> players;
    private Player captain;
    private List<Match> matches;

    private String stadium;
    private int totalGoalsScored = 0;
    private int totalGoalsReceived = 0;
    private int numberOfWins = 0;
    private int numberOfPoints = 0;
    private int numberOfLoses = 0;
    private int numberOfDraws = 0;



    private int matchesPlayed = 0;


    public double calculateAverageAge() {
        if (players == null || players.isEmpty()) {
            return 0.0;
        }

        double sumAge = 0;

        for (Player player : players) {
            sumAge += player.getAge();
        }

        return sumAge / players.size();
    }

    public double getAverageAge() {
        return calculateAverageAge();
    }

    public GoalKeeper getGK() {

        List<Player> players = getPlayers();


        for (Player player : players) {
            if (player instanceof GoalKeeper) {
                return (GoalKeeper) player;
            }
        }

        return null;
    }



    public static int totalTeams = 0;
    private transient Scanner scanner = new Scanner(System.in);


    // getters

    public String getTeamName() {
        return teamName;
    }


    public String getName() {
        return teamName;
    }

    public int getTeamId() {
        return teamId;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Player getCaptain() {
        return captain;
    }

    public int getTotalGoalsScored() {
        return totalGoalsScored;
    }

    public int getTotalGoalsReceived() {
        return totalGoalsReceived;
    }


    public int getNumberOfPoints() {
        return numberOfPoints;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public int getGoalDifference() {
        return getTotalGoalsScored() - getTotalGoalsReceived();
    }


    public String getStadium() {
        return stadium;
    }
    // Setters

    public void setTotalGoalsScored(int totalGoalsScored) {
        this.totalGoalsScored = totalGoalsScored;
    }

    public void setTotalGoalsReceived(int totalGoalsReceived) {
        this.totalGoalsReceived = totalGoalsReceived;
    }

    public void setNumberOfPoints(int numberOfPoints) {
        this.numberOfPoints = numberOfPoints;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public void setMatchesPlayed(int matchesPlayed) {
        this.matchesPlayed = matchesPlayed;
    }

    // Constructor

    public Team(String name, int teamId, String stadium) {
        this.teamName = name;
        this.teamId = teamId;
        this.stadium = stadium;
        this.players = new ArrayList<>();
        totalTeams++;
    }


    public void setCaptain(Player player) {
        captain = player;
    }


    public void updateTeamCaptain(Scanner scanner) {
        System.out.print("Enter the number of the player to be the new captain: ");
        int newCaptainNumber = scanner.nextInt();

        if (newCaptainNumber >= 1 && newCaptainNumber <= players.size()) {
            Player newCaptain = players.get(newCaptainNumber - 1);
            setCaptain(newCaptain);
            System.out.println("Player " + newCaptain.getPlayerName() + " is now the new captain.");
        } else {
            System.out.println("Invalid player selection. No change in captain.");
        }
    }



    @Override
    public void displayTeamInformation() {
        System.out.println("Team Information:");
        System.out.println("Name: " + teamName);
        System.out.println("Team ID: " + teamId);
        System.out.println("Team Stadium: " + stadium);


        System.out.println("Players:");
        for (Player player : players) {
            System.out.println("  - " + player.getPlayerName() + " (ID: " + player.getID() + ")");
        }
        if (captain != null) {
            System.out.println("Captain: " + captain.getPlayerName() + " (ID: " + captain.getID() + ")");
        } else {
            System.out.println("Captain: Not set");
        }
        System.out.println("Total Points: " + getNumberOfPoints());
        System.out.println("Total Goals: " + getTotalGoalsScored());

        System.out.println();
    }


    @Override
    public void displayTeamPlayers() {
        System.out.println("Team Players:");

        for (Player player : players) {
            String captainMark = player.equals(captain) ? " (C)" : "";
            System.out.println("Player Name: " + player.getPlayerName() + captainMark);
            System.out.println("Player ID: " + player.getID());
            System.out.println("Player Number: " + player.getNumber());
            System.out.println("Player Rank: " + player.getRank());
            System.out.println();
        }
    }


    public void displayTeamPlayersWithID() {
        System.out.println("Players:");

        int playerCounter = 1;
        for (Player player : players) {
            String captainMark = player.equals(captain) ? " (C)" : "";
            System.out.println("    " + playerCounter + ". " + player.getPlayerName() + " (ID: " + player.getID() + ")" + captainMark);
            playerCounter++;
        }
    }


    @Override
    public void addPlayerToTeam(Player player) {
        if (players == null) {
            players = new ArrayList<>();
        }

        players.add(player);

        System.out.println("Player " + player.getPlayerName() + " added to team " + teamName + " !");

        System.out.print("Do you want to make this player the captain? (y/n): ");
        Scanner scanner = new Scanner(System.in);
        if (scanner.next().equalsIgnoreCase("y")) {
            setCaptain(player);
            System.out.println(player.getPlayerName() + " is now the captain!");
        }
    }

    public void deletePlayer(int playerID) {
        Iterator<Player> iterator = players.iterator();
        while (iterator.hasNext()) {
            Player player = iterator.next();
            if (player.getID() == playerID) {
                iterator.remove();
                break;
            }
        }
    }

    @Override
    public int compareTo(Team otherTeam) {

        return Integer.compare(otherTeam.getNumberOfPoints(), this.getNumberOfPoints());
    }


    public void resetStats(){
        this.setTotalGoalsScored(0);
        this.setMatchesPlayed(0);
        this.setNumberOfPoints(0);
        this.setNumberOfWins(0);
        this.setNumberOfLoses(0);
        this.setNumberOfDraws(0);
        this.setTotalGoalsReceived(0);
    }
    public void setNumberOfWins(int num) {
        this.numberOfWins = num;
    }
    public void setNumberOfLoses(int num) {
        this.numberOfLoses= num;
    }
    public void setNumberOfDraws(int num) {
        this.numberOfDraws=num;}

}



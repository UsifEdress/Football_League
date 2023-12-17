package Football_League;

import java.io.Serializable;
import java.util.*;

public class Team implements Team_Interface, Serializable {
    // Attributes
    private String teamName;
    private int teamId;
    public List<Player> players;
    private Player captain;
    private List<Match> matches;





    private String stadium;
    private int goalsScored = 0;
    private int totalGoalsScored = 0;
    private int totalGoalsReceived = 0;
    private int numberOfWins = 0;
    private int numberOfPoints = 0;
    private int numberOfLoses = 0;
    private int numberOfDraws = 0;
    private int goalsReceived = 0;

//    private double averageAge = calculateAverageAge();

    public static int totalTeams = 0;
    private transient Scanner scanner = new Scanner(System.in);


    // getters

    public String getTeamName() {
        return teamName;
    }
//

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

    public int getGoalsScored() {
        return goalsScored;
    }

    public int getTotalGoalsScored() {
        return totalGoalsScored;
    }

    public int getTotalGoalsReceived() {
        return totalGoalsReceived;
    }

    public int getNumberOfWins() {
        return numberOfWins;
    }

    public int getNumberOfPoints() {
        return numberOfPoints;
    }

    public int getNumberOfLoses() {
        return numberOfLoses;
    }

    public int getNumberOfDraws() {
        return numberOfDraws;
    }

    public int getGoalsReceived() {
        return goalsReceived;
    }

//    public double getAverageAge() {
//        return averageAge;
//    }

    public String getStadium() {
        return stadium;
    }
    // Setters

    public void setGoalsScored(int goalsScored) {
        this.goalsScored = goalsScored;
    }

    public void setTotalGoalsScored(int totalGoalsScored) {
        this.totalGoalsScored = totalGoalsScored;
    }

    public void setTotalGoalsReceived(int totalGoalsReceived) {
        this.totalGoalsReceived = totalGoalsReceived;
    }

    public void setNumberOfWins() {
        this.numberOfWins++;
    }

    public void setNumberOfPoints(int numberOfPoints) {
        this.numberOfPoints = numberOfPoints;
    }

    public void setNumberOfLoses() {
        this.numberOfLoses++;
    }

    public void setNumberOfDraws() {
        this.numberOfDraws++;
    }

    public void setGoalsReceived(int goalsReceived) {
        this.goalsReceived = goalsReceived;
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
    public void enterTeamInformation() {


        System.out.println("Enter Team Information:");

        System.out.print("Team Name: ");
        teamName = scanner.nextLine();

        System.out.print("Team ID: ");
        teamId = scanner.nextInt();
        scanner.nextLine();


        System.out.print("Enter the number of players to add: ");
        int numberOfPlayers = scanner.nextInt();

        for (int i = 0; i < numberOfPlayers; i++) {
            int positionNumber;
            do {

                System.out.println("Choose a position:");
                System.out.println("1. Forward");
                System.out.println("2. Midfielder");
                System.out.println("3. Defender");
                System.out.println("4. Goalkeeper");


                System.out.println("Enter position for Player " + (i + 1) + ":");
                positionNumber = scanner.nextInt();
                scanner.nextLine();


            } while (positionNumber < 1 || positionNumber > 4);
            switch (positionNumber) {
                case 1:
                    Player player = new Forward();
                    System.out.println("Enter information for Player " + (i + 1) + ":");

                    System.out.print("Name: ");
                    player.setName(scanner.next());

                    System.out.print("Number: ");
                    player.setNumber(scanner.nextInt());

                    System.out.print("ID: ");
                    player.setPlayerID(scanner.nextInt());

                    System.out.print("Rank: ");
                    player.setRank(scanner.nextInt());


                    addPlayerToTeam(player);
                    break;
                case 2:
                    Player Mid = new Midfielder();
                    System.out.println("Enter information for Player " + (i + 1) + ":");

                    System.out.print("Name: ");
                    Mid.setName(scanner.next());

                    System.out.print("Number: ");
                    Mid.setNumber(scanner.nextInt());

                    System.out.print("ID: ");
                    Mid.setPlayerID(scanner.nextInt());

                    System.out.print("Rank: ");
                    Mid.setRank(scanner.nextInt());


                    addPlayerToTeam(Mid);
                    break;
                case 3:
                    Player def = new Defender();
                    System.out.println("Enter information for Player " + (i + 1) + ":");

                    System.out.print("Name: ");
                    def.setName(scanner.next());

                    System.out.print("Number: ");
                    def.setNumber(scanner.nextInt());

                    System.out.print("ID: ");
                    def.setPlayerID(scanner.nextInt());

                    System.out.print("Rank: ");
                    def.setRank(scanner.nextInt());


                    addPlayerToTeam(def);
                    break;
                case 4:
                    Player goalie = new GoalKeeper();
                    System.out.println("Enter information for Player " + (i + 1) + ":");

                    System.out.print("Name: ");
                    goalie.setName(scanner.next());

                    System.out.print("Number: ");
                    goalie.setNumber(scanner.nextInt());

                    System.out.print("ID: ");
                    goalie.setPlayerID(scanner.nextInt());

                    System.out.print("Rank: ");
                    goalie.setRank(scanner.nextInt());


                    addPlayerToTeam(goalie);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid position number.");


            }
        }
        System.out.println("Team information entered successfully!");
    }


    @Override
    public void updateTeam() {

        System.out.println("Update Team Information:");

        System.out.print("Do you want to update the team name? (y/n): ");
        if (scanner.next().equalsIgnoreCase("y")) {
            System.out.print("Enter new team name: ");
            teamName = scanner.next();
        }

        System.out.print("Do you want to update the team ID? (y/n): ");
        if (scanner.next().equalsIgnoreCase("y")) {
            System.out.print("Enter new team ID: ");
            teamId = scanner.nextInt();
        }

        System.out.print("Do you want to update the team captain? (y/n): ");
        if (scanner.next().equalsIgnoreCase("y")) {
            updateTeamCaptain(scanner);
        }

        System.out.println("Team information updated successfully!");
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

        // Prompt to make the player the captain
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
    public void deletePlayerFromTeam() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter player name to delete: ");
        String playerNameToDelete = scanner.nextLine().trim();

        System.out.print("Enter player ID to delete: ");
        int playerIdToDelete = scanner.nextInt();

        if (players != null) {
            Iterator<Player> iterator = players.iterator();
            while (iterator.hasNext()) {
                Player player = iterator.next();
                if (player.getPlayerName().equalsIgnoreCase(playerNameToDelete) && player.getID() == playerIdToDelete) {
                    if (player.equals(captain)) {
                        System.out.print("This player is the captain. Are you sure you want to delete the captain? (y/n): ");
                        String confirmation = scanner.next();
                        if (confirmation.equalsIgnoreCase("n")) {
                            System.out.println("Deletion canceled. The captain remains unchanged.");
                            return;
                        } else if (confirmation.equalsIgnoreCase("y")) {
                            iterator.remove();
                            System.out.println("Player " + playerNameToDelete + " (ID: " + playerIdToDelete + ") removed from the team!");


                            System.out.print("Enter the name of the new team captain: ");
                            String newCaptainName = scanner.next();


                            for (Player nextCaptain : players) {
                                if (nextCaptain.getPlayerName().equalsIgnoreCase(newCaptainName)) {
                                    captain = nextCaptain;
                                    System.out.println(nextCaptain.getPlayerName() + " is now the captain.");
                                    return;
                                }
                            }

                            System.out.println("Player with name " + newCaptainName + " not found. No change in captain.");
                        } else {
                            System.out.println("Invalid input. Deletion canceled. The captain remains unchanged.");
                            return;
                        }
                    }

                    iterator.remove();
                    System.out.println("Player " + playerNameToDelete + " (ID: " + playerIdToDelete + ") removed from the team!");
                    return;
                }
            }
        }

        System.out.println("Player " + playerNameToDelete + " (ID: " + playerIdToDelete + ") not found in the team.");
    }


    public static int calculateTotalTeams() {
        return totalTeams;


    }


    public int Goals_assumption() {
        return ((int) (Math.random() * 6 + 0));
    }

    //    public double calculateAverageAge()
//    {
//        double sumAge=0;
//        double numberOfPlayers = 0;
//        for (Player player : players) {
//            sumAge+=player.getAge();
//            numberOfPlayers=players.size();
//        }
//        sumAge /= numberOfPlayers;
//        return sumAge;
//    }


}



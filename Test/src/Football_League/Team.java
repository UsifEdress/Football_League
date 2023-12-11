package Football_League;
import java.util.*;
public class Team implements Team_Interface {
    // Attributes
    private String teamName;
    private int teamId;
    private List<Player> players;
    private Player captain;
    private List<Match> matches;
    private int goalsScored;
    private int totalGoalsScored;
    private int totalGoalsReceived;
    private int numberOfWins;
    private int numberOfPoints;
    private int numberOfLoses;
    private int numberOfDraws;
    private int goalsReceived;
    int Number_of_successful_passes;
    int Number_of_unsuccessful_passes;
    private static int totalTeams = 0;
    private Scanner scanner = new Scanner(System.in);

    public List<Team> myleagueTeams = new ArrayList<>();
    // getters

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
    // Setters

    public void setGoalsScored(int goalsScored) {
        this.goalsScored = goalsScored;
    }

    public void setTotalGoalsScored(int totalGoalsScored) {
        this.totalGoalsScored += totalGoalsScored;
    }

    public void setTotalGoalsReceived(int totalGoalsReceived) {
        this.totalGoalsReceived += totalGoalsReceived;
    }

    public void setNumberOfWins() {
        this.numberOfWins ++;
    }

    public void setNumberOfPoints(int numberOfPoints) {
        this.numberOfPoints += numberOfPoints;
    }

    public void setNumberOfLoses() {
        this.numberOfLoses ++;
    }

    public void setNumberOfDraws() {
        this.numberOfDraws ++;
    }

    public void setGoalsReceived(int goalsReceived) {
        this.goalsReceived = goalsReceived;
    }

    // Constructor
    //public Team(){}
    public Team(String name, int teamId) {
        this.teamName = name;
        this.teamId = teamId;
        this.players = new ArrayList<>();
        myleagueTeams.add(this);
    }



    GoalKeeper goalKeeper = new GoalKeeper();
    Defender[] defenders = new Defender[4];
    Midfielder[] midfielders = new Midfielder[3];
    Forward[] forwards = new Forward[3];

    Player[] players1 = new Player[11];

    private void Make_Team() {
        players1[0] = goalKeeper;
        System.arraycopy(defenders, 0, players1, 1, defenders.length);
        System.arraycopy(midfielders, 0, players1, 5, midfielders.length);
        System.arraycopy(forwards, 0, players1, 8, forwards.length);
        totalTeams++;
    }

    private void setCaptain(Player player) {
        captain = player;
    }


    private void updateTeamCaptain(Scanner scanner) {
        System.out.print("Enter the name of the new team captain: ");
        String newCaptainName = scanner.next();

        // Find the player with the specified name and set them as the captain
        for (Player player : players) {
            if (player.getPlayerName().equalsIgnoreCase(newCaptainName)) {
                captain = player;
                System.out.println(player.getPlayerName() + " is now the captain.");
                return;
            }
        }

        System.out.println("Player with name " + newCaptainName + " not found. No change in captain.");
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
            Player player = new Player();

            System.out.println("Enter information for Player " + (i + 1) + ":");

            System.out.print("Name: ");
            player.setName(scanner.next());

            System.out.print("Number: ");
            player.setNumber(scanner.nextInt());

            System.out.print("ID: ");
            player.setPlayerID(scanner.nextInt());

            System.out.print("Rank: ");
            player.setRank(scanner.nextInt());

            // Add the player to the team
            addPlayerToTeam(player);


            System.out.println("Team information entered successfully!");
        }
    }


    @Override
    public void updateTeam () {

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

        // Display players
//        System.out.println("Players:");
//        for (Player player : players) {
//            System.out.println("  - " + player.getPlayerName() + " (ID: " + player.getID() + ")");
//        }
//
//        // Display captain
//        if (captain != null) {
//            System.out.println("Captain: " + captain.getPlayerName() + " (ID: " + captain.getID() + ")");
//        } else {
//            System.out.println("Captain: Not set");
//        }
//
//        // Display matches
////            System.out.println("Matches:");  // Assuming you have a Match class
////            for (Match match : matches) {
////                System.out.println("  - " + match.getMatchInfo());
////            }
        //
        System.out.println("Goals Scored in match: " +goalsScored);
        System.out.println("Goals recieved in match: " +goalsReceived);
        // for testing
        System.out.println("Total Goals: " +totalGoalsScored);
        System.out.println("Total Points: " +numberOfPoints);
        System.out.println();
    }



    @Override
    public void displayTeamPlayers() {
        System.out.println("Team Players:");

        for (Player player : players) {
            System.out.println("Player Name: " + player.getPlayerName());
            System.out.println("Player ID: " + player.getID());
            System.out.println("Player Number: " + player.getNumber());
            System.out.println("Player Rank: " + player.getRank());
            System.out.println();
        }
    }



    @Override
    public void displayTeamMatches () {
        //No matches yet
    }

    @Override
    public void addPlayerToTeam(Player player) {
        if (players == null) {
            players = new ArrayList<>();
        }

        players.add(player);

        System.out.println("Player " + player.getPlayerName() + " added to the team!");

        // Prompt to make the player the captain
        System.out.print("Do you want to make this player the captain? (y/n): ");
        Scanner scanner = new Scanner(System.in);
        if (scanner.next().equalsIgnoreCase("y")) {
            setCaptain(player);
            System.out.println(player.getPlayerName() + " is now the captain!");
        }
    }



    @Override
    public void deletePlayerFromTeam() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter player name to delete: ");
        String playerNameToDelete = scanner.nextLine().trim();  // Trim to remove leading/trailing spaces

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

                            // Prompt for the next captain
                            System.out.print("Enter the name of the new team captain: ");
                            String newCaptainName = scanner.next();

                            // Find the player with the specified name and set them as the new captain
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







    @Override
    public int calculateTotalTeams () {
        return totalTeams;


    }

    public int Goals_assumption() {
        return ((int)(Math.random() * 6 + 0));
    }

    public void passes_calculation(Player p1){
        this.Number_of_successful_passes=this.Number_of_successful_passes+p1.Successful_passes;
        this.Number_of_unsuccessful_passes=this.Number_of_unsuccessful_passes+p1.miss_passes;
    }

}



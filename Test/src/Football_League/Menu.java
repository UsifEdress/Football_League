package Football_League;

import java.io.IOException;
import java.util.*;

public class Menu {
    private League league;
    private Scanner scanner;

    public Menu(League league) {
        this.league = league;
        this.scanner = new Scanner(System.in);
    }

    private void displayMenu() {
        System.out.println();
        System.out.println("Main Menu:");
        System.out.println("1. Players");
        System.out.println("2. Teams");
        System.out.println("3. Matches");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    public void start() throws IOException, ClassNotFoundException {
        System.out.println("Welcome to football league simulator !");
        int choice;
        do {
            displayMenu();

            try {
                choice = scanner.nextInt();
                scanner.nextLine();

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.nextLine();

                choice = -1;

            }


            switch (choice) {
                case 1:
                    handlePlayersMenu();
                    break;
                case 2:
                    handleTeamsMenu();
                    break;
                case 3:
                    handleMatchesMenu();
                    break;
                case 4:
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }

    private void handlePlayersMenu() {
        int choice;
        do {
            System.out.println();
            System.out.println("Players Menu:");
            System.out.println("1. Add Player");
            System.out.println("2. Display Player's info");
            System.out.println("3. Edit Player");
            System.out.println("4. Search for a Player");
            System.out.println("5. Delete a Player");
            System.out.println("6. Back");
            System.out.print("Enter your choice: ");
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.nextLine();
                choice = -1;

            }

            switch (choice) {
                case 1:
                    addPlayer();

                    break;
                case 2:
                    do {
                        System.out.println("Please enter the team of the player you want to display (type 0 to back)");
                        league.viewTeams();
                        int x = scanner.nextInt();
                        if (x == 0) {
                            return;
                        }
                        Team t = league.teams.get(x - 1);
                        System.out.println("Please enter the number of the player you want to display");
                        t.displayTeamPlayersWithID();
                        int y = scanner.nextInt();
                        Player p = t.players.get(y - 1);
                        p.displayPlayerInformation();

                        System.out.println("Do you want to display another player? (y/n)");
                        char decide = scanner.next().charAt(0);

                        if (decide != 'y') {
                            break;
                        }
                    } while (true);


                    break;

                case 3:
                    editPlayer();
                    break;
                case 4:
                    System.out.println("Search by: (type 0 to back)");
                    System.out.println("1. Player's name only");
                    System.out.println("2. Player's name and team's name");

                    int searchOption = scanner.nextInt();
                    if (searchOption == 0) {
                        return;
                    }

                    switch (searchOption) {
                        case 1:
                            System.out.println("Enter player's name:");
                            String playerName = scanner.next();
                            league.searchPlayerByName(playerName);
                            break;
                        case 2:
                            System.out.println("Enter player's name:");
                            String playerNameWithTeam = scanner.next();
                            System.out.println("Enter team's name:");
                            String teamName = scanner.next();
                            league.searchPlayerByNameAndTeam(playerNameWithTeam, teamName);
                            break;
                        default:
                            System.out.println("Invalid option. Please try again.");
                            break;
                    }
                    break;
                case 5:
                    System.out.println();
                    System.out.println("Please enter the team of the player you want to delete (type 0 to back)");
                    league.viewTeams();
                    int x = scanner.nextInt();
                    if (x == 0) {
                        return;
                    }
                    Team team = league.teams.get(x - 1);
                    System.out.println();
                    System.out.println("Please enter the player you want to delete");
                    team.displayTeamPlayersWithID();
                    int y = scanner.nextInt();
                    if (y >= 1 && y <= team.getPlayers().size()) {
                        Player playerToDelete = team.getPlayers().get(y - 1);
                        team.deletePlayer(playerToDelete.getID());

                        System.out.println("Player Named " + playerToDelete.getPlayerName() + " has been deleted from team " + team.getName());
                    } else {
                        System.out.println("Invalid player selection.");
                    }
                    break;


                case 6:
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);
    }

    private void handleTeamsMenu() throws IOException, ClassNotFoundException {
        int choice;
        do {
            System.out.println("Teams Menu:");
            System.out.println("1. Create Team");
            System.out.println("2. Edit Team");
            System.out.println("3. View Teams");
            System.out.println("4. Save Teams");
            System.out.println("5. Back");
            System.out.print("Enter your choice: ");
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.nextLine();
                choice = -1;

            }

            switch (choice) {
                case 1:
                    createTeam();
                    break;
                case 2:
                    editTeam();
                    break;
                case 3:
                    league.viewTeams();
                    break;
                case 4:
                    league.saveTeamNames();
                    league.saveTeams();
                    break;
                case 5:
                    league.readTeams(league.readTeamsNames());
                    break;
                case 6:

                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);
    }

    private void handleMatchesMenu() {
        int choice;
        do {
            System.out.println("Matches Menu:");
            System.out.println("1. View Matches");
            System.out.println("2. Edit Match");
            System.out.println("3. Back");
            System.out.print("Enter your choice: ");

            try {
                choice = scanner.nextInt();
                scanner.nextLine();

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.nextLine();
                choice = -1;

            }

            System.out.println();

            switch (choice) {
                case 1:
                    // View Matches logic
                    System.out.println("Viewing Matches...");
                    break;
                case 2:
                    // Edit Match logic
                    System.out.println("Editing Match...");
                    break;
                case 3:
                    System.out.println("Returning to main menu.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);
    }


    private void addPlayer() {
        System.out.println("Please enter the number of the team you want to assign the player to: (type 0 to back) ");
        league.viewTeams();
        int teamIndex = scanner.nextInt();
        scanner.nextLine();
        if (teamIndex == 0) {
            return;
        }
        Team team = league.teams.get(teamIndex - 1);


        int positionNumber;
        do {
            try {
                System.out.println("Choose a position for the player:");
                displayPossiblePositions();
                System.out.println("Enter the position number:");
                positionNumber = scanner.nextInt();

                if (positionNumber > 4 || positionNumber < 1) {
                    System.out.println("Please enter a valid number");
                }

                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid position number.");
                scanner.nextLine();  // Consume the invalid input
                positionNumber = -1;
            }


        } while (positionNumber < 1 || positionNumber > 4);


        Player player = createPlayerByPosition(positionNumber);


        player.enterPlayerInformation();
        while (isPlayerIdDuplicate(player.getID())) {
            System.out.println("Player with ID " + player.getID() + " already exists. Please choose a unique ID.");
            int newId = scanner.nextInt();
            if (!isPlayerIdDuplicate(newId)) {
                player.setPlayerID(newId);
                break;
            }
        }


        player.setTeam(team.getName());


        team.addPlayerToTeam(player);

        System.out.println("Player added successfully.");
        System.out.println();
    }

    public boolean isPlayerIdDuplicate(int playerId) {
        for (Team team : league.teams) {
            for (Player existingPlayer : team.getPlayers()) {
                if (existingPlayer.getID() == playerId) {
                    return true;
                }
            }
        }
        return false;
    }


    private void editPlayer() {
        System.out.println("Please enter the team of the player you want to edit (type 0 to back)");
        league.viewTeams();

        int x;
        x = scanner.nextInt();
        if (x == 0) {
            return;
        }
        Team t = league.teams.get(x - 1);
        System.out.println("Please enter the number of the player you want to edit");
        t.displayTeamPlayersWithID();
        int y;
        y = scanner.nextInt();
        Player p = t.players.get(y - 1);
        p.updatePlayerInformation();
        System.out.println("Player updated ");
        System.out.println();

    }

    private void createTeam() {
        System.out.println("Please enter team name . (type 0 to back)");
        String name;
        name = scanner.next();
        if (name.equals("0")) {
            return;
        }
        System.out.println("Please enter team Id .");
        int id;
        id = scanner.nextInt();
        Team team = new Team(name, id);
        league.teams.add(team);
        System.out.println("Team " + name + " Created");
        System.out.println();

    }

    private void editTeam() {
        // Implement team editing logic
        // You can call methods on the league object to perform the necessary actions
        // For example: league.editTeam();
        league.viewTeams();
        System.out.println("Choose Team Number");
        System.out.println();
    }


    private void editMatch() {
        // Implement match editing logic
        // You can call methods on the league object to perform the necessary actions
        // For example: league.editMatch();
        System.out.println("Editing Match...");
    }

    private void displayPossiblePositions() {
        System.out.println("1. Forward");
        System.out.println("2. Midfielder");
        System.out.println("3. Defender");
        System.out.println("4. Goalkeeper");
    }

    private Player createPlayerByPosition(int positionNumber) {
        switch (positionNumber) {
            case 1:
                return new Forward();
            case 2:
                return new Midfielder();
            case 3:
                return new Defender();
            case 4:
                return new GoalKeeper();
            default:
                throw new IllegalArgumentException("Invalid position number.");
        }
    }
}

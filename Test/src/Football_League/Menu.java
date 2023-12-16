package Football_League;

import java.io.IOException;
import java.util.*;

public class Menu {
    private League league;
    private Scanner scanner;

    private MatchManager matchManager;

    public Menu(League league) {
        this.league = league;
        this.matchManager = new MatchManager(league.teams);
        this.scanner = new Scanner(System.in);
    }

    private void displayMenu() {
        System.out.println();
        System.out.println("Main Menu:");
        System.out.println("1. Teams");
        System.out.println("2. Players");
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
                    handleTeamsMenu();
                    break;
                case 2:
                    handlePlayersMenu();
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
                    if (league.teams.isEmpty()) {
                        System.out.println("There are no Teams to add a player to !");
                        break;
                    }
                    addPlayer();

                    break;
                case 2:

                    displayPlayerInfo();

                    break;

                case 3:
                    if (league.teams.isEmpty() || league.teams.stream().allMatch(team -> team.getPlayers().isEmpty())) {
                        System.out.println("There are no players to edit !");
                        break;
                    }
                    editPlayer();
                    break;
                case 4:
                    if (league.teams.isEmpty() || league.teams.stream().allMatch(team -> team.getPlayers().isEmpty())) {
                        System.out.println("There are no players to view !");
                        break;
                    }
                    searchPlayer();
                    break;
                case 5:
                    if (league.teams.isEmpty() || league.teams.stream().allMatch(team -> team.getPlayers().isEmpty())) {
                        System.out.println("There are no players to delete !");
                        break;
                    }
                    deletePlayer();
                    break;


                case 6:
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);
    }

    private void addPlayer() {
        System.out.println("Please enter the number of the team you want to assign the player to: (type 0 to back) ");
        league.viewTeams();
        int teamIndex;

        while (true) {
            try {
                System.out.print("Enter team number: ");
                teamIndex = scanner.nextInt();

                if (teamIndex == 0) {
                    return;
                } else if (teamIndex > 0 && teamIndex <= league.teams.size()) {
                    break;
                } else {
                    System.out.println("Invalid input. Please enter a valid team number.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");


                scanner.nextLine();
            }
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
                scanner.nextLine();
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

        while (true) {

            x = scanner.nextInt();

            if (x == 0) {
                return;
            } else if (x > 0 && x <= league.teams.size()) {
                break;
            } else {
                System.out.println("Invalid input. Please enter a valid team number.");
            }
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

    private void deletePlayer() {
        System.out.println();
        System.out.println("Please enter the team of the player you want to delete (type 0 to go back)");
        league.viewTeams();

        int teamNumber;
        while (true) {
            try {
                System.out.print("Enter team number: ");
                teamNumber = scanner.nextInt();

                if (teamNumber == 0) {
                    return;
                } else if (teamNumber > 0 && teamNumber <= league.teams.size()) {
                    break;
                } else {
                    System.out.println("Invalid input. Please enter a valid team number.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");

                scanner.nextLine();
            }
        }


        Team team = league.teams.get(teamNumber - 1);


        team.displayTeamPlayersWithID();

        System.out.print("Enter the number of the player to delete (type 0 to go back): ");
        int playerNumberToDelete = scanner.nextInt();

        if (playerNumberToDelete == 0) {
            return;
        }

        if (playerNumberToDelete >= 1 && playerNumberToDelete <= team.getPlayers().size()) {
            Player playerToDelete = team.getPlayers().get(playerNumberToDelete - 1);

            if (playerToDelete.equals(team.getCaptain())) {
                System.out.print("This player is the captain. Are you sure you want to delete the captain? (y/n): ");
                String confirmation = scanner.next();

                if (confirmation.equalsIgnoreCase("n")) {
                    System.out.println("Deletion canceled. The captain remains unchanged.");
                    return;
                } else if (confirmation.equalsIgnoreCase("y")) {
                    team.deletePlayer(playerToDelete.getID());
                    System.out.println("Player named " + playerToDelete.getPlayerName() + " (ID: " + playerToDelete.getID() +
                            ") has been deleted from team " + team.getName());


                    team.displayTeamPlayersWithID();
                    System.out.print("Enter the number of the new captain: ");
                    int newCaptainNumber = scanner.nextInt();

                    if (newCaptainNumber >= 1 && newCaptainNumber <= team.getPlayers().size()) {
                        Player newCaptain = team.getPlayers().get(newCaptainNumber - 1);
                        team.setCaptain(newCaptain);
                        System.out.println(newCaptain.getPlayerName() + " is now the captain.");
                    } else {
                        System.out.println("Invalid selection for the new captain. The captain remains unchanged.");
                    }

                    return;
                } else {
                    System.out.println("Invalid input. Deletion canceled. The captain remains unchanged.");
                    return;
                }
            }

            team.deletePlayer(playerToDelete.getID());
            System.out.println("Player named " + playerToDelete.getPlayerName() + " (ID: " + playerToDelete.getID() +
                    ") has been deleted from team " + team.getName());
        } else {
            System.out.println("Invalid player selection.");
        }
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

    private void searchPlayer() {
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.println("Search by: (type 0 to back)");
                System.out.println("1. Player's name only");
                System.out.println("2. Player's name and team's name");

                int searchOption = scanner.nextInt();

                if (searchOption >= 0 && searchOption <= 2) {
                    validInput = true;

                    switch (searchOption) {
                        case 1:
                            System.out.println("Enter player's name:");
                            String playerName;
                            while (true) {
                                playerName = scanner.next();
                                if (validateName(playerName)) {
                                    break;
                                } else {
                                    System.out.println("Please enter a valid name.");
                                }
                            }

                            league.searchPlayerByName(playerName);
                            break;
                        case 2:
                            System.out.println("Enter team's name:");
                            String teamName;
                            while (true) {
                                teamName = scanner.next();
                                if (validateName(teamName)) {
                                    break;
                                } else {
                                    System.out.println("Please enter a valid name.");
                                }
                            }
                            System.out.println("Enter player's name:");
                            String playerNameWithTeam;
                            while (true) {
                                playerNameWithTeam = scanner.next();
                                if (validateName(playerNameWithTeam)) {
                                    break;
                                } else {
                                    System.out.println("Please enter a valid name.");
                                }
                            }

                            league.searchPlayerByNameAndTeam(playerNameWithTeam, teamName);
                            break;
                        case 0:
                            System.out.println("Returning to the main menu.");
                            break;
                        default:
                            System.out.println("Invalid option. Please try again.");
                            break;
                    }
                } else {
                    System.out.println("Invalid option. Please enter a valid search option.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.nextLine();
            }
        }
    }


    private void handleTeamsMenu() throws IOException, ClassNotFoundException {
        int choice;
        do {
            System.out.println();
            System.out.println("Teams Menu:");
            System.out.println("1. Create Team");
            System.out.println("2. Edit Team");
            System.out.println("3. View Teams");
            System.out.println("4. Save Teams");
            System.out.println("5. Display Team's Info");
            System.out.println("6. Delete a team");
            System.out.println("7. Back");
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
                    System.out.println("Total teams : " + Team.calculateTotalTeams());
                    break;
                case 4:
                    league.saveTeamNames();
                    league.saveTeams();
                    break;

                case 5:
                    displayTeamInfo();
                    break;
                case 6:
                    deleteTeam();
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 7);
    }

    private void createTeam() {
        System.out.println("Please enter team name. (type 0 to back)");
        String name;
        while (true) {
            name = scanner.nextLine();

            if (name.equals("0")) {
                return;
            }

            if (validateName(name)) {
                break;
            }

            System.out.println("Team name must be a non-empty string without numbers or other symbols.");
        }
        int id = 0;

        while (true) {
            try {
                System.out.println("Please enter team ID:");


                id = scanner.nextInt();


                if (id <= 0) {
                    System.out.println("Invalid input. ID should be greater than zero.");
                    continue;
                }


                if (isTeamIdDuplicate(id)) {
                    System.out.println("Team with ID " + id + " already exists. Please choose a unique ID.");
                    continue;
                }


                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer for team ID.");


                scanner.nextLine();
            }
        }
        scanner.nextLine();
        String stadium;
        while (true) {
            try {
                System.out.println("Please enter team Stadium:");

                stadium = scanner.nextLine();

                if (validateName(stadium)) {
                    break;
                } else {
                    System.out.println("Invalid input for team stadium. Make sure it is a non-empty string without numbers or other symbols.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid name for team stadium.");
                scanner.nextLine();
            }
        }


        Team team = new Team(name, id, stadium);
        league.teams.add(team);

        System.out.println("Team " + name + " Created");
        matchManager.updateTeams(league.teams);

        System.out.println();

    }

    private void editTeam() {
        System.out.println();
        System.out.println("Please enter the number of the team you want to edit: ");
        league.viewTeams();
        int teamNum;
        while (true) {
            try {
                System.out.println("Enter your choice: ");
                teamNum = scanner.nextInt();
                if (teamNum == 0) {
                    return;
                } else if (teamNum > 0 && teamNum <= league.teams.size()) {
                    break;
                } else {
                    System.out.println("Invalid input. Please enter a valid team number.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");

                scanner.nextLine();
            }
        }
        Team team = league.teams.get(teamNum - 1);
        updateTeam(team);
    }

    public void updateTeam(Team team) {
        System.out.println("Update Team Information:");


        while (true) {
            try {
                System.out.print("Do you want to update the team name? (y/n): ");
                String updateTeamName = scanner.next().toLowerCase();
                if ("y".equals(updateTeamName)) {

                    scanner.nextLine();

                    System.out.print("Enter new team name: ");
                    String teamName = scanner.nextLine();

                    if (validateName(teamName)) {
                        team.setTeamName(teamName);
                        break;
                    } else {
                        System.out.println("Team name must be a non-empty string without numbers or other symbols.");
                    }


                } else if ("n".equals(updateTeamName)) {
                    break;
                } else {
                    System.out.println("Invalid input. Please enter 'y' for yes or 'n' for no.");
                }
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
                scanner.nextLine();
            }
        }


        while (true) {
            try {
                System.out.print("Do you want to update the team ID? (y/n): ");
                String updateTeamId = scanner.next().toLowerCase();
                if ("y".equals(updateTeamId)) {
                    while (true) {
                        try {

                            System.out.print("Enter new team ID: ");
                            int id = scanner.nextInt();
                            if (id <= 0) {
                                System.out.println("Invalid input. ID should be greater than zero.");
                                continue;
                            }


                            if (isTeamIdDuplicate(id)) {
                                System.out.println("Team with ID " + id + " already exists. Please choose a unique ID.");
                                continue;
                            }
                            team.setTeamId(id);
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a valid integer for team ID.");
                            scanner.nextLine();
                        }
                    }
                    break;
                } else if ("n".equals(updateTeamId)) {
                    break;
                } else {
                    System.out.println("Invalid input. Please enter 'y' for yes or 'n' for no.");
                }
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
                scanner.nextLine();
            }
        }
        while (true) {
            try {
                System.out.print("Do you want to update the team stadium? (y/n): ");
                String updateTeamStadium = scanner.next().toLowerCase();
                if ("y".equals(updateTeamStadium)) {
                    scanner.nextLine();

                    System.out.print("Enter new team stadium: ");
                    String teamStadium = scanner.nextLine();

                    if (validateName(teamStadium)) {
                        team.setStadium(teamStadium);
                        break;
                    } else {
                        System.out.println("Stadium name must be a non-empty string without numbers or other symbols.");
                    }
                } else if ("n".equals(updateTeamStadium)) {
                    break;
                } else {
                    System.out.println("Invalid input. Please enter 'y' for yes or 'n' for no.");
                }
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
                scanner.nextLine();
            }

        }


        while (true) {
            try {
                System.out.print("Do you want to update the team captain? (y/n): ");
                String updateTeamCaptain = scanner.next().toLowerCase();
                if ("y".equals(updateTeamCaptain)) {
                    team.displayTeamPlayers();
                    team.updateTeamCaptain(scanner);
                    break;
                } else if ("n".equals(updateTeamCaptain)) {
                    break;
                } else {
                    System.out.println("Invalid input. Please enter 'y' for yes or 'n' for no.");
                }
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
                scanner.nextLine();
            }
        }

        System.out.println("Team information updated successfully!");
    }


    private boolean isTeamIdDuplicate(int id) {
        for (Team team : league.teams) {
            if (team.getTeamId() == id) {
                return true;
            }
        }
        return false;
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

                    displayTeamMatches();

                    break;
                case 2:

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


    private void editMatch() {
        // Implement match editing logic
        // You can call methods on the league object to perform the necessary actions
        // For example: league.editMatch();
        System.out.println("Editing Match...");
    }

    private boolean validateName(String name) {
        return !name.trim().isEmpty() && name.matches("[a-zA-Z]+");
    }

    public void teamPlayers() {
        System.out.println("View Team's Players");


        league.viewTeams();


        Team teamSelected = null;
        while (true) {
            try {
                System.out.print("Enter team number to view players (type 0 to go back): ");
                int teamChoice = scanner.nextInt();

                if (teamChoice == 0) {
                    System.out.println("Returning to the main menu.");
                    return;
                } else if (teamChoice > 0 && teamChoice <= league.teams.size()) {
                    teamSelected = league.teams.get(teamChoice - 1);
                    break;
                } else {
                    System.out.println("Invalid input. Please enter a valid team number.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer for team number.");
                scanner.nextLine();
            }
        }


        if (teamSelected != null) {
            System.out.println("Players of " + teamSelected.getName() + ":");
            teamSelected.displayTeamPlayers();


            while (true) {
                System.out.print("Do you want to choose another team? (y/n): ");
                String chooseAnotherTeam = scanner.next().toLowerCase();

                if ("y".equals(chooseAnotherTeam)) {

                    teamPlayers();
                    return;
                } else if ("n".equals(chooseAnotherTeam)) {
                    System.out.println("Returning to the main menu.");
                    return;
                } else {
                    System.out.println("Invalid input. Please enter 'y' for yes or 'n' for no.");
                }
            }
        }
    }

    public void displayTeamMatches() {
        System.out.println("Select a team to view matches:");

        league.viewTeams();

        System.out.print("Enter the number of the team: ");
        System.out.println();
        int teamNumber = scanner.nextInt();

        if (teamNumber >= 1 && teamNumber <= league.teams.size()) {
            Team selectedTeam = league.teams.get(teamNumber - 1);
            System.out.println("Matches for Team: " + selectedTeam.getName());

            boolean teamFound = false;

            for (Match match : matchManager.getMatches()) {
                if (match.getHomeTeam().equals(selectedTeam) || match.getAwayTeam().equals(selectedTeam)) {

                    teamFound = true;


                    String homeAwayIndication = match.getHomeTeam().equals(selectedTeam) ? "(Home)" : "(Away)";
                    System.out.println(match + " " + homeAwayIndication);
                }
            }

            if (!teamFound) {
                System.out.println("No matches found for Team: " + selectedTeam.getName());
            }
        } else {
            System.out.println("Invalid team selection.");
        }
    }

    private void displayPlayerInfo() {
        do {
            if (league.teams.isEmpty() || league.teams.stream().allMatch(team -> team.getPlayers().isEmpty())) {
                System.out.println("There are no players to display !");
                break;
            }
            System.out.println("Please enter the team of the player you want to display (type 0 to back)");
            league.viewTeams();
            int x;
            while (true) {

                x = scanner.nextInt();

                if (x == 0) {
                    return;
                } else if (x > 0 && x <= league.teams.size()) {
                    break;
                } else {
                    System.out.println("Invalid input. Please enter a valid team number.");
                }
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
    }

    private void displayTeamInfo() {
        do {
            if (league.teams.isEmpty()) {
                System.out.println("There are no Teams to display !");
                break;
            }
            System.out.println("Please enter the team you want to display (type 0 to back)");
            league.viewTeams();
            int x;
            while (true) {

                x = scanner.nextInt();

                if (x == 0) {
                    return;
                } else if (x > 0 && x <= league.teams.size()) {
                    break;
                } else {
                    System.out.println("Invalid input. Please enter a valid team number.");
                }
            }
            Team t = league.teams.get(x - 1);
            t.displayTeamInformation();


            System.out.println("Do you want to display another team? (y/n)");
            char decide = scanner.next().charAt(0);

            if (decide != 'y') {
                break;
            }
        } while (true);
    }

    private void deleteTeam() {
        System.out.println();
        System.out.println("Please enter the team of the team you want to delete (type 0 to go back)");
        league.viewTeams();

        int teamNumber;
        while (true) {
            try {
                System.out.print("Enter team number: ");
                teamNumber = scanner.nextInt();

                if (teamNumber == 0) {
                    return;
                } else if (teamNumber > 0 && teamNumber <= league.teams.size()) {
                    break;
                } else {
                    System.out.println("Invalid input. Please enter a valid team number.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");

                scanner.nextLine();
            }
        }

        Team teamToDelete = league.teams.get(teamNumber - 1);

        System.out.println("Are you sure you want to delete the team " + teamToDelete.getName() + "? , all players of this team will be deleted (y/n): ");
        String confirmation = scanner.next();

        if (confirmation.equalsIgnoreCase("y")) {
            league.teams.remove(teamToDelete);
            matchManager.updateTeams(league.teams);
            System.out.println("Team " + teamToDelete.getName() + " has been deleted.");
        } else {
            System.out.println("Deletion canceled. The team remains unchanged.");
        }
    }

}

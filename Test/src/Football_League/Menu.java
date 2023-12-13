package Football_League;
import java.util.Scanner;

public class Menu {
    private League league;
    private Scanner scanner;

    public Menu(League league) {
        this.league = league;
        this.scanner = new Scanner(System.in);
    }

    private void displayMenu() {
        System.out.println("1. Add Player");
        System.out.println("2. Create Team");
        System.out.println("3. View Teams");
        System.out.println("4. View Team Players");
        System.out.println("5. View Matches");
        System.out.println("6. Edit Player");
        System.out.println("7 Edit Team");
        System.out.println("8. Edit Match");
        System.out.println("9. Exit");
        System.out.print("Enter your choice: ");
    }

    public void startMenu() {
        System.out.println("Welcome to football league simulator");
        int choice;
        do {
            displayMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addPlayer();
                    break;
                case 2:
                    createTeam();
                    break;
                case 3:

                    league.viewTeams();
                    break;
                case 4:

                    league.viewPlayers();
                    break;
                case 5:

                    league.viewMatches();
                    break;
                case 6:

                    editPlayer();
                    break;
                case 7:

                    editTeam();
                    break;

                case 8:

                    editMatch();
                    break;
                case 9:
                    System.out.println("Exiting the Football League. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 9.");
            }

        } while (choice != 9);
    }

    private void addPlayer() {
        System.out.println("Please Enter the number of the team you want to assign the player to ");
        league.viewTeams();
        int x;
        x = scanner.nextInt();
        Team team = league.teams.get(x - 1);

        Player p = new Player();
        p.enterPlayerInformation();
        p.team = team.getName();
        System.out.println("Player " + p.getPlayerName() + " Added to " + p.getTeamName());
        team.addPlayerToTeam(p);
    }
    private void createTeam() {
        System.out.println("Please enter team name .");
        String name;
        name = scanner.next();
        System.out.println("Please enter team Id .");
        int id;
        id = scanner.nextInt();
        Team team = new Team(name , id);
        league.teams.add(team);
        System.out.println("Team " + name + " Created");

    }

    private void editPlayer() {
        System.out.println("Please enter the team of the player you want to edit");
        league.viewTeams();
        int x;
        x = scanner.nextInt();
        Team t = league.teams.get(x - 1);
        System.out.println("Please enter the number of the player you want to edit");
        t.displayTeamPlayersWithID();
        int y;
        y = scanner.nextInt();
        Player p = t.players.get(y-1);
        p.updatePlayerInformation();
        System.out.println("Player updated ");

    }
    private void editTeam() {
        // Implement team editing logic
        // You can call methods on the league object to perform the necessary actions
        // For example: league.editTeam();
        System.out.println("Editing Team...");
    }



    private void editMatch() {
        // Implement match editing logic
        // You can call methods on the league object to perform the necessary actions
        // For example: league.editMatch();
        System.out.println("Editing Match...");
    }


}

package Football_League;

import java.util.* ;
public class Player implements Player_Interface {

    private String Player_Name;
    private int Player_ID;
    private int Player_Number;
    private int Player_Age;
    private int Player_Score;
    private float Player_Rank;

    public enum position {Goalkeeper, defender, midfielder, forward};
    public position player_position;
    public String team;

    public int Tackling_number;
    public int Successful_passes;
    public int miss_passes;
    public int Number_Assists;
    public int Number_Goals;
    public int Number_Shots;
    public int Total_Tackling_number;
    public int Total_Successful_passes;
    public int Total_miss_passes;
    public int Total_Number_Assists;
    public int Total_Number_Goals;
    public int Total_Number_Shots;

    /////////////////////////////////////////////////////////////////

    public Player() {
    }

    public Player(String name, int player_ID, int player_Number, int player_Age, int player_Score, int player_Rank, String team) {
        this.Player_Name = name;
        Player_ID = player_ID;
        Player_Number = player_Number;
        Player_Age = player_Age;
        Player_Score = player_Score;
        Player_Rank = player_Rank;
        this.team = team;
    }

    //////////////////////////////////////////////////////////////////////////
    public void enterPlayerInformation() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Enter player name: ");
                String enteredName = scanner.nextLine();
                validateString(enteredName);
                this.Player_Name = enteredName;
                break;
            } catch (IllegalArgumentException ex) {
                System.out.println("Invalid input for player name. " + ex.getMessage());
            } finally {

            }
        }
        while (true) {
            try {
                System.out.print("Enter player ID: ");
                int enteredID = scanner.nextInt();

                validatePositiveNumber(enteredID);

                this.Player_ID = enteredID;
                break;
            } catch (InputMismatchException | IllegalArgumentException ex) {
                System.out.println("Invalid input for player ID. " + ex.getMessage());
            } finally {
                scanner.nextLine();
            }
        }
        while (true) {
            try {
                System.out.print("Enter player Number: ");
                int enteredAge = scanner.nextInt();
                validateTwoDigits(enteredAge);
                this.Player_Number = enteredAge;
                break;
            } catch (InputMismatchException | IllegalArgumentException ex) {
                System.out.println("Invalid input for player Number. " + ex.getMessage());
            } finally {
                scanner.nextLine();
            }
        }
        while (true) {
            try {
                System.out.print("Enter player Age: ");
                int enteredAge = scanner.nextInt();
                validateAge(enteredAge);
                this.Player_Age = enteredAge;
                break;
            } catch (InputMismatchException | IllegalArgumentException ex) {
                System.out.println("Invalid input for player Age. " + ex.getMessage());
            } finally {
                scanner.nextLine();
            }
        }
        while (true) {
            try {
                System.out.print("Enter player Score: ");
                int enteredScore = scanner.nextInt();
                validatescore(enteredScore);
                this.Player_Number = enteredScore;
                break;
            } catch (InputMismatchException | IllegalArgumentException ex) {
                System.out.println("Invalid input for player score. " + ex.getMessage());
            } finally {
                scanner.nextLine();
            }
        }
        while (true) {
            try {
                System.out.print("Enter player rank: ");
                float enteredrank = scanner.nextFloat();
                validaterank(enteredrank);
                this.Player_Rank = enteredrank;
                break;
            } catch (InputMismatchException | IllegalArgumentException ex) {
                System.out.println("Invalid input for player rank. " + ex.getMessage());
            } finally {
                scanner.nextLine();
            }
        }
//        System.out.print("Enter player team: ");
//        this.team = scanner.nextLine();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void displayPlayerInformation() {
        System.out.println("Player Information:");
        System.out.println("Name: " + this.Player_Name);
        System.out.println("ID: " + this.Player_ID);
        System.out.println("Number: " + this.Player_Number);
        System.out.println("Age: " + this.Player_Age);
        System.out.println("Score: " + this.Player_Score);
        System.out.println("Team: " + this.team);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void updatePlayerInformation() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter new player name (press Enter to keep the current name): ");
        String newName = scanner.nextLine();
        if (!newName.isEmpty()) {
            while (true) {
                try {
                    validateString(newName);
                    this.Player_Name = newName;
                    break;
                } catch (InputMismatchException | IllegalArgumentException ex) {
                    System.out.println("Invalid input for player Name. " + ex.getMessage());
                } finally {
//                    scanner.nextLine();
                }
            }
        }
        ///////////////////////////////
        System.out.print("Enter new player ID (press 0 to keep the current ID): ");

        while (true) {
            try {

                int enteredID = scanner.nextInt();
                if (enteredID == 0) {
                    break;
                }
                validatePositiveNumber(enteredID);

                this.Player_ID = enteredID;
                break;
            } catch (InputMismatchException | IllegalArgumentException ex) {
                System.out.println("Invalid input for player ID. " + ex.getMessage());
            } finally {
//                    scanner.nextLine();
            }
        }

        /////////////////////////////
        System.out.print("Enter new player number (press 0 to keep the current number): ");


        while (true) {
            try {

                int enteredAge = scanner.nextInt();
                if (enteredAge == 0) {
                    break;
                }
                validateTwoDigits(enteredAge);
                this.Player_Number = enteredAge;
                break;
            } catch (InputMismatchException | IllegalArgumentException ex) {
                System.out.println("Invalid input for player Number. " + ex.getMessage());
            } finally {
//                    scanner.nextLine();
            }
        }

        ////////////////////////////////////
        scanner.nextLine();
        System.out.print("Enter new player team (press Enter to keep the current team): ");
        String newTeam = scanner.nextLine();
        if (!newTeam.isEmpty()) {
            this.team = newTeam;
        }
        //////////////////////////////////////
        System.out.print("Enter new player age (press 0 to keep the current age): ");


        while (true) {
            try {

                int enteredAge = scanner.nextInt();
                if (enteredAge == 0) {
                    break;
                }
                validateAge(enteredAge);
                this.Player_Age = enteredAge;
                break;
            } catch (InputMismatchException | IllegalArgumentException ex) {
                System.out.println("Invalid input for player Age. " + ex.getMessage());
            } finally {
                scanner.nextLine();
            }
        }

        //////////////////////////////////////////////
        System.out.print("Enter new player score (press 0.0 to keep the current score): ");
        double newScore = scanner.nextDouble();
        if (newScore != 0.0) {
            this.Player_Score = (int) newScore;
        }
        ////////////////////////////////////////////
        System.out.print("Enter new player rank (press 0 to keep the current rank): ");
        int newRank = scanner.nextInt();
        if (newRank != 0) {
            this.Player_Rank = newRank;
        }
        //////////////////////////////////
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////


    // PLEASE NOTE THAT THIS METHOD IS NOT WORKING
    public static void searchPlayer() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter team name to search in: ");
        String teamName = scanner.nextLine().trim();

        System.out.print("Enter player name to search: ");
        String playerName = scanner.nextLine().trim();

        // In a real application, you would likely pass a list of teams to the method
        // For simplicity, let's assume you have a list called "teams"
        List<Team> teams = new ArrayList<>();

        for (Team team : teams) {
            if (team.getName().equals(teamName) && team.getPlayers() != null) {
                for (Player player : team.getPlayers()) {
                    if (player.getPlayerName().equals(playerName)) {
                        System.out.println("Player " + playerName + " found in team " + teamName + ".");
                        return;
                    }
                }
            }
        }

        System.out.println("Player " + playerName + " not found in team " + teamName + ".");
    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////////////
    private void validateTwoDigits(int number) {
        if (number <= 0 || number > 99) {
            throw new IllegalArgumentException("Player number must be between 1 and 99.");
        }
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    private void validateAge(int age) {
        if (age < 15 || age > 50) {
            throw new IllegalArgumentException("Player age must be between 15 and 50.");
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private void validatePositiveNumber(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("Input must be a positive value.");
        }
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private void validateString(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("Input must be a non-empty string.");
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private void validatescore(int score) {
        if (score < 0 || score > 60) {
            throw new IllegalArgumentException("Player Score must be between 0 and 60.");
        }
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void validaterank(float rank) {
        if (rank < 1 || rank > 10) {
            throw new IllegalArgumentException("Player rank must be between 1 and 10.");
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Getters
    public String getPlayerName() {
        return this.Player_Name;
    }

    public int getID() {
        return this.Player_ID;
    }

    public String getTeamName() {
        return this.team;
    }

    public int getNumber() {
        return Player_Number;
    }

    public int getAge() {
        return this.Player_Age;
    }

    public int getGoalsScored() {
        return this.Player_Score;
    }

    public float getRank() {
        return this.Player_Rank;
    }

    //setters
    @Override
    public void setName(String name) {
        this.Player_Name = name;
    }

    @Override
    public void setNumber(int number) {
        this.Player_Number = number;
    }

    @Override
    public void setPlayerID(int playerID) {
        this.Player_ID = playerID;
    }


    @Override
    public void setRank(int rank) {
        this.Player_Rank = rank;
    }

    // (int) (Math.random() * (Max-Min) + Min)
    /*
    this function returns double value
    https://ioflood.com/blog/math-random-java/
    https://stackoverflow.com/questions/6091355/setting-the-lower-limit-for-random-number-function
     */
    @Override
    public int successful_passes(int lower_limit, int upper_limit) {
        return (int)((Math.random() * (upper_limit-lower_limit)) + lower_limit);
    }
    @Override
    public int unsuccessful_passes(int lower_limit, int successful_passes) {
        return (int)((Math.random() * (successful_passes-lower_limit)) + lower_limit);
    }
    int Number_of_shots(int lower_limit, int upper_limit) {
        return (int)((Math.random() * (upper_limit-lower_limit)) + lower_limit);
    }
    void passes_simulation(Player p1){
        p1.Successful_passes=successful_passes(30,100);
        p1.miss_passes=unsuccessful_passes(0,p1.Successful_passes);
    }

    public void player_simulation(Team t1){

        for (int i =0 ; i<11 ;i++)
        {
            if(t1.players1[i].player_position==position.forward)
            {
                passes_simulation(t1.players1[i]);
                t1.passes_calculation(t1.players1[i]);
            }
            else if (t1.players1[i].player_position==position.midfielder)
            {
                passes_simulation(t1.players1[i]);
                t1.passes_calculation(t1.players1[i]);
            }
            else if(t1.players1[i].player_position==position.defender)
            {
                passes_simulation(t1.players1[i]);
                t1.passes_calculation(t1.players1[i]);
            }
            else
            {
                passes_simulation(t1.players1[i]);
                // unknown error t1.players1[i].GoalKeeper_saves=GoalKeeper_assumption_saves(20,0);
                t1.passes_calculation(t1.players1[i]);
            }
        }

    }


}

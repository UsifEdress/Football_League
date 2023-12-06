package Football_League;

import java.util.* ;
public  class Player implements Player_Interface{

    String Player_Name;
    int Player_ID;
    int Player_Number;
    int Player_Age;
    int Player_Score;
    float Player_Rank;
    public enum position { Goalkeeper , defender , midfielder , forward };
    position player_position;
    String team;

    int Tackling_number;
    int Successful_passes;
    int miss_passes;
    int Number_Assists;
    int Number_Goals;

    /////////////////////////////////////////////////////////////////

    public Player() {
    }

    public Player(String name, int player_ID, int player_Number, int player_Age, int player_Score,int player_Rank,String team) {
        this.Player_Name = name;
        Player_ID = player_ID;
        Player_Number = player_Number;
        Player_Age = player_Age;
        Player_Score = player_Score;
        Player_Rank = player_Rank;
        this.team = team;
    }
    //////////////////////////////////////////////////////////////////////////
    public void enterPlayerInformation()
    {
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
            }
        finally {
        scanner.nextLine();
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
        while(true)
        {
            try
            {
                System.out.print("Enter player Number: ");
                int enteredAge = scanner.nextInt();
                validateTwoDigits(enteredAge);
                this.Player_Number =enteredAge;
                break;
            } catch (InputMismatchException | IllegalArgumentException ex) {
                System.out.println("Invalid input for player Number. " + ex.getMessage());
            } finally {
                scanner.nextLine();
            }
        }
        while(true)
        {
            try
        {
            System.out.print("Enter player Age: ");
            int enteredAge = scanner.nextInt();
            validateAge(enteredAge);
            this.Player_Age =enteredAge;
            break;
        } catch (InputMismatchException | IllegalArgumentException ex) {
            System.out.println("Invalid input for player Age. " + ex.getMessage());
        } finally {
            scanner.nextLine();
        }
        }
        while(true)
        {
            try
            {
                System.out.print("Enter player Score: ");
                int enteredScore = scanner.nextInt();
                validatescore(enteredScore);
                this.Player_Number =enteredScore;
                break;
            } catch (InputMismatchException | IllegalArgumentException ex) {
                System.out.println("Invalid input for player score. " + ex.getMessage());
            } finally {
                scanner.nextLine();
            }
        }
        while(true)
        {
            try
            {
                System.out.print("Enter player rank: ");
                float enteredrank = scanner.nextFloat();
                validaterank(enteredrank);
                this.Player_Rank =enteredrank;
                break;
            } catch (InputMismatchException | IllegalArgumentException ex) {
                System.out.println("Invalid input for player rank. " + ex.getMessage());
            } finally {
                scanner.nextLine();
            }
        }
        System.out.print("Enter player team: ");
        this.team = scanner.nextLine();
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void displayPlayerInformation()
    {
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
                    scanner.nextLine();
                }
            }
        }
        ///////////////////////////////
        System.out.print("Enter new player ID (press 0 to keep the current ID): ");
        int newPlayerID = scanner.nextInt();
        if (newPlayerID != 0) {
            while(true) {
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
        }
        /////////////////////////////
        System.out.print("Enter new player number (press 0 to keep the current number): ");
        int newNumber = scanner.nextInt();
        if (newNumber != 0) {
            while(true)
            {
                try
                {
                    System.out.print("Enter player Number: ");
                    int enteredAge = scanner.nextInt();
                    validateTwoDigits(enteredAge);
                    this.Player_Number =enteredAge;
                    break;
                } catch (InputMismatchException | IllegalArgumentException ex) {
                    System.out.println("Invalid input for player Number. " + ex.getMessage());
                } finally {
                    scanner.nextLine();
                }
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
        int newAge = scanner.nextInt();
        if (newAge != 0) {
            while(true) {
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
        }
        //////////////////////////////////////////////
        System.out.print("Enter new player score (press 0.0 to keep the current score): ");
        double newScore = scanner.nextDouble();
        if (newScore != 0.0) {
            this.Player_Score = (int)newScore;
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
    public  boolean searchPlayer(String playerName, String teamName) {
        boolean nameMatch = this.Player_Name.equalsIgnoreCase(playerName);
        boolean teamMatch = this.team.equalsIgnoreCase(teamName);
        if (nameMatch && teamName.isEmpty())
        {
            return true;
        }
        else if (nameMatch && teamMatch)
        {
            return true;
        }
            return false;
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
        if (value <= 0) {
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
}

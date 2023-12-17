package Football_League;

import java.io.Serializable;
import java.util.*;

public abstract class Player implements Player_Interface, Serializable {

    private String Player_Name;
    private int Player_ID;
    private int Player_Number;
    private int Player_Age;
    private int Player_Score;
    private float Player_Rank;

    public enum position {Goalkeeper, defender, midfielder, forward}

    public position player_position;
    public String team;


    public int Number_Goals;


    public int Total_Number_Goals;


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
                this.Player_Score = enteredScore;
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

    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    public abstract void displayPlayerInformation();

    //
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
            }
        }
        /////////////////////////////
        System.out.print("Enter new player Position (press 0 to keep the current Position): ");
        System.out.println();
        displayPossiblePositions();

        int enteredNumber;
        do {
            try {
                enteredNumber = scanner.nextInt();


                switch (enteredNumber) {
                    case 0:

                        break;
                    case 1:
                        this.player_position = position.forward;
                        break;
                    case 2:
                        this.player_position = position.midfielder;
                        break;
                    case 3:
                        this.player_position = position.defender;
                        break;
                    case 4:
                        this.player_position = position.Goalkeeper;
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid input for player position. It must be between 0 and 4.");
                }

                break;
            } catch (InputMismatchException | IllegalArgumentException ex) {
                System.out.println("Invalid input for player Number. " + ex.getMessage());
            }
        } while (true);


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
        if (input == null || input.trim().isEmpty() || !input.matches("[a-zA-Z ]+")) {
            throw new IllegalArgumentException("String must be a non-empty string without numbers or symbols.");
        }
    }




    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private void validatescore(int score) {
        if (score < 0 || score > 90) {
            throw new IllegalArgumentException("Player Score must be between 0 and 60.");
        }
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void validaterank(float rank) {
        if (rank < 1 || rank > 10) {
            throw new IllegalArgumentException("Player rank must be between 1 and 10.");
        }
    }


    private void displayPossiblePositions() {
        System.out.println("Choose a position:");
        System.out.println("1. Forward");
        System.out.println("2. Midfielder");
        System.out.println("3. Defender");
        System.out.println("4. Goalkeeper");
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

    public void setTeam(String team) {
        this.team = team;
    }

    // (int) (Math.random() * (Max-Min) + Min)
    /*
    this function returns double value
    https://ioflood.com/blog/math-random-java/
    https://stackoverflow.com/questions/6091355/setting-the-lower-limit-for-random-number-function
     */
    @Override
    public int successful_passes(int lower_limit, int upper_limit) {
        return (int) ((Math.random() * (upper_limit - lower_limit)) + lower_limit);
    }

    @Override
    public int unsuccessful_passes(int lower_limit, int successful_passes) {
        return (int) ((Math.random() * (successful_passes - lower_limit)) + lower_limit);
    }

    int Number_of_shots(int lower_limit, int upper_limit) {
        return (int) ((Math.random() * (upper_limit - lower_limit)) + lower_limit);
    }


}




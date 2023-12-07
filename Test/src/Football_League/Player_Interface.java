package Football_League;

interface Player_Interface {
     void enterPlayerInformation();
     void displayPlayerInformation();
     void updatePlayerInformation();


     //setters
     void setName(String name);
     void setNumber(int number);
     void setPlayerID(int playerID);

     void setRank(int rank);


     // Getters
     String getPlayerName();
     int getID();
     String getTeamName();
     int getNumber();
     int getAge();

     int getGoalsScored();
     float getRank();
}
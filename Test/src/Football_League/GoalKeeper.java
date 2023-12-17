package Football_League;

import java.io.Serializable;

public class GoalKeeper extends Player implements Serializable {
    public GoalKeeper() {
        super();
        this.player_position = position.Goalkeeper;
    }
    public int GoalKeeper_saves;
    public GoalKeeper(String name, int player_ID, int player_Number, int player_Age, int player_Score, int player_Rank, String team) {
        super(name, player_ID, player_Number, player_Age, player_Score, player_Rank, team);
        this.player_position=position.Goalkeeper;
    }
    int GoalKeeper_assumption_saves(int upper_limit , int lower_limit){
        return (int)((Math.random() * (upper_limit-lower_limit)) + lower_limit);
    }
    public void displayPlayerInformation() {
        System.out.println("Player Information:");
        System.out.println("Name: " + this.getPlayerName());
        System.out.println("ID: " + this.getID());
        System.out.println("Position : " + this.player_position);
        System.out.println("Number: " + this.getNumber());
        System.out.println("Age: " + this.getAge());
        System.out.println("Score: " + this.getGoalsScored());
        System.out.println("Team: " + this.team);
    }
}

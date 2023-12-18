package Football_League;

import java.io.Serializable;

public class GoalKeeper extends Player implements Serializable {
    public GoalKeeper() {
        super();
        this.player_position = position.Goalkeeper;
    }

    public void displayPlayerInformation() {
        System.out.println("Player Information:");
        System.out.println("Name: " + this.getPlayerName());
        System.out.println("ID: " + this.getID());
        System.out.println("Position : " + this.player_position);
        System.out.println("Number: " + this.getNumber());
        System.out.println("Age: " + this.getAge());
        System.out.println("Rank: " + this.getRank());
        System.out.println("Team: " + this.team);
    }

    public String toString() {
        return  getPlayerName();
    }
}

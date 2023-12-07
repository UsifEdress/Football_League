package Football_League;

public class GoalKeeper extends Player{
    public GoalKeeper() {
    }
    public int GoalKeeper_saves;
    public GoalKeeper(String name, int player_ID, int player_Number, int player_Age, int player_Score, int player_Rank, String team) {
        super(name, player_ID, player_Number, player_Age, player_Score, player_Rank, team);
        this.player_position=position.Goalkeeper;
    }
    int GoalKeeper_assumption_saves(int upper_limit , int lower_limit){
        return (int)((Math.random() * (upper_limit-lower_limit)) + lower_limit);
    }
}

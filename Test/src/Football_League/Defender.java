package Football_League;

public class Defender extends Player{
    public Defender() {
    }

    public Defender(String name, int player_ID, int player_Number, int player_Age, int player_Score, int player_Rank, String team) {
        super(name, player_ID, player_Number, player_Age, player_Score, player_Rank, team);
        this.player_position=position.defender;
    }
}
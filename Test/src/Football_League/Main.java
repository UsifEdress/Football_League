package Football_League;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.NotSerializableException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NotSerializableException, FileNotFoundException {
        League league;
        if (Files.is_found()) {
            league = Files.ReadLeague();
        } else {
            league = new League();
        }
        Menu menu = new Menu(league);
        menu.start();
        Files.WriteLeague(league);
    }
}
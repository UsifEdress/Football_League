package Football_League;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.NotSerializableException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NotSerializableException, FileNotFoundException {
        League league;
        Menu menu ;
        if (Files.is_MatchManager_found()) {
            menu = new Menu(Files.ReadMatchManager());

        } else {
            league = new League();
            menu = new Menu(league);
        }
        menu.start();
        Files.WriteMatchManager(menu.getMatchManager());
    }
}
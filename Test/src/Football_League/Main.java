package Football_League;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        League league = new League();
        Menu menu = new Menu(league);
        menu.start();
    }
}
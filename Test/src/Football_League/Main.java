package Football_League;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        League league = new League();
        Menu menu = new Menu(league);
        menu.start();


    }
}
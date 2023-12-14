package Football_League;

import java.io.*;
import java.util.ArrayList;

public class Files {
    private File file;

    public Files(String team_Name) {
        team_Name = team_Name + ".txt";
        file = new File(team_Name);
    }
    public Files() {
        file = new File("Team_list");
    }

    void WriteFiles(ArrayList<Player> players_list) throws IOException {
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(players_list);
        oos.flush();
        oos.close();
        fos.close();
    }
    void WriteList(ArrayList<String> Teams_list) throws IOException {
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(Teams_list);
        oos.flush();
        oos.close();
        fos.close();
    }


    ArrayList<Player> ReadFiles() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        ArrayList<Player> players_list = (ArrayList<Player>) ois.readObject();
        ois.close();
        fis.close();
        return players_list;
    }
    ArrayList<String> ReadList() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        ArrayList<String> Teams_list = (ArrayList<String>) ois.readObject();
        ois.close();
        fis.close();
        return Teams_list;
    }
}
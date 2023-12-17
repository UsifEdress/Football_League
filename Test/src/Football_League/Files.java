package Football_League;

import java.io.*;
import java.util.ArrayList;

public class Files implements Serializable {
    private File file;

    public Files(String team_Name) {
        //team_Name = team_Name + ".txt";
        file = new File(team_Name);
    }
    public Files() {
        file = new File("Team_list.txt");
    }

    void WriteFiles(Team t1) throws IOException , NotSerializableException {
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(t1);
        oos.flush();
        oos.close();
        fos.close();
    }
    void WriteList(ArrayList<String> Teams_list) throws IOException , NotSerializableException{
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(Teams_list);
        oos.flush();
        oos.close();
        fos.close();
    }


    Team ReadFiles() throws IOException, ClassNotFoundException ,NotSerializableException {
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Team Team1 = (Team) ois.readObject();
        ois.close();
        fis.close();
        return Team1;
    }
    ArrayList<String> ReadList() throws IOException, ClassNotFoundException ,NotSerializableException {
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        ArrayList<String> Teams_list = (ArrayList<String>) ois.readObject();
        ois.close();
        fis.close();
        return Teams_list;
    }
}
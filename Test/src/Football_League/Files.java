package Football_League;

import java.io.*;
import java.util.ArrayList;

public class Files implements Serializable {
    private File file;
    private static final File Leaguefile = new File("League.txt");

    public Files(String team_Name)  throws IOException , NotSerializableException , FileNotFoundException{
        //team_Name = team_Name + ".txt";
        file = new File(team_Name);
    }
    public Files() throws IOException , NotSerializableException , FileNotFoundException {
        file = new File("Team_list.txt");
    }

    void WriteFiles(Team t1) throws IOException , NotSerializableException , FileNotFoundException{
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(t1);
        oos.flush();
        oos.close();
        fos.close();
    }
    void WriteList(ArrayList<String> Teams_list) throws IOException , NotSerializableException, FileNotFoundException{
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(Teams_list);
        oos.flush();
        oos.close();
        fos.close();
    }
//

    Team ReadFiles() throws IOException, ClassNotFoundException ,NotSerializableException , FileNotFoundException{
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Team Team1 = (Team) ois.readObject();
        ois.close();
        fis.close();
        return Team1;
    }
    ArrayList<String> ReadList() throws IOException, ClassNotFoundException ,NotSerializableException , FileNotFoundException{
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        ArrayList<String> Teams_list = (ArrayList<String>) ois.readObject();
        ois.close();
        fis.close();
        return Teams_list;
    }
    static void WriteLeague(League l1) throws IOException , NotSerializableException , FileNotFoundException{
        FileOutputStream fos = new FileOutputStream(Leaguefile);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(l1);
        oos.flush();
        oos.close();
        fos.close();
    }
    static League ReadLeague() throws IOException, ClassNotFoundException ,NotSerializableException , FileNotFoundException{
        FileInputStream fis = new FileInputStream(Leaguefile);
        ObjectInputStream ois = new ObjectInputStream(fis);
        League l1 = (League) ois.readObject();
        ois.close();
        fis.close();
        return l1;
    }
    static boolean is_found()throws IOException, ClassNotFoundException ,NotSerializableException , FileNotFoundException{
        if(Leaguefile.exists())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
package Football_League;

import java.io.*;
import java.util.ArrayList;

public class Files implements Serializable {
    private static final File MatchManagerfile = new File("MatchManager.txt");

    static void WriteMatchManager(MatchManager m1) throws IOException , NotSerializableException , FileNotFoundException{
        FileOutputStream fos = new FileOutputStream(MatchManagerfile);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(m1);
        oos.flush();
        oos.close();
        fos.close();
    }
    static MatchManager ReadMatchManager() throws IOException, ClassNotFoundException ,NotSerializableException , FileNotFoundException{
        FileInputStream fis = new FileInputStream(MatchManagerfile);
        ObjectInputStream ois = new ObjectInputStream(fis);
        MatchManager m1 = (MatchManager) ois.readObject();
        ois.close();
        fis.close();
        return m1;
    }

    static boolean is_MatchManager_found()throws IOException, ClassNotFoundException ,NotSerializableException , FileNotFoundException{
        if(MatchManagerfile.exists())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
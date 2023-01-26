import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DataManager {
    public void loadFromFile(GenTree tree) {
        String inpString;
        int ti1;
        int ti2;
        boolean bo3;
        // GenTree tree = new GenTree();

        try {
            String[] tempStr;
            BufferedReader br = new BufferedReader(new FileReader("treeFile.txt"));
            inpString = br.readLine();
            //System.out.println(inpString);
            while (inpString != null) {
                //System.out.println(inpString);
                tempStr = inpString.split("!");
                //System.out.println(tempStr[0]);
                ti1 = Integer.parseInt(tempStr[2]);
                ti2 = Integer.parseInt(tempStr[3]);
                bo3 = Boolean.parseBoolean(tempStr[4]);
                tree.add(new Person(ti1, ti2, bo3, tempStr[1]));
                inpString = br.readLine();
            }
            br.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } 
        // return tree;
    }

    public boolean saveToFile(ArrayList<Person> members) {
        //String outpt;
        try (FileWriter fw = new FileWriter("treeFile.txt",false)) {
            for (Person member : members) {
                fw.write(member.toString().replace(" ", "!")+"!"+member.gender+"\n");
            }
            fw.flush();
            return true;
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }


}

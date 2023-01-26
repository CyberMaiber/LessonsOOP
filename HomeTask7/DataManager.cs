
public class DataManager {
    public void loadFromFile(GenTree tree) {
        string inpString;
        int ti1;
        int ti2;
        bool bo3;
        // GenTree tree = new GenTree();

        try {
                string[] tempStr;
                using (StreamReader br = new StreamReader("treeFile.txt"))
                {
                    while ((inpString = br.ReadLine())!= null)
                    {
                        tempStr = inpString.Split("!");
                        //System.out.println(tempStr[0]);
                        ti1 = int.Parse(tempStr[2]);
                        ti2 = int.Parse(tempStr[3]);
                        bo3 = bool.Parse(tempStr[4]);
                        tree.add(new Person(ti1, ti2, bo3, tempStr[1]));
                    }
                }
            } catch (Exception ex) {
            Console.WriteLine(ex.Message);
            } 
        // return tree;
    }

    public bool saveToFile(List<Person> members) {
        try {
                using (StreamWriter fw = new StreamWriter("treeFile.txt")) 
                {
                    foreach (Person member in members)
                    {
                        fw.Write(member.toString().Replace(" ", "!")+"!"+member.gender+"\n");
                    }
                    return true;
                }
            } catch (IOException ex) {
                Console.WriteLine(ex.Message);
                return false;
            }
    }


}

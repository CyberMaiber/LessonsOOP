import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class GenTree implements InnerGenTree {
    private ArrayList<Person> members = new ArrayList<>();
    int personsCount = 1;
    
    public void add(Person person) {
        if (this.addPerson(person)) {System.out.println(person.namePerson + " добавлен(а)");}
        else {System.out.println(person.namePerson + " не добавлен(а)");}
    }

    //метод определяющий можно ли добавить человека с такими данными в дерево
    //проверяется что в дереве уже есть родители
    private boolean addPerson(Person person) {
        if (this.haveID(person.parentIDfather) && this.haveID(person.parentIDmother)){
            person.personID = this.personsCount++;
            this.members.add(person);
            return true;
        }
        return false;
    }
    //Метод проверки наличия ID в дереве
    private boolean haveID(int personID) {
        if (personID == 0){return true;}
        for (Person member : this.members) {
            if (member.personID == personID) {return true;}
        }
        return false;
    }
    //печать дерева
    public void printTree() {
        for (Person member : this.members) {
            System.out.println(member.toString());
        }
    }

    //метод поиска детей - результат arrayList
    public ArrayList<Person> findChildren (int parent) {
        ArrayList<Person> tempArStr = new ArrayList<>();
        for (Person member : this.members) {
           if (member.parentIDfather == parent || member.parentIDmother == parent){tempArStr.add(member);}
        }
        return tempArStr;
    }

    //Сохранить дерево в файл
    public void saveToFile() {
        //String outpt;
        try (FileWriter fw = new FileWriter("treeFile.txt",false)) {
            for (Person member : this.members) {
                fw.write(member.toString().replace(" ", "!")+"!"+member.gender+"\n");
            }
            fw.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    //загрузить дерево из файла
    public void loadFromFile() {
        String inpString;
        int ti1;
        int ti2;
        boolean bo3;
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
                this.add(new Person(ti1, ti2, bo3, tempStr[1]));
                inpString = br.readLine();
            }
            br.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } 
    }

}


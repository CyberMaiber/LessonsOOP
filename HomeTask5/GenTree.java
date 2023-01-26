
import java.util.ArrayList;

public class GenTree {
    private ArrayList<Person> members = new ArrayList<>();
    int personsCount = 1;
    
    public void add(Person person) {
        if (this.addPerson(person)) {System.out.println(person.namePerson + " добавлен(а)");}
        else {System.out.println(person.namePerson + " не добавлен(а)");}
    }

    private boolean addPerson(Person person) {
        if (this.haveID(person.parentIDfather) && this.haveID(person.parentIDmother)){
            person.personID = this.personsCount++;
            this.members.add(person);
            return true;
        }
        return false;
    }

    private boolean haveID(int personID) {
        if (personID == 0){return true;}
        for (Person member : this.members) {
            if (member.personID == personID) {return true;}
        }
        return false;
    }

    public void printTree() {
        for (Person member : this.members) {
            System.out.println(member.toString());
        }
    }

    public ArrayList<Person> findChildren (int parent) {
        ArrayList<Person> tempArStr = new ArrayList<>();
        for (Person member : this.members) {
           if (member.parentIDfather == parent || member.parentIDmother == parent){tempArStr.add(member);}
        }
        return tempArStr;
    }

    public void saveToFile() {
        new DataManager().saveToFile(this.members);
    }

    public void loadFromFile() {
        new DataManager().loadFromFile(this);
       
    }

}


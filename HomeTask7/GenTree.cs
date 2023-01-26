


public class GenTree {
    private List<Person> members = new List<Person>();
    int personsCount = 1;
    
    public void add(Person person) {
        if (this.addPerson(person)) {Console.WriteLine(person.namePerson + " добавлен(а)");}
        else {Console.WriteLine(person.namePerson + " не добавлен(а)");}
    }

    private bool addPerson(Person person) {
        if (this.haveID(person.parentIDfather) && this.haveID(person.parentIDmother)){
            person.personID = this.personsCount++;
            this.members.Add(person);
            return true;
        }
        return false;
    }

    private bool haveID(int personID) {
        if (personID == 0){return true;}
        foreach (Person member in this.members) {
            if (member.personID == personID) {return true;}
        }
        return false;
    }

    public void printTree() {
        foreach (Person member in this.members) {
            Console.WriteLine(member.toString());
        }
    }

    public List<Person> findChildren (int parent) {
        List<Person> tempArStr = new List<Person>();
        foreach (Person member in this.members) {
           if (member.parentIDfather == parent || member.parentIDmother == parent){tempArStr.Add(member);}
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


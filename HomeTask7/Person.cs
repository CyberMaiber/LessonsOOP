public class Person {
    public int personID;
    public int parentIDfather;
    public int parentIDmother;
    public bool gender; //1 - M; 0 - Ж
    public string namePerson;
    //String commentPerson;
    
    public Person(int parentIDfather, int parentIDmother, bool gender, String namePerson)//,
            //String commentPerson) 
    {
        this.personID = 0;
        this.parentIDfather = parentIDfather;
        this.parentIDmother = parentIDmother;
        this.gender = gender;
        this.namePerson = namePerson;
       // this.commentPerson = commentPerson;
    }

    private string makeString() {
        string temp;
        temp = $"{this.personID} {this.namePerson} {this.parentIDfather} {this.parentIDmother}";
        //System.out.println(temp);
        return temp;
    }

    public string toString() {
        return makeString();
    }
}

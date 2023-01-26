public class Person {
    int personID;
    int parentIDfather;
    int parentIDmother;
    boolean gender; //1 - M; 0 - Ж
    String namePerson;
    //String commentPerson;
    
    public Person(int parentIDfather, int parentIDmother, boolean gender, String namePerson)//,
            //String commentPerson) 
    {
        this.personID = 0;
        this.parentIDfather = parentIDfather;
        this.parentIDmother = parentIDmother;
        this.gender = gender;
        this.namePerson = namePerson;
       // this.commentPerson = commentPerson;
    }

    private String makeString() {
        String temp;
        temp = String.format("%d %s %d %d",
        this.personID,
        this.namePerson,
        this.parentIDfather,
        this.parentIDmother);
        //System.out.println(temp);
        return temp;
    }

    @Override
    public String toString() {
        return makeString();
    }
}

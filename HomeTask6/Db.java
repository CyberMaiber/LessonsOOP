import java.util.ArrayList;
public class Db {
    ArrayList<Servant> servants = new ArrayList<>();
    ArrayList<Chief> chief = new ArrayList<>();
    ArrayList<Division> division = new ArrayList<>();
  
    public void addChief(Chief chf) {
      chief.add(chf);
    } 
}

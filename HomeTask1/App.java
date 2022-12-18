//Создать информационную систему позволяющую работать с сотрудниками некой компании\студентами вуза\учениками школы.

import java.util.ArrayList;

public class App {
  public static void main(String[] args) {
    Company myCompany = new Company();

    //System.out.println(myCompany.findAll("Петя"));
    System.out.println(myCompany.getAllInfo(1));
    System.out.println(myCompany.getAllInfo(2));
    System.out.println(myCompany.getAllInfo(3));
    System.out.println(myCompany.getAllInfo(4));
    
  }
}

class Company {
  public Company() {
    init();
  }

  Db db;

  public Db getDb() {
    return db;
  }

  public String getAllInfo(int idServant) {
    Servant c = db.servants.get(idServant - 1);

    return String.format("%d %s %s %s",
        c.id,
        c.name,
        db.division.get(c.div - 1).name,
        db.chief.get(c.div - 1).chiefName);
  }

  public ArrayList<String> findAll(String inpString) {
    ArrayList<String> tempArStr = new ArrayList<>();
    for (Servant cnm : db.servants) {
      if (cnm.name.toLowerCase().contains(inpString.toLowerCase())) {
        tempArStr.add(cnm.name);  
      }
    }  
    return tempArStr;
  }

  Db init() {
    db = new Db();
    Servant c1 = new Servant(1, "Петя", 1);
    Servant c2 = new Servant(2, "Андрей", 1);
    Servant c3 = new Servant(3, "Мавлют", 2);
    Servant c4 = new Servant(4, "Аркадий", 3);

    db.servants.add(c1);
    db.servants.add(c2);
    db.servants.add(c3);
    db.servants.add(c4);

    db.division.add(new Division(1, 1,"Продажи"));
    db.division.add(new Division(2, 2,"Бухгалтерия"));
    db.division.add(new Division(3, 3,"Техподдержка"));

    ChiefAdder pf = new ChiefAdder();
    
    db.addChief(pf.getChiefName("Виталий Петрович"));
    db.addChief(pf.getChiefName("Антон Андреевич"));
    db.addChief(pf.getChiefName("Айдар Мосгутович"));

    return db;
  }
}

class Db {
  ArrayList<Servant> servants = new ArrayList<>();
  ArrayList<Chief> chief = new ArrayList<>();
  ArrayList<Division> division = new ArrayList<>();

  public void addChief(Chief chf) {
    chief.add(chf);
  }
}

class Servant {
  int id;
  String name;
  int div;

  public Servant(int id, String name, int divisionID){
    this.id = id;
    this.name = name;
    this.div = divisionID;
  }
}

class Chief {
  int id;
  String chiefName;
}

class Division {
  int id;
  int chiefId;
  String name;

  public Division(int id, int chiefId, String name) {
    this.id = id;
    this.name = name;
    this.chiefId = chiefId;
  }
}

class ChiefAdder {
  int count = 1;

  public Chief getChiefName(String name) {
    Chief chf = new Chief();
    chf.id = count++;
    chf.chiefName = name;
    return chf;
  }
}
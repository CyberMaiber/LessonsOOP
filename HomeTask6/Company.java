import java.util.ArrayList;
public class Company {
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

/**
 * main
 */
public class Program {
    public static void Main(String[] args) {
        // Person p1 = new Person(0, 0, true, "Шереметьев_Антон_Андреевич");
        // Person p2 = new Person(0, 0, false, "Шереметьева_(Брусникина)_Василиса_Сергеевна");
        // Person p3 = new Person(1, 2, false, "Кулагина_(Шереметьева)_Дарья_Антоновна");
        
        // Person p4 = new Person(0, 0, true, "Кулагин_Николай_Васильевич");
        // Person p5 = new Person(0, 0, false, "Кулагина_(Загурская)_Екатерина_Петровна");
        // Person p6 = new Person(4, 5, true, "Кулагин_Евгений_Николаевич");
        
        // Person p7 = new Person(6, 3, false, "Кулагина_Анна_Евгеньевна");
        // Person p8 = new Person(6, 3, true, "Кулагин_Олег_Евгеньевич");

        GenTree bigTree = new GenTree(); 
        // bigTree.add(p1);
        // bigTree.add(p2);
        // bigTree.add(p3);
        // bigTree.add(p4);
        // bigTree.add(p5);
        // bigTree.add(p6);
        // bigTree.add(p7);
        // bigTree.add(p8);
        bigTree.loadFromFile();
        //bigTree.printTree();
        List<Person> pl = bigTree.findChildren(3);
        foreach (Person prs in pl)
        {
            Console.WriteLine(prs.toString());    
        }
        
        // bigTree.saveToFile();
    }
    
}
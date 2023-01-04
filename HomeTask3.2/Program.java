
public class Program {

  public static void main(String[] args) {
    Worker w1 = new Worker();
    w1.age = 22;
    w1.salary = 221;
    w1.name = "Какое-то имя.";

    Document doc1 = new Document();
    doc1.wrk = w1;
    doc1.docMod = new DocModHtml();
    doc1.button.click();
    doc1.docMod = new DocModXml();
    doc1.button.click();
    doc1.docMod = new DocModJson();
    doc1.button.click();
  }
}

// #region DocMod
abstract class DocMod {
    abstract void saver(Worker wrk);
}

class DocModHtml extends DocMod {
    @Override
    void saver(Worker wrk) {
      System.out.println("Логика сохранения в HTML");
    }
}

class DocModXml extends DocMod {
    @Override
    void saver(Worker wrk) {
        System.out.println("Логика сохранения в XML");
    }
}

class DocModJson extends DocMod {
    @Override
    void saver(Worker wrk) {
        System.out.println("Логика сохранения в JSON");
    }
}
//#endregion

class Document {
  Button button = new Button();
  DocMod docMod;
  Worker wrk;
  class Button {
    public void click() {
        Document.this.docMod.saver(Document.this.wrk);
        System.out.println(Document.this.wrk.toString());
    }
  }
}

class Worker {
  int age;
  int salary;
  String name;
@Override
public String toString() {
    return "Worker [age=" + age + ", salary=" + salary + ", name=" + name + "]";
}
}

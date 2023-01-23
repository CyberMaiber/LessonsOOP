public class ChiefAdder {
    int count = 1;

    public Chief getChiefName(String name) {
      Chief chf = new Chief();
      chf.id = count++;
      chf.chiefName = name;
      return chf;
    }
}

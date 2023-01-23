//Создать информационную систему позволяющую работать с сотрудниками некой компании\студентами вуза\учениками школы.



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

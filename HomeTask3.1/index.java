/**
 * main
 */
public class index {
    public static void main(String[] args) {

        GenTree bigTree = new GenTree(); 

        bigTree.loadFromFile();

        System.out.println(bigTree.findChildren(3));

    }
    
}
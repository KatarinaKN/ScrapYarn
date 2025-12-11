import java.util.List;

public class Main {
    public static void main(String[] args) {
        DBInquiries db = new DBInquiries();
        List<String> beginners = db.getCrochetPatternByLevel("Beginner");

        System.out.println("Begynder-opskrifter:");
        for (String name : beginners) {
            System.out.println(name);
        }
    }
}

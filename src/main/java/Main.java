public class Main {
    static void main() {

        DBInquiries dbInquiries = new DBInquiries("jdbc:sqlite:src/main/resources/patterns.db");

        dbInquiries.getCrochetPatternByLevel("beginner");



    }
}

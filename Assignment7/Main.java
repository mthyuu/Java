import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        StatisticGradeBook SGB = new StatisticGradeBook("Assignment7-Spreadsheet.csv");
        Thread t1 = new Thread(SGB);
        t1.start();
        Scanner sc = new Scanner(System.in);
        System.out.println("What student would you like to see grades for: ");
        String name = sc.nextLine();
        SGB.getStudentGrade(name);
    }
}

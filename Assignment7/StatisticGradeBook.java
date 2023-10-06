import java.util.LinkedList;

public class StatisticGradeBook extends Gradebook implements Runnable{

    StatisticGradeBook(String name){
        super(name);
    }

    @Override
    public void run() {
        int counter = 0;
        LinkedList<String> name = getAllStudentNames();
        int numOfStudents = StudentList.size();
        for (Student stud : StudentList){
            stud.calcQuizAverage();
            stud.calcHWAverage();
            stud.calcOverallAverage();
            if (counter%100==0){
                System.out.println("Calculating grades "+counter+" out of "+numOfStudents);
            }
            counter++;
        }
        System.out.println("All grades calculated");
    }
}

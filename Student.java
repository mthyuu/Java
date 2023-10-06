import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
public class Student {
    private final int[] quizScores = new int[10];
    private final int[] hwScores = new int[10];
    private int midtermScore, finalExamScore;
    private double quizAvg, hwAvg, overallAvg;
    private String name;
    private int ID;
    Student(String dataline){
        String[] amt = dataline.split(",");
        name = amt[0];
        ID = Integer.parseInt(amt[1]);
        for (int i=0;i<10;i++){
            quizScores[i]= Integer.parseInt(amt[(i+2)]);
        }
        for (int i=0;i<10;i++){
            hwScores[i]= Integer.parseInt(amt[(i+12)]);
        }
        midtermScore = Integer.parseInt(amt[22]);
        finalExamScore = Integer.parseInt(amt[23]);
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }

    public void calcQuizAverage(){
        int sum = 0;
        int min = quizScores[0];
        for (int quizScore : quizScores) {
            sum += quizScore;
            if (quizScore < min) {
                min = quizScore;
            }
        }
        quizAvg = (sum-min)/9.0;
    }
    public void calcHWAverage(){
        int sum = 0;
        int min = hwScores[0];
        for (int hwScore : hwScores) {
            sum += hwScore;
            if (hwScore < min) {
                min = hwScore;
            }
        }
        hwAvg = (sum-min)/9.0;
    }
    public void calcOverallAverage(){
        overallAvg = ((0.4*quizAvg)+(0.1*hwAvg)+(0.2*midtermScore)+(0.3*finalExamScore));
    }
    public String getGrade(){
        int counter =1;
        for (int quiz : quizScores){
            System.out.println("Quiz "+counter+": "+quiz);
            counter++;
        }
        System.out.println("Quiz Avg: "+quizAvg);
        counter=1;
        for (int hw : hwScores){
            System.out.println("Hw "+counter+": "+hw);
            counter++;
        }
        System.out.println("HW Avg: "+hwAvg);
        System.out.println("Midterm: "+midtermScore);
        System.out.println("Final Exam: "+finalExamScore);
        System.out.println("Overall Average: "+overallAvg);
        return null;
    }
}

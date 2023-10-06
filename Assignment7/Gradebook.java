import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class Gradebook {
    protected LinkedList<Student> StudentList = new LinkedList<>();

    Gradebook(String filename){
        try{
            File myFile = new File(filename);
            Scanner sc = new Scanner(myFile);
            sc.nextLine();
            while(sc.hasNextLine()){
                Student newStud = new Student(sc.nextLine());
                StudentList.add(newStud);
            }
        }

        catch (FileNotFoundException e){
            System.out.println("Error: "+e.getMessage());
        }
    }

    public Student getStudent(String name){
        for (Student found : StudentList){
            if (found.getName().equals(name)){
                return found;
            }
        }
        return null;
    }
    public void getStudentGrade(String name){
        for (Student found : StudentList){
            if (found.getName().equals(name)){
                found.getGrade();
            }
        }
    }
    public LinkedList<String> getAllStudentNames(){
        LinkedList<String> names = new LinkedList<>();
        for (Student stud : StudentList){
            names.add(stud.getName());
        }
        return names;
    }
}

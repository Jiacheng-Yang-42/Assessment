
/**
 * Write a description of class Assessment here.
 *
 * @author (Jiacheng Yang)
 * @version (23882003)
 */
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
public class StudentScoreStatistics{
    public static void main(String[] args){
        Scanner userInput = new Scanner(System.in);
        System.out.print("Please enter the file name: ");//F1:The user will provide the file name.
        String fileName = userInput.nextLine();
        System.out.print("Please enter the threshold: ");
        double threshold = userInput.nextDouble();
        userInput.nextLine();
        ArrayList<Student> studentList = new ArrayList<>();
    try (Scanner scanner = new Scanner(new File("prog5001_students_grade_2022.csv"))){//F1:reads the unit name and students' marks from a given text file.
            int lineCount = 0;
     while (scanner.hasNextLine()) {//Read file line by line.
        lineCount++;
        String input = scanner.nextLine();
        String[] parts = input.split(",");//Using a comma delimiter to split the data.
    if(lineCount == 1){//F1: reads the unit name.
        String unitName = parts[0]; 
        System.out.println(unitName);
        System.out.println();
    }else if(lineCount >= 3){//Read data starting from the third line and beyond.
        String studentName = parts[0] + " " + parts[1];
        String studentID = parts[2];
        double assignment1 = 0.0;
        double assignment2 = 0.0;
        double assignment3 = 0.0;
        // Check and extract score data. 
        // Fill empty places with default value 0.0.
    if(parts.length >=4 && !parts[3].isEmpty()){
            assignment1 = Double.parseDouble(parts[3]);
        }
    if(parts.length >=5 && !parts[4].isEmpty()){
            assignment2 = Double.parseDouble(parts[4]);
        }
    if(parts.length >=6 && !parts[5].isEmpty()){
            assignment3 = Double.parseDouble(parts[5]);
        }
        double totalMark = assignment1 + assignment2 + assignment3;//F2: calculates the total mark.
        if (totalMark < threshold){
        System.out.println("Student " + (lineCount - 2) + "Name: " + studentName);//F2:Print Student Names.
        System.out.println("Student " + (lineCount - 2) + "ID: " + studentID);//F2:Print Student ID.
        System.out.println("Assignment1: " + assignment1 + "  ");
        System.out.println("Assignment2: " + assignment2 + "  ");
        System.out.println("Assignment3: " + assignment3);
        System.out.println("Totals: " + totalMark);//F2:Print Total Marks.
        System.out.println();
    } 
  }
 }
   }
  catch (FileNotFoundException e) {
    System.out.println("File not found: " + "prog5001_students_grade_2022.csv");
  }
  for (Student student : studentList) {
            System.out.println("Name: " + student.getName());
            System.out.println("ID: " + student.getID());
            System.out.println("Assignment1: " + student.getAssignment1());
            System.out.println("Assignment2: " + student.getAssignment2());
            System.out.println("Assignment3: " + student.getAssignment3());
            System.out.println("Total Mark: " + student.getTotalMark());
            System.out.println();
 }
 int n = studentList.size();
for (int i = 0; i < n - 1; i++) {
    for (int j = 0; j < n - i - 1; j++) {
        if (studentList.get(j).getTotalMark() > studentList.get(j + 1).getTotalMark()) {
             Student tempStudent = studentList.get(j);
            studentList.set(j, studentList.get(j + 1));
            studentList.set(j + 1, tempStudent);
        }
    }
}
for (int i = 0; i < Math.min(5, n); i++) {
    Student student = studentList.get(i);
}
System.out.println("Top 5 Students with the Highest Total Marks:");
for (int i = n - 1; i >= Math.max(0, n - 5); i--) {
            Student student = studentList.get(i);
        }
System.out.println("Top 5 Students with the Lowest Total Marks:");
    }
}
 class Student{
     private String name;
     private String id;
     private double assignment1;
     private double assignment2;
     private double assignment3;
     private double totalMark;
public Student(String name, String id, double assignment1, double assignment2, double assignment3, double totalMark){
    this.name = name;
    this.id = id;
    this.assignment1 = assignment1;
    this.assignment2 = assignment2;
    this.assignment3 = assignment3;
    this.totalMark = totalMark;
}
public String getName(){
    return name;
}
public String getID(){
    return id;
}
public double getAssignment1(){
    return assignment1;
}
public double getAssignment2(){
    return assignment2;
}
public double getAssignment3(){
    return assignment3;
}
public double getTotalMark(){
    return totalMark;
}
}

 




   
    


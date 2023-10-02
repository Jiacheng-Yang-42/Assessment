
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
         ArrayList<Student> studentList = new ArrayList<>();//Create an empty student list named studentList.
         Scanner userInput = new Scanner(System.in);
         while (true) {//F5:Menu System.
        System.out.println("Menu:");
        System.out.println("1. View student grades");
        System.out.println("2. View Students Below Threshold");
        System.out.println("3. View the top 5 students with the highest total marks");
        System.out.println("4. View the top 5 students with the lowest total marks");
        System.out.println("5. Exit");
        System.out.println();
        System.out.println();
        System.out.print("Enter your choose: ");
        int choose = userInput.nextInt();
        
        if (choose == 1) {
            StudentData(studentList);
        } else if (choose == 2) {
            if (studentList.isEmpty()) {
                System.out.println("Please check all student grades first (Option 1).");
            } else {
                System.out.print("Please enter the threshold: ");//F3:User inputs a threshold.
                double threshold = userInput.nextDouble();
                userInput.nextLine();
                viewStudentsBelowThreshold(threshold, studentList);
            }
        } else if (choose == 3) {
            if (studentList.isEmpty()) {
                System.out.println("Please check all student grades first (Option 1).");
            } else {
                viewTop5Students(studentList);
            }
        } else if (choose == 4) {
            if (studentList.isEmpty()) {
                System.out.println("Please check all student grades first (Option 1).");
            } else {
                viewLowest5Students(studentList);
            }
        } else if (choose == 5) {
            System.out.println("End");
            System.exit(0);
        } else {
            System.out.println("Invalid choice. Please try again.");
        }
    }
} 
     public static void StudentData(ArrayList<Student> studentList) { 
        Scanner userInput = new Scanner(System.in);
        System.out.print("Please enter the file name: ");//F1:The user will provide the file name.
        String fileName = userInput.nextLine();
    try (Scanner scanner = new Scanner(new File(fileName))){//F1:reads the unit name and students' marks from a given text file.
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
        double totalMark = assignment1 + assignment2 + assignment3;//F2: calculates the total mark..
        System.out.println("Student " + (lineCount - 2) + "Name: " + studentName);//F2:Print Student Names.
        System.out.println("Student " + (lineCount - 2) + "ID: " + studentID);//F2:Print Student ID.
        System.out.println("Assignment1: " + assignment1 + "  ");
        System.out.println("Assignment2: " + assignment2 + "  ");
        System.out.println("Assignment3: " + assignment3);
        System.out.println("Totals: " + totalMark);//F2:Print Total Marks.
        System.out.println();//After printing the information of each student, add a blank line.
        Student student = new Student(studentName, studentID, assignment1, assignment2, assignment3, totalMark);
        studentList.add(student);
    } 
  }
 }
  catch (FileNotFoundException e) {
    System.out.println("File not found: " + "prog5001_students_grade_2022.csv");//When the code captures an exception, it will display "File not found: prog5001_students_grade_2022.csv" to indicate that the file was not found.
  }
// Sort the student list by total marks.
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
// Print student data.
for (Student student : studentList) {//The code iterates through the data stored in the student list, ensuring that each student's detailed information in the list is displayed in the correct format.
            System.out.println("Name: " + student.getName());
            System.out.println("ID: " + student.getID());
            System.out.println("Assignment1: " + student.getAssignment1());
            System.out.println("Assignment2: " + student.getAssignment2());
            System.out.println("Assignment3: " + student.getAssignment3());
            System.out.println("Total Mark: " + student.getTotalMark());
            System.out.println();
 }
}
// F3:View students below the threshold
public static void viewStudentsBelowThreshold(double threshold, ArrayList<Student> studentList) {
System.out.print("Students below the threshold include: ");
System.out.println(); 
for (Student student : studentList) {
            if (student.getTotalMark() < threshold) {
             System.out.println("Name: " + student.getName());
             System.out.println("ID: " + student.getID());
             System.out.println("Total Mark: " + student.getTotalMark());
             System.out.println();         
    }
}
// F4:View the top 5 students with the highest scores in the total marks.
}
public static void viewTop5Students(ArrayList<Student> studentList) {
        System.out.println("Top 5 Students with the Highest Total Marks:");
        System.out.println();
        int n = studentList.size();
        int bottom = Math.min(5, studentList.size());
        for (int i = n - 1; i >= n - bottom; i--) {
            Student student = studentList.get(i);
            System.out.println("Name: " + student.getName());
             System.out.println("ID: " + student.getID());
             System.out.println("Total Mark: " + student.getTotalMark());
             System.out.println();   
        }
    }
// F4:View the top 5 students with the lowest scores in the total marks.
public static void viewLowest5Students(ArrayList<Student> studentList) {
        System.out.println("Top 5 Students with the Lowest Total Marks:");
        System.out.println();
        int top = Math.min(5, studentList.size());
        for (int i = 0; i < top; i++) {
            Student student = studentList.get(i);
            System.out.println("Name: " + student.getName());
             System.out.println("ID: " + student.getID());
             System.out.println("Total Mark: " + student.getTotalMark());
             System.out.println();   
        }
    }
}

 




   
    


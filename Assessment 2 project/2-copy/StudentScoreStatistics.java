
/**
 * Write a description of class Assessment here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
import java.io.*;
public class StudentScoreStatistics{
    public static void main(String[] args){
    try (Scanner scanner = new Scanner(new File("prog5001_students_grade_2022.csv"))){
            String unitName = parts[0];
            int lineCount = 0;
        while (scanner.hasNextLine()) {
        lineCount++;         
        String input = scanner.nextLine();
        String[] parts = input.split(",");
        String studentName = parts[0] + " " + parts[1];
        String studentID = parts[2];
        double assigment1 = Double.parseDouble(parts[3]);
        double assigment2 = Double.parseDouble(parts[4]);
        double assigment3 = Double.parseDouble(parts[5]);
        double totalMark = assigment1 + assigment2 + assigment3;
        System.out.println("Student " + (lineCount - 2) + "Name: " + studentName);
        System.out.println("Student " + (lineCount - 2) + "ID: " + studentID);
          }
        
    }
}
}
   
    


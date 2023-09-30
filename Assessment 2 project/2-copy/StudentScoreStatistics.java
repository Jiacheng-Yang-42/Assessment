
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
            int lineCount = 0;
     while (scanner.hasNextLine()) {
        lineCount++;
        String input = scanner.nextLine();
        String[] parts = input.split(",");
    if(lineCount == 1){
        String unitName = parts[0]; 
        System.out.println(unitName);
        System.out.println();
    }else if(lineCount >= 3){
        String studentName = parts[0] + " " + parts[1];
        String studentID = parts[2];
        double assignment1 = 0.0;
        double assignment2 = 0.0;
        double assignment3 = 0.0;
    if(parts.length >=4 && !parts[3].isEmpty()){
            assignment1 = Double.parseDouble(parts[3]);
        }
    if(parts.length >=5 && !parts[4].isEmpty()){
            assignment2 = Double.parseDouble(parts[4]);
        }
    if(parts.length >=6 && !parts[5].isEmpty()){
            assignment3 = Double.parseDouble(parts[5]);
        }
        double totalMark = assignment1 + assignment2 + assignment3;
        System.out.println("Student " + (lineCount - 2) + "Name: " + studentName);
        System.out.println("Student " + (lineCount - 2) + "ID: " + studentID);
        System.out.println("Assignment1: " + assignment1 + "  ");
        System.out.println("Assignment2: " + assignment2 + "  ");
        System.out.println("Assignment3: " + assignment3);
        System.out.println("Totals: " + totalMark);
        System.out.println();
      }
   }
  }catch (FileNotFoundException e) {
    System.out.println("File not found: " + "prog5001_students_grade_2022.csv");
  }
 }
}


   
    


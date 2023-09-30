
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
            String unitName = null;
            int studentCount = 0;
        while (scanner.hasNextLine()) {
                String input = scanner.nextLine();
                String[] parts = input.split(",");
        }
    String studentName = parts[0] + " " + parts[1]; 
    }
}
}
   
    


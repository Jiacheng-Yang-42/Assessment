
/**
 * Write a description of class Project here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class Assignmentscore{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Student[] student = new Student[30];
        int count = 0;
        System.out.println("Enter the assignment name: ");
        String AssignmentName = scanner.nextLine();
        while (count<30){
        System.out.println("Enter student's assignment score: ");
        double score= scanner.nextDouble();
            if(score<0 | score>30){
                System.out.println("Error: Enter a valid mark (0-30).");
                continue;
        }
    }
}
}
    

        
    


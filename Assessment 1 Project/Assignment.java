
/**
 * Write a description of class Project here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class Assignment{
//
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the assignment name: ");
        String assignmentName = scanner.nextLine();
        double[] studentScores = new double[30];
        for (int i =0;i <30;i++){
        while(true) {
        System.out.println("Enter student's assignment score"+(i+1)+": "); 
        double score = scanner.nextDouble();
        if(score>= 0 && score<= 30){
          studentScores[i] = score;break;
        }else{
            System.out.println("Error: Enter a valid score (0-30).");
        }
    }   
}
//
System.out.println("Assignment Name: " + assignmentName);
//
double[] scores = findHighestAndLowestScores(studentScores);
System.out.println("Highest Score: " + scores[0]);
System.out.println("Lowest Score: " + scores[1]);
}
//
public static double[] findHighestAndLowestScores(double[] scores){
double highest = scores[0];
for(double score:scores){
    if(score> highest){
       highest = score; 
    }
}
double lowest = scores[1];
for(double score:scores){
    if(score< lowest ){
        lowest = score;
    }
}
return scores;
}
}



        
        

       
        

    

        
    


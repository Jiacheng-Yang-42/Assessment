
/**
 * Write a description of class Project here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class Assignment{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        //F1: Allows the user to input the assignment name
        System.out.println("Enter the assignment name: ");
        String assignmentName = scanner.nextLine();
        double[] studentScores = new double[30];//30 students in total
        //F2: Allows the user to input students' score for the assignment.
        for (int i =0;i <30;i++){
        while(true) {
        System.out.println("Enter student's assignment score"+(i+1)+": "); 
        //F3:Show error message to user and re-enter
        double score = scanner.nextDouble();
        if(score>= 0 && score<= 30){
          studentScores[i] = score;break;
        }else{
            System.out.println("Error: Enter a valid score (0-30).");
        }
    }   
}
//F4:Prints the assignment name after the "Student's assignment" score.
System.out.println("Assignment Name: " + assignmentName);
//F5:Print the highest and lowest scores.
double highestScore =findHighestScore(studentScores);
double lowestScore =findLowestScore(studentScores);
System.out.println("Highest Score: " + highestScore);
System.out.println("Lowest Score: " + lowestScore);
scanner.close();
//F6:Print the mean and standard deviation of the scores.
double mean= calculateMean(studentScores);
double standardDeviation= calculateStandardDeviation(studentScores,mean);
System.out.println("Mean: " + mean);
System.out.println("Standard Deviation: " + standardDeviation);
scanner.close();
}
//Algorithm 1:Find Highestscore.
public static double findHighestScore(double[] scores){
double highestScore = scores[0];
for(double score:scores){
    if(score> highestScore){
       highestScore = score; 
    }
}
return highestScore;
//Algorithm 1:Find Lowestscore.
}
public static double findLowestScore(double[] scores){
double lowestScore = scores[0];
for(double score:scores){
    if(score< lowestScore ){
        lowestScore = score;
    }
}
return lowestScore;
}
//Algorithm 2:Calculate Mean.
public static double calculateMean(double[] scores){
    double sum = 0;
    for(double score:scores){ 
        sum += score;
    }
    return sum / scores.length;
    }
//Algorithm 2:Calculate Standard Deviation.
public static double calculateStandardDeviation(double[] scores,double mean){
    double sumSquaredDifferences =0;
    for(double score: scores){
        double difference = score- mean;
        sumSquaredDifferences = difference * difference;
        double standardDeviation = sumSquaredDifferences / scores.length;
    }
    return sumSquaredDifferences / scores.length;
}
}





        
        

       
        

    

        
    


package Grade;
import java.util.*;

public class GradeCalculator {
    public static void main(String[] args) {
        int numSubjects, marks, totalMarks = 0;
        double avgPercentage;
        char grade;
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter Number of Subjects:");
        numSubjects = scanner.nextInt();
        
        for (int i = 1; i <= numSubjects; i++) {
            System.out.println("Enter marks obtained in subject " + i + ":");
            marks = scanner.nextInt();
            totalMarks += marks;
        }
        
        avgPercentage = (double) totalMarks / numSubjects;
        
        if (avgPercentage <= 100 && avgPercentage >= 90) {
            grade = 'A';
        } else if (avgPercentage < 90 && avgPercentage >= 80) {
            grade = 'B';
        } else if (avgPercentage < 80 && avgPercentage >= 70) {
            grade = 'C';
        } else if (avgPercentage < 70 && avgPercentage >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }
        
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + avgPercentage);
        System.out.println("Grade: " + grade);
        
        scanner.close();
    }
}

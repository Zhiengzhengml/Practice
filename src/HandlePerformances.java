import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class HandlePerformances {
    
    Queue<Performance> performances = new LinkedList<>();
    Scanner input = new Scanner(System.in);
    
public void handlePerformances(){
    int option;
    do{
    System.out.println("Enter the option to handle performance");
    System.out.println("Option1:Add performance");
    System.out.println("Option2:Display all the performances");
    System.out.println("Option3:Start the performances");
    System.out.println("Option4:QUIT");
    option = input.nextInt();
    input.nextLine();
    switch(option){
        case 1:
        System.out.println("How many performances would you like to add?");
        int number = input.nextInt();
        input.nextLine();
        for(int i=0;i<number;i++){
            System.out.println("Enter the ID of the performance" +(i+1) +":");
            String newperformanceID = input.nextLine();
            System.out.println("Enter the name of the performance"+(i+1) +":");
            String newperformanceName = input.nextLine();
            System.out.println("Enter the leadname of the performance:"+(i+1) +":");
            String newperformanceLeadName = input.nextLine();
            addPerformances(newperformanceID,newperformanceName,newperformanceLeadName);
        }
        break;
        case 2:
        displayPerformances();
        case 3:
        startPerformance();
        case 4:
        break;
        default:
        System.out.println("Invalid choice,Please enter a valid choice.");
        }
    }while(option !=4);
}

    public void addPerformances(String performanceID,String performanceName,String performanceLeadName){
        Performance Performance = new Performance(performanceID,performanceName,performanceLeadName);
        performances.offer(Performance);
    }
    public void displayPerformances(){
        System.out.println("All performances:"+performances.toString());
    }
    public void startPerformance(){
        System.out.println("The first performance:"+performances.peek());
    }

}


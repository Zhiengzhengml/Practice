import java.time.LocalDate;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception{
    Scanner input = new Scanner(System.in);

    System.out.println("Enter the details of the event:");
    System.out.println("Enter event ID:");
    String eventID = input.nextLine();
    System.out.println("Enter event Name:");
    String eventName = input.nextLine();
    System.out.println("Enter event Venue:");
    String eventVenue = input.nextLine();
    System.out.println("Enter event date(YYYY-MM-DD):");
    String eventDateInput = input.nextLine();
    LocalDate eventDate = LocalDate.parse(eventDateInput);
    Event event = new Event(eventID,eventName,eventVenue,eventDate);
    int choice;
    
    do{
        System.out.println("Now you can do the following:");
        System.out.println("1.Add attendee");
        System.out.println("2.Remove attendee");
        System.out.println("3.Update an attendee in the list");
        System.out.println("4.Search an attendee in the list");
        System.out.println("5.Display the details of attendees");
        System.out.println("6.Handle complementary passes");
        System.out.println("7.Handle performances");
        System.out.println("8.Enter the seat number to find the attendee:");
        System.out.println("9.Exit.");
        System.out.println("Enter the choice what you want to do(1-9):");
        choice = input.nextInt();  
        event.organizeEvent(choice);
    }while(choice != 9);  
    System.out.println(event);
   input.close();
}
}

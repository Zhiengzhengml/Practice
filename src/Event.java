import java.time.LocalDate;
import java.util.*;

public class Event {
    private String eventID;
    private String eventName;
    private String eventVenue;
    private LocalDate eventDate;
    ArrayList<Attendee> eventAttendees = new ArrayList<>();//和ArrayList<String> ...是一样的
    Scanner input = new Scanner(System.in);

    public Event(){}

    public String getEventID() {
        return eventID;
    }
    public void setEventID(String eventID) {
        this.eventID = eventID;
    }
    public String getEventName() {
        return eventName;
    }
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }
    public String getEventVenue() {
        return eventVenue;
    }
    public void setEventVenue(String eventVenue) {
        this.eventVenue = eventVenue;
    }
    public LocalDate getEventDate() {
        return eventDate;
    }
    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }
    public ArrayList<Attendee> getEventAttendees() {
        return eventAttendees;
    }
    public void setEventAttendees(ArrayList<Attendee> eventAttendees) {
        this.eventAttendees = eventAttendees;
    }
    public Event(String eventID, String eventName, String eventVenue, LocalDate eventDate) {
        this.eventID = eventID;
        this.eventName = eventName;
        this.eventVenue = eventVenue;
        this.eventDate = eventDate;
        this.eventAttendees = new ArrayList<>();
    }

    HashMap<String,Attendee> seatDetails = new HashMap<>(200,0.6f);
    final int CAPACITY = 200;
    public void setSeatDetails(String seatNo,Attendee attendee) {
        seatDetails.put(seatNo,attendee);
    }
    public Attendee getSeatDetails(String seatNumber) {
        return seatDetails.get(seatNumber);
    }
    
    
    public void organizeEvent(int choice){
     switch(choice){
        case 1:
        System.out.println("Enter the total number of attendees:");
        int number = input.nextInt();
        input.nextLine();
        for(int i=0;i<number;i++){
            System.out.println("Enter the name of the attendee" +(i+1) +":");
            String name = input.nextLine();
            System.out.println("Enter the gender(male/female) of the attendee"+(i+1) +":");
            String gender = input.nextLine();
            System.out.println("Enter the age of the attendee"+(i+1) +":");
            int age = input.nextInt();
            input.nextLine();
            System.out.println("Enter the seat number([A-C]#) of the attendee"+(i+1) +":");
            String seatNo = input.nextLine(); 
            Attendee newAttendee = new Attendee(name,gender,age,seatNo);
            eventAttendees.add(newAttendee);
            seatDetails.put(seatNo, newAttendee);
        }
        break;
        case 2:
        System.out.println("Enter the name of the attendee you want to remove:");
        String nameToRemove = input.nextLine();
        for(Attendee attendee : eventAttendees){
            if(nameToRemove.equals(attendee.getName())){   //eventAttendees.removeIf(attendee -> attendee.getName().equals(nameToRemove));
                eventAttendees.remove(attendee);
                break;
            }
        }
        System.out.println("'" + nameToRemove + "'" + "removed successfully.");
        break;
        case 3:
        System.out.print("Enter the name of attendee you want to update：");
        String nameToUpdate = input.nextLine();
        for(Attendee attendee : eventAttendees){
            if(nameToUpdate.equals(attendee.getName())){
            System.out.println("Enter the new name or enter 'null' if you don't want to update:");
            String newName = input.nextLine();
            if(!newName.equals("null")){
                attendee.setName(newName);
            }
            System.out.println("Enter the new gender,or enter 'null' if you don't want to update: ");
            String newGender = input.nextLine();
            if(!newGender.equals("null")){
                attendee.setGender(newGender);
            }
            System.out.println("Enter the new age,or enter 'null' if you don't want to update: ");
            int newAge = input.nextInt();
            input.nextLine();
            if(newAge !=0 ){
                attendee.setAge(newAge);
            }    
        }
    }break;
        case 4:
        System.out.print("Enter the name of the anttendee you want to find：");
        String nameToFind = input.next();
        for(Attendee attendee : eventAttendees){
            if (attendee.getName().equals(nameToFind)) {
                System.out.println(attendee);
                System.out.println("\n" + "'" + nameToFind + "'" + " found in the list.");
            } else {
                System.out.println("Didn't find.");
            }break;
        }break;
        case 5:
        System.out.println("Here is the list of attendees:" + "\n" + eventAttendees);
        break;
        case 6:
        HandleComplementaryPasses complement = new HandleComplementaryPasses();
        complement.handleComplementaryPasses();
        break;
        case 7:
        HandlePerformances performance = new HandlePerformances(); 
        performance.handlePerformances();
        break;
        case 8:
        System.out.println("Enter the seat number to find its details:");
        String seat = input.nextLine();
        if(seatDetails.containsKey(seat)){
            System.out.println("the details of the attendee:"+ seatDetails.get(seat));
            }else{
                System.out.println("Didn't find.");
            }break;
        case 9:
        break;
        default:
        System.out.println("Invalid choice");
        }
    }


    @Override
    public String toString(){
        return "The details of the event:" +
               "\nEvent ID=" + eventID + 
               "\nEvent name=" + eventName + 
               "\nEvent venue=" + eventVenue + 
               "\nEvent date=" + eventDate + 
               "\nEvent attendees=" + eventAttendees;
    }
}

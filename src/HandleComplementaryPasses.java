import java.util.*;

public class HandleComplementaryPasses {
    Scanner input = new Scanner(System.in);
    Stack<ComplementaryPasses> comPassess = new Stack<>();

    public void handleComplementaryPasses(){
        int choice= 0;
        do{
            System.out.println("Here are the complementary passes operations available to you:");
            System.out.println("Type 1 to redeem complementary passes:");
            System.out.println("Type 2 to display the list of redeemed complementary passes:");
            System.out.println("Type 3 to display the last redeemed complementary passes:");
            System.out.println("Type 4 to undo the redeemed complementary passes:");
            System.out.println("Type 5 to quit:");
            choice = input.nextInt();
            input.nextLine();
            switch(choice){
                case 1:
                System.out.println("How many complementary passes would you like to redeem?");
                int num = input.nextInt();
                input.nextLine();
                redeemComplementaryPassess(num);
                break;
                case 2:
                displayComplementaryPasses();
                break;
                case 3:
                displayLastRedeemedComplementaryPasses();
                break;
                case 4:
                undoRedeemedComplementaryPass();
                break;
                case 5:
                break;
                default:
                System.out.println("Invalid choice,Please enter a valid choice.");
            }
        }while(choice !=5);
    }

    public void redeemComplementaryPassess(int numOfPasses){
        if(comPassess.size() >= 10){
            System.out.println("\n" + "Invalid operation.All the complementary passes have already been redeemed.");
            System.out.println("\n" + "Would you like to see the list of redeemed complementary passes?(Y/N)");
            char choice = input.nextLine().charAt(0);
            if(choice == 'Y'){
                displayComplementaryPasses();
                return;
            }
        }else{
            int i=0;
            do{
                System.out.println("Enter the detail of Complementary Pass" + (i+1) +":");
                System.out.println("Enter the Complementary Pass ID:");
                String ID = input.nextLine();
                System.out.println("Enter the access level:");
                String accessLevel = input.nextLine();
                ComplementaryPasses pass = new ComplementaryPasses(ID,accessLevel);
                comPassess.push(pass);
                i++;
            }while(i<numOfPasses);
        }
    }
    public void displayComplementaryPasses(){
        System.out.println("Here is the list of redeemed complementary passes:" + "\n" + comPassess);
    }
    public void displayLastRedeemedComplementaryPasses(){
        System.out.println("The last redeemed complementary pass is:" + "\n" + comPassess.peek());
    }
    public void undoRedeemedComplementaryPass(){
        System.out.println("Enter the Pass ID you want to undo:");
        String ID = input.nextLine();
        for(ComplementaryPasses pass: comPassess){
            if(pass.getPassID().equals(ID)){
                comPassess.pop();
                System.out.println("The pass with the ID" + ID + "has been removed from the redeemed list.");
                return;
            }
        }
    }
}

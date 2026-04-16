package g1.presentation;
import java.util.Scanner;
public class AdminMenu {

    Scanner scanner;

    public AdminMenu(Scanner scanner){
        this.scanner = scanner;
    }


    public void run(){
        String choice;
    
    do{
        printAdminMenu();
        choice = getChoice();
        switch (choice) {
            case "1":
                System.out.println("Showing product menu");
                break;
            case "2": 
                System.out.println("Showing material menu");
                break;
            case "3":
                System.out.println("Showing account menu");
                break;
            case "9":
                System.out.println("Exiting");
                break;
            default:
                System.out.println("Not a valid choice, try again.");
                break;
        }
    } while(!(choice.equals("9")));
}
                


    
                
    

                
            
        
    

  
public void printAdminMenu() {

        System.out.println();
        System.out.println(" -------Admin Menu--------");
        System.out.println("| 1) Show product menu");
        System.out.println("| 2) Show material menu");
        System.out.println("| 3) Show Account Menu");
        System.out.println("| 9) Exit");
        System.out.println(" -------------------------");
        System.out.println();
    }

    
public String getChoice(){

    System.out.print("Enter menu choice: ");
    return scanner.nextLine();

    }
    }
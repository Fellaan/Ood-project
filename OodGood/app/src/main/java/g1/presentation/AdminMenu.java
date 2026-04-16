package g1.presentation;
import java.util.Scanner;
public class AdminMenu {

    Scanner scanner;
    MaterialMenu materialMenu;
    productMenu productMenu;
    AccountMenu accountMenu;

    public AdminMenu(Scanner scanner, MaterialMenu materialMenu, productMenu productMenu, AccountMenu accountMenu){
        this.scanner = scanner;
        this.materialMenu = materialMenu;
        this.productMenu = productMenu;
        this.accountMenu = accountMenu;
    }


    public void run(){
        String choice;
    
    do{
        printAdminMenu();
        choice = getChoice();
        switch (choice) {
            case "1":
                System.out.println("Showing product menu");
                productMenu.run();
                break;
            case "2": 
                System.out.println("Showing material menu");
                materialMenu.run();
                break;
            case "3":
                System.out.println("Showing account menu");
                accountMenu.run();
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
        System.out.println(" -----------------");
        System.out.println("| 1) Show product menu");
        System.out.println("| 2) Show material menu");
        System.out.println("| 3) Show Account Menu");
        System.out.println("| 9) Exit");
        System.out.println(" -----------------");
        System.out.println();
    }

    
public String getChoice(){

    System.out.print("Enter a choice:");
    return scanner.nextLine();

    }
    }
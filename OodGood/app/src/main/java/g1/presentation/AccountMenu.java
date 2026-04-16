package g1.presentation;
import java.util.Scanner;


public class AccountMenu {
    Scanner scanner;
    public AccountMenu(Scanner scanner) {
        this.scanner = scanner;
    }

  public void run() {
        String choice;

        printAccountMenu();
        do {
            choice = getChoice();
            switch (choice) {
                case "1":           //Här skapas ett nytt konto
                    System.out.println("A new account has been created");
                    break;

                case "2":           //Här raderas ett konto
                    System.out.println("Enter username to be deleted: ");
                    String usernameToDelete = scanner.nextLine();
                    System.out.println("Account removed: " + usernameToDelete);
                    break;

                case "9":       //Här avslutas appen
                    break;
                default:
                    System.err.println("Wrong input, please try again"); //Om man trycker fel får man det här felmeddelandet
            }
        } while (!(choice.equals("9")));        
    }

    public  String getChoice() {
        System.out.println("Enter menu choice: ");
        return scanner.nextLine();
    }

    private void printAccountMenu() {
        String menuText =   """
            -------------------
            | 1) Create account
            | 2) Remove account
            | 9) Return
            ----------------""";

        System.out.println(menuText);
    }
}



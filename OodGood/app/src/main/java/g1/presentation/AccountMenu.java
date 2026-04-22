package g1.presentation;
import g1.application.AccountService;


public class AccountMenu {
    InputHandler input;
    AccountService acc;
    public AccountMenu(InputHandler input, AccountService acc) {
        this.input = input;
        this.acc = acc;
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
                    String usernameToDelete = input.inputString();
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
        System.out.print("Enter menu choice: ");
        return input.inputString();
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



package g1.presentation;
import g1.application.AccountRecord;
import g1.application.AccountService;



public class AccountMenu {
    InputHandler input;
    AccountService acc;
    String username;
    String password;
    String access;
    Boolean boolAccess;
    Boolean passwordAccepted;
    public AccountMenu(InputHandler input, AccountService acc) {
        this.input = input;
        this.acc = acc;
    }

  public void run() {
        String choice;

        
        do {
            printAccountMenu();
            choice = getChoice();
            switch (choice) {
                case "1":           //Här skapas ett nytt konto 
                
                createAccount();

                        
                    break;
                case "2":           //Här raderas ett konto
                removeAccount();
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

    private void createAccount(){
        passwordAccepted = true;

        do{
        System.out.print("Username: ");
        username = input.inputString();
        } while (acc.checkUsername(username));




        do{
        System.out.print("Password: ");
        password = input.inputString();
        if (password.length() >= 8){
            passwordAccepted = false;
        } else{
            System.out.println("Password needs to be minumum 8 characters long! Please try agian.");
        }
        }while (passwordAccepted);

        do{
        System.out.println("User access (admin or user)");
        System.out.print("Enter: ");

        access = input.inputString();
        } while (!(access.equals("admin") || access.equals("user")));

        if (access.equals("admin")){
            boolAccess = true;
        } else {
            boolAccess = false;
        }

        acc.createAccount(new AccountRecord(username, password, boolAccess));
    }


    public void removeAccount(){


         do{
        System.out.print("Account to remove:    (Press 9 to return to menu)");
        username = input.inputString();
            if (username.equals("9")){
                break;
            }


        } while (!(!acc.checkUsername(username) && username.equals("admin")));

        acc.removeAccount(username);

    }


}



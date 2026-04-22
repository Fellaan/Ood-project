package g1.presentation;

import g1.application.AccountService;


public class LoginMenu {

    
    InputHandler input;
    AdminMenu adminMenu;
    userMenu userMenu;
    String usr;
    String psw;
    AccountService acc;

    public LoginMenu(InputHandler input, AdminMenu adminMenu, userMenu userMenu, AccountService acc) {
        this.input = input;
        this.adminMenu = adminMenu;
        this.userMenu = userMenu;
        this.acc = acc;
        
    }

    

    public void runMenu(){

        Boolean correctLogin = false;

        //Allt nedanför ersätts när vi ska skapa vidare med login funktionen

        do {
            System.out.print("Username: ");
            usr = input.inputString();
            
            System.out.print("Password: ");
            psw = input.inputString();
            
            if(acc.login(usr, psw)){
                correctLogin = true;
                if (acc.accessAuth(usr)){
                    adminMenu.run();
                } else
                    userMenu.run();
    
            } else
                System.out.println("Wrong login, please try agian!");


    } while (!(correctLogin));}

   



}

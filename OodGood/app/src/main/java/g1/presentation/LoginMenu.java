package g1.presentation;

import java.util.Scanner;

import g1.application.AccountService;


public class LoginMenu {

    
    Scanner scanner;
    AdminMenu adminMenu;
    userMenu userMenu;
    String username = "admin";
    String password = "admin";
    String usr;
    String psw;
    AccountService acc;

    public LoginMenu(Scanner scanner, AdminMenu adminMenu, userMenu userMenu, AccountService acc) {
        this.scanner = scanner;
        this.adminMenu = adminMenu;
        this.userMenu = userMenu;
        this.acc = acc;
        
    }

    

    public void runMenu(){

        Boolean correctLogin = false;

        //Allt nedanför ersätts när vi ska skapa vidare med login funktionen

        do {
            System.out.print("Username: ");
            usr = getChoice();
            
            System.out.print("Password: ");
            psw = getChoice();
            
            if(acc.login(usr, psw)){
                correctLogin = true;
                if (acc.accessAuth(usr)){
                    adminMenu.run();
                } else
                    userMenu.run();
    
            } else
                System.out.println("Wrong login, please try agian!");

          



    } while (!(correctLogin));}

    public String getChoice(){
        return scanner.nextLine();
    }





}

package g1.presentation;

import java.util.Scanner;


public class LoginMenu {

    
    Scanner scanner;
    String username = "admin";
    String password = "admin";
    String usr;
    String psw;

    public LoginMenu(Scanner scanner) {
        this.scanner = scanner;
    }

    

    public void runMenu(){

        Boolean correctLogin = false;

        //Allt nedanför ersätts när vi ska skapa vidare med login funktionen

        do {
            System.out.print("Username: ");
            usr = getChoice();
            
            System.out.print("Password: ");
            psw = getChoice();
            

            if (usr.equals(username) && psw.equals(password) || usr.equals("user") && psw.equals("user") ){
                correctLogin = true;   
            }

            else{
                System.out.println("Login not correct, please try agian");
            }
        } while (!correctLogin);

        System.out.println("Nice login bro");
        if (usr.equals("admin")){
            System.out.println("Damn admin is mogging");
        }else{
            System.err.println("Lil bro");
        }



    }

    public String getChoice(){
        return scanner.nextLine();
    }





}

package g1.presentation;

public class LoginMenu {

    
    InputHandler input;
    AdminMenu adminMenu;
    userMenu userMenu;
    String username = "admin";
    String password = "admin";
    String usr;
    String psw;

    public LoginMenu(InputHandler input, AdminMenu adminMenu, userMenu userMenu) {
        this.input = input;
        this.adminMenu = adminMenu;
        this.userMenu = userMenu;
        
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
            adminMenu.run();
        }else{
            System.err.println("Lil bro");
            userMenu.run();
        }



    }

    public String getChoice(){
        return input.inputString();
    }





}

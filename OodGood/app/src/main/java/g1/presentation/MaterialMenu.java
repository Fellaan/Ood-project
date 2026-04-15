package g1.presentation;

import java.util.Scanner;

public class MaterialMenu {

    Scanner scanner;

    public MaterialMenu(Scanner scanner){
        this.scanner = scanner;
    }

    public void run(){
        String choice;
        
        do{
            printMaterialMenu();
            choice = getChoice();

            switch (choice) {
                case "1":
                    System.out.println("Here you can create a Material");
                    break;
                case "2":
                    System.out.println("Here you can remove a Material");
                    break;
                case "3":
                    System.out.println("Here you can list Materials");
                    break;
                case "4":
                    System.out.println("Here you can see Material Info");
                    break;
                case "5":
                    System.out.println("Returning to the Main menu");
                    break;
                default:
                    System.out.println("Not a valid choice, try again.");
                    break;
            }
        }
        while(!(choice.equals("5")));


    }

    public String getChoice(){
        System.out.print("Enter a choice: ");
        return scanner.nextLine();
    }

    public void printMaterialMenu(){
        System.out.println("""
                ---------------- Material Menu ----------------
                | 1) Create Material
                | 2) Remove Material
                | 3) List Materials
                | 4) Show Material Info
                | 5) Return to Main Menu
                ----------------------------------------------"""
            );
    }


}

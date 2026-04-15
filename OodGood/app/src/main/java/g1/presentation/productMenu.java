package g1.presentation;

import java.util.Scanner;

public class productMenu {
    Scanner scanner;

    public productMenu(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {
        String choice;

        printMenu();

        do {
            choice = getChoice();
            switch (choice) {
                case "1":  // Skapa ny produkt
                    System.out.println("Creating new product...\n" );
                    printMenu(); // Får upp menyn igen efter varje val för enklare navigering.
                    break;
                case "2":   // Ta bort produkt som specifieras
                    System.out.println("Removing product...\n");
                    printMenu();
                    break;
                case "3":   // Skriv ut lista på alla produkter som finns
                    System.out.println("Listing all products...\n");
                    printMenu();
                    break;
                case "4":   // Visar information på en produkt som specifieras
                    System.out.println("Showing info of product X: ...\n");
                    printMenu();
                    break;
                case "5":   // Räknar ut miljö påverkan av produkt som specifieras
                    System.out.println("Calculating impact of product X ...\n");
                    printMenu();
                    break;
                case "9":
                    System.out.println("Buh bye!");
                    break;
            
                default:
                    System.err.println("Not a valid menu option, please try again!");
                    
            }
        } while (!(choice.equals("9")));
    }


    private String getChoice() {        //Öppnar ny scanner, det skulle vi lösa på annat sätt?
        System.out.print("Enter menu alternative: ");
        String input = scanner.nextLine();
        return input;
    }


    private void printMenu() {          // Meny layout, idéer på design välkomnas.
        String menuText = """
                 ---------------- Product Menu ----------------
                | 1) Create new product
                | 2) Remove an existing product
                | 3) List all existing products
                | 4) Show info of specific product
                | 5) Calculate environmental impact of a product
                | 9) Return to Main menu
                 ----------------------------------------------""";

        System.out.println(menuText);
    }

}

package g1.presentation;

import java.util.ArrayList;
import java.util.Scanner;

import g1.application.ProductApplicationService;

public class productMenu {
    Scanner scanner;
    ArrayList<String> materials;
    ProductApplicationService pas;
    String choice;
    String name;
    int amount;
    int lifespan;

    public productMenu(Scanner scanner, ProductApplicationService pas) {
        this.scanner = scanner;
        this.pas = pas;
    }

    public void run() {

       

        do {
            
            printMenu();
            choice = getChoice();
            switch (choice) {
                case "1":  // Skapa ny produkt
                    createProduct();
                    
                    break;
                case "2":   // Ta bort produkt som specifieras
                    pas.removeProduct(name);
                    
                    break;
                case "3":   // Skriv ut lista på alla produkter som finns
                    pas.showList();
                    
                    break;
                case "4":   // Visar information på en produkt som specifieras
                    pas.getDetails(name);
                    
                    break;
                case "5":   // Räknar ut miljö påverkan av produkt som specifieras
                    pas.calcImpact(name);
                    
                    break;
                case "6":
                    pas.showGuidance(name);
                    break;
                case "9":
                    System.out.println("Buh bye!");
                    break;
            
                default:
                    System.err.println("Not a valid menu option, please try again!");
                    
            }
        } while (!(choice.equals("9")));
    }


    private String getChoice() {
        System.out.print("Enter menu choice: ");
        String input = scanner.nextLine();
        return input;
    }


    private void printMenu() {          // Meny layout, idéer på design välkomnas.
        String menuText = """
                 ----------------- Product Menu -----------------
                | 1) Create new product
                | 2) Remove an existing product
                | 3) List all existing products
                | 4) Show info of specific product
                | 5) Calculate environmental impact of a product
                | 6) Show recycling guidance
                | 9) Return to Main menu
                 ----------------------------------------------""";

        System.out.println(menuText);
    }

    private void createProduct(){
             System.out.print("Enter product name: " );
                    name = scanner.nextLine();
                    while (true) {
                        try {
                            System.out.print("How many materials is needed to create product? ");
                            amount = Integer.parseInt(scanner.nextLine());
                            break;
                            
                        } catch (Exception e) {
                            // TODO: handle exception
                            System.err.println("Enter an number please!");
                        }
                    }
                    while (true) {
                        try {
                            System.out.print("Enter estimated lifespan of product: ");
                            lifespan = Integer.parseInt(scanner.nextLine());
                            break;
                            
                        } catch (Exception e) {
                            // TODO: handle exception
                            System.err.println("Enter a number please!");
                        }
                    }
                    pas.createProduct(name,materials, lifespan );
    }

}

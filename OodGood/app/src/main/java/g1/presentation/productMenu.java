package g1.presentation;

import java.util.ArrayList;
import g1.application.ProductApplicationService;

public class productMenu {
    InputHandler input;
    ArrayList<String> materials;
    ProductApplicationService pas;
    String choice;
    String name;
    int amount;
    int lifespan;

    public productMenu(InputHandler input, ProductApplicationService pas) {
        this.input = input;
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
        return input.inputString();
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
                    name = input.inputString();
                    
                    System.out.print("How many materials is needed to create product? ");
                    amount = input.inputInt();
                    
                    System.out.print("Enter estimated lifespan of product: ");
                    lifespan = input.inputInt();

                    pas.createProduct(name,materials, lifespan );
    }

}

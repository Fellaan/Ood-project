package g1.presentation;

import java.util.ArrayList;
import g1.application.ProductApplicationService;
import g1.application.ProductApplicationService.productRecord;
import g1.application.ProductApplicationService.productDTO;
import g1.application.ProductApplicationService.materialRecord;

public class productMenu {
    InputHandler input;
    ArrayList<materialRecord> materials = new ArrayList<>();
    ArrayList<String> impactStrategies;
    ProductApplicationService pas;
    String choice;
    String name;
    int amount;
    int lifespan;
    boolean materialDuplicated = false;

    public productMenu(InputHandler input, ProductApplicationService pas) {
        this.input = input;
        this.pas = pas;
        this.impactStrategies = pas.loadImpactStrategies();
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
                    System.out.print("What is the name of the product you want to remove?: ");
                    name = input.inputString();
                    removeProduct(name);
                    break;
                case "3":   // Skriv ut lista på alla produkter som finns
                    showList();
                    break;
                case "4":   // Visar information på en produkt som specifieras
                    System.out.print("What is the name of the product?: ");
                    name = input.inputString();
                    getDetails(name);
                    break;
                case "5":  //factory strategy will be implemented here
                    System.out.print("Name of product?: ");
                    name = input.inputString();
                    if (pas.productExists(name)){
                        calcImpact(name);
                    }
                    else{
                        System.out.println("That product does not exist.");
                    }
                    break;
                case "6":
                    System.out.print("For what Product?: ");
                    name = input.inputString();
                    showGuidance(name);
                    break;
                case "9":
                    System.out.println("Exiting product menu...");
                    break;
                default:
                    System.err.println("Not a valid menu option, please try again!"); 
            }
        } while (!(choice.equals("9")));
    }

    //list all products
    private void showList(){
        for (String product : pas.showList()){
            System.out.println(ProductOutputFormatter.displayProduct(product));
        }
    }
    //get details of specific product
    private void getDetails(String name){
        productDTO product = pas.getDetails(name);
        if (product.name().equals(null)){
            System.out.println("Product you requested does not exist.");
        } else {System.out.println(ProductOutputFormatter.getDetails(product));}
    }

    //factory strategy
    private void calcImpact(String name){
        System.out.println("Impact calculator");
        int count = 1;
        for (String i : impactStrategies){
        System.out.println(count + ". " + i);
        count++;
        }

        while(true){
            System.out.print("Enter strategy to use: ");
            int strategyChoice = input.inputInt();
            if(strategyChoice < 1 || strategyChoice > impactStrategies.size()){
                System.out.println("Not a menu choice. ");
            } 
            else{double impactValue = pas.calcImpact(name, impactStrategies.get(strategyChoice-1));
                System.out.println(ProductOutputFormatter.displayImpact(impactValue));
                break;
            }
        }
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
                | 5) Calculate impact of a product
                | 6) Show recycling guidance
                | 9) Return to Main menu
                 ----------------------------------------------""";

        System.out.println(menuText);
    }
    //creates a product through a record
    private void createProduct(){
        materialDuplicated = false;
        System.out.print("Enter product name: " );
        String prodName = input.inputString();
                    
            do {
                System.out.print("What material do you want? ");
                name = input.inputString();

                System.out.print("How much of this material? ");
                double weight = input.inputDouble();

                for (materialRecord m : materials){
                    if (m.name().equals(name)){
                        System.out.println("You have already added this material.");
                        materialDuplicated = true;
                    }
                }
                
                if (materialDuplicated = false){
                        materialRecord requestedMaterial = new materialRecord(name, weight);
                        materials.add(requestedMaterial);
                    }

                System.out.print("More material to add? y/n ");
                choice = input.inputString();

            } while (choice.equals("y"));

            System.out.print("Category of product? ");
            String category = input.inputString();

            System.out.print("Lifespan of product? ");
            int lifespan = input.inputInt();

            productRecord productRequest = new productRecord(prodName, materials, category, lifespan);
            boolean createStatus = pas.createProduct(productRequest);

            if(createStatus){
                System.out.println("Product successfully created");
            } else{System.out.println("Error in creation");}
        }

    //remove a product
    private void removeProduct(String name){
        String message = pas.removeProduct(name);
        System.out.println(message);
    }
    //display guidance
    private void showGuidance(String name){
        String guidance = pas.showGuidance(name);
        ProductOutputFormatter.displayGuidance(guidance);
    }

}

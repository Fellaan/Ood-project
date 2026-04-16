package g1.presentation;

import java.util.Scanner;
import g1.application.MaterialApplicationService;

public class MaterialMenu {

    Scanner scanner;
    MaterialApplicationService mas;

    public MaterialMenu(Scanner scanner, MaterialApplicationService mas){
        this.scanner = scanner;
        this.mas = mas;
    }

    public void run(){
        String choice;
        
        do{
            printMaterialMenu();
            choice = getChoice();

            switch (choice) {
                case "1":
                    System.out.println("Here you can create a Material");
                    createMaterial();
                    break;
                case "2":
                    System.out.println("Here you can remove a Material");
                    removeMaterial();
                    break;
                case "3":
                    System.out.println("Here you can list Materials");
                    listMaterials();
                    break;
                case "4":
                    System.out.println("Here you can see Material Info");
                    showMaterialInfo();
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
                | 9) Return to Main Menu
                -----------------------------------------------"""
            );
    }

    public void createMaterial(){
        String name = getChoice();
        String recyclingCategory = getChoice();
        int environmentalImpact = Integer.parseInt(getChoice());
        String message = mas.createMaterial(name, recyclingCategory, environmentalImpact);
        System.out.println(message);
    }

    public void removeMaterial(){
        String name = getChoice();
        String message = mas.removeMaterial(name);
        System.out.println(message);
    }

    public void listMaterials(){
        String message = mas.listMaterials();
        System.out.println(message);
    }

    public void showMaterialInfo(){
        String name = getChoice();
        String message = mas.showInfo(name);
        System.out.println(message);
    }


}

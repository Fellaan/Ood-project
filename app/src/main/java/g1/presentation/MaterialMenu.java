package g1.presentation;

import java.io.IOException;

import g1.application.CreateMaterialRequest;
import g1.application.MaterialApplicationService;
import g1.application.MaterialDto;
import g1.application.SaveErrorException;

public class MaterialMenu {

    InputHandler input;
    MaterialApplicationService mas;
    String name;
    String recyclingCategory;
    double emissionFactor;

    public MaterialMenu(InputHandler input, MaterialApplicationService mas){
        this.input = input;
        this.mas = mas;
    }

    // Metod för att köra menyn 
    public void run(){
        String choice;
        
        do{
            printMaterialMenu();
            choice = getChoice();

            //Menyval kallar på metoder 
            switch (choice) {
                case "1":
                    createMaterial();
                    break;
                case "2":
                    removeMaterial();
                    break;
                case "3":
                    listMaterials();
                    break;
                case "4":
                    showMaterialInfo();
                    break;
                case "9":
                    System.out.println("Returning to the Main menu");
                    break;
                default:
                    System.out.println("Not a valid choice, try again.");
                    break;
            }
        }
        while(!(choice.equals("9")));


    }

    //Hanterar input för menyn
    public String getChoice(){
        System.out.print("Enter a choice: ");
        return input.inputString();
    }

    //Menutext
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

    //Menyval för att skapa material
    public void createMaterial(){
        do {
            System.out.print("Name of Material: ");
            name = input.inputString();
        } while (mas.checkMaterial(name));

        do {
            System.out.print("Category of Material: ");
            recyclingCategory = input.inputString();
        } while (!(mas.categoryExists(recyclingCategory)));
            
            System.out.print("Environmental Impact of Material: ");
            emissionFactor = input.inputDouble();

        CreateMaterialRequest request = new CreateMaterialRequest(name, recyclingCategory, emissionFactor);
        try {
            MaterialDto createdMaterial = mas.createMaterial(request);
            System.out.println("\nMaterial created:");
            System.out.println(MaterialOutputFormatter.materialDto(createdMaterial));      
        } catch (SaveErrorException e) {
            System.err.println("Save error: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("File error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        }
    }

    //Menyval för att ta bort Material
    public void removeMaterial(){
        System.out.print("Name of Material to remove: ");
        String name = input.inputString();

        System.out.println("\nRemoved material:");
        try {
            mas.removeMaterial(name);
        } catch (SaveErrorException e) {
            System.err.println("Save error: " + e.getMessage());
        } catch (IOException e){
            System.err.println("File error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        }
        
    }


    //list all materials
    private void listMaterials(){
        System.out.println("List of materials:\n------------------");
        for (MaterialDto mat: mas.listMaterials()){
            System.out.println(MaterialOutputFormatter.displayMaterial(mat));
        }
        System.out.println("\n------------------\n");
    }

    //Menyval för att visa information om ett Material
    public void showMaterialInfo(){
        System.out.print("Name of the Material to display: ");
        String name = input.inputString();

        if(mas.checkMaterial(name)){
            System.out.println("\nSpecified material:");
            System.out.println(MaterialOutputFormatter.materialDto(mas.showInfo(name)));
        } else { 
            System.out.println("Material does not exist.\n");
        }
        
    }


}

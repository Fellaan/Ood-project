package g1.presentation;

import java.util.Scanner;

import g1.application.MaterialApplicationService;
import g1.domain.Material;

public class ConsoleUi {

    public void runMenu(){
        MaterialApplicationService mas = new MaterialApplicationService();
        Material material = mas.createMaterial();
        System.out.println(material);
        String name = mas.showName();
        System.out.println(name );
    }







    public String getChoice(){
        Scanner scanner = new Scanner(System.in);
        
        
        return scanner.nextLine();
    }
}

package g1.presentation;
import java.util.Scanner;

public class InputHandler {
    private Scanner scanner;

    public InputHandler(Scanner scanner){
        this.scanner = scanner;
    }
    //Metod för att returnera Strings
    public String inputString(){
        return scanner.nextLine();
    }

    //Metod för att returnera Int, med felhantering
    public int inputInt(){
       while(true){
        try {
            String input = scanner.nextLine();
            return Integer.parseInt(input);
        } catch (Exception e) {
            System.err.println("Bad input, try again.");
        }
       }
    }

    //Metod för att returnera Double, med felhantering
    public double inputDouble(){
       while(true){
        try {
            String input = scanner.nextLine();
            return Double.parseDouble(input);
        } catch (Exception e) {
            System.err.println("Bad input, try again.");
        }
       }
    }
}

package g1.presentation;
import java.io.Console;
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

    
    public String inputHidden() {
    // Fungerar endast när man kör programmet som en .jar
    Console console = System.console();
    if (console != null) {
        char[] chars = console.readPassword();
        return new String(chars);
    }

    // Om man kör genom gradle så fungerar inte console input, därav finns denna som backup.
    System.out.print("Enter (hidden not supported here): ");
    return inputString();
}

    //Metod för att returnera Int, med felhantering
    public int inputInt(){
       while(true){
        try {
            String input = scanner.nextLine();
            return Integer.parseInt(input);
        } catch (Exception e) {
            System.err.println("Input needs to be a number, please try again.");
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
            System.err.println("Inputs need to be a number, please try again.");
        }
       }
    }
}

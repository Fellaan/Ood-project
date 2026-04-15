package g1.presentation;

import java.util.Scanner;

public class userMenu {
    
    Scanner scanner;

    public userMenu(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {
        String choice;

        printMenu();

        do {
            choice = getChoice();
            switch (choice) {
                case "1":  // Visar och öppnar produkt menyn
                    System.out.println("Showing product menu...\n" );
                    printMenu(); // Får upp menyn igen efter varje val för enklare navigering.
                    break;
                case "2":   // Visar och öppnar material menyn
                    System.out.println("Showing material menu...\n");
                    printMenu();
                    break;
                case "9":
                    System.out.println("Work has been saved!\nExiting now! Buh bye.");

                    break;
            
                default:
                    System.err.println("Not a valid menu option, please try again!");
                    
            }
        } while (!(choice.equals("9")));
    }


    private String getChoice() {
        System.out.print("Enter menu alternative: ");
        String input = scanner.nextLine();
        return input;
    }


    private void printMenu() {          // Meny layout, idéer på design välkomnas.
        String menuText = """
                 ---------------- User Menu ----------------
                | 1) Show Product Menu
                | 2) Show Material Menu
                | 9) Save & Exit
                 -------------------------------------------""";

        System.out.println(menuText);
    }

}

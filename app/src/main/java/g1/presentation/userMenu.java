package g1.presentation;

public class userMenu {
    
    InputHandler input;
    MaterialMenu materialMenu;
    productMenu productMenu;

    public userMenu(InputHandler input, MaterialMenu materialMenu, productMenu productMenu) {
        this.input = input;
        this.materialMenu = materialMenu;
        this.productMenu = productMenu;
    }

    public void run() {
        String choice;

        printMenu();

        do {
            choice = getChoice();
            switch (choice) {
                case "1":  // Visar och öppnar produkt menyn
                    System.out.println("Showing product menu...\n" );
                    productMenu.run();
                    printMenu(); // Får upp menyn igen efter varje val för enklare navigering.
                    break;
                case "2":   // Visar och öppnar material menyn
                    System.out.println("Showing material menu...\n");
                    materialMenu.run();
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
        return input.inputString();
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

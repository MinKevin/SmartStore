package menu;


import java.util.StringTokenizer;

import static util.Main.br;
import static util.Main.input;

public class Menu {
    private static Menu menu;

    protected Menu() {}

    public static Menu getInstance() {
        if (menu == null)
            menu = new Menu();
        return menu;
    }

    public void run() {
        String inp = " ";
        while (true) {
            System.out.print(
                    "==============================\n" +
                            " 1. Classification Parameter\n" +
                            " 2. Customer Data\n" +
                            " 3. Summary\n" +
                            " 4. Quit\n" +
                            "==============================\n" +
                            "Choose One:"
            );
            inp = input();

            switch (inp) {
                case "1":
                    GroupMenu.getInstance().run();
                    break;

                case "2":
                    CustomerMenu.getInstance().run();
                    break;

                case "3":
                    SummaryMenu.getInstance().run();
                    break;

                case "4":
                    return;

                default:
                    System.out.println("Invalid Input. Please try again.\n");
                    break;
            }
        }
    }
}

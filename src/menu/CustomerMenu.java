package menu;

import customers.Customers;

import java.util.StringTokenizer;

import static util.Main.br;
import static util.Main.input;

public class CustomerMenu extends Menu {
    private static CustomerMenu customerMenu;

    private CustomerMenu(){}

    public static CustomerMenu getInstance(){
        if (customerMenu == null)
            customerMenu = new CustomerMenu();
        return customerMenu;
    }
    @Override
    public void run() {
        String inp = " ";
        while (true) {
            System.out.printf(
                    "==============================\n" +
                            " 1. Add Customer Data\n" +
                            " 2. View Customer Data\n" +
                            " 3. Update Customer Data\n" +
                            " 4. Delete Customer Data\n" +
                            " 5. Back\n" +
                            "==============================\n" +
                            "Choose One:");
            inp = input();

            switch (inp) {
                case "1":
                    Customers.getInstance().add();
                    break;

                case "2":
                    Customers.getInstance().view();
                    if (Customers.getInstance().size() == 0) break;
                    break;

                case "3":
                    Customers.getInstance().view();
                    if (Customers.getInstance().size() == 0) break;
                    Customers.getInstance().update();
                    break;

                case "4":
                    Customers.getInstance().view();
                    if (Customers.getInstance().size() == 0) break;
                    Customers.getInstance().delete();
                    break;

                case "5":
                    return;

                default:
                    System.out.println("Invalid Input. Please try again.\n");
                    break;

            }
        }
    }
}

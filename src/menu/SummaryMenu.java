package menu;

import customers.ClassifiedCustomersGroup;

import java.util.StringTokenizer;

import static util.Main.br;
import static util.Main.input;

public class SummaryMenu extends Menu {
    private static SummaryMenu summaryMenu;

    private SummaryMenu(){}

    public static SummaryMenu getInstance(){
        if (summaryMenu == null)
            summaryMenu = new SummaryMenu();
        return summaryMenu;
    }

    @Override
    public void run() {
        String inp = " ";
        ClassifiedCustomersGroup.getInstance().sortByGroup();
        while (true) {
            System.out.printf(
                    "==============================\n" +
                            " 1. Summary\n" +
                            " 2. Summary (Sorted By Name)\n" +
                            " 3. Summary (Sorted By Spent Time)\n" +
                            " 4. Summary (Sorted By Total Payment)\n" +
                            " 5. Back\n" +
                            "==============================\n" +
                            "Choose One:");

            inp = input();
            String sort = " ";
            switch (inp) {
                case "1": //사실상 sortedBySerialNO
                    ClassifiedCustomersGroup.getInstance().sortByGroup();
                    ClassifiedCustomersGroup.getInstance().printSorted();
                    break;

                case "2":
                    sort = ClassifiedCustomersGroup.getInstance().selectSortType();
                    ClassifiedCustomersGroup.getInstance().sortByName(sort);
                    break;

                case "3":
                    sort = ClassifiedCustomersGroup.getInstance().selectSortType();
                    ClassifiedCustomersGroup.getInstance().sortBySpentTime(sort);
                    break;

                case "4":
                    sort = ClassifiedCustomersGroup.getInstance().selectSortType();
                    ClassifiedCustomersGroup.getInstance().sortByTotalPayment(sort);
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

package customers;

import groups.Group;
import groups.Groups;

import java.util.Arrays;
import java.util.Comparator;

import static util.Main.input;

public class ClassifiedCustomersGroup { // 싱글톤
    private static ClassifiedCustomersGroup classifiedCustomersGroup;
    protected ClassifiedCustomers[] classifiedCustomers; // Customer[][]

    private ClassifiedCustomersGroup() {

    }

    public static ClassifiedCustomersGroup getInstance() {
        if (classifiedCustomersGroup == null) {
            classifiedCustomersGroup = new ClassifiedCustomersGroup();
        }
        return classifiedCustomersGroup;
    }

    public ClassifiedCustomers[] getClassifiedCustomers() {
        if (classifiedCustomers == null) {
            classifiedCustomers = new ClassifiedCustomers[4];
        }
        return classifiedCustomers;
    }

    public String selectSortType() {
        while (true) {
            System.out.println(
                    "** Press 'end', if you want to exit! **\n" +
                            "Which order (1. ASCENDING, 2. DESCENDING)?"
            );
            String inp = input();

            switch (inp) {
                case "1":
                case "ASCENDING":
                    return "ASC";

                case "2":
                case "DESCENDING":
                    return "DES";
                default:
                    break;
            }
        }
    }

    public void printSorted() {
        System.out.println("\n==========================================");
        for (int i = 0; i < 4; i++) {
            if (Groups.getInstance().getGroupArr()[i] == null)
                continue;
            System.out.println(Groups.getInstance().getGroupArr()[i].getGroupType().name() +
                    "(" + Groups.getInstance().getGroupArr()[i].getGroupType().getLabel() + ") : " +
                    classifiedCustomers[i].size() + " Customer(s)"
            );
            System.out.println("------------------------------------------");
            if (classifiedCustomers[i].size() == 0) {
                System.out.println("No customer...");
            } else {
                for (int j = 0; j < classifiedCustomers[i].size(); j++) {
                    System.out.printf("No. %03d == > ", j + 1);
                    System.out.println(classifiedCustomers[i].getCustomerArr()[j]);
                }
            }
            System.out.println();
        }
        System.out.println("==========================================");
    }

    public void sortByGroup() {
        classifiedCustomers = new ClassifiedCustomers[4];
        for (int i = 0; i < 4; i++)
            classifiedCustomers[i] = new ClassifiedCustomers();
        Group[] groups = Groups.getInstance().getGroupArr();
        Customer[] customers = Customers.getInstance().getCustomerArr();
        for (int i = 0; i < Customers.getInstance().size(); i++) {
            int spentTime = customers[i].getSpentTime();
            int totalPay = customers[i].getTotalPay();

            int minSpentTime = groups[0].getParameter().getMinimumSpentTime();
            int minTotalPay = groups[0].getParameter().getMinimumTotalPay();
            int maxSpentTime, maxTotalPay;
            boolean isSorted = false;
            int exLoc = 0;
            for (int j = 1; j < 4; j++) {
                if (groups[j] == null)
                    continue;
                else {
                    maxSpentTime = groups[j].getParameter().getMinimumSpentTime();
                    maxTotalPay = groups[j].getParameter().getMinimumTotalPay();
                }

                if (spentTime >= minSpentTime &&
                        spentTime < maxSpentTime &&
                        totalPay >= minTotalPay &&
                        totalPay < maxTotalPay) {
                    classifiedCustomers[exLoc].add(customers[i]);
                    isSorted = true;
                    break;
                }
                exLoc = j;
                minSpentTime = maxSpentTime;
                minTotalPay = minTotalPay;
            }
            if (isSorted == false){
                classifiedCustomers[exLoc].add(customers[i]);
            }
        }
    }

    public void arraysSort(int i, Comparator<Customer> cp){
        Arrays.sort(classifiedCustomers[i].getCustomerArr(), 0, classifiedCustomers[i].size(), cp);
    }
    public void sortByName(String order) {
        for (int i = 0; i < 4; i++) {
            if (order == "DES")
                arraysSort(i, Sort.getSort().compareByNameDes);
            else
                arraysSort(i, Sort.getSort().compareByNameASC);
        }
        printSorted();
    }

    public void sortBySpentTime(String order) {
        for (int i = 0; i < 4; i++) {
            if (order == "DES")
                arraysSort(i, Sort.getSort().compareBySpentTimeDes);
            else
                arraysSort(i, Sort.getSort().compareBySpentTimeAsc);
        }
        printSorted();
    }

    public void sortByTotalPayment(String order) {
        for (int i = 0; i < 4; i++) {
            if (order == "DES")
                arraysSort(i, Sort.getSort().compareByTotalPaymentDes);
            else
                arraysSort(i, Sort.getSort().compareByTotalPaymentAsc);
        }
        printSorted();
    }
}

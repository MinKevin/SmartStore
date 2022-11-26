package util;

import customers.Customer;
import customers.Customers;
import groups.Group;
import groups.GroupType;
import groups.Groups;
import groups.Parameter;
import menu.Menu;

import java.util.Objects;

import static util.Main.br;

public class SmartStoreApplication {//싱글톤

    private static SmartStoreApplication smartStoreApplication;
    private Groups allGroups = Groups.getInstance();
    private Customers allCustomers = Customers.getInstance();

    private SmartStoreApplication() {
    }

    ;

    protected static SmartStoreApplication getInstance() {
        if (smartStoreApplication == null)
            smartStoreApplication = new SmartStoreApplication();
        return smartStoreApplication;
    }

    public SmartStoreApplication details() {
        System.out.println("===========================================");
        System.out.println(" Title : SmartStore Customer Classification");
        System.out.println("===========================================\n");
        return this;
    }


    public SmartStoreApplication test() {
        allGroups.getGroupArr()[1] = new Group(GroupType.GENERAL, new Parameter(10, 100000));
        //allGroups.getGroupArr()[2] = new Group(GroupType.VIP, new Parameter(70, 700000));
        allGroups.getGroupArr()[3] = new Group(GroupType.VVIP, new Parameter(100, 1000000));
//        allGroups.add(new Group(GroupType.GENERAL, new Parameter(10, 100000)));
//        allGroups.add(new Group(GroupType.VIP, new Parameter(20, 200000)));
//        allGroups.add(new Group(GroupType.VVIP, new Parameter(30, 300000)));

        for (int i = 0; i < 20; i++) {
            allCustomers.add(new Customer(
                    Character.toString((char) ('a' + i)), (char) ('a' + i) + "12345",
                    i * 10, i * 100000));
        }
        return this;
    }

    /*
     * this is method for running application.
     * */
    public void run() {
        // print main menu
        // call main menu
        // call sub menu by user select
        Menu.getInstance().run();

    }
}

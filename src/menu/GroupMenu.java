package menu;

import groups.GroupType;
import groups.Groups;

import java.util.StringTokenizer;

import static util.Main.br;
import static util.Main.input;

public class GroupMenu extends Menu {
    private static GroupMenu groupMenu;

    private GroupMenu(){}

    public static GroupMenu getInstance(){
        if (groupMenu == null)
            groupMenu = new GroupMenu();
        return groupMenu;
    }

    @Override
    public void run() {
        String inp = " ";
        while (true) {
            System.out.printf(
                    "==============================\n" +
                            " 1. Set Parameter\n" +
                            " 2. View Parameter\n" +
                            " 3. Update Parameter\n" +
                            " 4. Back\n" +
                            "==============================\n" +
                            "Choose One:");

            inp = input();
            String groupType;
            int cntValidGroup;
            switch (inp) {
                case "1":
                    //모든 그룹 정보 출력 및 모든 그룹이 초기화 되어있는지 확인
                    cntValidGroup = Groups.getInstance().view("-1");
                    if (cntValidGroup == 4) {
                        System.out.println("All Groups are initialized!");
                        break;
                    }

                    groupType = Groups.getInstance().selectGroupType();
                    Groups.getInstance().set(groupType);
                    break;

                case "2":
                    Groups.getInstance().view("-1");
                    break;

                case "3":
                    cntValidGroup = Groups.getInstance().view("-1");
                    if (cntValidGroup == 1){
                        System.out.println("No Groups Exist");
                        break;
                    }
                    groupType = Groups.getInstance().selectGroupType();
                    Groups.getInstance().update(groupType);
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

package groups;

import static util.Main.*;

public class Groups {//싱글톤
    private Group[] groupArr;
    private static Groups groups;

    private Groups() {
        groupArr = new Group[groupsCapacity];
        groupArr[0] = new Group(GroupType.NONE);
    }

    public static Groups getInstance() {
        if (groups == null) {
            groups = new Groups();
        }
        return groups;
    }

    public Group[] getGroupArr() {
        return groupArr;
    }

    public String selectGroupType() {
        while (true) {
            System.out.print(
                    "Which group (1. GENERAL, 2. VIP, 3. VVIP)?\n" +
                            "** Press 'end', if you want to exit! **\n" +
                            "Insert Number:"
            );
            String inp = input();
            switch (inp) {
                case "1":
                case "GENERAL":
                    return "1";

                case "2":
                case "VIP":
                    return "2";

                case "3":
                case "VVIP":
                    return "3";

                case "-1":
                case "END":
                    return "-1";

                default:
                    System.out.println("Invalid Input. Please try again.\n");
                    break;
            }
        }
    }

    public void set(String groupType) {
        //입력으로 들어온 groupType를 처리
        //해당 그룹이 초기화되어있을 시 이전으로 돌아감
        if (Integer.parseInt(groupType) == -1)
            return;

        else if (groupArr[Integer.parseInt(groupType)] != null) {
            System.out.println(padding + '\n' + groupArr[Integer.parseInt(groupType)].getGroupType().name() + " group already exists");
            view(groupType);
            return;
        }

        //새로운 그룹 초기화
        switch (groupType) {
            case "0":
                groupArr[0] = new Group(GroupType.NONE);
            case "1":
                groupArr[1] = new Group(GroupType.GENERAL);
                break;
            case "2":
                groupArr[2] = new Group(GroupType.VIP);
                break;
            case "3":
                groupArr[3] = new Group(GroupType.VVIP);
                break;

        }
        update(groupType);
    }

    public int view(String groupType) {
        int cntValidGroup = 0;
        boolean isFirst = false;
        String inputStr = groupType;
        for (int i = 0; i < groupArr.length; i++) {
            if (inputStr == "-1") {//모든 구문 출력
                groupType = String.format("%d", i);
            }

            if (groupArr[i] != null && i == Integer.parseInt(groupType)) {
                cntValidGroup++;
                if (isFirst == false) {
                    System.out.println(padding);
                    isFirst = true;
                }
                System.out.println(
                        "GroupType : " +
                                groupArr[i].getGroupType().name() +
                                " (" + groupArr[i].getGroupType().getLabel() + ")\n" +
                                "Parameter : \n" +
                                "Minimum Spent Time : " + groupArr[i].getParameter().getMinimumSpentTime() + '\n' +
                                "Minimum Total Pay : " + groupArr[i].getParameter().getMinimumTotalPay() + '\n' +
                                padding
                );
            }
        }
        return cntValidGroup;
    }

    public void update(String groupType) {
        while (true) {
            Group presentGroup = groupArr[Integer.parseInt(groupType)];
            String inp = " ";
            Parameter parameter = presentGroup.getParameter();
            System.out.println(
                    "\nGroupType: " +
                            groupArr[Integer.parseInt(groupType)].getGroupType().name() +
                            "(" + groupArr[Integer.parseInt(groupType)].getGroupType().getLabel() + ")\n" +
                            "Parameter : " +
                            parameter.toString() + "\n" +
                            "==============================\n" +
                            " 1. Minimum Spent Time\n" +
                            " 2. Minimum Total Pay\n" +
                            " 3. Save And Exit\n" +
                            "==============================\n" +
                            "Choose One:"
            );

            inp = input();

            switch (inp) {
                case "1":
                    System.out.print("Input Minimum Spent Time:");
                    inp = input();
                    parameter.setMinimumSpentTime(Integer.parseInt(inp));
                    break;

                case "2":
                    System.out.print("Input Minimum Total Pay:");
                    inp = input();
                    parameter.setMinimumTotalPay(Integer.parseInt(inp));
                    break;

                case "3":
                    groupArr[Integer.parseInt(groupType)].setParameter(parameter);
                    System.out.println("New Classification Parameter is administrated");
                    return;

                default:
                    System.out.println("Invalid Input. Please try again.\n");
                    break;
            }
        }

    }

}

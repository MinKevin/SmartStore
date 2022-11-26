package groups;

public class Group {
    private GroupType groupType = GroupType.NONE;
    private Parameter parameter;

    public Group(GroupType groupType, Parameter parameter) {
        this.groupType = groupType;
        this.parameter = parameter;
    }

    public Group(GroupType groupType){
        this.groupType = groupType;
        if (parameter == null){
            parameter = new Parameter();
        }

    }

    public GroupType getGroupType() {
        return groupType;
    }
    public void setGroupType(GroupType groupType) {
        this.groupType = groupType;
    }

    public Parameter getParameter() {
        return parameter;
    }

    public void setParameter(Parameter parameter) {
        this.parameter = parameter;
    }
}


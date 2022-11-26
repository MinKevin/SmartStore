package groups;

public enum GroupType {
	NONE("해당없음"), GENERAL("일반고객"), VIP("우수고객"), VVIP("최우수고객");
	private String label = "";

	GroupType(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
}

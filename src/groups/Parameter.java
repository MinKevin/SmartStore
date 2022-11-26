package groups;

import java.util.Objects;

public class Parameter {
	private int minimumSpentTime;
	private int minimumTotalPay;

	public Parameter() {
	}

	public Parameter(int minimumSpentTime, int minimumTotalPay) {
		this.minimumSpentTime = minimumSpentTime;
		this.minimumTotalPay = minimumTotalPay;
	}

	public int getMinimumSpentTime() {
		return minimumSpentTime;
	}

	public Parameter setMinimumSpentTime(int minimumSpentTime) {
		this.minimumSpentTime = minimumSpentTime;
		return this;
	}

	public int getMinimumTotalPay() {
		return minimumTotalPay;
	}

	public Parameter setMinimumTotalPay(int minimumTotalPay) {
		this.minimumTotalPay = minimumTotalPay;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Parameter parameter = (Parameter) o;
		return minimumSpentTime == parameter.minimumSpentTime && minimumTotalPay == parameter.minimumTotalPay;
	}

	@Override
	public int hashCode() {
		return Objects.hash(minimumSpentTime, minimumTotalPay);
	}

	@Override
	public String toString() {
		return "Parameter{" +
				"minimumSpentTime=" + minimumSpentTime +
				", minimumTotalPay=" + minimumTotalPay +
				'}';
	}
}

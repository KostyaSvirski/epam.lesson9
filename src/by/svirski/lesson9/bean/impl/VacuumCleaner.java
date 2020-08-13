package by.svirski.lesson9.bean.impl;

import by.svirski.lesson9.bean.BeanIndicator;

public class VacuumCleaner implements BeanIndicator{

	private int power;
	private String filterType;
	private String bagType;
	private String wandType;
	private int motorSpeedRegulation;
	private int cleaningWidth;
	
	public VacuumCleaner() {
	}

	public VacuumCleaner(int power, String filterType, String bagType, String wandType, int motorSpeedRegulation,
			int cleaningWidth) {
		this.power = power;
		this.filterType = filterType;
		this.bagType = bagType;
		this.wandType = wandType;
		this.motorSpeedRegulation = motorSpeedRegulation;
		this.cleaningWidth = cleaningWidth;
	}

	public int getPower() {
		return power;
	}

	public String getFilterType() {
		return filterType;
	}

	public String getBagType() {
		return bagType;
	}

	public String getWandType() {
		return wandType;
	}

	public int getMotorSpeedRegulation() {
		return motorSpeedRegulation;
	}

	public int getCleaningWidth() {
		return cleaningWidth;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public void setFilterType(String filterType) {
		this.filterType = filterType;
	}

	public void setBagType(String bagType) {
		this.bagType = bagType;
	}

	public void setWandType(String wandType) {
		this.wandType = wandType;
	}

	public void setMotorSpeedRegulation(int motorSpeedRegulation) {
		this.motorSpeedRegulation = motorSpeedRegulation;
	}

	public void setCleaningWidth(int cleaningWidth) {
		this.cleaningWidth = cleaningWidth;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bagType == null) ? 0 : bagType.hashCode());
		result = prime * result + cleaningWidth;
		result = prime * result + ((filterType == null) ? 0 : filterType.hashCode());
		result = prime * result + motorSpeedRegulation;
		result = prime * result + power;
		result = prime * result + ((wandType == null) ? 0 : wandType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		VacuumCleaner other = (VacuumCleaner) obj;
		if (bagType == null) {
			if (other.bagType != null) {
				return false;
			}
		} else if (!bagType.equals(other.bagType)) {
			return false;
		}
		if (cleaningWidth != other.cleaningWidth) {
			return false;
		}
		if (filterType == null) {
			if (other.filterType != null) {
				return false;
			}
		} else if (!filterType.equals(other.filterType)) {
			return false;
		}
		if (motorSpeedRegulation != other.motorSpeedRegulation) {
			return false;
		}
		if (power != other.power) {
			return false;
		}
		if (wandType == null) {
			if (other.wandType != null) {
				return false;
			}
		} else if (!wandType.equals(other.wandType)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("VacuumCleaner [power=");
		builder.append(power);
		builder.append(", filterType=");
		builder.append(filterType);
		builder.append(", bagType=");
		builder.append(bagType);
		builder.append(", wandType=");
		builder.append(wandType);
		builder.append(", motorSpeedRegulation=");
		builder.append(motorSpeedRegulation);
		builder.append(", cleaningWidth=");
		builder.append(cleaningWidth);
		builder.append("]");
		return builder.toString();
	}

	
}

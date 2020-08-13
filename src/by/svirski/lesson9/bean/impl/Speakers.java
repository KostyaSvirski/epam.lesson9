package by.svirski.lesson9.bean.impl;

import by.svirski.lesson9.bean.BeanIndicator;

public class Speakers implements BeanIndicator{
	
	private int power;
	private int numberOfSpeakers;
	private double minRange;
	private double maxRange;
	private int cordLength;	

	public Speakers() {
	}

	public Speakers(int power, int numberOfSpeakers, double minRange, double maxRange, int cordLength) {
		this.power = power;
		this.numberOfSpeakers = numberOfSpeakers;
		this.minRange = minRange;
		this.maxRange = maxRange;
		this.cordLength = cordLength;
	}

	public int getPower() {
		return power;
	}

	public int getNumberOfSpeakers() {
		return numberOfSpeakers;
	}

	public double getMinRange() {
		return minRange;
	}

	public double getMaxRange() {
		return maxRange;
	}

	public int getCordLength() {
		return cordLength;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public void setNumberOfSpeakers(int numberOfSpeakers) {
		this.numberOfSpeakers = numberOfSpeakers;
	}

	public void setMinRange(double minRange) {
		this.minRange = minRange;
	}

	public void setMaxRange(double maxRange) {
		this.maxRange = maxRange;
	}

	public void setCordLength(int cordLength) {
		this.cordLength = cordLength;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cordLength;
		long temp;
		temp = Double.doubleToLongBits(maxRange);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(minRange);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + numberOfSpeakers;
		result = prime * result + power;
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
		Speakers other = (Speakers) obj;
		if (cordLength != other.cordLength) {
			return false;
		}
		if (Double.doubleToLongBits(maxRange) != Double.doubleToLongBits(other.maxRange)) {
			return false;
		}
		if (Double.doubleToLongBits(minRange) != Double.doubleToLongBits(other.minRange)) {
			return false;
		}
		if (numberOfSpeakers != other.numberOfSpeakers) {
			return false;
		}
		if (power != other.power) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Speakers [power=");
		builder.append(power);
		builder.append(", numberOfSpeakers=");
		builder.append(numberOfSpeakers);
		builder.append(", minRange=");
		builder.append(minRange);
		builder.append(", maxRange=");
		builder.append(maxRange);
		builder.append(", cordLength=");
		builder.append(cordLength);
		builder.append("]");
		return builder.toString();
	}

	
}

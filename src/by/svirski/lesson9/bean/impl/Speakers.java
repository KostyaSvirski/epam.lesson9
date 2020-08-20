package by.svirski.lesson9.bean.impl;

import by.svirski.lesson9.bean.Appliances;

public class Speakers implements Appliances{
	
	private int power;
	private int numberOfSpeakers;
	private String range;
	private int cordLength;	

	public Speakers() {
	}

	public Speakers(int power, int numberOfSpeakers, String range, int cordLength) {
		super();
		this.power = power;
		this.numberOfSpeakers = numberOfSpeakers;
		this.range = range;
		this.cordLength = cordLength;
	}

	public int getPower() {
		return power;
	}

	public int getNumberOfSpeakers() {
		return numberOfSpeakers;
	}

	public String getRange() {
		return range;
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

	public void setRange(String range) {
		this.range = range;
	}

	public void setCordLength(int cordLength) {
		this.cordLength = cordLength;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cordLength;
		result = prime * result + numberOfSpeakers;
		result = prime * result + power;
		result = prime * result + ((range == null) ? 0 : range.hashCode());
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
		if (numberOfSpeakers != other.numberOfSpeakers) {
			return false;
		}
		if (power != other.power) {
			return false;
		}
		if (range == null) {
			if (other.range != null) {
				return false;
			}
		} else if (!range.equals(other.range)) {
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
		builder.append(", range=");
		builder.append(range);
		builder.append(", cordLength=");
		builder.append(cordLength);
		builder.append("]");
		return builder.toString();
	}

	

	
}

package by.svirski.lesson9.bean.impl;

import by.svirski.lesson9.bean.BeanIndicator;

public class Refrigerator implements BeanIndicator{
	
	private int power;
	private int weight;
	private double freezerCap;
	private double overallCap;
	private int height;
	private int width;

	public Refrigerator() {
	}

	public Refrigerator(int power, int weight, double freezerCap, double overallCap, int height, int width) {
		this.power = power;
		this.weight = weight;
		this.freezerCap = freezerCap;
		this.overallCap = overallCap;
		this.height = height;
		this.width = width;
	}

	public int getPower() {
		return power;
	}

	public int getWeight() {
		return weight;
	}

	public double getFreezerCap() {
		return freezerCap;
	}

	public double getOverallCap() {
		return overallCap;
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public void setFreezerCap(double freezerCap) {
		this.freezerCap = freezerCap;
	}

	public void setOverallCap(double overallCap) {
		this.overallCap = overallCap;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(freezerCap);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + height;
		temp = Double.doubleToLongBits(overallCap);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + power;
		result = prime * result + weight;
		result = prime * result + width;
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
		Refrigerator other = (Refrigerator) obj;
		if (Double.doubleToLongBits(freezerCap) != Double.doubleToLongBits(other.freezerCap)) {
			return false;
		}
		if (height != other.height) {
			return false;
		}
		if (Double.doubleToLongBits(overallCap) != Double.doubleToLongBits(other.overallCap)) {
			return false;
		}
		if (power != other.power) {
			return false;
		}
		if (weight != other.weight) {
			return false;
		}
		if (width != other.width) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Refrigerator [power=");
		builder.append(power);
		builder.append(", weight=");
		builder.append(weight);
		builder.append(", freezerCap=");
		builder.append(freezerCap);
		builder.append(", overallCap=");
		builder.append(overallCap);
		builder.append(", height=");
		builder.append(height);
		builder.append(", width=");
		builder.append(width);
		builder.append("]");
		return builder.toString();
	}
	
	

}

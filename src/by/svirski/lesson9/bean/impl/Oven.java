package by.svirski.lesson9.bean.impl;

import by.svirski.lesson9.bean.BeanIndicator;

public class Oven implements BeanIndicator{
	
	private int power;
	private int weight;
	private int capacity;
	private double depth;
	private double height;
	private double width;

	public Oven() {
	}
	
	public Oven(int power, int weight, int capacity, double depth, double height, double width) {
		this.power = power;
		this.weight = weight;
		this.capacity = capacity;
		this.depth = depth;
		this.height = height;
		this.width = width;
	}

	public int getPower() {
		return power;
	}

	public int getWeight() {
		return weight;
	}

	public int getCapacity() {
		return capacity;
	}

	public double getDepth() {
		return depth;
	}

	public double getHeight() {
		return height;
	}

	public double getWidth() {
		return width;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public void setDepth(double depth) {
		this.depth = depth;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + capacity;
		long temp;
		temp = Double.doubleToLongBits(depth);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(height);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + power;
		result = prime * result + weight;
		temp = Double.doubleToLongBits(width);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Oven other = (Oven) obj;
		if (capacity != other.capacity) {
			return false;
		}
		if (Double.doubleToLongBits(depth) != Double.doubleToLongBits(other.depth)) {
			return false;
		}
		if (Double.doubleToLongBits(height) != Double.doubleToLongBits(other.height)) {
			return false;
		}
		if (power != other.power) {
			return false;
		}
		if (weight != other.weight) {
			return false;
		}
		if (Double.doubleToLongBits(width) != Double.doubleToLongBits(other.width)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Oven [power=");
		builder.append(power);
		builder.append(", weight=");
		builder.append(weight);
		builder.append(", capacity=");
		builder.append(capacity);
		builder.append(", depth=");
		builder.append(depth);
		builder.append(", height=");
		builder.append(height);
		builder.append(", width=");
		builder.append(width);
		builder.append("]");
		return builder.toString();
	}
	
}

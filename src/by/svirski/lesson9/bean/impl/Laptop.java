package by.svirski.lesson9.bean.impl;

import by.svirski.lesson9.bean.Appliances;

public class Laptop implements Appliances{
	
	private double batteryCapacicty;
	private String OS;
	private int memmoryRom;
	private int memmorySys;
	private double CPU;
	private int displayInches;

	public Laptop() {
	}

	public Laptop(double batteryCapacicty, String oS, int memmoryRom, int memmorySys, double cPU, int displayInches) {
		this.batteryCapacicty = batteryCapacicty;
		OS = oS;
		this.memmoryRom = memmoryRom;
		this.memmorySys = memmorySys;
		CPU = cPU;
		this.displayInches = displayInches;
	}

	public double getBatteryCapacicty() {
		return batteryCapacicty;
	}

	public String getOS() {
		return OS;
	}

	public int getMemmoryRom() {
		return memmoryRom;
	}

	public int getMemmorySys() {
		return memmorySys;
	}

	public double getCPU() {
		return CPU;
	}

	public int getDisplayInches() {
		return displayInches;
	}

	public void setBatteryCapacicty(int batteryCapacicty) {
		this.batteryCapacicty = batteryCapacicty;
	}

	public void setOS(String oS) {
		OS = oS;
	}

	public void setMemmoryRom(int memmoryRom) {
		this.memmoryRom = memmoryRom;
	}

	public void setMemmorySys(int memmorySys) {
		this.memmorySys = memmorySys;
	}

	public void setCPU(double cPU) {
		CPU = cPU;
	}

	public void setDisplayInches(int displayInches) {
		this.displayInches = displayInches;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(CPU);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((OS == null) ? 0 : OS.hashCode());
		temp = Double.doubleToLongBits(batteryCapacicty);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + displayInches;
		result = prime * result + memmoryRom;
		result = prime * result + memmorySys;
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
		Laptop other = (Laptop) obj;
		if (Double.doubleToLongBits(CPU) != Double.doubleToLongBits(other.CPU)) {
			return false;
		}
		if (OS == null) {
			if (other.OS != null) {
				return false;
			}
		} else if (!OS.equals(other.OS)) {
			return false;
		}
		if (Double.doubleToLongBits(batteryCapacicty) != Double.doubleToLongBits(other.batteryCapacicty)) {
			return false;
		}
		if (displayInches != other.displayInches) {
			return false;
		}
		if (memmoryRom != other.memmoryRom) {
			return false;
		}
		if (memmorySys != other.memmorySys) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Laptop [batteryCapacicty=");
		builder.append(batteryCapacicty);
		builder.append(", OS=");
		builder.append(OS);
		builder.append(", memmoryRom=");
		builder.append(memmoryRom);
		builder.append(", memmorySys=");
		builder.append(memmorySys);
		builder.append(", CPU=");
		builder.append(CPU);
		builder.append(", displayInches=");
		builder.append(displayInches);
		builder.append("]");
		return builder.toString();
	}
	
	

}

package by.svirski.lesson9.bean.impl;

import by.svirski.lesson9.bean.Appliances;

public class TabletPC implements Appliances{
	
	private int battaryCapacity;
	private int displayInches;
	private int memorryRom;
	private int flashMemmoryCapacity;
	private String color;

	public TabletPC() {
	}

	public TabletPC(int battaryCapacity, int displayInches, int memorryRom, int flashMemmoryCapacity, String color) {
		this.battaryCapacity = battaryCapacity;
		this.displayInches = displayInches;
		this.memorryRom = memorryRom;
		this.flashMemmoryCapacity = flashMemmoryCapacity;
		this.color = color;
	}

	public int getBattaryCapacity() {
		return battaryCapacity;
	}

	public int getDisplayInches() {
		return displayInches;
	}

	public int getMemorryRom() {
		return memorryRom;
	}

	public int getFlashMemmoryCapacity() {
		return flashMemmoryCapacity;
	}

	public String getColor() {
		return color;
	}

	public void setBattaryCapacity(int battaryCapacity) {
		this.battaryCapacity = battaryCapacity;
	}

	public void setDisplayInches(int displayInches) {
		this.displayInches = displayInches;
	}

	public void setMemorryRom(int memorryRom) {
		this.memorryRom = memorryRom;
	}

	public void setFlashMemmoryCapacity(int flashMemmoryCapacity) {
		this.flashMemmoryCapacity = flashMemmoryCapacity;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + battaryCapacity;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + displayInches;
		result = prime * result + flashMemmoryCapacity;
		result = prime * result + memorryRom;
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
		TabletPC other = (TabletPC) obj;
		if (battaryCapacity != other.battaryCapacity) {
			return false;
		}
		if (color == null) {
			if (other.color != null) {
				return false;
			}
		} else if (!color.equals(other.color)) {
			return false;
		}
		if (displayInches != other.displayInches) {
			return false;
		}
		if (flashMemmoryCapacity != other.flashMemmoryCapacity) {
			return false;
		}
		if (memorryRom != other.memorryRom) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TabletPC [battaryCapacity=");
		builder.append(battaryCapacity);
		builder.append(", displayInches=");
		builder.append(displayInches);
		builder.append(", memorryRom=");
		builder.append(memorryRom);
		builder.append(", flashMemmoryCapacity=");
		builder.append(flashMemmoryCapacity);
		builder.append(", color=");
		builder.append(color);
		builder.append("]");
		return builder.toString();
	}

	
}

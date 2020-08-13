package by.svirski.lesson9.service.tag;

public enum CustomTag {
	LAPTOP_TAG("Laptop"),
	OVEN_TAG("Oven"),
	REFRIGERATOR_TAG("Refrigerator"),
	SPEAKERS_TAG("Speakers"),
	TABLET_PC_TAG("TabletPC"),
	VACUUM_CLEANER_TAG("VacuumCleaner");
	
	private String tagName;

	private CustomTag(String tagName) {
		this.tagName = tagName;
	}

	public String getTagName() {
		return tagName;
	}
	
}

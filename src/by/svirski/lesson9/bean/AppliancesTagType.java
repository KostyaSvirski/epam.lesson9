package by.svirski.lesson9.bean;

import by.svirski.lesson9.bean.impl.*;
import by.svirski.lesson9.service.util.builder.CustomBuilder;
import by.svirski.lesson9.service.util.builder.impl.*;

public enum AppliancesTagType {
	LAPTOP_TAG(new Laptop(), "Laptop", new LaptopBuilder()), OVEN_TAG(new Oven(), "Oven", new OvenBuilder()),
	REFRIGERATOR_TAG(new Refrigerator(), "Refrigerator", new RefrigeratorBuilder()),
	SPEAKERS_TAG(new Speakers(), "Speakers", new SpeakersBuilder()),
	TABLET_PC_TAG(new TabletPC(), "TabletPC", new TabletPCBuilder()),
	VACUUM_CLEANER_TAG(new VacuumCleaner(), "VacuumCleaner", new VacuumCleanerBuilder());

	private Appliances appliance;
	private String tagName;
	private CustomBuilder<? extends Appliances> builder;

	private AppliancesTagType(Appliances appliance, String tagName,
			CustomBuilder<? extends Appliances> builder) {
		this.appliance = appliance;
		this.tagName = tagName;
		this.builder = builder;
	}

	public String getTagName() {
		return tagName;
	}

	public CustomBuilder<? extends Appliances> getBuilder() {
		return builder;
	}

	public Appliances getAppliance() {
		return appliance;
	}

}

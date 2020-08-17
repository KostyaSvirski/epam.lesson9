package by.svirski.lesson9.service.util.builder.factory;

import by.svirski.lesson9.service.util.builder.impl.LaptopBuilder;
import by.svirski.lesson9.service.util.builder.impl.OvenBuilder;
import by.svirski.lesson9.service.util.builder.impl.RefrigeratorBuilder;
import by.svirski.lesson9.service.util.builder.impl.SpeakersBuilder;
import by.svirski.lesson9.service.util.builder.impl.TabletPCBuilder;
import by.svirski.lesson9.service.util.builder.impl.VacuumCleanerBuilder;

public final class CustomBuilderFactory {
	
	private final static CustomBuilderFactory instance = new CustomBuilderFactory();
	
	private final LaptopBuilder laptopBuilder;
	private final OvenBuilder ovenBuilder;
	private final RefrigeratorBuilder refrigaratorBuilder;
	private final SpeakersBuilder speakersBuilder;
	private final TabletPCBuilder tabletPCBuilder;
	private final VacuumCleanerBuilder vacuumCleanerBuilder;

	private CustomBuilderFactory() {
		laptopBuilder = new LaptopBuilder();
		ovenBuilder = new OvenBuilder();
		refrigaratorBuilder = new RefrigeratorBuilder();
		speakersBuilder = new SpeakersBuilder();
		tabletPCBuilder = new TabletPCBuilder();
		vacuumCleanerBuilder = new VacuumCleanerBuilder();
	}

	public static CustomBuilderFactory getInstance() {
		return instance;
	}

	public LaptopBuilder getLaptopBuilder() {
		return laptopBuilder;
	}

	public OvenBuilder getOvenBuilder() {
		return ovenBuilder;
	}

	public RefrigeratorBuilder getRefrigaratorBuilder() {
		return refrigaratorBuilder;
	}

	public SpeakersBuilder getSpeakersBuilder() {
		return speakersBuilder;
	}

	public TabletPCBuilder getTabletPCBuilder() {
		return tabletPCBuilder;
	}

	public VacuumCleanerBuilder getVacuumCleanerBuilder() {
		return vacuumCleanerBuilder;
	}
	

}

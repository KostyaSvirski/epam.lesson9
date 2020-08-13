package by.svirski.lesson9.service.factory;

import by.svirski.lesson9.service.impl.LaptopServiceImpl;
import by.svirski.lesson9.service.impl.OvenServiceImpl;
import by.svirski.lesson9.service.impl.RefrigeratorServiceImpl;
import by.svirski.lesson9.service.impl.SpeakersServiceImpl;
import by.svirski.lesson9.service.impl.TabletPCServiceImpl;
import by.svirski.lesson9.service.impl.VacuumCleanerServiceImpl;

public final class ServiceFactory {

	private final static ServiceFactory instance = new ServiceFactory();
	
	private final LaptopServiceImpl laptopService;
	private final OvenServiceImpl ovenService;
	private final RefrigeratorServiceImpl refrigeratorService;
	private final SpeakersServiceImpl speakersService;
	private final TabletPCServiceImpl tabletPCService;
	private final VacuumCleanerServiceImpl vacuumCleanerService;
	
	public ServiceFactory() {
		laptopService = new LaptopServiceImpl();
		ovenService = new OvenServiceImpl();
		refrigeratorService = new RefrigeratorServiceImpl();
		speakersService = new SpeakersServiceImpl();
		tabletPCService = new TabletPCServiceImpl();
		vacuumCleanerService = new VacuumCleanerServiceImpl();
	}

	public static ServiceFactory getInstance() {
		return instance;
	}

	public LaptopServiceImpl getLaptopService() {
		return laptopService;
	}

	public OvenServiceImpl getOvenService() {
		return ovenService;
	}

	public RefrigeratorServiceImpl getRefrigeratorService() {
		return refrigeratorService;
	}

	public SpeakersServiceImpl getSpeakersService() {
		return speakersService;
	}

	public TabletPCServiceImpl getTabletPCService() {
		return tabletPCService;
	}

	public VacuumCleanerServiceImpl getVacuumCleanerService() {
		return vacuumCleanerService;
	}

}

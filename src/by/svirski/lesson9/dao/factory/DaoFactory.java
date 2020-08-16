package by.svirski.lesson9.dao.factory;

import by.svirski.lesson9.dao.impl.AppliancesDaoImpl;

public final class DaoFactory {
	
	private final static DaoFactory instance = new DaoFactory();

	private final AppliancesDaoImpl applienceDao;
	
	private DaoFactory() {
		applienceDao = new AppliancesDaoImpl();
	}

	public static DaoFactory getInstance() {
		return instance;
	}

	public AppliancesDaoImpl getApplienceDao() {
		return applienceDao;
	}

}

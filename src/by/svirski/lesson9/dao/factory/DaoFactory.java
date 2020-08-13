package by.svirski.lesson9.dao.factory;

import by.svirski.lesson9.dao.impl.ApplienceDaoImpl;

public final class DaoFactory {
	
	private final static DaoFactory instance = new DaoFactory();

	private final ApplienceDaoImpl applienceDao;
	
	private DaoFactory() {
		applienceDao = new ApplienceDaoImpl();
	}

	public static DaoFactory getInstance() {
		return instance;
	}

	public ApplienceDaoImpl getApplienceDao() {
		return applienceDao;
	}

}

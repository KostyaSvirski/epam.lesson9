package by.svirski.lesson9.service.factory;

import by.svirski.lesson9.service.impl.ServiceImpl;

public final class ServiceFactory {

	private final static ServiceFactory instance = new ServiceFactory();

	private final ServiceImpl service;

	public ServiceFactory() {
		service = new ServiceImpl();
	}

	public static ServiceFactory getInstance() {
		return instance;
	}

	public ServiceImpl getService() {
		return service;
	}

}

package by.svirski.lesson9.controller.command.impl;

import java.util.List;

import by.svirski.lesson9.bean.impl.Refrigerator;
import by.svirski.lesson9.controller.command.AbstractCommand;
import by.svirski.lesson9.controller.exception.CommandExceptiom;
import by.svirski.lesson9.service.CustomService;
import by.svirski.lesson9.service.exception.ServiceException;
import by.svirski.lesson9.service.factory.ServiceFactory;

public class RefrigeratorCommand implements AbstractCommand<Refrigerator> {

	public RefrigeratorCommand() {
	}

	@Override
	public List<Refrigerator> execute(String request) throws CommandExceptiom {
		ServiceFactory factory = ServiceFactory.getInstance();
		CustomService<Refrigerator> service = factory.getRefrigeratorService();
		try {
			List<Refrigerator> foundList = service.find(request);
			return foundList;
		} catch (ServiceException e) {
			throw new CommandExceptiom(e.getMessage(), e);
		}
	}

}

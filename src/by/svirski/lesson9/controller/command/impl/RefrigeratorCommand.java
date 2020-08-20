package by.svirski.lesson9.controller.command.impl;

import java.util.List;

import by.svirski.lesson9.bean.Appliances;
import by.svirski.lesson9.bean.AppliancesTagType;
import by.svirski.lesson9.controller.command.AbstractCommand;
import by.svirski.lesson9.controller.exception.CommandException;
import by.svirski.lesson9.service.CustomService;
import by.svirski.lesson9.service.exception.ServiceException;
import by.svirski.lesson9.service.factory.ServiceFactory;

public class RefrigeratorCommand implements AbstractCommand {

	public RefrigeratorCommand() {
	}

	@Override
	public List<? extends Appliances> execute(String request) throws CommandException {
		ServiceFactory factory = ServiceFactory.getInstance();
		CustomService service = factory.getService();
		try {
			List<? extends Appliances> foundList = service.find(AppliancesTagType.REFRIGERATOR_TAG, request);
			return foundList;
		} catch (ServiceException e) {
			throw new CommandException(e.getMessage(), e);
		}
	}

}

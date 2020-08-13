package by.svirski.lesson9.controller.command.impl;

import java.util.List;

import by.svirski.lesson9.bean.impl.Oven;
import by.svirski.lesson9.controller.command.AbstractCommand;
import by.svirski.lesson9.controller.exception.CommandExceptiom;
import by.svirski.lesson9.service.CustomService;
import by.svirski.lesson9.service.exception.ServiceException;
import by.svirski.lesson9.service.factory.ServiceFactory;

public class OvenCommand implements AbstractCommand<Oven> {

	public OvenCommand() {
	}

	@Override
	public List<Oven> execute(String request) throws CommandExceptiom {
		ServiceFactory factory = ServiceFactory.getInstance();
		CustomService<Oven> service = factory.getOvenService();
		try {
			List<Oven> foundList = service.find(request);
			return foundList;
		} catch (ServiceException e) {
			throw new CommandExceptiom(e.getMessage(), e);
		}
	}

}

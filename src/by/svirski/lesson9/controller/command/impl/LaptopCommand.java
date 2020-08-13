package by.svirski.lesson9.controller.command.impl;

import java.util.List;

import by.svirski.lesson9.bean.impl.Laptop;
import by.svirski.lesson9.controller.command.AbstractCommand;
import by.svirski.lesson9.controller.exception.CommandExceptiom;
import by.svirski.lesson9.service.CustomService;
import by.svirski.lesson9.service.exception.ServiceException;
import by.svirski.lesson9.service.factory.ServiceFactory;

public class LaptopCommand implements AbstractCommand<Laptop> {

	public LaptopCommand() {
	}

	@Override
	public List<Laptop> execute(String request) throws CommandExceptiom {
		ServiceFactory factory = ServiceFactory.getInstance();
		CustomService<Laptop> service = factory.getLaptopService();
		try {
			List<Laptop> foundList = service.find(request);
			return foundList;
		} catch (ServiceException e) {
			throw new CommandExceptiom(e.getMessage(), e);
		}
	}

}

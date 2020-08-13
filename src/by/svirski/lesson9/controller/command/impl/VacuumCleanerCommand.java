package by.svirski.lesson9.controller.command.impl;

import java.util.List;

import by.svirski.lesson9.bean.impl.VacuumCleaner;
import by.svirski.lesson9.controller.command.AbstractCommand;
import by.svirski.lesson9.controller.exception.CommandExceptiom;
import by.svirski.lesson9.service.CustomService;
import by.svirski.lesson9.service.exception.ServiceException;
import by.svirski.lesson9.service.factory.ServiceFactory;

public class VacuumCleanerCommand implements AbstractCommand<VacuumCleaner> {

	public VacuumCleanerCommand() {
	}

	@Override
	public List<VacuumCleaner> execute(String request) throws CommandExceptiom {
		ServiceFactory factory = ServiceFactory.getInstance();
		CustomService<VacuumCleaner> service = factory.getVacuumCleanerService();
		try {
			List<VacuumCleaner> foundList = service.find(request);
			return foundList;
		} catch (ServiceException e) {
			throw new CommandExceptiom(e.getMessage(), e);
		}
	}

}

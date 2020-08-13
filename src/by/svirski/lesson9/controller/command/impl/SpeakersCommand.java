package by.svirski.lesson9.controller.command.impl;

import java.util.List;

import by.svirski.lesson9.bean.impl.Speakers;
import by.svirski.lesson9.controller.command.AbstractCommand;
import by.svirski.lesson9.controller.exception.CommandExceptiom;
import by.svirski.lesson9.service.CustomService;
import by.svirski.lesson9.service.exception.ServiceException;
import by.svirski.lesson9.service.factory.ServiceFactory;

public class SpeakersCommand implements AbstractCommand<Speakers>{

	public SpeakersCommand() {
	}

	@Override
	public List<Speakers> execute(String request) throws CommandExceptiom {
		ServiceFactory factory = ServiceFactory.getInstance();
		CustomService<Speakers> service = factory.getSpeakersService();
		try {
			List<Speakers> foundList = service.find(request);
			return foundList;
		} catch (ServiceException e) {
			throw new CommandExceptiom(e.getMessage(), e);
		}
	}

}

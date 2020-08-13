package by.svirski.lesson9.controller.provider;

import by.svirski.lesson9.bean.BeanIndicator;
import by.svirski.lesson9.controller.command.AbstractCommand;
import by.svirski.lesson9.controller.exception.ProviderException;
import by.svirski.lesson9.controller.type.CommandType;

public final class CommandProvider {

	public CommandProvider() {

	}

	public static AbstractCommand<? extends BeanIndicator> defineCommand(String tag) throws ProviderException {
		CommandType[] commandTypes = CommandType.values();
		for (CommandType typeOfCommand : commandTypes) {
			if (tag.equalsIgnoreCase(typeOfCommand.getApplience())) {
				return typeOfCommand.getCommand();
			}
		}
		throw new ProviderException("invalid name of command!");
	}
}

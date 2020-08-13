package by.svirski.lesson9.controller.invoker;

import java.util.ArrayList;
import java.util.List;

import by.svirski.lesson9.bean.BeanIndicator;
import by.svirski.lesson9.controller.command.AbstractCommand;
import by.svirski.lesson9.controller.exception.CommandExceptiom;
import by.svirski.lesson9.controller.exception.ProviderException;
import by.svirski.lesson9.controller.provider.CommandProvider;

public final class CustomInvoker {

	private static CustomInvoker instance = null;

	private CustomInvoker() {
	}

	public static CustomInvoker getInstance() {
		if (instance == null) {
			instance = new CustomInvoker();
		}
		return instance;
	}

	public String invoke(String request) {
		List<? extends BeanIndicator> resultList = new ArrayList<BeanIndicator>();
		String[] parsedRequest = request.strip().split(":", 2);
		try {
			AbstractCommand<? extends BeanIndicator> command = CommandProvider.defineCommand(parsedRequest[0]);
			resultList = command.execute(parsedRequest[1]);
		} catch (ProviderException | CommandExceptiom e) {
			e.printStackTrace();
		}
		return resultList.toString();
	}
}

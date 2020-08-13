package by.svirski.lesson9.controller.command;

import java.util.List;

import by.svirski.lesson9.controller.exception.CommandExceptiom;

public interface AbstractCommand<T> {
	
	List<T> execute(String request) throws CommandExceptiom;
}

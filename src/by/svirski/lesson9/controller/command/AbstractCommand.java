package by.svirski.lesson9.controller.command;

import java.util.List;

import by.svirski.lesson9.bean.Appliances;
import by.svirski.lesson9.controller.exception.CommandException;

public interface AbstractCommand {
	
	List<? extends Appliances> execute(String request) throws CommandException;
}

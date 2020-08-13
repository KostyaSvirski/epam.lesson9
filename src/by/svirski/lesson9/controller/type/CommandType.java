package by.svirski.lesson9.controller.type;

import by.svirski.lesson9.bean.BeanIndicator;
import by.svirski.lesson9.controller.command.AbstractCommand;
import by.svirski.lesson9.controller.command.impl.*;

public enum CommandType {

	LAPTOP (new LaptopCommand(), "laptop"), 
	OVEN (new OvenCommand(), "oven"),
	REFRIGERATOR (new RefrigeratorCommand(), "refrigerator"), 
	SPEAKERS (new SpeakersCommand(), "speakers"),
	TABLET_PC (new TabletPCCommand(), "tablet_pc"), 
	VACUUM_CLEANER (new VacuumCleanerCommand(), "vacuum_cleaner");

	private AbstractCommand<? extends BeanIndicator> command;
	private String applience;

	private CommandType(AbstractCommand<? extends BeanIndicator> command, String applience) {
		this.command = command;
		this.applience = applience;
	}

	public AbstractCommand<? extends BeanIndicator> getCommand() {
		return command;
	}

	public String getApplience() {
		return applience;
	} 
	
}

package by.svirski.lesson9.controller.type;

import by.svirski.lesson9.controller.command.AbstractCommand;
import by.svirski.lesson9.controller.command.impl.*;

public enum CommandType {

	LAPTOP (new LaptopCommand(), "laptop"), 
	OVEN (new OvenCommand(), "oven"),
	REFRIGERATOR (new RefrigeratorCommand(), "refrigerator"), 
	SPEAKERS (new SpeakersCommand(), "speakers"),
	TABLET_PC (new TabletPCCommand(), "tablet_pc"), 
	VACUUM_CLEANER (new VacuumCleanerCommand(), "vacuum_cleaner");

	private AbstractCommand command;
	private String applience;

	private CommandType(AbstractCommand command, String applience) {
		this.command = command;
		this.applience = applience;
	}

	public AbstractCommand getCommand() {
		return command;
	}

	public String getApplience() {
		return applience;
	} 
	
}

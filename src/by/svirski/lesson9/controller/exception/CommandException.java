package by.svirski.lesson9.controller.exception;

public class CommandException extends Exception {

	private static final long serialVersionUID = 1L;

	public CommandException() {
	}

	public CommandException(String message) {
		super(message);
	}

	public CommandException(Throwable cause) {
		super(cause);
	}

	public CommandException(String message, Throwable cause) {
		super(message, cause);
	}

}

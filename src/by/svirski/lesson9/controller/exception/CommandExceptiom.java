package by.svirski.lesson9.controller.exception;

public class CommandExceptiom extends Exception {

	private static final long serialVersionUID = 1L;

	public CommandExceptiom() {
	}

	public CommandExceptiom(String message) {
		super(message);
	}

	public CommandExceptiom(Throwable cause) {
		super(cause);
	}

	public CommandExceptiom(String message, Throwable cause) {
		super(message, cause);
	}

}

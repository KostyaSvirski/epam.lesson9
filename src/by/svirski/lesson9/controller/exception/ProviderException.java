package by.svirski.lesson9.controller.exception;

public class ProviderException extends Exception {

	private static final long serialVersionUID = 1L;

	public ProviderException() {
	}

	public ProviderException(String message) {
		super(message);
	}

	public ProviderException(Throwable cause) {
		super(cause);
	}

	public ProviderException(String message, Throwable cause) {
		super(message, cause);
	}

}

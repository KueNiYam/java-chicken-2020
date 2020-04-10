package domain.exceptions;

public class OrderNumberException extends RuntimeException {
	public OrderNumberException(final String message) {
		super(message);
	}
}

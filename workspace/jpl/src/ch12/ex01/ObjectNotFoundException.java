package ch12.ex01;

public class ObjectNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public ObjectNotFoundException(final String message ) {
		super(message);
	}
}

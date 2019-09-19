package ch01.ex16;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class TestBadDataSetException {

	@Test
	public void testGetCause() {
		IOException ioerr = new IOException("io err");
		BadDataSetException exception = new BadDataSetException("name", ioerr);
		assertEquals(IOException.class, exception.getCause().getClass());
	}

	@Test
	public void testGetName() {
		String name = "errName";
		IOException ioerr = new IOException("io err");
		BadDataSetException exception = new BadDataSetException(name, ioerr);
		assertEquals(name, exception.getName());
	}

}

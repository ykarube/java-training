package ch01.ex14;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestTerminal {

	@Test
	public void testOut() {
		Terminal terminal = new Terminal();
		String music = "abc";
		assertEquals(music, terminal.out(music));
	}

}

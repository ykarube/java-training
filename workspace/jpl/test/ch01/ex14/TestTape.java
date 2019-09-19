package ch01.ex14;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestTape {

	@Test
	public void testPlay() {
		Tape tape = new Tape();
		assertEquals("(play music)♪ ♪ ♪ ♪.", tape.play());
	}

	@Test
	public void testPause() {
		Tape tape = new Tape();
		assertEquals("(pause music)...", tape.pause());
	}

}

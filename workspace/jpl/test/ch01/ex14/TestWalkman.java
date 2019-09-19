package ch01.ex14;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestWalkman {

	@Test
	public void testSetGetTerminal() {
		Walkman walkman = new Walkman();

		Terminal terminal = new Terminal();
		walkman.setTerminal(terminal);
		assertEquals(terminal, walkman.getTerminal());
	}

	@Test
	public void testSetGetTape() {
		Walkman walkman = new Walkman();

		Tape tape = new Tape();
		walkman.setTape(tape);
		assertEquals(tape, walkman.getTape());
	}

	@Test
	public void testStartStop() {
		Walkman walkman = new Walkman();
		Tape tape = new Tape();
		walkman.setTape(tape);
		walkman.start();
		//コンソールから音楽(文字列)から出力されることを確認

		walkman.stop();
		//コンソールから停止(文字列)が出力されることを確認
	}

}

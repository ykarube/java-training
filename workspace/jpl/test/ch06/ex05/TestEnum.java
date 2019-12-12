package ch06.ex05;

import static org.junit.Assert.*;

import org.junit.Test;

import ch06.ex05.Executer.Signal;


public class TestEnum {


	@Test
	public void testEnum() {

		assertEquals("blue", Signal.BLUE.getColor());
	}

}

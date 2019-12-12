package ch06.ex04;

import static org.junit.Assert.*;

import org.junit.Test;

import ch06.ex04.Executer.Signal;

public class TestEnum {


	@Test
	public void testEnum() {
		assertEquals("RED", Signal.RED.getColor());
		assertNotEquals("RED", Signal.RED);
	}

}

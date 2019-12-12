package ch06.ex01;

import static org.junit.Assert.*;

import org.junit.Test;

import ch06.ex01.Executer.Day;
import ch06.ex01.Executer.Signal;


public class TestEnum {


	@Test
	public void testEnum() {

		assertEquals("MONDAY", Day.MONDAY.toString());
		assertNotEquals(Day.SATURDAY, Day.SUNDAY);


		assertEquals("BLUE", Signal.BLUE.toString());
		assertNotEquals("yellow", Signal.YELLOW.toString());
	}

}

package ch13.ex03;

import static org.junit.Assert.*;

import org.junit.Test;


public class TestDelimitedString {


	@Test
	public void testDelimitedStrings(){

		DelimitedString ds = new DelimitedString();
		String[] strings = ds.delimitedStrings("<abc><abdc><aaaabc>", '<', '>');

		assertEquals("<abc>", strings[0]);
		assertEquals("<abdc>", strings[1]);
		assertEquals("<aaaabc>", strings[2]);
		assertEquals(3, strings.length);



	}

}

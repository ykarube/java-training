package ch13.ex01;

import static org.junit.Assert.*;

import org.junit.Test;


public class TestStringCounter {


	@Test
	public void testCount(){

		assertEquals(1, new StringCounter().count("abc", 'a'));
		assertEquals(1, new StringCounter().count("abc", 'b'));
		assertEquals(1, new StringCounter().count("abc", 'c'));
		assertEquals(0, new StringCounter().count("abc", '1'));
		assertEquals(3, new StringCounter().count("aaabc", 'a'));

		try {
			 new StringCounter().count(null, 'a');
			 fail();
		} catch (Exception e) {
		}


	}

}

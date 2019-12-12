package ch13.ex02;

import static org.junit.Assert.*;

import org.junit.Test;


public class TestStringCounter {


	@Test
	public void testCount(){

		assertEquals(1, new StringCounter2().count("abc", "a"));
		assertEquals(1, new StringCounter2().count("abc", "b"));
		assertEquals(1, new StringCounter2().count("abc", "c"));
		assertEquals(0, new StringCounter2().count("abc", "1"));
		assertEquals(3, new StringCounter2().count("aaabc", "a"));
		assertEquals(1, new StringCounter2().count("aaabc", "aaabc"));
		assertEquals(0, new StringCounter2().count("aaabc", "aaabcv"));

		try {
			 new StringCounter2().count(null, "a");
			 fail();
		} catch (Exception e) {
		}


		try {
			 new StringCounter2().count("1", null);
			 fail();
		} catch (Exception e) {
		}

	}

}

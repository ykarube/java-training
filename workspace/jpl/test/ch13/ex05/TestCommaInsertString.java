package ch13.ex05;

import static org.junit.Assert.*;

import org.junit.Test;


public class TestCommaInsertString {


	@Test
	public void testDelimitedStrings(){

		assertEquals("123", CommaInsertString.insertComma("123"));
		assertEquals("1,234", CommaInsertString.insertComma("1234"));
		assertEquals("123,456,789", CommaInsertString.insertComma("123456789"));
		assertEquals("a,bcd",CommaInsertString.insertComma("abcd"));
	}

}

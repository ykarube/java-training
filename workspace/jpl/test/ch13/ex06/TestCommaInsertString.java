package ch13.ex06;

import static org.junit.Assert.*;

import org.junit.Test;


public class TestCommaInsertString {


	@Test
	public void testDelimitedStrings(){

		assertEquals("123", CommaInsertString2.insertComma("123",',',3));
		assertEquals("1,234", CommaInsertString2.insertComma("1234",',',3));
		assertEquals("123,456,789", CommaInsertString2.insertComma("123456789",',',3));

		assertEquals("a,bcd",CommaInsertString2.insertComma("abcd",',',3));
	}

}

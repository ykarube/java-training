package ch11.ex01;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestLinkedList {

	@Test
	public void testLinkedList(){

		LinkedList<String> list1 = new LinkedList<String>();
		LinkedList<String> list2 = new LinkedList<String>();
		list1.setNext(list2);

		assertEquals(list1.getNext(), list2);

		String a = new String("a");
		list1.setObj(new String("a"));
		assertTrue(a.equals(list1.getObj()));
	}


}

package ch12.ex01;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestLinkedList {

	@Test
	public void testLinkedList(){

		LinkedList<String> list1 = new LinkedList<String>();
		LinkedList<String> list2 = new LinkedList<String>();
		LinkedList<String> list3 = new LinkedList<String>();
		list1.setNext(list2);
		list1.setNext(list3);
		String s1 = "hoge1";
		String s2 = "hoge2";
		String s3 = "hoge3";
		list1.setObj(s1);
		list2.setObj(s2);
		list3.setObj(s3);


		try {
			assertEquals(s1, list1.find(s1));
		} catch (ObjectNotFoundException e) {
			e.printStackTrace();
			fail();
		}

		try {
			System.out.println(list1.find("hoge"));
			fail();
		} catch (ObjectNotFoundException e) {
			System.out.println(e.getMessage());
			assertEquals("hoge is not found.", e.getMessage());
		}

	}


}

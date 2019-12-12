package ch11.ex02;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestAttr {

	@Test
	public void testAttr(){

		Attr<String> attr1 = new Attr<String>("key1");
		attr1.setValue("value1");
		Attr<String> attr2 = new Attr<String>("key2");
		attr2.setValue("value2");

		Attributed<String> attributed = new AttributedImpl<String>();
		attributed.add(attr1);
		attributed.add(attr2);

		assertEquals(attributed.find("key1"), attr1);
		assertNotEquals(attributed.find("key"), attr1);
		assertEquals(attributed.find("key2"), attr2);
	}


}

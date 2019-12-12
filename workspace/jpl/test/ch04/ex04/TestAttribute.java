package ch04.ex04;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestAttribute {

	@Test
	public void testAttr() {
		Attr<String> attr1 = new AttrString("name1");
		Attr<String> attr2 = new AttrString("name2", "val2");
		Attributed attrTable = new AttributedImpl();

		attrTable.add(attr1);
		attrTable.add(attr2);

		Attr a1  = attrTable.find("name1");
		assertNotNull(a1);
		assertEquals(attr1, a1);
		System.out.println(a1.toString());

		Attr a2  = attrTable.find("name2");
		assertNotNull(a2);
		System.out.println(a2.toString());

		Attr a3  = attrTable.find("hoge");
		assertNull(a3);

		attrTable.remove("name2");
		a2  = attrTable.find("name2");
		assertNull(a2);

	}
}


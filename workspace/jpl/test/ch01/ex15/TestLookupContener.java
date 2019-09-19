package ch01.ex15;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestLookupContener {

	@Test
	public void testLookupContener() throws NoSuchFieldException, SecurityException {

		LookupContener contener = new LookupContener();
		assertNull(contener.find(null));

		final Object obj1 = new Object();
		final Object obj2 = new Object();
		final Object obj3 = new Object();
		final String name1 = "kensyu1";
		final String name2 = "kensyu2";
		final String name3 = "kensyu3";

		contener.add(obj1, name1);
		contener.add(obj2, name2);
		contener.add(obj3, name3);

		assertNull(contener.find("test"));

		assertNotNull(contener.find(name1));
		assertEquals(obj1, contener.find(name1));


		try {
			contener.remove(null);
		} catch (Exception e) {
			assertEquals(NullPointerException.class, e.getClass());
		}

		try {
			contener.remove("");
		} catch (Exception e) {
			assertEquals(IllegalArgumentException.class, e.getClass());
		}

		try {
			contener.remove("noName");;
		} catch (Exception e) {
			System.out.println(e);
			fail();
		}

		assertNotNull(contener.find(name1));
		contener.remove(name1);
		assertNull(contener.find(name1));

	}


}

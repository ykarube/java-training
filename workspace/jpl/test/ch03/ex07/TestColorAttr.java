package ch03.ex07;

import static org.junit.Assert.*;

import org.junit.Test;


public class TestColorAttr {

	@Test
	public void testHashCode(){
		String name = "hoge";
		ColorAttr c1 = new ColorAttr(name);
		ColorAttr c2 = new ColorAttr(name);

		assertNotEquals(c1.hashCode(), c2.hashCode());
		System.out.println(c1.hashCode());
		System.out.println(c2.hashCode());

	}

	@Test
	public void testEquals(){
		String name = "hoge";
		ColorAttr c1 = new ColorAttr(name);
		ColorAttr c2 = new ColorAttr(name);

		assertFalse(c1.equals(c2));
		assertFalse(c2.equals(c1));
	}

}

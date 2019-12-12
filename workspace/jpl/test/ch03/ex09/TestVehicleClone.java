package ch03.ex09;

import static org.junit.Assert.*;

import org.junit.Test;


public class TestVehicleClone {

	@Test
	public void testClone(){
		Vehicle first = new Vehicle("owner", 10, new GasTank(1000, 10));
		Vehicle second = first.clone();

		assertEquals(first.toString(), second.toString());
		System.out.println(first.toString());
		System.out.println(second.toString());

		assertEquals(first.getNextID(), second.getNextID());
		System.out.println(first.getNextID());
		System.out.println(second.getNextID());

		assertEquals(first.getSpeed(), second.getSpeed());
		assertEquals(first.getMyID(), second.getMyID());
		assertEquals(first.getOwner(), second.getOwner());

		System.out.println(first.hashCode() +  "," + second.hashCode() );
		assertNotEquals(first.hashCode(), second.hashCode());

	}

}

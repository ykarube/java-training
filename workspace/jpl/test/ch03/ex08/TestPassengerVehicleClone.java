package ch03.ex08;

import static org.junit.Assert.*;

import org.junit.Test;


public class TestPassengerVehicleClone {

	@Test
	public void testClone(){
		PassengerVehicle first = new PassengerVehicle("owner", 10, 4, new GasTank(1000, 10));
		PassengerVehicle second = first.clone();

		assertEquals(first.toString(), second.toString());
		System.out.println(first.toString());
		System.out.println(second.toString());

		assertEquals(first.getNextID(), second.getNextID());
		System.out.println(first.getNextID());
		System.out.println(second.getNextID());

		assertEquals(first.getSpeed(), second.getSpeed());
		assertEquals(first.getMyID(), second.getMyID());
		assertEquals(first.getOwner(), second.getOwner());
		assertEquals(first.getSeatNum_(), second.getSeatNum_());

		System.out.println(first.hashCode() +  "," + second.hashCode() );
		assertNotEquals(first.hashCode(), second.hashCode());

	}

}

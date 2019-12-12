package ch03.ex01;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestPassengerVehicle {

	@Test
	public void testGetSeatNum(){
		final int seat = 5;
		PassengerVehicle pv = new PassengerVehicle("ricoh", 10, seat);
		assertEquals(seat, pv.getSeatNum_());
	}


	@Test
	public void testRidePerson(){
		final int seat = 5;
		PassengerVehicle pv = new PassengerVehicle("ricoh", 10, seat);

		try {
			pv.addRidePerson( seat+1 );
			fail();
		} catch (Exception e) {
			assertEquals(IllegalStateException.class, e.getClass());
		}

		try {
			pv.removeRidePerson( 1 );
			fail();
		} catch (Exception e) {
			assertEquals(IllegalStateException.class, e.getClass());
		}

		int personNum = 3;
		pv.addRidePerson(personNum);
		assertEquals(personNum, pv.getRidePerson());

		int dropOffPersonNum = 2;
		pv.removeRidePerson(dropOffPersonNum);
		assertEquals(personNum - dropOffPersonNum, pv.getRidePerson());
	}


}

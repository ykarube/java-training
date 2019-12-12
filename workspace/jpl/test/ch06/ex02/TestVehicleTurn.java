package ch06.ex02;

import static org.junit.Assert.*;

import org.junit.Test;


public class TestVehicleTurn {


	@Test
	public void testEnum() {
		Vehicle nissan = new Vehicle( "jiro", 456 );
		nissan.setAngle(90);
		assertEquals(90, nissan.getAngle());
		nissan.turn( Vehicle.Turn.TURN_LEFT);
		assertEquals(0, nissan.getAngle());
	}

}

package ch02.ex17;

import static org.junit.Assert.*;

import org.junit.Test;

import ch02.ex18.Vehicle;

public class TestVechicle {


	@Test
	public void testTurnInt(){
		int angle = 45;
		int turn = 90;

		Vehicle vehicle = new Vehicle("taro",999);
		vehicle.setAngle(angle);
		assertEquals(angle, vehicle.getAngle());

		vehicle.turn(turn);
		assertEquals(angle+turn, vehicle.getAngle());
	}

	@Test
	public void testTurnField(){
		int angle = 45;

		Vehicle vehicle = new Vehicle("taro",999);
		vehicle.setAngle(angle);
		assertEquals(angle, vehicle.getAngle());

		vehicle.turn(Vehicle.Turn.TURN_LEFT);
		assertEquals(angle + Vehicle.Turn.TURN_LEFT.getAngle(), vehicle.getAngle());
	}

}

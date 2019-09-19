package ch02.ex13;

import static org.junit.Assert.*;

import java.lang.reflect.Field;

import org.junit.Test;

public class TestVechicle {

	@Test
	public void testSetSpeed() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		int speed = 100;

		Vehicle vehicle = new Vehicle("taro",999);
		vehicle.setSpeed(speed);


		Field field = Vehicle.class.getDeclaredField("speed_");
        field.setAccessible(true);
        assertEquals(speed, field.getInt(vehicle));
	}

	@Test
	public void testGetSpeed() {
		int speed = 100;

		Vehicle vehicle = new Vehicle("taro",999);
		vehicle.setSpeed(speed);
        assertEquals(speed, vehicle.getSpeed());
	}


	@Test
	public void testSetAngle() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		int angle = 45;

		Vehicle vehicle = new Vehicle("taro",999);
		vehicle.setAngle(angle);


		Field field = Vehicle.class.getDeclaredField("angle_");
        field.setAccessible(true);
        assertEquals(angle, field.getInt(vehicle));
	}

	@Test
	public void testGetAngle() {
		int angle = 45;
		Vehicle vehicle = new Vehicle("taro",999);
		vehicle.setAngle(angle);
        assertEquals(angle, vehicle.getAngle());
	}

	@Test
	public void testSetOwner() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		String name = "jiro";

		Vehicle vehicle = new Vehicle("taro",999);
		vehicle.setOwner(name);

		Field field = Vehicle.class.getDeclaredField("owner_");
        field.setAccessible(true);
        String owner = String.valueOf(field.get(vehicle));
        assertEquals(name, owner);
	}

	@Test
	public void testGetOwner()  {
		String name = "jiro";
		Vehicle vehicle = new Vehicle(name,999);
        assertEquals(name, vehicle.getOwner());
	}

	@Test
	public void testGeMyID()  {
		int id = 999;
		Vehicle vehicle = new Vehicle("taro",id);
        assertEquals(id, vehicle.getMyID());
	}
}

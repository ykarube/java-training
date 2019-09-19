package ch02.ex15;

import static org.junit.Assert.*;

import java.lang.reflect.Field;

import org.junit.Test;

public class TestVechicle {

	@Test
	public void testChangeSpeed() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		int speed = 100;

		Vehicle vehicle = new Vehicle("taro",999);
		vehicle.changeSpeed(speed);

		Field field = Vehicle.class.getDeclaredField("speed_");
        field.setAccessible(true);
        assertEquals(speed, field.getInt(vehicle));
	}

	@Test
	public void testStop() {
		int speed = 100;
		Vehicle vehicle = new Vehicle("taro",999);
		vehicle.changeSpeed(speed);
		assertEquals(speed, vehicle.getSpeed());

		vehicle.stop();
        assertEquals(0, vehicle.getSpeed());
	}
}

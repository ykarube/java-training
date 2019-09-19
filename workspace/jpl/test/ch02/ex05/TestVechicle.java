package ch02.ex05;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestVechicle {

	/**
	 * Fieldのテスト
	 */
	@Test
	public void testField() {
		Vehicle vechicle = new Vehicle();
		vechicle.speed_ = 100;
		assertEquals(100, vechicle.speed_);

		vechicle.angle_ = 45;
		assertEquals(45, vechicle.angle_);

		vechicle.owner_ = "taro";
		assertEquals("taro", vechicle.owner_);

		vechicle.nextID_ = 999;
		assertEquals(999, vechicle.nextID_);

		vechicle.myID_ = 012;
		assertEquals(012, vechicle.myID_);

	}
}

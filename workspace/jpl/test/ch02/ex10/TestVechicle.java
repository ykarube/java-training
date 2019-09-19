package ch02.ex10;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestVechicle {

	/**
	 * overrideしたtoStringのテスト
	 */
	@Test
	public void testToString() {
		Vehicle vehicle = null;
		String ret = null;

		vehicle = new Vehicle();
		ret = "owner:null, id:0";
		assertEquals(ret, vehicle.toString());


		vehicle = new Vehicle("taro");
		vehicle.myID_ = 999;
		ret = "owner:taro, id:999";
		assertEquals(ret, vehicle.toString());
	}

}

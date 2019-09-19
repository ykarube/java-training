package ch02.ex09;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestVechicle {

	/**
	 * いままで使われた識別番号の最大値を返すstaticメソッドを追加
	 */
	@Test
	public void testGetNextId() {
		int count = 0;
		Vehicle vehicle= new Vehicle();

		assertNotEquals(count, vehicle.nextID_);
		assertEquals(++count, vehicle.nextID_);	//期待値1

		vehicle= new Vehicle();
		assertEquals(++count, vehicle.nextID_);	//期待値2

		vehicle= new Vehicle();
		assertEquals(++count, vehicle.nextID_);	//期待値3
	}

}

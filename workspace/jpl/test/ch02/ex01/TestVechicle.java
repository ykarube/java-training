package ch02.ex01;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestVechicle {

	/**
	 * クラスの全フィールドをコール
	 */
	@Test
	public void testFieldCall() {
		Vechicle vechicle = new Vechicle();
		vechicle.speed_ = 100;
		vechicle.angle_ = 90;
		vechicle.owner_ = "ricoh";

		assertNotNull(vechicle);
	}
}

package ch02.ex03;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestVechicle {

	/**
	 * クラスの全フィールドをコール
	 */
	@Test
	public void testFieldCall() {
		Vehicle vechicle = new Vehicle();
		vechicle.speed_ = 100;
		vechicle.angle_ = 90;
		vechicle.owner_ = "ricoh";
		vechicle.nextID_ = 0005;
		vechicle.myID_ = 0005;

		assertNotNull(vechicle);
	}
}

package ch02.ex07;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestVechicle {

	/**
	 * コンストラクタ引数無しのテスト
	 */
	@Test
	public void testConstuctorNoParam() {
		Vehicle vechicleNoParam = new Vehicle();
		assertEquals(0, vechicleNoParam.speed_);
		assertEquals(0, vechicleNoParam.angle_);
		assertEquals(null, vechicleNoParam.owner_);
		assertEquals(1, vechicleNoParam.nextID_); //初回呼び出し
		assertEquals(0, vechicleNoParam.myID_);
	}


	/**
	 * コンストラクタ引数ありのテスト
	 */
	@Test
	public void testConstuctorWithParam() {
		String name = "taro";
		Vehicle vechicleWithParam = new Vehicle( name );
		assertEquals(0, vechicleWithParam.speed_);
		assertEquals(0, vechicleWithParam.angle_);
		assertEquals(name, vechicleWithParam.owner_);
		assertEquals(2, vechicleWithParam.nextID_); //二回目呼び出し
		assertEquals(0, vechicleWithParam.myID_);
	}
}

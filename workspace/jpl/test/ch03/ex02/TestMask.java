package ch03.ex02;

import org.junit.Test;

public class TestMask {

	@Test
	public void testMask(){

		X x = new X();
		System.out.println( x.xMask );
		System.out.println( x.mask(1) ) ;

		Y y = new Y();
		System.out.println( y.fullMask );
		System.out.println( y.yMask );
		System.out.println( y.fullMask );
	}


}

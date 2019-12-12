package ch03.ex06;

import static org.junit.Assert.*;

import org.junit.Test;


public class TestGasTank {

	@Test
	public void testEmpty(){
		GasTank tank = new GasTank( 100,1 );
		assertTrue( tank.empty() );

		tank.charge( 10 );
		assertFalse( tank.empty() );
	}

	@Test
	public void testCharge(){
		GasTank tank = new GasTank( 100,1 );

		int overSize = 100 + 10;
		int safeSize = 100 - 30;

		try {
			tank.charge(overSize);
			fail();
		} catch (Exception e) {
			assertEquals(IllegalArgumentException.class, e.getClass());
		}

		tank.charge(safeSize);
		assertEquals(safeSize, tank.getGasSize());
	}



}

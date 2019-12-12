package ch03.ex08;

import static org.junit.Assert.*;

import org.junit.Test;

import ch03.ex09.Garage;
import ch03.ex09.GasTank;
import ch03.ex09.Vehicle;


public class TestGarage {

	@Test
	public void testClone(){
		Vehicle v1 = new Vehicle("first",	1, new GasTank(100, 10));
		Vehicle v2 = new Vehicle("second", 	2, new GasTank(200, 20));
		Vehicle v3 = new Vehicle("third", 	3, new GasTank(300, 30));

		int space = 4;
		Garage originalGarage = new Garage( space );
		originalGarage.inGarage(v1);
		originalGarage.inGarage(v2);
		originalGarage.inGarage(v3);

		Garage cloneGarage = originalGarage.clone();

		Vehicle cloneV1 = cloneGarage.outGarage(0);
		Vehicle cloneV2 = cloneGarage.outGarage(1);
		Vehicle cloneV3 = cloneGarage.outGarage(2);

		assertNotEquals(v1, cloneV1);
		assertNotEquals(v2, cloneV2);
		assertNotEquals(v3, cloneV3);

		assertNotEquals(v1.hashCode(), cloneV1.hashCode());
		assertNotEquals(v2.hashCode(), cloneV2.hashCode());
		assertNotEquals(v3.hashCode(), cloneV3.hashCode());

		assertEquals(originalGarage.getCapacity(), cloneGarage.getCapacity());

		assertEquals(v1.getOwner(), cloneV1.getOwner());
		assertEquals(v2.getOwner(), cloneV2.getOwner());
		assertEquals(v3.getOwner(), cloneV3.getOwner());

	}

}

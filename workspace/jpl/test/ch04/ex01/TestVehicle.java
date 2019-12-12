package ch04.ex01;

import org.junit.Test;


public class TestVehicle {

	@Test
	public void testStartGasTankVehicle(){
		GasTank tank = new GasTank( 100,1  );
		tank.charge( 10 );

		Vehicle gasVehicle = new Vehicle("owner", 101, tank);
		gasVehicle.start();
		tank.charge(5);
		gasVehicle.start();

		//cosole確認
	}

	@Test
	public void testStartBattelyVehicle(){
		EnergySource es = new Battery( 2 );
		es.charge( 10 );

		Vehicle vehicle = new Vehicle("owner", 101, es);
		vehicle.start();
		es.charge(12);

		//cosole確認
	}

}

package ch02.ex18;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestVechicle {

	@Test
	public void testCommandLine(){
		String param0 = "taro";
		String param1 = "jiro";
		String param2 = "saburo";


		String[] args = { param0, param1, param2 };
		Vehicle[] vechicleList = new Vehicle[args.length];
		for (int i = 0; i < args.length; i++) {
			String name = args[i];
			vechicleList[i] = new Vehicle( name, i );
		}

		assertEquals(param0, vechicleList[0].getOwner());
		assertEquals(param1, vechicleList[1].getOwner());
		assertEquals(param2, vechicleList[2].getOwner());
	}

}

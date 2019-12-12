package ch03.ex05;

import org.junit.Test;


public class TestMethodBenchMark {

	@Test
	public void testMain(){

		MethodBenchmark mb = new MethodBenchmark();

		String[] args = new String[1];
		args[0] = "10";
		mb.main(args);

		//コンソール確認.
	}


}

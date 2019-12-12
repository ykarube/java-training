package ch03.ex05;

import org.junit.Test;


public class TestMethodBenchMarkTostring {

	@Test
	public void testMain(){

		MethodBenchmarkTostring mb = new MethodBenchmarkTostring();

		String[] args = new String[1];
		args[0] = "10";
		mb.main(args);

		//コンソール確認.
	}


}

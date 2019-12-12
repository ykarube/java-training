package ch06.ex03;

import org.junit.Test;

import ch06.ex03.Verbose.Verbosity;


public class TestVebose {


	@Test
	public void testEnum() {
		VerbosieImpl v = new VerbosieImpl();
		System.out.println(v.getVerbosity());
		v.setVerbosity(Verbosity.SILENT);
		System.out.println(v.getVerbosity());
	}

}

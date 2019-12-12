package ch10.ex04;

public class MethodBenchmark extends Benchmark {

	/** 何もしないで戻るだけ **/
	void benchmark() {
	}

	public static void main(String[] args) {
		int count = Integer.parseInt ( args[0] );
		long time = new MethodBenchmark().repeat( count );
		System.out.println( count + " methods in " + time + " nanoseconds." );
	}

}

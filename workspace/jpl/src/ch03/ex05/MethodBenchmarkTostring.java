package ch03.ex05;

/**
 * 練習問題3.5 他のベンチマークを行う新たな拡張したクラスを作成しなさい
 * たとえば0からパラメータとして渡された値までループするのに要する時間を図るなど
 */
public class MethodBenchmarkTostring extends Benchmark {

	private static int number = 0;

	public MethodBenchmarkTostring() {
		this.number = 0;
	}

	void benchmark() {
		Integer.toString(number);
	}

	public static void main(String[] args) {
		int count = Integer.parseInt ( args[0] );
		number = count;
		long time = new MethodBenchmarkTostring().repeat( count );
		System.out.println( count + " methods in " + time + " nanoseconds." );
	}



}

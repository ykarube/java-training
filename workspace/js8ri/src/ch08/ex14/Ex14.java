package ch08.ex14;

import java.util.Objects;

public class Ex14 {

	public static void main(String[] args) {
		test(() -> { System.out.println("run"); });
		test(null);
	}

	static void test(Runnable runner) {
		Objects.requireNonNull(runner, " is null").run();
	}
}
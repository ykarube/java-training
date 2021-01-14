package ch06.ex03;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;
import java.util.function.Consumer;
import java.util.function.Function;

public class Ex03 {
	private static final int THREAD_SIZE = 1000;
	private static final int COUNTER = 1000000;

	public static void main(String[] args) {

		Duration test1 = evalThreadTimes(new AtomicLong(), value -> value.incrementAndGet(), value -> value.get());
		Duration test2 = evalThreadTimes(new LongAdder(), value -> value.increment(), value -> value.longValue());

		System.out.println("AtomicLong: " + test1.toMillis() + "[ms]");
		System.out.println("LongAddr  : " + test2.toMillis() + "[ms]");


		// 入れ替え
		System.out.println("\n change... \n");
		test2 = evalThreadTimes(new LongAdder(), value -> value.increment(), value -> value.longValue());
		test1 = evalThreadTimes(new AtomicLong(), value -> value.incrementAndGet(), value -> value.get());

		System.out.println("AtomicLong :" + test1.toMillis() + "[ms]");
		System.out.println("LongAddr   :" + test2.toMillis() + "[ms]");
	}

	private static<T> Duration evalThreadTimes(T instance, Consumer<T> action, Function<T, Long> tester) {
		Thread[] threads = makeThreads(instance, action);

		Duration duration = calcRunningTime(threads);

		if( tester.apply(instance) != (THREAD_SIZE * COUNTER) ) {
			throw new RuntimeException("runtime exception.");
		}

		return duration;
	}

	private static<T> Thread[] makeThreads(T instance, Consumer<T> action ) {
		Thread threads[] = new Thread[THREAD_SIZE];

		for(int i = 0; i < THREAD_SIZE; i++) {
			threads[i] = new Thread(() -> {
				for(int j = 0; j < COUNTER; j++) {
					action.accept(instance);
				}
			});
		}

		return threads;
	}

	private static Duration calcRunningTime(Thread[] threads) {
		Instant start = Instant.now();

		Arrays.stream(threads).forEach(thread ->  thread.start());
		Arrays.stream(threads).forEach(thread -> {
			try {
				thread.join();
			} catch(InterruptedException ex) {
				ex.printStackTrace();
			}
		});

		Instant end = Instant.now();
		return Duration.between(start, end);
	}
}

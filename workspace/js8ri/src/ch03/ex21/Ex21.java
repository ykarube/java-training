package ch03.ex21;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Function;

public class Ex21 {
	public static void main(String[] args) throws InterruptedException, ExecutionException  {
		ExecutorService exec = Executors.newFixedThreadPool(1);
		FutureTask<Integer> future = new FutureTask<Integer>(() -> {
			Thread.sleep(1000);
			return 1;
		});

		try {
			exec.execute(future);

			Future<String> result = map(future, i -> String.valueOf("result="+(i * 2))) ;
			System.out.println(result.get());
		} finally {
			exec.shutdown();
		}
	}

	static <T, U> Future<U> map(Future<T> future, Function<T, U> f)
			throws InterruptedException, ExecutionException {
		return new Future<U>() {
			@Override
			public boolean cancel(boolean mayInterruptIfRunning) {
				return future.cancel(mayInterruptIfRunning);
			}

			@Override
			public boolean isCancelled() {
				return future.isCancelled();
			}

			@Override
			public boolean isDone() {
				return future.isDone();
			}

			@Override
			public U get() throws InterruptedException, ExecutionException {
				return f.apply(future.get());
			}

			@Override
			public U get(long timeout, TimeUnit unit)
					throws InterruptedException, ExecutionException,
						   TimeoutException {
				return f.apply(future.get(timeout, unit));
			}
		};
	}
}
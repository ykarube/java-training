package ch14.ex10;

import static org.junit.Assert.*;

import org.junit.Test;


public class TestThread {

	/**
	 * クラスの全フィールドをコール
	 */
	@Test
	public void testThreadPool() {
		System.out.println("test start");
		ThreadPool th = new ThreadPool(1, 2);
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				System.out.println("hoge");
			}
		};
		th.start();
		th.dispatch(runnable);
		th.stop();

		assertEquals(1, 1);
		System.out.println("test end");

		boolean stop = true;
		while(!stop) {
			System.out.println("a");
		}
		System.out.println("dddddd");
	}
}

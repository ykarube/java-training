package ch10.ex04;

import ch03.ex05.MethodBenchmark;

/**
 * 練習問題10.4
 * 今までの練習問題からforループを使用した問題を数台選んでwthileループを使用して書き直しなさい
 * do-whileループを使用しても書き直すことができますか
 * そのように書き直したりしますか、しないとしたらなぜですか
 *
 */
public class EX04 {


	public static void main(String[] args) {
		System.out.println("from exercise 3.5");
		long time = new MethodBenchmark().repeat( 100 );
		System.out.println( 100 + " methods in " + time + " nanoseconds." );

		time = new MethodBenchmark().repeatByWhille( 100 );
		System.out.println( 100 + " methods in " + time + " nanoseconds." );

	}
}
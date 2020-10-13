package js8ri.ch01.ex01;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

/**
 * Array.sortメソッド内で呼び出されるコンパレータのコードは
 * sortメソッドを呼び出したスレッドで実行されるか、それとも別のスレッドで実行されるか
 */
public class ArraySort {


	public static void main(String[] args) throws InterruptedException {
		System.out.println("call thread=" + Thread.currentThread().getName());
		Integer[] values = {7,9,8,0};
		doSort(values);
	}

	public static void doSort(Integer[] values) {
		Arrays.sort(
				values,
				new Comparator<Integer>(){
						@Override
						public int compare(Integer o1, Integer o2) {
							System.out.println( "compare() execute thread=" + Thread.currentThread().getName() );
							return o1.compareTo(o2);
						}
					}
				);
		Stream.of(values).forEach(System.out::println);
	}
}
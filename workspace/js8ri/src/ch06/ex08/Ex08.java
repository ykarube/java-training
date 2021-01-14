package ch06.ex08;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;


public class Ex08 {
	private static final int INIT_SIZE = 10;
	private static final int MAX_SAMPLE = 20;

	public static void main(String[] args) throws InterruptedException {
		int n = INIT_SIZE;
		Random rand = new Random(10000);
		List<Integer> totalList = new ArrayList<>();

		while(true){
			int[] arrayBase = IntStream.generate(() -> rand.nextInt()).limit(n).toArray();
			int[] array;
			Instant s1, e1, s2, e2;
			Duration d1, d2;

			// ■Arrays.parallelSort
			array = Arrays.copyOf(arrayBase, arrayBase.length);
			s1 = Instant.now();
			Arrays.parallelSort(array);
			e1 = Instant.now();
			d1 = Duration.between(s1, e1);

			// ■Arrays.sort
			array = Arrays.copyOf(arrayBase, arrayBase.length);
			s2 = Instant.now();
			Arrays.sort(array);
			e2 = Instant.now();
			d2 = Duration.between(s2, e2);

			// Arrays.parallesSortがArraysSortより速くなった場合、配列へ格納する
			if(d1.minus(d2).isNegative()) {
				totalList.add(n);

				// 上限サンプルまでたまったら、処理終了
				if(totalList.size() > MAX_SAMPLE){
					break;
				} else {
					// リソース初期化
					n = INIT_SIZE;
				}
			} else {
				n++;
			}
		}

		System.out.println("(Arrays.parallesSort > ArraysSort)  array size is = " + totalList.stream().mapToInt(i -> i).sum() / totalList.size() );
		System.out.println(totalList);
	}
}

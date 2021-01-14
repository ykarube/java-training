package ch08.ex07;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Ex07 {
	public static void main(String[] args) {

		Integer[] ints = new Integer[]{
			3, 2, null, 1, 4 ,5, null,6, null
		};
		Arrays.sort(ints, Comparator.comparing(i -> i, Comparator.nullsFirst(Comparator.<Integer>naturalOrder())));
		List<Integer> list = Arrays.asList(ints);
		Collections.reverse(list);
		System.out.println(list);
	}
}
package ch03.ex20;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;


class StreamUtil {
	public static <T, U> List<U> map(List<T> list, Function<T, U> f) {
		return list.stream().map(f).collect(Collectors.toList());
	}
}

public class Ex20 {
	public static void main(String[] args) {
		List<String> list = StreamUtil.map(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10),
			i -> "#" + String.valueOf(i * 10)
		);

		System.out.println(list);
	}
}
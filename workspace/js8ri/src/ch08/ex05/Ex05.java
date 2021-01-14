package ch08.ex05;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
steam無しのほうが速い
*/
public class Ex05 {

	static int N = 10;

	public static void main(String[] args) throws IOException {
		String contents = new String(
				Files.readAllBytes(Paths.get(System.getProperty("user.dir") + "\\src\\ch06\\ex07\\input.txt")), StandardCharsets.UTF_8);
		List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

		List<Long> list1 = new ArrayList<>();
		long cnt1 = Long.MAX_VALUE;
		for(int i = 0; i < N; i++) {
			long t1 = System.nanoTime();
			cnt1 = words.stream().filter(w -> w.length() > 12).count();
			long t2 = System.nanoTime();

			list1.add(t2 - t1);
		}

		List<Long> list2 = new ArrayList<>();
		long[] cnt2 = new long[1];
		for(int i = 0; i < N; i++) {
			cnt2[0] = 0L;
			long t1 = System.nanoTime();
			words.forEach(w -> {
				if(w.length() > 12) {
					cnt2[0]++;
				}
			});
			long t2 = System.nanoTime();

			list2.add(t2 - t1);
		}

		List<Long> list4 = new ArrayList<>();
		long[] cnt4 = new long[1];
		for(int i = 0; i < N; i++) {
			cnt4[0] = 0L;
			long t1 = System.nanoTime();
			words.forEach(w -> {
				if(w.length() > 12) {
					cnt4[0]++;
				}
			});
			long t2 = System.nanoTime();
			list4.add(t2 - t1);
		}

		List<Long> list3 = new ArrayList<>();
		@SuppressWarnings("unused") long cnt3 = Long.MAX_VALUE;
		for(int i = 0; i < N; i++) {
			long t1 = System.nanoTime();
			cnt3 = words.stream().filter(w -> w.length() > 12).count();
			long t2 = System.nanoTime();
			list3.add(t2 - t1);
		}

		list1.sort((e1, e2) -> e1.compareTo(e2));
		list2.sort((e1, e2) -> e1.compareTo(e2));
		list3.sort((e1, e2) -> e1.compareTo(e2));
		list4.sort((e1, e2) -> e1.compareTo(e2));

		System.out.println("stream		:" + list1.get(list1.size() / 2) + "ms " + list3.get(list3.size() / 2) + "ms");
		System.out.println("non stream	:" + list2.get(list2.size() / 2) + "ms " + list4.get(list4.size() / 2) + "ms");
	}
}
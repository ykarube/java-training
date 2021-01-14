package ch06.ex07;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Ex07 {
	public static void main(String[] args) throws IOException {
		ConcurrentHashMap<String, Long> txtLength = new ConcurrentHashMap<>();

		String contents = new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir") + "\\src\\ch06\\ex07\\input.txt")), StandardCharsets.UTF_8);
		String[] words = contents.split("[\\P{L}]+");

		Arrays.stream(words).parallel().forEach(word -> {
			txtLength.putIfAbsent(word, (long)word.length());
		});

		Map.Entry<String, Long> maxEntry = txtLength.reduceEntries(1, (e1, e2) -> {
			return e1.getKey().length() >= e2.getKey().length() ? e1 : e2;
		});

		System.out.println(maxEntry.getKey() + " : " + maxEntry.getValue());
	}
}

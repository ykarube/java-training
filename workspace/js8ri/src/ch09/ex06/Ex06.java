package ch09.ex06;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.ListIterator;

public class Ex06 {
	static final Path FILE_PATH = Paths.get(System.getProperty("user.dir") + "\\src\\ch09\\ex06\\output.txt");

	public static void main(String[] args) throws IOException {
		List<String> lines = Files.readAllLines(Paths.get(System.getProperty("user.dir") + "\\src\\ch09\\ex06\\input.txt"));

		Files.write(FILE_PATH, new byte[]{}, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);

		ListIterator<String> it = lines.listIterator(lines.size());
		while( it.hasPrevious() ) {
			StringBuffer buffer = new StringBuffer();
			buffer.append(it.previous()).append("\n");

			Files.write(FILE_PATH, buffer.toString().getBytes(), StandardOpenOption.APPEND);
		}
	}
}
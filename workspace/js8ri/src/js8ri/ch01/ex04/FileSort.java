package js8ri.ch01.ex04;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class FileSort {


	 public static void main(String[] args) {
		 listFiles("./").forEach(file -> System.out.println(file.getName()));
	 }

	 public static List<File> listFiles(String path) {
		Objects.requireNonNull(path);
		File[] list = new File(path).listFiles();
		Arrays.sort(list, (File a, File b) -> {
			if (a.isDirectory() && !b.isDirectory()) {
			    return -1;
			} else if (!a.isDirectory() && b.isDirectory()) {
			    return 1;
			} else {
			    return a.getName().compareTo(b.getName());
			}
		});
		return Arrays.asList(list);
	}
}
package ch01.ex03;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ListEx {

	   public static void main(String[] args) {
	        getFilesByExtension(System.getProperty("user.home"), ".txt").forEach(System.out::println);
	    }

	    public static List<String> getFilesByExtension(String path, String ext) {
	        Objects.requireNonNull(path);
	        Objects.requireNonNull(ext);
	        File dir = new File(path);
	        if (!dir.isDirectory()) {
	            throw new IllegalArgumentException("Not a directory: " + dir);
	        }
	        List<String> list = Arrays.asList(dir.list((file, name) -> {
	            return file.exists() && name.endsWith(ext); // "ext" captured.
	        }));
	        return list;
	    }
}
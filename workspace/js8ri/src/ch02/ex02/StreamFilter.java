package ch02.ex02;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamFilter {

  private static final String PATH = System.getProperty("user.dir") + "\\src\\ch02\\ex02\\alice.txt";

  public static void main(String[] args) throws IOException {
    String contents = new String(
        Files.readAllBytes(Paths.get(PATH)), StandardCharsets.UTF_8);

    List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

    getWord(10, 3,words.stream());
    System.out.println("execute " + count + " times");
  }

  private static int count = 0;

  public static List<String> getWord(int length, int limit, Stream<String> wordStream) {
    count = 0;
    return wordStream
      .filter(w -> w.length() > length)
      .peek(e -> {
        System.out.println("peek");
        count++;
      })
      .limit(limit)
      .collect(Collectors.toList());
  }

}
package ch02.ex03;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;


/**
 * stream  :3 , 346500ns(0ms)
 * pstream1:3 , 10234500ns(10ms)
 * pstream2:3 , 449300ns(0ms)
 */
public class StreamCounter {

	private static final String PATH = System.getProperty("user.dir") + "\\src\\ch02\\ex02\\alice.txt";


	public static void main(String[] args) throws IOException {
		String contents = new String(
				Files.readAllBytes(Paths.get( PATH )),
				StandardCharsets.UTF_8);
		List<String> words1 = Arrays.asList(contents.split("[\\P{L}]+"));
		List<String> words2 = Arrays.asList(contents.split("[\\P{L}]+"));
		List<String> words3 = Arrays.asList(contents.split("[\\P{L}]+"));

		long start, end, diff1, diff2, diff3;

		// パラレルストリームでカウントアップ
		start = System.nanoTime();
		long parallelCount = words1.parallelStream().filter( w -> w.length() > 12 ).count();
		end = System.nanoTime();
		diff2 = end - start;

		// シーケンシャルなストリームのカウントアップ
		start = System.nanoTime();
		long count = words2.stream().filter( w -> w.length() > 12 ).count();
		end = System.nanoTime();
		diff1 = end - start;

		// パラレルストリームでカウントアップ
		start = System.nanoTime();
		parallelCount = words3.parallelStream().filter( w -> w.length() > 12 ).count();
		end = System.nanoTime();
		diff3 = end - start;

		System.out.println( "stream  :" + count + " , " + diff1 + "ns(" + (diff1/1000/1000) + "ms)" );
		System.out.println( "pstream1:" + parallelCount + " , " + diff2 + "ns(" + (diff2/1000/1000) + "ms)" );
		System.out.println( "pstream2:" + parallelCount + " , " + diff3 + "ns(" + (diff3/1000/1000) + "ms)" );
	}
}

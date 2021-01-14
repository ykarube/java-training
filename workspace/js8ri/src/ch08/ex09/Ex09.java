package ch08.ex09;

import java.util.Iterator;
import java.util.PrimitiveIterator.OfDouble;
import java.util.PrimitiveIterator.OfInt;
import java.util.Scanner;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Ex09 {
	public static void main(String[] args) {
		final String word = "1\n2.0\n-3\nA";


		System.out.println("---word stream---");
		toWordStream(new Scanner(word)).forEach(System.out::println);
		System.out.println("------------------");

		System.out.println("---line stream---");
		toLineStream(new Scanner(word)).forEach(System.out::println);
		System.out.println("------------------");

		System.out.println("---int stream---");
		toIntStream(new Scanner(word)).forEach(System.out::println);
		System.out.println("------------------");

		System.out.println("---double stream---");
		toDoubleStream(new Scanner(word)).forEach(System.out::println);
		System.out.println("------------------");
	}

	/**
	 * スキャナを単語のストリームへ変換
	 * @param scan スキャナ
	 * @return ストリーム
	 */
	public static Stream<String> toWordStream(final Scanner scan) {
		return StreamSupport.stream(Spliterators.spliteratorUnknownSize(
				scan, Spliterator.ORDERED | Spliterator.NONNULL), false);
	}

	/**
	 * スキャナを行のストリームへ変換
	 * @param scan スキャナ
	 * @return　ストリーム
	 */
	public static Stream<String> toLineStream(final Scanner scan) {
		final Iterator<String> itr = new Iterator<String>() {
			@Override
			public boolean hasNext() {
				return scan.hasNextLine();
			}

			@Override
			public String next() {
				return scan.nextLine();
			}
		};
		return StreamSupport.stream(Spliterators.spliteratorUnknownSize(
				itr, Spliterator.ORDERED | Spliterator.NONNULL), false);
	}

	/**
	 * スキャナを整数のストリームへ変換
	 * @param scan スキャナ
	 * @return ストリーム
	 */
	public static IntStream toIntStream(final Scanner scan) {
		final OfInt primitiveItr = new OfInt() {

			@Override
			public boolean hasNext() {
				return scan.hasNextInt();
			}

			@Override
			public int nextInt() {
				return scan.nextInt();
			}
		};

		return StreamSupport.intStream(Spliterators.spliteratorUnknownSize(
				primitiveItr, Spliterator.ORDERED | Spliterator.NONNULL), false);
	}

	/**
	 * スキャナをdouble値のストリームへ変換
	 * @param scan スキャナ
	 * @return ストリーム
	 */
	public static DoubleStream toDoubleStream(final Scanner scan) {
		final OfDouble primitiveItr = new OfDouble() {
			@Override
			public boolean hasNext() {
				return scan.hasNextDouble();
			}

			@Override
			public double nextDouble() {
				return scan.nextDouble();
			}
		};

		return StreamSupport.doubleStream(Spliterators.spliteratorUnknownSize(
				primitiveItr, Spliterator.ORDERED | Spliterator.NONNULL), false);
	}
}
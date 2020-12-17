package ch03.ex18;

import java.util.function.Function;

/**
 * 任意の例外をスローする抽象メソッドを持つ関数型インターフェース
 * @param <T>
 * @param <U>
 */
@FunctionalInterface
interface FunctionEx<T, U> {
	public U apply(T arg) throws Exception;
}

public class Ex18 {
	public static void main(String[] args) {
		// 引数("2")に1を加える
		Integer value = unchecked((Integer t) -> {
			int a = 2;

			if(a != 1) {
				throw new Exception("not one");	// 任意の例外をスロー
			}

			return t + a;
		} ).apply(2);
		System.out.println(value);
	}

	public static <T, U> Function<T, U> unchecked(FunctionEx<T, U> f) {
		return (t) -> {
			try {
				return f.apply(t);
			} catch (Exception e) {
				throw new RuntimeException(e);
			} catch (Throwable e) {
				throw e;
			}
		};
	}
}
package ch13.ex02;

/**
 * 実行クラス
 */
public class Executor {

	public static void main(String[] args) {
		execute();
	}

	/**
	 * 練習問題を実行する
	 */
	public static void execute() {
		System.out.println( new StringCounter2().count("abc", "abc"));
		System.out.println( new StringCounter2().count("abc", "bca"));
		System.out.println( new StringCounter2().count("abc", "c"));
		System.out.println( new StringCounter2().count("abc", "1"));
		System.out.println( new StringCounter2().count("aaabc", "a"));
		System.out.println( new StringCounter2().count("aaabc", "aaabca"));
		System.out.println( new StringCounter2().count("aaabc", "aaabc"));
		System.out.println( new StringCounter2().count(null, "a"));
	}

}

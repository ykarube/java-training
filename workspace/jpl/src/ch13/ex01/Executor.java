package ch13.ex01;

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
		System.out.println( new StringCounter().count("abc", 'a'));
		System.out.println( new StringCounter().count("abc", 'b'));
		System.out.println( new StringCounter().count("abc", 'c'));
		System.out.println( new StringCounter().count("abc", '1'));
		System.out.println( new StringCounter().count("aaabc", 'a'));
		System.out.println( new StringCounter().count(null, 'a'));
	}

}

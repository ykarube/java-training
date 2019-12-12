package ch13.ex06;

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
		System.out.println(CommaInsertString2.insertComma("123456789", ',', 3));
		System.out.println(CommaInsertString2.insertComma("123", ',', 3));
		System.out.println(CommaInsertString2.insertComma("123456789", '.', 1));
		System.out.println(CommaInsertString2.insertComma("123456789", '?', 2));
	}

}

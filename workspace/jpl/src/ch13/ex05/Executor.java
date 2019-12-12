package ch13.ex05;

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
		System.out.println(CommaInsertString.insertComma("123456789"));
		System.out.println(CommaInsertString.insertComma("123"));
	}

}

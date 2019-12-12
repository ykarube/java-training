package ch13.ex03;

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
		DelimitedString ds = new DelimitedString();
		String[] strings = ds.delimitedStrings("[abc][abdc][aaaabc]", '[', ']');
		for (String s : strings) {
			System.out.println(s);
		}

		System.out.println("----------------------------");
		strings = ds.delimitedStrings("[abc][abdc][aaaabc]", 'a', 'c');
		for (String s : strings) {
			System.out.println(s);
		}

	}

}

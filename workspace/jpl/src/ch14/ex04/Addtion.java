package ch14.ex04;


/**
 * ex14-4.
 * 14-3.を修正してstaticデータとstaticメソッドを使う事
 */
public class Addtion {


	private static int CURRENT_NUM;

	public Addtion() {
		Addtion.CURRENT_NUM  = 0;
	}

	public static void addPrint(final int num) {
		CURRENT_NUM += num;
		System.out.println(CURRENT_NUM);
	}


}

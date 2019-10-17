package ch03.ex02;

/**
 * 実行クラス
 *
 * 練習問題2.18
 */
public class Executor {

	public static void main(String[] args) {
		X x = new X();
		System.out.printf("%x \n", x.xMask);
		System.out.printf("%x \n", x.fullMask);
		System.out.printf("%x \n", x.mask(0xff00));
		System.out.printf("%x \n", x.xMask);
		System.out.printf("%x \n", x.fullMask);

		System.out.println("-------------------");
		Y y = new Y();
		System.out.printf("%x \n", y.yMask);
		System.out.printf("%x \n", x.fullMask);
	}

}

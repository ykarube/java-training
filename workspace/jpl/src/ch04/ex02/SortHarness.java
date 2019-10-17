package ch04.ex02;

/**
 * 練習問題4.2
 * 99項の練習問題3.12の解答を
 * 最初にインターフェースを使用して書いていなければ
 * インターフェースを使用して書き直しなさい
 *
 * memo:
 * abstract→interfaceに残す
 * その他を一段階さげる（今回はSimpleSortInt.javaに引っ越し）
 */
public interface SortHarness {

	/** ソートする */
	void doSort();

	/**
	 * 要素を比較し、比較結果を返す
	 * Object型なので、サブクラスで比較方法を実装する。
	 * @param i 要素番号
	 * @param j 要素番号
	 * @return 0:イコールの場合、 -1：要素[i]が小さい、 +1:要素[j]が大きい
	 */
	int compare(int i, int j);

}


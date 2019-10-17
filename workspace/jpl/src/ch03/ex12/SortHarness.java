package ch03.ex12;

/**
 * 練習問題3.12
 * どのようなオブジェクト型もソートできる一般的なSortHarnessクラスを作成しなさい
 * オブジェクトの比較するのに < は仕様できないとして
 * オブジェクトの順序を表す方法をどのように提供します
 *
 * 参考： SortDouble.java P95
 *
 *
 * Answer of ex3-12
 *
 * サブクラスにて比較対象に応じてcompare実装する
 */
public abstract class SortHarness {

	private Object[] values;

	/** ソート */
	public final Object[] sort( Object[] data ) {
		values = data;
		doSort();
		return values;
	}

	/** ソートする */
	protected abstract void doSort();


	/**
	 * 要素を比較し、比較結果を返す
	 * Object型なので、サブクラスで比較方法を実装する。
	 * @param i 要素番号
	 * @param j 要素番号
	 * @return 0:イコールの場合、 -1：要素[i]が小さい、 +1:要素[j]が大きい
	 */
	protected abstract int compare(int i, int j);

	/** 拡張したクラスが要素を調べるため */
	protected final Object probe( int i ) {
		return values[i];
	}

	// P95流用
	/** 拡張したクラスが要素の数を知るため */
	protected final int getDataLength() {
		return values.length;
	}

	// P95流用
	/** 拡張したクラスが要素を交換するため */
	protected final void swap( int i, int j ) {
		Object tmp = values[i];
		values[i] = values[j];
		values[j] = tmp;
	}

}


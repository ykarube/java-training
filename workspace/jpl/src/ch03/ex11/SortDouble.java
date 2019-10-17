package ch03.ex11;

/**
 * 練習問題3.11
 * ソートアルゴリズムが気付かれることなくメトリクスに関して不正を行える
 * SortDoubleのセキュリティホールを少なくとも1つ見つけなさい
 * そのセキュリティホールをなくすよう修正しなさい
 * この場合ソートアルゴリズムの作成者はmainをかかないと想定してください
 *
 * Answer of 練習問題3.11
 * SortMetricsのcurMetrics,probeCnt,CompareCountに上限を設ける.
 * 理由は、オーバーフローが発生するから。
 * 実際にSimpleSortDouble.javaでdoSort()内で、doSort()再起呼び出し実行したところStackOverFlowが出力された
 */
//P95～
abstract class SortDouble {

	private double[] values;
	private final SortMetrics curMetrics = new SortMetrics();
	private int max = 2;

	/** 全ソートをするために呼び出される */
	public final SortMetrics sort( double[] data ) {
		values = data;
		curMetrics.init();
		doSort();
		return getMetrics();
	}

	/** 拡張したクラスが実装する  ^^ ソートするのに使用される */
	protected abstract void doSort();

	public SortMetrics getMetrics() {
		return curMetrics.clone();
	}

	/** 拡張したクラスが要素の数を知るため */
	protected final int getDataLength() {
		return values.length;
	}

	/** 拡張したクラスが要素を調べるため */
	protected final double probe( int i ) {
		if(curMetrics.probeCnt > max )
			throw new IllegalStateException("probe times limit.");
		curMetrics.probeCnt++;
		return values[i];
	}

	/** 拡張したクラスが要素を比較するため */
	protected final int compare( int i, int j ) {
		if(curMetrics.compareCnt > max )
			throw new IllegalStateException("compare times limit.");
		curMetrics.compareCnt++;
		double d1 = values[i];
		double d2 = values[j];
		if ( d1 == d2 )
			return 0;
		else
			return ( d1 < d2 ) ? -1 : 1;
	}

	/** 拡張したクラスが要素を交換するため */
	protected final void swap( int i, int j ) {
		if(curMetrics.swapCnt > max )
			throw new IllegalStateException("swap times limit.");
		curMetrics.swapCnt++;
		double tmp = values[i];
		values[i] = values[j];
		values[j] = tmp;
	}

}

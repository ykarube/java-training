package ch04.ex02;


//Intのソートクラス
class SimpleSortInt implements SortHarness {

	private Object[] values;

	/** ソート */
	public final Object[] sort( Object[] data ) {
		values = data;
		doSort();
		return values;
	}


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


	public void doSort() {
		for (int i = 0; i < getDataLength(); i++) {
			for (int j = i + 1; j < getDataLength(); j++ ) {
				if (compare(i, j) > 0 )
					swap(i, j);
			}
		}
	}

	public int compare(int i, int j) {
		int i1 = (int) probe(i);
		int i2 = (int) probe(j);
		if ( i1 == i2 )
			return 0;
		else
			return ( i1 < i2 ) ? -1 : 1;
	}
}

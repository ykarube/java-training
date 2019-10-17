package ch03.ex12;


//Intのソートクラス
class SimpleSortInt extends SortHarness {

	@Override
	protected void doSort() {
		for (int i = 0; i < getDataLength(); i++) {
			for (int j = i + 1; j < getDataLength(); j++ ) {
				if (compare(i, j) > 0 )
					swap(i, j);
			}
		}
	}

	@Override
	protected int compare(int i, int j) {
		int i1 = (int) probe(i);
		int i2 = (int) probe(j);
		if ( i1 == i2 )
			return 0;
		else
			return ( i1 < i2 ) ? -1 : 1;
	}
}

package ch03.ex11;

class SimpleSortDoubleHole extends SortDouble{

	@Override
	protected void doSort() {
		for (int i = 0; i < getDataLength(); i++) {
			for (int j = i + 1; j < getDataLength(); j++ ) {
				if (compare(i, j) > 0 )
					swap(i, j);
			}
		}
		//無限ループ→OverFlow
		doSort();
	}
}
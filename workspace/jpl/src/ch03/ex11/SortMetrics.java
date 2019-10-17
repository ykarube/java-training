package ch03.ex11;

/**
 * P96～
 */
public class SortMetrics implements Cloneable {
	public long probeCnt,		//単純なデータの値調査
				 compareCnt,	//２つの要素の比較
				 swapCnt;		//２つの要素の交換

	public void init() {
		probeCnt = swapCnt = compareCnt = 0;
	}

	@Override
	public String toString() {
		return probeCnt + " probes, " + compareCnt +" compares, " + swapCnt + " swaps.";
	}

	public SortMetrics clone(){
		try {
			return (SortMetrics) super.clone();
		} catch ( CloneNotSupportedException e) {
			throw new InternalError( e.toString());

		}
	}

}

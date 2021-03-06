package ch03.ex05;

public abstract class Benchmark {

	/**
	 * ベンチマーク処理
	 */
	abstract void benchmark();


	/**
	 * ベンチマークの実行に要した処理時間を提供
	 * @param count
	 * @return ベンチマークの実行に要した処理時間
	 */
	public final long repeat( int count ) {
		long start = System.nanoTime();
		for (int i = 0; i < count; i++)
			benchmark();
		return ( System.nanoTime() - start);
	}

	//練習問題10.4
	public final long repeatByWhille( int count ) {
		long start = System.nanoTime();
		int i = 0;
		while( i < count ) {
			benchmark();
			i++;
		}
		return ( System.nanoTime() - start);
	}


}

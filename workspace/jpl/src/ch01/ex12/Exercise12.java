package ch01.ex12;

/*
 * 練習問題1.12
 * ImprovedFibonacchiを修正してprintlnで文字列を直接表示するのではなく、
 * Stringオブジェクトを作成して配列に入れるようにすること
 *
 * memo
 * P18
 * Stringオブジェクトはread onlyであり、immutable(不変)
 */
public class Exercise12 {

	public static void main(String[] args) {
		Exercise12 ex = new Exercise12();
		ImprovedFibonacchii_12 if12 = ex.new ImprovedFibonacchii_12();
		if12.function();
		if12.out();
	}


	class ImprovedFibonacchii_12{
		static final int MAX_INDEX = 9;
		String[] fibonacchi_ = new String[MAX_INDEX];

		public void function() {
			int lo = 1;
			int hi = 1;
			String mark;

			this.fibonacchi_[0] = "1: " + lo;
			for ( int i = 2; i <= MAX_INDEX; i++ ) {
				if ( hi % 2 == 0 ) {
					mark = " *";
				}else {
					mark = "";
				}
				this.fibonacchi_[i-1] = i + ": " + hi + mark;
				hi = lo + hi;
				lo = hi - lo;
			}
		}

		/**
		 * 結果を出力する
		 */
		public void out() {
			for (int i = 0; i < fibonacchi_.length; i++) {
				System.out.println(fibonacchi_[i]);
			}
		}


	}

//P8より
//	class ImprovedFibonacchi{
//
//		static final int MAX_INDEX = 9;
//
//		public void function() {
//			int lo = 1;
//			int hi = 1;
//			String mark;
//			System.out.println("1: " + lo );
//			for ( int i = 2; i <= MAX_INDEX; i++ ) {
//				if ( hi % 2 == 0 ) {
//					mark = " *";
//				}else {
//					mark = "";
//				}
//				System.out.println( i + ": " + hi + mark );
//				hi = lo + hi;
//				lo = hi - lo;
//			}
//		}

}

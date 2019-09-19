package ch01.ex13;

/*
 * 練習問題1.11
 * ImprovedFibonacchiを修正してprintlnで文字列を直接表示するのではなく、
 * Stringオブジェクトを作成して配列に入れるようにすること
 *
 * memo
 * P18
 * Stringオブジェクトはread onlyであり、immutable(不変)
 */
public class Exercise13 {

	public static void main(String[] args) {
		Exercise13 ex = new Exercise13();
		ImprovedFibonacchii_13 obj = ex.new ImprovedFibonacchii_13();
		obj.function();
	}


	class ImprovedFibonacchii_13{
		static final int MAX_INDEX = 9;

		public void function() {
			int lo = 1;
			int hi = 1;
			String mark;
			System.out.printf("1: " + lo + "%n" );
			for ( int i = 2; i <= MAX_INDEX; i++ ) {
				if ( hi % 2 == 0 ) {
					mark = " *";
				}else {
					mark = "";
				}
				System.out.printf( i + ": " + hi + mark + "%n" );
				hi = lo + hi;
				lo = hi - lo;
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

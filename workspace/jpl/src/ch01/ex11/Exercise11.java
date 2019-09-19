package ch01.ex11;

//TODO 問題の意味意図がわからない,,,


/*
 * 練習問題1.11
 * StringDemoアプリケーションを修正して他の文字列を使用する
 *
 * memo
 * P18
 * Stringオブジェクトはread onlyであり、immutable(不変)
 */
public class Exercise11 {

	public static void main(String[] args) {
		Exercise11 ex = new Exercise11();
		StringDemo demo = ex.new StringDemo();
		demo.function();
//		fibonacchi.out();
	}


	class StringDemo{
		String myName = "Petronius";

		public void function() {
			myName = myName + " Arbiter";
			System.out.println( "Name = " + myName);
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

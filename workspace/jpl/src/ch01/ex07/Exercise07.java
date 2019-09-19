package ch01.ex07;

/*
 * 練習問題1.7
 * iが逆順に値が減るようにImprovedFibonacciのループを書き直しなさい
 *
 */
public class Exercise07 {

	static final int MAX_INDEX = 9;

	public static void main(String[] args) {
		int lo = 1;
		int hi = 1;
		String mark;

		System.out.println("1: " + lo );
		// (int i = 2; i <= MAX_INDEX; i++) {                 //ORIGINALｺﾒﾝﾄアウト

		/* iが逆順に値が減るように修正 */
		for (int i = MAX_INDEX ; i >= 2 ; i--) {
			if ( hi % 2 == 0 )
				mark = " *";
			else
				mark = "";
			System.out.println(i + ": " + hi + mark);
			hi = lo + hi;
			lo = hi-lo;
		}

	}
}

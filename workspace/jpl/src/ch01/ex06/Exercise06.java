package ch01.ex06;

/*
 * 練習問題1.6
 * 練習問題1.3を修正し、タイトルに対して名前付文字列定数を使用するよう修正する
 *
 */
public class Exercise06 {

	final static String TITLE = "Fibonacci function ....";
	public static void main(String[] args) {
		int lo = 1;
		int hi = 1;
		System.out.println( TITLE );  //add.
		System.out.println(lo);
		while( hi < 50){
			System.out.println(hi);
			hi = lo + hi;
			lo = hi - lo;
		}
	}

}

package practice.exercise1;

/*
 * 練習問題1.3
 * Fibonacciの出力リストにタイトルを追加しなさい
 *
 */
public class Exercise03 {

	public static void main(String[] args) {
		int lo = 1;
		int hi = 1;
		System.out.println("Fibonacci function ....");  //add.
		System.out.println(lo);
		while( hi < 50){
			System.out.println(hi);
			hi = lo + hi;
			lo = hi - lo;
		}
	}

}

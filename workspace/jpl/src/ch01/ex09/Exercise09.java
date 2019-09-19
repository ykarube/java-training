package ch01.ex09;

/*
 * 練習問題1.9
 * Fibonacciアプリケーションを修正して、数列を配列に保存して、最後に値のリストを表示する
 *
 */
public class Exercise09 {

	public static void main(String[] args) {
		Exercise09 ex = new Exercise09();
		Fibonacchi f = ex.new Fibonacchi();
		f.function();

	}


	//Fibonacchi数列クラス
	class Fibonacchi {
		//Fibonacci数列を配列に保存し、数列のリストを表示する。
		static final int MAX_INDEX = 9;
		public void function() {
			int lo = 1;
			int hi = 1;
			int fibonacchi[] = new int[MAX_INDEX];
			int index = 0;
			System.out.println(hi);
			while( hi < 50){
				fibonacchi[index]= hi;
				hi = lo + hi;
				lo = hi - lo;
				index += 1;
			}

			for (int i = 0; i < fibonacchi.length; i++) {
				if (fibonacchi[i] != 0) {
					System.out.print(fibonacchi[i] +", " );
				}
			}

		}
	}

}

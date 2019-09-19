package ch01.ex04;

/*
 * 練習問題1.4
 * なんらかの数列を生成するプログラムを作成しなさい。　例えば平方表とか
 *
 */
public class Exercise04 {

	/*
	 * 1～9までの２乗の数列を出力するプログラム
	 *
	 */
	public static void main(String[] args) {
		int i = 1;
		int max = 9;

		System.out.println("1～9までの２乗を出力するプログラム");
		while( i <= max){
			System.out.println(i*i);
			i++;
		}
	}
}

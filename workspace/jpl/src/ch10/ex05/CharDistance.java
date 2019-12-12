package ch10.ex05;

/**
 * 練習問題10.5
 * 2つのcharを引数にとってそれらの文字とそれらのも時間の文字を表示するメソッドを作成する
 *
 */
//no testCode
public class CharDistance {


	   public static void main(String[] args) {
	        System.out.println(print('0', '9'));
	        System.out.println(print('a', 'z'));
	    }


	   public static String print(char start, char end) {
			StringBuilder result = new StringBuilder();
			for (char c = start; c <= end; c++)
				result.append(String.valueOf(c));
			return result.toString();
	    }

}
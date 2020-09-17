package ch22.ex01;

/**
 * ex22-1  p557
 * 浮動小数点値の配列と、何列使用するかを指定する数字を受け取り、
 * 配列の内容を表示するメソッドを書きなさい。
 * 各列のエントリーが綺麗に整列することを保証するようにしなさい。
 * 1行は80文字と想定してください。
 */
public class FormattedListPrint {

	public static void showDouble(double[] array, int length){
        if (array == null)
            throw new NullPointerException();
        if (length <= 0)
            throw new IllegalArgumentException();
        for (double d : array) {
            System.out.printf("%." + length + "f%n", d);
        }
	}

	   public static void main(String[] args) {
	        double[] data = { -0.1, 1.1, 2.2, 1.0 / 4, 0.000005,1.2345678901234567890 };
	        showDouble(data, 80);
	    }

}

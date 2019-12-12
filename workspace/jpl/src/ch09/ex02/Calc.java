package ch09.ex02;

/**
 * 練習問題9.1
 * 2つの無限大のオペランドに対して演算子+,-,*,/を使用するプログラムを作成して
 * 結果を表示しなさい。どちらも同じ符号の値と異なる符号の値の両方を示しなさい。
 *
 */
//no testCode
public class Calc {

	public static void main(String[] args) {
		Double pInfinity_ = Double.POSITIVE_INFINITY;
		Double nInfinity_ = Double.NEGATIVE_INFINITY;

		System.out.println( pInfinity_ + "+" + nInfinity_ + "=" + (pInfinity_ + nInfinity_) );
		System.out.println( pInfinity_ + "-" + nInfinity_ + "=" + (pInfinity_ - nInfinity_) );
		System.out.println( pInfinity_ + "*" + nInfinity_ + "=" + (pInfinity_ * nInfinity_) );
		System.out.println( pInfinity_ + "/" + nInfinity_ + "=" + (pInfinity_ / nInfinity_) );
		System.out.println( pInfinity_ + "+" + pInfinity_ + "=" + (pInfinity_ + pInfinity_) );
		System.out.println( pInfinity_ + "-" + pInfinity_ + "=" + (pInfinity_ - pInfinity_) );
		System.out.println( pInfinity_ + "*" + pInfinity_ + "=" + (pInfinity_ * pInfinity_) );
		System.out.println( pInfinity_ + "/" + pInfinity_ + "=" + (pInfinity_ / pInfinity_) );
	}

}
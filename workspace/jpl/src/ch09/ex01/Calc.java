package ch09.ex01;

/**
 * 練習問題9.2
 * ビット操作演算子だけを使用し、（すなわち Intefer.bitCountを使用しないで）
 * 渡されたintで、1となっているビット数を調べるメソッドを作成しなさい。
 * 作成した回答と公開されているアルゴリズムを比較しなさい。
 * 公開されているアルゴリズムの1つに関しては 670項の「一般的なプログラミング技能の関連する書式を参照してください。。
 *
 */
//no testCode
public class Calc {

	public static void main(String[] args) {
		Double pInfinity_ = Double.POSITIVE_INFINITY;
		Double nInfinity_ = Double.NEGATIVE_INFINITY;

		System.out.println( pInfinity_ + " + " + nInfinity_ + " = " + (pInfinity_ + nInfinity_) );
		System.out.println( pInfinity_ + " - " + nInfinity_ + " = " + (pInfinity_ - nInfinity_) );
		System.out.println( pInfinity_ + " * " + nInfinity_ + " = " + (pInfinity_ * nInfinity_) );
		System.out.println( pInfinity_ + " / " + nInfinity_ + " = " + (pInfinity_ / nInfinity_) );
		System.out.println( pInfinity_ + " + " + pInfinity_ + " = " + (pInfinity_ + pInfinity_) );
		System.out.println( pInfinity_ + " - " + pInfinity_ + " = " + (pInfinity_ - pInfinity_) );
		System.out.println( pInfinity_ + " * " + pInfinity_ + " = " + (pInfinity_ * pInfinity_) );
		System.out.println( pInfinity_ + " / " + pInfinity_ + " = " + (pInfinity_ / pInfinity_) );
	}

}
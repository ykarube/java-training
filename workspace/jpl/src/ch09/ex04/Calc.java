package ch09.ex04;

/**
 * 練習問題9.4
 * この章で学んだ事柄を使用して実際にコードを書かないで
 * 次の式のどれが正しいか判断しなさい。そして正しい式であれば、その方を値が何であるか考えなさい。
 */
//no testCode
//TODO refact.
public class Calc {

    public static void main(String[] args) {

    	// int 6
    	System.out.println(3 << 2L - 1);

    	// double 11
        System.out.println((3L << 2) - 1);

        // boolean false
        System.out.println(10 < 12 == 6 > 17);

        // boolean false
        System.out.println(10 << 12 == 6 >> 17);

        // double 1.35
        System.out.println(13.5e-1 % Float.POSITIVE_INFINITY);

        // double NaN
        System.out.println(Float.POSITIVE_INFINITY + Double.NEGATIVE_INFINITY);

        // double Infinity
        System.out.println(Double.POSITIVE_INFINITY - Float.NEGATIVE_INFINITY);


        // boolean false
        System.out.println(0.0 / -0.0 == -0.0 / 0.0);

        // int -1
        System.out.println(Integer.MAX_VALUE + Integer.MIN_VALUE);

        // long -9223372036854775804
        System.out.println(Long.MAX_VALUE + 5);


        // int 50
        System.out.println((short) 5 * (byte) 10);

        int i = 3;
        // float 1720.0
        System.out.println(i < 15 ? 1.72e3f : 0);
        // int 11
        System.out.println(i++ + i++ + --i);
    }
}

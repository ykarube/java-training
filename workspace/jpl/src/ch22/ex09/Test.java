package ch22.ex09;

/**
 * ex22-9 p570
 *
 * 286頁の正規表現の効率性の議論を参照して、
 * CSVの行を解析するパターンを少なくとも4つ考え出しなさい。
 *
 * (ヒント:286頁での忠告に加えて、
 * 最長一致の量指定子（greedy quantifier）と
 * 最短一致の量指定子(non-greedy quantifier)の使用を考えてみてください。）
 *
 * 各パターンの効率性を比較するベンチマークプログラムを書きなさい。
 * そして、カンマ間が短い文字列と非常に長い文字列の両方でテストすることを忘れないでください。
 *
 */
public class Test {

    private static final String PATTERN1 = "(.*),(.*)";
    private static final String PATTERN2 = "([^,]*),([^,]*)";
    private static final String PATTERN3 = "";
    private static final String PATTERN4 = "";

    private static final String SOURCE1 = "1,2";
    private static final String SOURCE2 = "12345678901234567890,12345678901234567890";

    private static final int MAX_TRY = 1000;

    public static void main(String[] args) {
        System.out.println("p1s1: " + exec(PATTERN1, SOURCE1));
        System.out.println("p1s2: " + exec(PATTERN1, SOURCE2));
        System.out.println("p2s1: " + exec(PATTERN2, SOURCE1));
        System.out.println("p2s2: " + exec(PATTERN2, SOURCE2));
    }

    private static long exec(String pattern, String source) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < MAX_TRY; i++)
            source.matches(pattern);
        long end = System.currentTimeMillis();
        return end - start;
    }
}
package ch09.ex03;

import ch07.ex03.PascalTriangle;

/**
 * 練習問題9.3
 * 本賞で学んだ演算子を使用して、練習問題7.3の回答をより明瞭あるいは、より簡潔に書くことができるか検討しなさい
 *
 */
//no testCode
//TODO refact.
public class PascalRefacter {

    public static void main(String[] args) {
        new PascalTriangle().print(12);
    }


    /**
     * トライアングルの出力
     *
     * @param size トライアングルのサイズ
     */
    public void print(int size) {
        int[][] table = createTabale(size);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - 1 - i; j++)
                System.out.print("  ");
            for (int num : table[i])
                System.out.printf("%4d", num);
            System.out.println();
        }
    }

    /**
     * トライアングルのテーブル生成
     *
     *
     * @return int[][] データ
     */
    private int[][] createTabale(int size) {
        int[][] table = new int[size][];
        for (int i = 0; i < size; i++) {
            table[i] = new int[i + 1];
            table[i][0] = 1;
            table[i][i] = 1;
        }
        for (int i = 2; i < size; i++)
            for (int j = 1; j < table[i].length - 1; j++)
                table[i][j] = table[i - 1][j - 1] + table[i - 1][j];
        return table;
    }
}

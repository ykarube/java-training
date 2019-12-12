package ch07.ex03;

/**
 * 練習問題7.3
 * 深さが12のパスカルの三角形を計算するプログラムを作成しなさい
 * 三角形の各行を適切な長さの配列とし、各行の配列を長さ12のint配列の配列に格納しなさい。
 * 定数12ではなく、各配列の長さを使用して配列の配列を表示するメソッドにより、結果を表示するようにプログラムしなさい
 * さらに、表示メソッドを変更することなく、12を他の定数に変更してみなさい
 *
 */
public class PascalTriangle {

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

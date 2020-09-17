package ch22.ex05;

import java.util.Random;

/**
 * ex22-5  p565
 *
 * 6面サイコロの個数が指定されると、可能性のある合計値ごとの理論的確率を計算できます。
 * たとえば、2個の6面サイコロでは、合計が7になる確率は、1/6です。
 * プログラムを作成して、特定の個数の6面サイコロでの合計値の理論的分布を、
 * 1から6までの数を発生するRandomを使用して膨大な数のサイコロを「振った」結果と比較しなさい。
 *
 * どの乱数発生メソッドを使用するかは、問題となりますか。
 * オブザーバーヘ変化を通知するのにObserver/Observableを使用する
 * Attributedインタフェースの実装を提供しなさい
 */
public class Dice {

    private static final int SIDE = 6;

    public int nextValueWithUtilRandom() {
        return new Random().nextInt(SIDE) + 1;
    }
    public int nextValueWithMathRandom() {
        return (int) (Math.random() * 100) % SIDE + 1;
    }
}
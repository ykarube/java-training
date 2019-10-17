package ch04.ex01;

/**
 * 練習問題4.1
 * 86項の練習問題3.6の解答を抽象クラスではなく、EnegySourceのための
 * インターフェースを使用して書き直しなさい
 *
 * memo.
 * 実装先でpublicにしないと以下メッセージがでる.
 * "EnergySource から継承されたメソッドの可視性を下げることはできません"
 */
public interface EnergySource {

	boolean empty();
	void charge( int energy );
	boolean run();

}

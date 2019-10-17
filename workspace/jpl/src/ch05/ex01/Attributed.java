package ch05.ex01;

/**
 * 練習問題4.4
 * インターフェースのみを利用してコレクションクラス階層を設計しなさい
 */
//P109より
public interface Attributed {
	void add(Attr newAttr);
	Attr find(String attrName);
	Attr remove(String attrName);
	java.util.Iterator<Attr> attrs();
}

package ch11.ex02;

/**
 * 練習問題11.2
 * 第3章のAttrクラスをジェネリックスクラスとして書き直しなさい
 */
public interface Attributed<E> {

	void add(Attr<E> newAttr);
	Attr<E> find(String attrName);
	Attr<E> remove(String attrName);
	java.util.Iterator<Attr<E>> attrs();

}
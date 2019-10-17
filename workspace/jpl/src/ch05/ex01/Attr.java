package ch05.ex01;

/**
 * 練習問題5.1
 *
 * 第4章のAttrクラスとAttirbutedインターフェースについて考えてみてください
 * これはどちらかがネストした型であるべきですか
 * もしそうであれば、どちらかがネストした方であることに意味がありますか
 *
 * ■Answer of ex5.1
 * ネスト不要
 * AttrにAttirubtedインターフェースを定義するのは適切とはいえない
 * 理由は、より抽象化されるべきで、Attibutedを定義することで、他のinterfaceが持てなくなるから
 *
 * Attributed内にattrを定義した場合も同様。
 *
 */
public interface Attr<T> {

	public String getName();
	public T getValue();
	public void setValue( T value);
	public String toString();

}

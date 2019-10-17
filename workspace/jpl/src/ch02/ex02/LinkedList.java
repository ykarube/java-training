package ch02.ex02;

/**
 * ex2.2
 * LinkedListクラスを作成しなさい
 * LinkdeListクラスはObject型のフィールドとリストの中で次のListdListの参照を持ちます
 */
public class LinkedList {

	private Object obj;
	LinkedList next;		//次のLinkedList

	public void setData( Object obj) {
		this.obj = obj;
	}

	public Object getObject() {
		return this.obj;
	}

	/** 次のLikedListへの参照をセットする */
	public void setNext( LinkedList next ) {
		this.next = next;
	}

	public LinkedList getNext() {
		return this.next;
	}

}

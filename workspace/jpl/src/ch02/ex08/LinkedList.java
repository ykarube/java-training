package ch02.ex08;

/**
 * ex2.8
 * LinkedListクラスにどのようなコンストラクタを生成すべきか
 *
 * Answer of ex2.8
 *   public LinkedList() {
 * 		this.obj = null;
 * 		this.next = null;
 * 	}
 */
public class LinkedList {

	private Object obj;
	LinkedList next;		//次のLinkedList

	public LinkedList() {
		this.obj = null;
		this.next = null;
	}

	public void setObject( Object obj) {
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

/** ---------------------------------------------------------------- */
	public static void main(String[] args) {

		LinkedList list = new LinkedList();
		System.out.println("object:"+list.getObject());
		System.out.println("next:"+list.getNext());

		list.setNext(new LinkedList());
		list.setObject("hoge");
		System.out.println("object:"+list.getObject());
		System.out.println("next:"+list.getNext());

	}

}

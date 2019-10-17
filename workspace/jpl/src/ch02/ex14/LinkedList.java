package ch02.ex14;

/**
 * ex2.14
 * メンバをprivateにする
 */
public class LinkedList {

	private Object obj;
	private LinkedList next;		//次のLinkedList

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

	@Override
	public String toString() {
		String str = null;
		if(obj != null)
			str = obj.toString();
		if(next != null)
			str += ", next:" + next;
		return str;
	}

/** ---------------------------------------------------------------- */
	public static void main(String[] args) {

		LinkedList list = new LinkedList();
		System.out.println("object:"+list.getObject());
		System.out.println("next:"+list.getNext());

		LinkedList list2 = new LinkedList();
		list2.setObject("hogehoeg");
		list.setNext(list2);
		list.setObject("hoge");
		System.out.println("object:"+list.getObject());
		System.out.println("next:"+list.getNext());

		System.out.println(list.toString());
	}

}

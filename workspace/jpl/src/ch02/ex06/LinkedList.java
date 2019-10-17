package ch02.ex06;

/**
 * ex2.6
 * LinkedListクラスにメインメソッドを書いて、Vehicle型のオブジェクトを数個作成して
 * リストの連続したノードに入れなさい
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
		Vehicle v1 = new Vehicle();
		Vehicle v2 = new Vehicle();
		Vehicle v3 = new Vehicle();

		v1.owner_ = "toyota";
		v2.owner_ = "honda";
		v3.owner_ = "nissan";

		LinkedList list1 = new LinkedList();
		list1.setObject(v1);

		LinkedList list2 = new LinkedList();
		list2.setObject(v2);
		list1.setNext(list2);

		LinkedList list3 = new LinkedList();
		list3.setObject(v3);
		list2.setNext(list3);

		Object obj1 = list1.getObject();
		if (obj1 instanceof Vehicle) {
			System.out.println(((Vehicle) obj1).owner_ );
		}

	}

}

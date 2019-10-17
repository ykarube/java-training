package ch02.ex16;

/**
 * ex2.16
 * リスト内の要素数を返すメソッドを追加
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

	//Answer
	public int getSize(){
		int size = 0;
		LinkedList list = next;
		while(next != null){
			if(this == list)
				break;
			size++;
			next = list.getNext();
		}
		return size;
	}

/** ---------------------------------------------------------------- */
	public static void main(String[] args) {

		LinkedList list1 = new LinkedList();
		LinkedList list2 = new LinkedList();
		list1.setNext(list2);
		list1.setObject("hoge");
		list2.setObject("hogehoeg");
		System.out.println(list1.getSize());
		System.out.println(list2.getSize());
	}

}

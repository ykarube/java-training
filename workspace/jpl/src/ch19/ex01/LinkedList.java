package ch19.ex01;

/**
 * 練習問題2.16で作成したLinkedListクラスにドキュメンテーションコメントを追加しなさい。
 * javadocを生成して、誰かにそのクラスを使用したサンプルプログラムを書いてもらいなさい。
 * その人がサンプルプログラムを書けるまで、必要ならばコメントを書き直して、同じことを繰り返しなさい。
 */

//練習問題2.16からコピー
/**
 * LinkedListクラス
 */
public class LinkedList {

	private Object obj;
	private LinkedList next;		//次のLinkedList

	/**
	 * コンストラクタ
	 */
	public LinkedList() {
		this.obj = null;
		this.next = null;
	}

	/**
	 * このリストへ指定された要素をセットする
	 * @param obj セットする要素
	 */
	public void setObject( Object obj ) {
		this.obj = obj;
	}

	/**
	 * このリストが保持する要素を取得する
	 * @param obj リストが保持する要素
	 */
	public Object getObject() {
		return this.obj;
	}

	/**
	 * 次のLikedListへの要素を設定する（参照をセットする)
	 * @param next 次の要素
	 */
	public void setNext( LinkedList next ) {
		this.next = next;
	}

	/**
	 * このリストの次の要素を取得する
	 * @return LinkedListが保持する次の要素
	 */
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
	/**
	 * このリストないにある要素の数を返す
	 * @return int 要素数
	 */
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

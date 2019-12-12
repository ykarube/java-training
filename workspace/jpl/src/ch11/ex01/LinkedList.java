package ch11.ex01;

/**
 * 練習問題11.1
 * 練習問題2.2で始めたLinkedListクラスを見直して、ジェネリッククラスとして書き直しなさい
 */
public class LinkedList<E> {

		E obj;
		LinkedList<E> next;

		public E getObj() {
			return obj;
		}
		public void setObj(E obj) {
			this.obj = obj;
		}
		public LinkedList<E> getNext() {
			return next;
		}
		public void setNext(LinkedList<E> next) {
			this.next = next;
		}

}
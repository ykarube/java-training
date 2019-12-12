package ch12.ex01;

/**
 * 練習問題13.1
 * 以前の練習問題で作成したLinkedListクラスに対するObjectNotFoundExceptionクラスを作成する
 * リスト中のオブジェクトを探すfindメソッドを追加して、要求されたオブジェクトが含まれるlinkedListオブジェクトを
 * 返すか、発見されなければその例外をスローすること
 *
 *
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

		public E find(E target)throws ObjectNotFoundException{
			if(target.equals(obj)) {
				return obj;
			}
			else if(next == null){
				throw new ObjectNotFoundException(target.toString() +" is not found.");
			}
			else{
				return next.find(target);
			}
		}

}
package ch21.ex07;

import java.util.ArrayList;

/**
 * ex21-7  p545
 * ArrayListを使用してスタックを実装しなさい。
 * スタック固有の異なるメソッドを提供するために、そのスタックのクラスは、ArrayListのサブクラスとすべきですか。
 * それともArrayListを内部で使用すべきですか。
 *
 *
 * >> Answer.
 * >>  ArrayListのサブクラスとすると、他のコレクションで使えないのでArrayListを内部で使用するべき。
  */

public class ArrayListStack<E> {

	private ArrayList<E> stack;
	private final int DEFAULT_CAPACITY = 10;
	private int sp = 0; /* Stack Pointer */

	public ArrayListStack() {
		stack = new ArrayList<E>(DEFAULT_CAPACITY);
	}
	public void push(E item) {
		stack.add(item);
		sp++;
	}
	public E pop() {
		sp--;
		if(sp < 0){
			sp = 0;
			return null;
		}
		else{
			E e = stack.get(sp);
			stack.remove(sp);
			return e;
		}
	}
	public static void main(String[] args){
		ArrayListStack stack = new ArrayListStack();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}
}

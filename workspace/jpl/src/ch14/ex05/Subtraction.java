package ch14.ex05;


/**
 * ex14-5
 * 14-4.を修正staticの同期されたメソッドを使用しないでスレッドが安全に値を減算できるようにしなさい
 */
public class Subtraction {


	private int CURRENT_NUM;
	private Object lock = new Object();

	public Subtraction() {
		this.CURRENT_NUM  = 10000;
	}

	public void subPrint(final int num) {
		synchronized (lock) {
			CURRENT_NUM -= num;
			System.out.println(CURRENT_NUM);
		}
	}

}

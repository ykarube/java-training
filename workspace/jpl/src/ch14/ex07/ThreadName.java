package ch14.ex07;

/**
 * mainを実行しているスレッドの名前を表示する
 */
public class ThreadName {

	public static void main(String[] args) {
		System.out.println(	"id=" + Thread.currentThread().getId());
		System.out.println(	"name=" + Thread.currentThread().getName());
	}
}

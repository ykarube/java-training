package ch12.ex01;

/**
 * 実行クラス
 */
public class Executor {

	public static void main(String[] args) {
		execute();
	}

	/**
	 * 練習問題を実行する
	 */
	public static void execute() {
		LinkedList<String> list1 = new LinkedList<String>();
		LinkedList<String> list2 = new LinkedList<String>();
		LinkedList<String> list3 = new LinkedList<String>();
		list1.setNext(list2);
		list1.setNext(list3);
		String s1 = "hoge1";
		String s2 = "hoge2";
		String s3 = "hoge3";
		list1.setObj(s1);
		list2.setObj(s2);
		list3.setObj(s3);


		try {
			System.out.println(list1.find(s1));
		} catch (ObjectNotFoundException e) {
			e.printStackTrace();
		}

		try {
			System.out.println(list1.find("hoge"));
		} catch (ObjectNotFoundException e) {
			e.printStackTrace();
		}


		try {
			System.out.println(list1.find("hoge1"));
		} catch (ObjectNotFoundException e) {
			e.printStackTrace();
		}

	}

}

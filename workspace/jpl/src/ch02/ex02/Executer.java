package ch02.ex02;

public class Executer {

	public static void main(String[] args) {
		execute();
	}

	private static void execute() {
		LinkedList list = new LinkedList();
		list.setData("hoge");
		Object obj = list.getObject();
		System.out.println(obj.toString());

		LinkedList list2 = new LinkedList();
		list.setNext(list2);

		System.out.println(list2.equals(list.getNext()));

	}
}

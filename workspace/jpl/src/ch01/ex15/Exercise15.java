package ch01.ex15;

/*
 * 練習問題1.15

 */
public class Exercise15 {

	public static void main(String[] args) {
		execute();
	}

	/**
	 * 練習問題の実行
	 */
	public static void execute() {
		final Object obj1 = new Object();
		final Object obj2 = new Object();
		final Object obj3 = new Object();

		final String name1 = "kensyu1";
		final String name2 = "kensyu2";
		final String name3 = "kensyu3";

		LookupContener contener = new LookupContener();
		contener.add(obj1, name1);
		contener.add(obj2, name2);
		contener.add(obj3, name3);

		Object obj = null;

		if(obj1.equals( contener.find(name1)))
			System.out.println("found.... " + name1);
		else
			System.out.println("not found");

		contener.remove(name1);

		if(obj1.equals( contener.find(name1)))
			System.out.println("found.... " + name1);
		else
			System.out.println("not found");


	}


}

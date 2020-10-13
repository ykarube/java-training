package ch01.ex09;

import ch01.ex09.Collection2.ArrayList2;

public class Execute {

	public static void main(String[] args) {
	    ArrayList2<String> arrayList2 = new ArrayList2<>();
	    arrayList2.add("abc1");
	    arrayList2.add("abcl");
	    arrayList2.add("abc");
	    arrayList2.add("abc123");

	    System.out.println("====forEachIf====");
	    arrayList2.forEach(System.out::println);
	    System.out.println("====forEachIf contain [1]====");
	    arrayList2.forEachIf(System.out::println, (String a)-> a.contains("1") );
	}
}

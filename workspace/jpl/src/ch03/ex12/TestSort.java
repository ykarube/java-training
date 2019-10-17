package ch03.ex12;

public class TestSort {

	static Object[] testData =  {
						10, 2 ,5
		};

	public static void main(String[] args) {
		SortHarness sort = new SimpleSortInt();
		Object obj[] = sort.sort(testData);
		for (int i = 0; i < obj.length; i++) {
			System.out.println( "\t" + obj[i] );
		}
	}
}

package ch04.ex02;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestSimpleSortInt {


	static Object[] testData =  {
			3, 2 ,5
	};


	@Test
	public void testDoSortCompare() {
		SimpleSortInt sortInt = new SimpleSortInt();
		//doSortではデータをセットできないので、sortでテストする
		Object obj[] = sortInt.sort(testData);
		assertEquals(2, obj[0]);
		assertEquals(3, obj[1]);
		assertEquals(5, obj[2]);
	}

}

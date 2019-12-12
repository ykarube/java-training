package ch03.ex11;

import static org.junit.Assert.*;

import org.junit.Test;

//P97～ 選択ソート
public class TestSortDoubleSecurityHole {

	static double[] testData =  {
			0.3, 1.3e-2, 7.9, 3.17
	};

	@Test
	public void testDoSort() {
		SimpleSortDoubleHole sort = new SimpleSortDoubleHole();

		try {
			SortMetrics metrics = sort.sort(testData);

			fail();
		} catch (Exception e) {
			assertEquals(e.getClass(), IllegalStateException.class);
		}
	}

}

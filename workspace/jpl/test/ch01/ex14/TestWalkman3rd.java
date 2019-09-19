package ch01.ex14;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestWalkman3rd {

	@Test
	public void testConnect_Communicate() {
		Walkman3rd walkman = new Walkman3rd();

		try {
			walkman.connect(null);
			fail();
		} catch (Exception e) {
			assertEquals(NullPointerException.class, e.getClass());
		}

		try {
			walkman.communicate("talk...");
			fail();
		} catch (Exception e) {
			assertEquals(IllegalStateException.class, e.getClass());
		}


		Walkman3rd target = new Walkman3rd();
		walkman.connect(target);
		walkman.communicate("talk...");
		//コンソールから停止(文字列)が出力されることを確認

		walkman.close();
	}

}

package ch01.ex16;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.IOException;

import org.junit.Test;

public class TestMyUtilities {

	/**
	 * fileからデータの集まりを読み込んで返却する
	 * 成功パタン
	 */
	@Test
	public void testGetDataSetSuccess() {
		String path = "C:\\work\\workspace_repos\\java-training\\workspace\\jpl\\src\\ch01\\ex16\\exercise16";

		MyUtilities utility = new MyUtilities();
		double[] ret = null;
		Exception error = null;
		try {
			ret = utility.getDataSet(path);
		} catch (BadDataSetException e) {
			error = e;
		}
		assertNotNull(ret);
		assertNull(error);
	}

	/**
	 * fileからデータの集まりを読み込んで返却する
	 * 失敗パタン
	 */
	@Test
	public void testGetDataSetException() {
		String path = "badPath";

		MyUtilities utility = new MyUtilities();
		double[] ret = null;
		Exception error = null;
		try {
			ret = utility.getDataSet(path);
		} catch (BadDataSetException e) {
			error = e;
		}
		assertNull(ret);
		assertNotNull(error);
		assertEquals(BadDataSetException.class, error.getClass());
	}


	/**
	 * fileからデータの集まりを読み込んで返却する
	 * 失敗パタンW
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void testReadDataSet() {
		FileInputStream in = null;
		MyUtilities utility = new MyUtilities();
		double ret[] = null;

		try {
			utility.readDataSet(in);
		} catch (NullPointerException e) {
			assertEquals(NullPointerException.class, e.getClass());
		}

		String path = "C:\\work\\workspace_repos\\java-training\\workspace\\jpl\\src\\ch01\\ex16\\exercise16.dset";
		try {
			in = new FileInputStream( path );
			ret = utility.readDataSet(in);
		} catch (IOException e) {
			fail();
		} finally {
			try {
				if ( in != null )
					in.close();
			} catch ( IOException e ){
			}
		}
		assertNotNull(ret);

		double[] compare = null;
		path = "C:\\work\\workspace_repos\\java-training\\workspace\\jpl\\src\\ch01\\ex16\\exercise16";
		try {
			compare = utility.getDataSet(path);
		} catch (BadDataSetException e) {
			fail();
		}

	}

}

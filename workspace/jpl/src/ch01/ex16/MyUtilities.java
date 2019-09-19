package ch01.ex16;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MyUtilities {


	/**
	 * fileからデータの集まりを読み込んで返却する
	 * @param setName
	 * @return
	 * @throws BadDataSetException
	 */
	public double[] getDataSet( final String setName )
		throws BadDataSetException {
		String file = setName + ".dset";
		FileInputStream in = null;
		try {
			in = new FileInputStream( file );
			return readDataSet(in);
		} catch (IOException e) {
			throw new BadDataSetException( setName, e);
		} finally {
			try {
				if ( in != null )
					in.close();
			} catch ( IOException e ){
				;
			}
		}

	}

	/**
	 * FileInputStreamからデータを配列にセットして返却する
	 * @param setName
	 * @return
	 * @throws BadDataSetException
	 */
	public double[] readDataSet(FileInputStream in) {
		double dataSet[] = new double[100];

		if ( in == null ) {
			throw new NullPointerException(" FileInputStream is null.");
		}
		InputStreamReader reader = new InputStreamReader(in);

		int data;
		try {
			int i = 0;
			while ( (data =reader.read()) != -1 )  {
				dataSet[i] = data;
				i++;
//				System.out.println(data);
			}
		} catch (IOException e) {
		}
		return dataSet;
	}
}

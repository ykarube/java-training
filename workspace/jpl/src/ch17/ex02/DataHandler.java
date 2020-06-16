package ch17.ex02;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
/**
 * DataHallldlerを修正してlastFileも弱く保存されるようにしなさい。
 */
public class DataHandler {

	private WeakReference<File> lastFile;
	private WeakReference<byte[]> lastData;

	byte[] readFile(File file){
		byte[] data;
		if (file.equals(lastFile)){
		data = lastData.get();
		if (data != null)
		return data;
		}
		data = readBytesFromFile(file);
		lastFile = new WeakReference<File>(file);
		lastData = new WeakReference<byte[]>(data);
		return data;
	}

	byte[] readBytesFromFile(File file){
		byte[] bytes = new byte[(int) file.length()];
		try{
			new FileInputStream(file).read(bytes);
		}catch(IOException e){
			e.printStackTrace();
		}
		return bytes;
	}

	public static void main(String[] args){
		DataHandler dh = new DataHandler();
	    String path = System.getProperty("user.dir");
		dh.readFile(new File(path+"\\src\\ch17\\ex02\\hoge.txt"));

	}

}

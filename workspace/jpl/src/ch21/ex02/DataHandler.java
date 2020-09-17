package ch21.ex02;

import java.io.File;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/**
 *  400頁のDataHandlerクラスを書き直して、
 *  1つのWeakReferenceの代わりにWeakHashMapを使用して返されたデータを保持するようにしなさい。
 */
class DataHandler {
	static String path = System.getProperty("user.dir") + "\\src\\ch21\\ex02\\hoge.txt";
	private WeakReference<File> lastFile = new WeakReference<File>(new File(path));
	private WeakHashMap<Integer, byte[]> lastDataMap = new WeakHashMap<>();

	byte[] readFile(File file) {
	    byte[] data;

	    if (file.equals(lastFile.get())) {
	        data = lastDataMap.get(1);
	        if (data != null)
	            return data;
	    }

	    data = readBytesFromFile(file);
	    lastFile = new WeakReference<File>(file);
	    lastDataMap.put(1, data);
	    return data;
	}

	byte[] readBytesFromFile(File file) {
	    return null;
	}

	public static void main(String[] args){
		DataHandler dh = new DataHandler();
		System.out.println(path);
		System.out.println(dh.readFile(new File(path)));
		System.out.println(dh.readFile(new File(path)));

	}

}
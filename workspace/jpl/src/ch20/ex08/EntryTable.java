package ch20.ex08;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

/**
 *  %%で始まる行で分割されているエントリーを持つファイルを読み込み、
 *  各エントリーの開始位置を持つテーブルファイルを作成するプログラムを書きなさい。
 *  そして、そのテーブルを使用してランダムにエントリーを表示するプログラムを作成しなさい
 *  (579頁の「MathとstrictMath」で説明されているMath.randomメソッドを参照)
 */
class EntryTable {

	   public static void main(String[] args) {
		   String path = System.getProperty("user.dir") + "\\src\\ch20\\ex08\\hoge.txt";
		   EntryTable et = new EntryTable();
		   et.entryTable(path);
	   }

	   public void entryTable( final String filePath ) {
		   List<Long> table = new ArrayList<Long>();
			RandomAccessFile file;
			try {
				file = new RandomAccessFile(new File(filePath), "r");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				return;
			}
			try {
				// エントリー読込み
				String line;
				boolean first = true;
				while ((line = file.readLine()) != null) {
				    if (line.startsWith("%%")) {
				    	first = true;
				        continue;
				    }
				    if (first) {
				    	table.add(file.getFilePointer() - line.length() - 1);
				    }
				    first = false;
				}

				// テーブル出力
				for (Long l : table) {
				    System.out.println("Entry: " + l);
				}

				// テーブルを使用してランダムにエントリーを表示
				int target = (int) (Math.random() * 1000) % table.size();
				file.seek(table.get(target));
				while ((line = file.readLine()) != null) {
				    if (line.startsWith("%%"))
				                break;
				            System.out.println(line);
			        }
		    } catch (IOException e) {
		        e.printStackTrace();
		    } finally {
		        try {
		            file.close();
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		    }
		}

}
package ch21.ex01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ファイル開いて1行ずつ読み込み、各行をString.compareToを使用してソートされたListに保存するプログラムを書きなさい。
 * 練習問題20.4で作成した行を読み込むクラスが役立ちます。
 */
class FileToSort{

	   public static void main(String[] args) {
		   String path = System.getProperty("user.dir") + "\\src\\ch21\\ex01\\input.txt";
		   FileToSort f = new FileToSort();
		   System.out.println("=====original==================");
		   f.out(path);

		   System.out.println("\n=====original to sort===========");
		   f.sort(path);
	   }

		static void sort(String filePath){
	        List<String> list = new ArrayList<>();
//	        LineFilterReader reader = null;
//	        try {
//	            reader = new LineFilterReader(new FileReader(new File(filePath)));
//	            list = reader.readLine();
//	        } catch (FileNotFoundException e) {
//	            e.printStackTrace();
//	        } catch (IOException e) {
//	            e.printStackTrace();
//	        } finally {
//	            try {
//	                if (reader != null)
//	                    reader.close();
//	            } catch (IOException e) {
//	                e.printStackTrace();
//	            }
//	        }
//	        Collections.sort(list);
//	        System.out.println("List size: " + list.size());
//	        for (String s : list)
//	            System.out.println(s);

	        LineFilterReader reader = null;
	        try {
	            reader = new LineFilterReader(new FileReader(new File(filePath)));
	            list = reader.readLine();
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                if (reader != null)
	                    reader.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	        Collections.sort(list);
	        for (String s : list)
	            System.out.println(s);
		}

		static void out(String filePath){
	        List<String> list = new ArrayList<>();
	        LineFilterReader reader = null;
	        try {
	            reader = new LineFilterReader(new FileReader(new File(filePath)));
	            list = reader.readLine();
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                if (reader != null)
	                    reader.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	        for (String s : list)
	            System.out.println(s);
		}

}
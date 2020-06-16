package ch20.ex05;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * 指定されたファイルを読み込んで、指定された単語を検索するプログラムを作成しなさい。
 * 単語が発見された全ての行を、行の前に行番号を付けて表示しなさい。
 */
class SearchLine {

	public String searchLine(File file, String word){
		StringBuilder s = new StringBuilder();
		try{
			BufferedReader  br = new BufferedReader(new FileReader(file));
			for(int i = 0; ; i++){
				String line = br.readLine();
				if(line == null)break;
				if((line.indexOf(word)) != -1){
					s.append(i + ":" + line + "\n");
				}
			}
			return s.toString();
		}catch(IOException e){
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args){
		SearchLine sl = new SearchLine();
		String path = System.getProperty("user.dir");
		System.out.println(sl.searchLine(new File(path+"\\src\\ch20\\ex05\\hoge.txt"), "xyz"));
	}
}
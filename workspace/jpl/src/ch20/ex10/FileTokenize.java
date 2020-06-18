package ch20.ex10;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 *  入カファイルを単語に分解して、そのファイル内で各単語の出現数を数えて表示するために
 *  StreamTokenizerオブジェクトを使用するプログラムを作成しなさい。
 *  単語とその出現数を管理するためにHashMapを使用しなさい。
 */
class FileTokenize {

	   public static void main(String[] args) {
		   String path = System.getProperty("user.dir") + "\\src\\ch20\\ex10\\hoge.txt";
		   FileTokenize fi = new FileTokenize();
		   fi.showFileinfo(path);
	   }

		static void showFileinfo(String filePath){
			StreamTokenizer tokenizer;
			try {
				tokenizer = new StreamTokenizer(new FileReader(new File(filePath)));

			   Map<String, Integer> map = new HashMap<>();
			   int token;
			   while ((token = tokenizer.nextToken()) != StreamTokenizer.TT_EOF) {
			        if (token == StreamTokenizer.TT_WORD) {
			            String value = tokenizer.sval;
			            Integer c = map.get(value);
			            if (c == null)
			                map.put(value, 1);
			            else {
			                map.put(value, ++c);
			            }
			        }
			    }
			    for (Entry<String, Integer> e : map.entrySet())
			        System.out.println(e.getKey() + ": " + e.getValue());

			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

}
package ch13.ex01;

/**
 *  練習問題13.1
 */
public class StringCounter {

	public int count(String source, char target){
		 if (source == null)
			 throw new NullPointerException();
		 int count = 0;
		 for (int i = 0; i < source.length(); i++) {
			 if (source.charAt(i) == target)
				 count++;
		 }
		 return count;
	}
}

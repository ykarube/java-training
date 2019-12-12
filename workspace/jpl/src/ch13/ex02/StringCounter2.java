package ch13.ex02;

/**
 *  練習問題13.2
 */
public class StringCounter2 {

	public int count(String source, String target){

        if (source == null || target == null)
            throw new NullPointerException("param is null");
        if (source.isEmpty() || target.isEmpty())
            throw new IllegalArgumentException("param is empty");

        if (source.length() < target.length())
            return 0; //ng

        if (source.equals(target))
            return 1; //ok

        int count = 0;
        for (int i = 0; i < source.length() - target.length() + 1; i++) {
        	if (source.substring(i, i + target.length()).equals(target)) {
        		count++;
        	}
        }
        return count;
	}
}

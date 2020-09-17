package ch21.ex04;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * ex21-4  p537
 * Listlteratorオブジェクトをフィルターするために
 * Listlteratorを実装したShortStringsの別のバージョンを作成しなさい。
 * そのクラスは、ShortStringsを拡張すべきか。
 */

public class ShortStrings implements Iterator<String> {

    private Iterator<String> strings;
    private String nextShort;
    private final int maxLen;

    public ShortStrings(Iterator<String> strings, int maxLen) {
        this.strings = strings;
        this.maxLen = maxLen;
        nextShort = null;
    }

    @Override
    public boolean hasNext() {
        if (nextShort != null)
            return true;
        while (strings.hasNext()) {
            nextShort = strings.next();
            if (nextShort.length() <= maxLen)
                return true;
        }
        nextShort = null;
        return false;
    }

    @Override
    public String next() {
        if (nextShort == null && !hasNext())
            throw new NoSuchElementException();
        String n = nextShort;
        nextShort = null;
        return n;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }


	public static void main(String[] args){
		List<String> list = new ArrayList<String>();
		list.add("1234567890");
		list.add("12345678901234");
		list.add("1234567890123456789");
		list.add("123456");
		ShortStrings ss = new ShortStrings(list.iterator(), 10);
		while(ss.hasNext()){
			System.out.println(ss.next());
		}

	}
}
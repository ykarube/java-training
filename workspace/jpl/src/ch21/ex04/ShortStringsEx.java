package ch21.ex04;

import java.util.ArrayList;
import java.util.List;

/**
 * ex21-4  p537
 * Listlteratorオブジェクトをフィルターするために
 * Listlteratorを実装したShortStringsの別のバージョンを作成しなさい。
 * そのクラスは、ShortStringsを拡張すべきか。
 */

import java.util.ListIterator;
import java.util.NoSuchElementException;

public class ShortStringsEx implements ListIterator<String> {

    private ListIterator<String> strings;
    private String nextShort;
    private String prevShort;
    private final int maxLen;
    private int index;

    public ShortStringsEx(ListIterator<String> strings, int maxLen) {
        this.strings = strings;
        this.maxLen = maxLen;
        nextShort = null;
        prevShort = null;
        index = 0;
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
        index++;
        return n;
    }

    @Override
    public boolean hasPrevious() {
        if (prevShort != null)
            return true;
        while (strings.hasPrevious()) {
            prevShort = strings.previous();
            if (prevShort.length() <= maxLen)
                return true;
        }
        prevShort = null;
        return false;
    }

    @Override
    public String previous() {
        if (prevShort == null && !hasPrevious())
            throw new NoSuchElementException();
        String n = prevShort;
        prevShort = null;
        index--;
        return n;
    }

    @Override
    public int nextIndex() {
        return index + 1;
    }

    @Override
    public int previousIndex() {
        return index - 1;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void set(String e) {
        strings.set(e);
    }

    @Override
    public void add(String e) {
        strings.add(e);
    }

	public static void main(String[] args){
		List<String> list = new ArrayList<String>();
		list.add("123455");
		list.add("123455566");
		list.add("123451234512345");
		list.add("12345");
		ShortStringsEx ss = new ShortStringsEx(list.listIterator(), 10);
		while(ss.hasNext()){
			System.out.println(ss.next());
		}
		while(ss.hasPrevious()){
			System.out.println(ss.previous());
		}
	}
}
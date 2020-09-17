package ch22.ex13;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Observable;
/**
 * ex22-12
 * 467頁の属性を読むメソッドをscannerを使用して書き直しなさい。
 * この練習問題に関しては、どちらのバージョンも正しくフォーマットされた入力を受け付けるだけでよいです。
 */

public class AttributedImpl extends Observable implements Attributed<String> {

    protected Map<String, Attr<String>> attrTable = new HashMap<String, Attr<String>>();

    @Override
    public void add(Attr<String> newAttr) {
        attrTable.put(newAttr.getName(), newAttr);
        setChanged();
        notifyObservers();
    }

    @Override
    public Attr<String> find(String attrName) {
        return attrTable.get(attrName);
    }

    @Override
    public Attr<String> remove(String attrName) {
        Attr<String> ret = attrTable.remove(attrName);
        setChanged();
        notifyObservers();
        return ret;
    }

    @Override
    public Iterator<Attr<String>> attrs() {
        return attrTable.values().iterator();
    }
}

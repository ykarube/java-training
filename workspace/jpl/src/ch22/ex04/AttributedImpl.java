package ch22.ex04;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Observable;
/**
 * ex22-3  p560
 * オブザーバーヘ変化を通知するのにObserver/Observableを使用する
 * Attributedインタフェースの実装を提供しなさい
 */

public class AttributedImpl extends Observable implements Attributed<Integer> {

    protected Map<String, Attr<Integer>> attrTable = new HashMap<String, Attr<Integer>>();

    @Override
    public void add(Attr<Integer> newAttr) {
        attrTable.put(newAttr.getName(), newAttr);
        setChanged();
        notifyObservers();
    }

    @Override
    public Attr<Integer> find(String attrName) {
        return attrTable.get(attrName);
    }

    @Override
    public Attr<Integer> remove(String attrName) {
        Attr<Integer> ret = attrTable.remove(attrName);
        setChanged();
        notifyObservers();
        return ret;
    }

    @Override
    public Iterator<Attr<Integer>> attrs() {
        return attrs();
    }
}

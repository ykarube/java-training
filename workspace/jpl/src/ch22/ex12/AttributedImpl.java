package ch22.ex12;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Observable;
/**
 * ex22-13
 * StreamTokenizerのバージョンと同様に、
 * 誤って置かれた=文字を検出するように練習問題22.12の回答を拡張しなさい。
 * (ヒント:ある種のトークン間でデリミタパターンを動的に変更してみると良いかもしれません
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

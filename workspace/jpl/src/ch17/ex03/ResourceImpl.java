package ch17.ex03;

import java.lang.ref.WeakReference;

/**
 * ハッシュコードを使用する代わりに、
 * キーを管理することで参照オブジェクトを使用するように、リソース実装クラスを書き直しなさい。
 */

public class ResourceImpl implements Resource {
    private WeakReference<Object> keyRef;
    boolean needsRelease = false;

    ResourceImpl(Object key) {
        keyRef = new WeakReference<Object>(key);
        // Set resource
        needsRelease = true;
    }

    @Override
    public void use(Object key, Object... args) {
        if (!keyRef.get().equals(key))
            throw new IllegalArgumentException("wrong key");
    }

    @Override
    public synchronized void release() {
        if (needsRelease) {
            needsRelease = false;
        }
    }


	public static void main(String[] args){
		Resource r = new ResourceImpl("r");
		r.use("r", null);
		r.release();

	}
}
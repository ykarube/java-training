package ch17.ex04;

/**
 * 刈り取リスレッドを修正して、すべての割り当てられたリソースが解放されるまで、
 * シャットダウンの後も生き続けるようにしなさい。
 */

public class ResourceImpl implements Resource {
    int keyHash;
    boolean needsRelease = false;

    ResourceImpl(Object key) {
        keyHash = System.identityHashCode(key);
        needsRelease = true;
    }

    @Override
    public void use(Object key, Object... args) {
        if (System.identityHashCode(key) != keyHash)
            throw new IllegalArgumentException("wrong key");

    }

    @Override
    public synchronized void release() {
        if (needsRelease) {
            needsRelease = false;
        }
    }
}
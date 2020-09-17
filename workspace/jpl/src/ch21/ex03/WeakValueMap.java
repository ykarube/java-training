package ch21.ex03;

import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * ex21-3　p522
 * WeakHashMapは弱いキーと強い値を持っています。
 * WeakValueMapなら、強いキーと弱い値を持つことになるでしょう。
 * WeakvalueMapを設計しなさい。
 * 見かけほど簡単ではないことに注意してください。
 * 実際、非常に複雑であり、数多くの設計上の選択をしなければなりません。
 * たとえば、値のイテレーションはhasNextがtrueを返した後にnullを返すことが許されるべきか、
 * あるいは、値をイテレートしている間は、値は生きているべきかとか。
 *
 * ヒント:AbstractMapを拡張しようとしないこと。代わりに、HashMapに委譲してください。
 *
 */

public class WeakValueMap<K, V> implements Map<K, V> {

	private Map<K, WeakReference<V>> map_ = new HashMap<>();

	@Override
	public int size() {
		return this.map_.size();
	}

	@Override
	public boolean isEmpty() {
		return this.map_.isEmpty();
	}

	@Override
	public boolean containsKey(Object key) {
		return this.map_.containsKey(key);
	}

	@Override
	public boolean containsValue(Object value) {
		return this.map_.containsKey(value);
	}

	@Override
	public V get(Object key) {
		return this.map_.get(key).get();
	}

	@Override
	public V put(K key, V value) {
		WeakReference<V> valueRef = new WeakReference<>(value);
        return this.map_.put(key, valueRef).get();
	}

	@Override
	public V remove(Object key) {
		return this.map_.remove(key).get();
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		//TODO
	}

	@Override
	public void clear() {
	}

	@Override
	public Set<K> keySet() {
		return this.map_.keySet();
	}

	@Override
	public Collection<V> values() {
		return null;
	}

	@Override
	public Set<Entry<K, V>> entrySet() {
		return null;
	}

}

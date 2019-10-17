package ch04.ex04;

public interface Attr<T> {

	public String getName();
	public T getValue();
	public void setValue( T value);
	public String toString();

}

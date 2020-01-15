package ch14.ex02;

import java.util.LinkedList;
import java.util.Queue;

public class SingleLinkQueue<E> {

	private Queue<E> queue_ = new LinkedList<>();
	
	public void add(E element) {
		this.queue_.add(element);
	}
	
	public E remove() { 
		return this.queue_.remove();
	}
	
	public int size() {
		return this.queue_.size();
	}
}

package software;

import java.util.LinkedList;

// Custom Class!!
public class MyQueue<T> {
	private LinkedList<T> list;
	private int count; // This counts how many times deQueue was used
	public MyQueue() {
		list = new LinkedList();
		count = 0;
	}
	public void enQueue(T item) {
		list.addLast(item);
	}
	public T deQueue() {
		if (isEmpty())
			throw new RuntimeException("No levels.");
		count++;
		return list.removeFirst();
	}
	// Accessor Methods
	public boolean isEmpty() {
		return list.isEmpty();
	}
	public int getNum() {
		return count;
	}
}
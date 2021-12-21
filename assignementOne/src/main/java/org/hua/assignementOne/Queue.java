package org.hua.circularqueue;

/**
 * A FIFO queue interface.
 * @param <E>
 */

public interface Queue<E>{

	void enqueue(E element);

	E dequeue();

	E front(); 

	boolean isEmpty();

	int size();

	void clear();
}

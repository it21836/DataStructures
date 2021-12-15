package org.hua.assignementOne;

//A FIFO Queue interface.

public interface Queue<E>{

	void enqueue(E element);

	E dequeue();

	E front(); 

	boolean isEmpty();

	int size();

	void clear();
}

package org.hua.assignementOne;

import java.util.NoSuchElementException;

//A FIFO Queue implemented with circular array.

public class CircularQueue<E> implements Queue<E>{
	
	//private instances 
	
	public static final int DEFAULT_CAPACITY=64;
	
	private int front; // shows the first element
	private int rear; //shows the first empty space
	private int currentsize; // shows how many elements are currently in the queue
	private E[] circularArray;
	private int arrayLenght;
	
	//constructors
	
	public CircularQueue() {
		this(DEFAULT_CAPACITY);
	}
	
	@SuppressWarnings("unchecked")
	public CircularQueue(int capacity) {
		if(capacity <= 0 ) {
			throw new IllegalArgumentException("Wrong capacity.");
		}
		this.front=0;
		this.rear=0;
		this.currentsize=0;
		this.circularArray = (E[]) new Object[capacity];
		this.arrayLenght=circularArray.length;
		
	}
	
	//Implemented methods from interface
	
	@Override
	public void enqueue(E elem) {
		//When queue is full
		if(size()==circularArray.length) {
			doubleCapacity();
		}
		//When there is space
		circularArray[rear%circularArray.length]=elem;
		rear++;
		currentsize++;
	}

	@Override
	public E dequeue() {
		//If is empty
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		
		//If there is space
		E result = circularArray[front%circularArray.length];
		circularArray[front%circularArray.length]=null;
		front++;
		currentsize--;
		
		//if there is more than 3/4 of the cells free decrease the capacity
		if(currentsize <= circularArray.length/4) {
			halfCapacity();
		}
		
		return result;
	}

	@Override
	public E front() {
		//if there is no element in the queue
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		
		return circularArray[front%circularArray.length];
	}

	@Override
	public boolean isEmpty() {
		return front == rear;
	}

	@Override
	public int size() {
		//its empty
		if(front == rear) {
			return 0;
		}
		//its full
		else if((rear-front )==circularArray.length){
			return circularArray.length;
		}
		//it has some elements
		else if(front > rear) {
			return rear-front+circularArray.length;
		}
		else if(front < rear) {
			return rear-front;
		} 
		//something has gone really wrong?
		return -1;
	}

	@Override
	public void clear() {
		//if there is no queue to clear
		if(isEmpty()) {
				throw new NoSuchElementException();
		}
		
		for(int i=0 ; i<circularArray.length;i++) {
			circularArray[i]=null;	
		}
		this.front=0;
		this.rear=0;
		this.currentsize=0;
	
	}
	
	private void doubleCapacity() {
		int newCapacity = circularArray.length * 2;
		@SuppressWarnings("unchecked")
		E[] newArray = (E[]) new Object[newCapacity];
		for(int i = 0;i<circularArray.length;i++){
			newArray[i]=circularArray[front++%circularArray.length];
		}
		circularArray=newArray;
		front=0;
		rear=currentsize ;
		arrayLenght=circularArray.length;
		
		
	}
	
	private void halfCapacity() {
		int newCapacity = circularArray.length /2;
		@SuppressWarnings("unchecked")
		E[] newArray = (E[]) new Object[newCapacity];
		for(int i = 0;i<currentsize;i++){
			newArray[i]=circularArray[front++%circularArray.length];
		}
		circularArray=newArray;
		front=0;
		rear=currentsize;
		arrayLenght=circularArray.length;
	} 
	
	//getters & setters 

	public int getFront() {
		return front;
	}

	public void setFront(int front) {
		this.front = front;
	}

	public int getRear() {
		return rear;
	}

	public void setRear(int rear) {
		this.rear = rear;
	}

	public int getCurrentsize() {
		return currentsize;
	}

	public void setCurrentsize(int currentsize) {
		this.currentsize = currentsize;
	}

	public E[] getCircularArray() {
		return circularArray;
	}

	public void setCircularArray(E[] circularArray) {
		this.circularArray = circularArray;
	}
	
	public int getArrayLenght() {
		return this.arrayLenght;
	}
	
	public void setArrayLengt(E[] circularArray) {
		this.arrayLenght=circularArray.length;
	}
	
	
	void print(){
	    if (!isEmpty()) {
	        int i = front;
	        do {
	            System.out.print(" " + circularArray[i]);
	            i = ++i % circularArray.length;
	        }
	        while (i != rear);
	    }
	}
	
}

package org.hua.circularqueue;

import java.util.NoSuchElementException;

/**
 * This code is part of the 1st assignment for the Data Structures course at 
 * Harokopio University of Athens, Dept. of Informatics and Telematics.
 * @authors 21860 | 21836
 * 
 * A FIFO queue implemented with a Circular Array.
 * @param <E> the element type
 */

public class CircularQueue<E> implements Queue<E>{
	
	//private instances 
	private E[] CircularQueueArray;
	public static final int DEFAULT_CAPACITY=64;
	
	private int front; // shows the first element
	private int rear; //shows the first empty space
	private int currentSize; // shows how many elements are currently in the queue
	private int arrayLength;
	
	//constructors
	
	public CircularQueue() {
		this(DEFAULT_CAPACITY);
	}
	
	public CircularQueue(int capacity) {
		if(capacity <= 0 ) {
			throw new IllegalArgumentException("Wrong capacity!");
		}
		this.CircularQueueArray = (E[])new Object[capacity];
		this.front=0;
		this.rear=0;
		this.currentSize=0;
		this.arrayLength=CircularQueueArray.length; 
		
	}
	
	//Implemented methods from interface
	
	@Override
	/**
         * Adds element always at rear position
     	 */
	public void enqueue(E element) {
		//When queue is full
		if(size()==CircularQueueArray.length) {
			doubleCapacity();
		}
		//When there is space
		CircularQueueArray[rear%CircularQueueArray.length]=element;
		rear++;
		currentSize++;
	}

	@Override
	 /**
     	  * Removes element always from front position
   	  */
	public E dequeue() {
		//If is empty
		if(isEmpty()) {
			throw new NoSuchElementException("The queue is empty");
		}
		
		//If there is space
		E result = CircularQueueArray[front%CircularQueueArray.length];
		CircularQueueArray[front%CircularQueueArray.length]=null;
		front++;
		currentSize--;
		
		//if there is more than 3/4 of the cells free decrease the capacity
		if(currentSize <= CircularQueueArray.length/4) {
			halfCapacity();
		}
		
		return result;
	}

	@Override
	public E front() {
		//if there is no element in the queue
		if(isEmpty()) {
			throw new NoSuchElementException("The queue is empty");
		}
		return CircularQueueArray[front%CircularQueueArray.length];
	}

	@Override
	public boolean isEmpty() {
		return front == rear;
	}

	@Override
	public int size() {
		// empty
		if(front == rear) {
			return 0;
		}
		// full
		else if((rear-front)==CircularQueueArray.length){
			return CircularQueueArray.length;
		}
		//it has some elements
		else if(front > rear) {
			return rear-front+CircularQueueArray.length;
		}
		else if(front < rear) {
			return rear-front;
		} 
		
		return -1;
	}

	@Override
	public void clear() {
		//if there is no queue to clear
		if(isEmpty()) {
			throw new NoSuchElementException("The queue is empty!");
		}
		
		for(int i=0 ; i<CircularQueueArray.length;i++) {
			CircularQueueArray[i]=null;	
		}
		 this.front=this.rear=this.currentSize=this.arrayLength=0;
	
	}
	
	private void doubleCapacity() {
		int newCapacity = 2 * CircularQueueArray.length;
		E[] newArray = (E[]) new Object[newCapacity];
		
		for(int i = 0;i<CircularQueueArray.length;i++){
			newArray[i]=CircularQueueArray[front++%CircularQueueArray.length];
		}
		CircularQueueArray=newArray;
		front=0;
		rear=currentSize ;
		arrayLength=CircularQueueArray.length;
		
		
	}
	
	private void halfCapacity() {
		int newCapacity = CircularQueueArray.length/2;
		E[] newArray = (E[]) new Object[newCapacity];
		
		for(int i = 0;i<currentSize;i++){
			newArray[i]=CircularQueueArray[front++%CircularQueueArray.length];
		}
		currentSize=newArray.length;
		CircularQueueArray=newArray;
		front=0;
		rear=currentSize;
		arrayLenght=CircularQueueArray.length;
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

	public int getCurrentSize() {
		return currentSize;
	}

	public void setCurrentSize(int currentSize) {
		this.currentSize = currentSize;
	}

	public E[] getCircularQueueArray() {
		return CircularQueueArray;
	}

	public void setCircularQueueArray(E[] CircularQueueArray) {
		this.CircularQueueArray = CircularQueueArray;
	}
	
	public int getArrayLength() {
		return this.arrayLength;
	}
	
	public void setArrayLength(E[] CircularQueueArray) {
		this.arrayLength=CircularQueueArray.length;
	}
	
	
	void print(){
	    if (!isEmpty()) {
	        int i = front;
	        do {
	            System.out.print(" " + CircularQueueArray[i]);
	            i = ++i % CircularQueueArray.length;
	        }
	        while (i != rear);
	    }
	}
	
}

package org.hua.assignementOne;

public class App 
{
    public static void main( String[] args )
    {
    	
    	//Make a new circular queue
    	CircularQueue<Integer> q = new CircularQueue<Integer>(10);
    	
    	//print her current capacity and the number of elements
    	System.out.println("Capacity after initialization:" + q.getArrayLenght());
    	System.out.println("Number of elements in queue:" + q.size());
    	
    	
    	//fill with capacity plus one elements
    	int n =q.getArrayLenght() + 1;
    	for (int i=0;i<n;i++) {
    		q.enqueue(i);
    	}
    	
    	//print the queue
    	q.print();
    	System.out.println();
    	
    	//print her current capacity and the number of elements
    	System.out.println("Capacity of the new array after enqueuing more elements that it originally could:" + q.getArrayLenght());
    	System.out.println("Number of elements in queue:" + q.size());
    	
    	
    	//leave inside queue the 1/4 of the elements
    	int s= (3*q.getArrayLenght())/4;
    	for (int i=0;i<s;i++) {
    		try {   		
    	    	q.dequeue();
    	    	}catch(Exception E) {
    	    		//System.out.println("There is no elements to dequeue!");
    	    	}
    	}
    	
    	//print the queue
    	q.print();
    	System.out.println();
    	
    	System.out.println("Number of elements in queue:" + q.size());
    	System.out.println("Capacity of the new array after leaving only some elements:" + q.getArrayLenght());
    	
    	//push another element
    	q.enqueue(9);
    	System.out.println("Number of elements in queue:" + q.size());
    	
    	/*
    	//Code to show that clear works
    	try {
        	q.clear();
        	}catch(Exception E) {
        		System.out.println("There is no elements in queue to clear!");
        	}
      */
    }
    	

}

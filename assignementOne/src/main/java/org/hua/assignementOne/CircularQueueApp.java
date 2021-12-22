package org.hua.circularqueue;
/**
 * Demo App for the Circular Queue
 * 
 */
public class CircularQueueApp 
{
    public static void main( String[] args )
    {
    	
    	//Make a new circular queue
    	CircularQueue<Integer> q = new CircularQueue<Integer>(10);
    	
    	//print queue's current capacity and the number of elements
    	System.out.println("Capacity after initialization: " + q.getArrayLenght());
    	System.out.println("Number of elements in queue: " + q.size());
    	
    	
    	//fill with capacity plus one elements
    	int n =q.getArrayLenght() + 1;
    	for (int i=0;i<n;i++) {
    		q.enqueue(i);
    	}
    	
    	//print the queue
        System.out.println("This is the queue after adding elements: ");
    	q.print();
    	System.out.println();
    	
    	//print queue's current capacity and the number of elements
    	System.out.println("Capacity of the new array after adding more elements than it could fit: " + q.getArrayLenght());
    	System.out.println("Number of elements in queue: " + q.size());
    	
    	
    	//leave in the 1/4 of the elements
    	int s= =(3*q.size())/4;
    	for (int i=0;i<s;i++) {
    		try {   		
    	    	q.dequeue();
    	    	}catch(Exception E) {}
    	}
    	
    	//print the queue
        System.out.println("This is the queue after deleting some elements: ");
    	q.print();
    	System.out.println();
    
    	System.out.println("Capacity of the new array after leavingin fewer elements: " + q.getArrayLenght());
    	System.out.println("Number of elements in queue: " + q.size());
        
    	//push another element
    	q.enqueue(11);
    	System.out.println("This is the queue after we added a new element: ");
        q.print();
    	System.out.println();
        System.out.println("Number of elements in queue: " + q.size());
    	
    	try {
        	q.clear();
        	}catch(Exception E) {
        		System.out.println("There is no elements in queue to clear!");
        }
        System.out.println("This is the queue after we have cleared it: " );
        q.print();
        System.out.println();
        System.out.println("Number of elements in queue: " + q.size());
    }
    	

}

package org.hua.circularqueue;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/**
 * Unit tests.
 */
public class CircularTest 
{
	@Test
	public void testCircularQueue() {
		CircularQueue<Integer> q = new CircularQueue<>();
		
		assertTrue(q.isEmpty());

		int count = 100000;

		for (int i = 0; i < count; i++) {
			q.enqueue(i);
			assertTrue(q.size() == i + 1);
			assertTrue(q.front() == 0);
		}

		int current = 0;
		while (!q.isEmpty()) {
			assertTrue(q.front() == current);
			assertTrue(q.dequeue() == current);
			current++;
		}
		assertTrue(q.isEmpty());
	}
	
	@Test
	public void testDoubleCapacityQueue() {
		CircularQueue<Integer> q = new CircularQueue<Integer>();
		
		//check if is empty
		assertTrue(q.isEmpty());
		
		for (int i = 0; i < q.getArrayLength(); i++) {
			q.enqueue(i);
		}
		
		int firstLength=q.getArrayLength();
		int firstSize=q.size();
		//ckeck if is full
		assertTrue(q.size()==q.getArrayLength());
		
		//push another element
		q.enqueue(10);
		
		//check if the array has doubled
		assertTrue(q.getArrayLength()== 2*firstLength);
		
		//check if the size of elements has augmented 
		assertTrue(q.size()==firstSize+1);
		
		
	}
	
	@Test
	public void testHalfCapacityQueue() {
		CircularQueue<Integer> q = new CircularQueue<Integer>();
		
		//check if is empty
		assertTrue(q.isEmpty());
		
		//fill the queue
		for (int i = 0; i < q.getArrayLength(); i++) {
			q.enqueue(i);
		}
		
		int firstSize=q.size();
		
		//check if is full
		assertTrue(q.size()==q.getArrayLength());
		
		//leave less that 1/4 of elements inside queue
		int s= (3*q.getArrayLength())/4;
		for(int i=0;i<=s;i++) {
			q.dequeue();
		}
		
		//check if the capacity has become half of what it was
		assertTrue(q.getArrayLength()==(firstSize/2));
			
	}
	
}

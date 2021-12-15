package org.hua.assignementOne;

import static org.junit.Assert.assertTrue;

import org.hua.assignementOne.CircularQueue;
import org.hua.assignementOne.Queue;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
	@Test
	public void testCircularQueue() {
		Queue<Integer> q = new CircularQueue<>();
		
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
		
		for (int i = 0; i < q.getArrayLenght(); i++) {
			q.enqueue(i);
		}
		
		int firstlenght=q.getArrayLenght();
		int firstsize=q.size();
		//ckeck if is full
		assertTrue(q.size()==q.getArrayLenght());
		
		//push another element
		q.enqueue(10);
		
		//check if the array has doubled
		assertTrue(q.getArrayLenght()== 2*firstlenght);
		
		//check if the size of elements has augmented 
		assertTrue(q.size()==firstsize+1);
		
		
	}
	
	@Test
	public void testHalfCapacityQueue() {
		CircularQueue<Integer> q = new CircularQueue<Integer>();
		
		//check if is empty
		assertTrue(q.isEmpty());
		
		//fill the queue
		for (int i = 0; i < q.getArrayLenght(); i++) {
			q.enqueue(i);
		}
		
		int firstsize=q.size();
		
		//ckeck if is full
		assertTrue(q.size()==q.getArrayLenght());
		
		//leave less that 1/4 of elements inside queue
		int s= (3*q.getArrayLenght())/4;
		for(int i=0;i<=s;i++) {
			q.dequeue();
		}
		
		//check if the capacity has become half of what it was
		assertTrue(q.getArrayLenght()==(firstsize/2));
		
		
	}
	
}

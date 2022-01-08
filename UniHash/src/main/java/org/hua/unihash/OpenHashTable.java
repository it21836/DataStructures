package org.hua.unihash;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This code is part of the 1st assignment for the Data Structures course at 
 * Harokopio University of Athens, Dept. of Informatics and Telematics.
 * @authors 21860 | 21836
 * 
 * A hashtable implemented with Open Addressing and Linear Probing 
 * using Matrix Method for Universal Hashing.
 */

public class OpenHashTable<K, V> implements Dictionary<K, V> {

    public static final int DEFAULT_INITIAL_SIZE = 17;
    
    private Entry<K,V>[] CircularArray;
    private int size;
    private int front;
    private int rear;
    
    //default constructor
    public OpenHashTable() {
        this(DEFAULT_INITIAL_SIZE);
    }
    
    //constructor
    public OpenHashTable(int m) {
    if(m <= 0){
            throw new IllegalArgumentException("Array size must be positive!");
        }
        this.CircularArray = (Entry<K, V>[]) new Object[m];
        this.size = 0;
        this.front = 0;
        this.rear = 0;
        
    }
    
    @Override
    public void put(K key, V value) {
       rehashIfNeeded();
       insert(key, value);
    }

    @Override
    public V remove(K key) {
        return null;
        //TODO
    }

    @Override
    public V get(K key) {
       for(var entrySet: CircularArray){
            if(key.equals(entrySet.getKey())){
                return entrySet.getValue();
            }    
        }
        return null; 
    }

    @Override
    public boolean contains(K key) {
       for(var entrySet: CircularArray){ 
            if(key.equals(entrySet.getKey())){
                return true;
            }    
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return front == rear;
    }

    @Override
    public int size() {
        if(front == rear) {
            return 0;
	}
	else if((rear-front)==CircularArray.length){
            return CircularArray.length;
	}
	else if(front > rear) {
            return rear-front+CircularArray.length;
	}
	else if(front < rear) {
            return rear-front;
	}
	return -1;
    }

    @Override
    public void clear() {
        if(isEmpty()){
            throw new NoSuchElementException("The queue is empty!");
        }
        for (int i=0; i<CircularArray.length; i++){
            CircularArray[i]=null;
        }
        this.front=this.rear=this.size=0;
    }

    
    @Override
    public Iterator<Entry<K, V>> iterator() {
        return new HashIterator();
    }
    
    private class HashIterator implements Iterator<Entry<K,V>> {

        @Override
        public boolean hasNext() {
            //TODO
            return false;
            
        }

        @Override
        public Entry<K, V> next() {
            //TODO
            return null;
        }
        
    }
    
    private void insert(K key, V value){
        //TODO 
        
        int i = hash(key);
        //while it has next
    }
    
    private int hash(K key){
        return Math.abs(key.hashCode()) % CircularArray.length;
    }
    
    public void rehashIfNeeded() {
        //TODO
    }
    
    /*
    Ένα entry key-value βρίσκεται μέσα σε κάθε θέση του πίνακα.
    */
    private static class EntryImplementation<K,V> implements Dictionary.Entry<K,V> {

        private K key;
        private V value;

        //constructor
        public EntryImplementation(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }
    }
    
    public boolean isFull()
    {
        return size == CircularArray.length;
    }
}

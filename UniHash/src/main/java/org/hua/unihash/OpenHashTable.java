package org.hua.unihash;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This code is part of the 1st assignment for the Data Structures course at 
 * Harokopio University of Athens, Dept.of Informatics and Telematics.
 * @author 21860 | 21836
 * 
 * A hashtable implemented with Open Addressing and Linear Probing 
 * using Matrix Method for Universal Hashing.
 * @param <K>
 * @param <V>
 */

public class OpenHashTable<K, V> implements Dictionary<K, V> {

    public static final int DEFAULT_INITIAL_CAPACITY = 17;
    private Entry<K,V>[] Array;
    
    private int capacity;
    private int size;
    
    //default constructor
    public OpenHashTable() {
        this(DEFAULT_INITIAL_CAPACITY);
    }
    
    //constructor
    public OpenHashTable(int m) {
        if(m <= 0){
            throw new IllegalArgumentException("Array size must be positive!");
        }
        this.Array = (Entry<K, V>[]) new Object[m];
        this.capacity = m;
        this.size = 0; 
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
        for(Entry<K,V> e: Array){
            if(key.equals(e.getKey())){
                return e.getValue();
            }    
        }
        return null;    
    }

    @Override
    public boolean contains(K key) {
        return get(key) != null;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        if(isEmpty()){
            throw new NoSuchElementException("The queue is empty!");
        }
        for (int i=0; i<Array.length; i++){
            Array[i]=null;
        }
        this.size=0;
    }

    
    @Override
    public Iterator<Entry<K, V>> iterator() {
        return new HashIterator();
    }
    
    private class HashIterator implements Iterator<Entry<K,V>> {

        private int i;
        private Iterator<Entry<K,V>> it;
        
        //constructor
        public HashIterator(){
            i=0;
            it=Αrray[0].iterator();
        }
        
        @Override
        public boolean hasNext() {
            if(it.hasNext()){
                return true;
            }
            //προχώρα προς τα δεξιά και προς τα κάτω για να δεις αν υπάρχουν άλλα στοιχεία
            while(i < array.length-1){
                i++;
                it = array[i].iterator();
                if(it.hasNext()){
                    return true;
                }
            }
            return false;
        }

        @Override
        public Entry<K, V> next() {
           if(!hasNext()){
                throw new NoSuchElementException("There is no next element!");
            }
            return it.next();
        }
        
    }
    
    private void insert(K key, V value){
        //TODO
    }
    
    private Entry<K,V> hash(K key){
        return Array[Math.abs(key.hashCode()) % Array.length];
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
    
    public boolean isFull() {
        return size == Array.length;
    }
}

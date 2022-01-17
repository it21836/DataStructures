/**
 * This code is part of the exercises for the Data Structures course at Harokopio
 * University of Athens, Dept. of Informatics and Telematics.
 *
 * @author 21860 | 21836
 */
package org.hua.unihash;

import java.util.Iterator;

/**
 * A dictionary
 *
 * @param <K> the key type
 * @param <V> the value type
 */
public interface Dictionary<K, V> extends Iterable<Dictionary.Entry<K, V>> {

    void put(K key, V value);

    V remove(K key);

    V get(K key);
    
    boolean contains(K key);
    
    boolean isEmpty();

    int size();

    void clear();

    Iterator<Entry<K, V>> iterator();

    interface Entry<K, V> {

        K getKey();

        V getValue();
    }
}

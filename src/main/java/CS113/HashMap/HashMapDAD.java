package CS113.HashMap;

import java.util.ArrayList;

import CS113.IteratorInterface;
import CS113.LinkedList.LinkedListDAD;

public class HashMapDAD<K, V> implements MapInterface<K, V> {

    @SuppressWarnings("hiding")
    class Entry<K, V> implements  MapInterface.Entry<K, V> {

        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return this.key;
        }

        @Override
        public V getValue() {
            return this.value;
        }

        @Override
        public V setValue(V value) {
            this.value = value;

            return this.value;
        }

    }

    // Constants
    final int BUCKET_COUNT = 8;

    // Fields
    int count;
    int capacityFactor;

    @SuppressWarnings("unchecked")
    LinkedListDAD<Entry<K, V>>[] buckets = new LinkedListDAD[BUCKET_COUNT];

    // [ 0, 1, 2, 3, 4, 5, 6, 7]
    //   1  1
    //   2  2
    //   3

    // Constructor
    public HashMapDAD() {
        count = 0;

        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedListDAD<>();
        }

        capacityFactor = (int)(buckets.length * 0.75);

        String[] names = {"Noah", "Derek", "Kyle", "Rafail", "Frankie", "KC", "Katanu"};
        for (String name : names) {
            long hashCode = Integer.toUnsignedLong(name.hashCode());
            System.out.println(name + " " + hashCode+ " modulated hash " + hashCode % buckets.length);
        }
    }

    private int getHash(K key) {
        return Math.abs(key.hashCode()) % buckets.length;
    }

    @Override
    public int size() {
        return this.count;
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override
    public boolean containsKey(K key) {
        int index = getHash(key);
        LinkedListDAD<Entry<K, V>> bucket = buckets[index];

        IteratorInterface<Entry<K, V>> iterator = bucket.iterator();
        while (iterator.hasNext()) {
            Entry<K, V> entry = iterator.next();
            if (entry.key == key) {
                // found it!
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean containsValue(V value) {
        for (LinkedListDAD<Entry<K, V>> bucket : buckets) {
            IteratorInterface<Entry<K, V>> iterator = bucket.iterator();
            while (iterator.hasNext()) {
                if (iterator.next().getValue().equals(value)) {
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public V get(K key) {
        int index = getHash(key);
        LinkedListDAD<Entry<K, V>> bucket = buckets[index];

        IteratorInterface<Entry<K, V>> iterator = bucket.iterator();

        while (iterator.hasNext()) {
            Entry<K, V> entry = iterator.next();
            if (entry.key == key) {
                // found it!
                return entry.getValue();
            }
        }
        return null;
    }

    @Override
    public V put(K key, V value) {
        int index = getHash(key);
        LinkedListDAD<Entry<K, V>> bucket = buckets[index];

        IteratorInterface<Entry<K, V>> iterator = bucket.iterator();

        while (iterator.hasNext()) {
            Entry<K, V> entry = iterator.next();
            if (entry.key == key) {
                // found it!
                entry.setValue(value);
                return value;
            }
            
        }

        Entry<K, V> toSave =  new Entry<>(key, value);
        bucket.add(toSave);
        count++;

        // Check if load factor exceeded
        if (count > capacityFactor) {
            rehash(); // Call your resizing method
        }

        return value;
    }

    @Override
    public V remove(K key) {

        count --;
        return null;
    }

    @Override
    public void clear() {
        for (LinkedListDAD<Entry<K, V>> bucket : buckets) {
            bucket.clear(); // Clear each linked list
        }
        count = 0; // Reset the count
    }

    @Override
    public ArrayList<K> keySet() {
        ArrayList<K> keys = new ArrayList<>();
    
        for (LinkedListDAD<Entry<K, V>> bucket : buckets) {
            IteratorInterface<Entry<K, V>> iterator = bucket.iterator();
    
            while (iterator.hasNext()) {
                keys.add(iterator.next().getKey());
            }
        }
    
        return keys;
    }

    @Override
    public ArrayList<V> values() {
        ArrayList<V> returnValue = new ArrayList<>();

        for (LinkedListDAD<Entry<K, V>> bucket : buckets) {
            IteratorInterface<Entry<K, V>> iterator = bucket.iterator();
            
            while(iterator.hasNext()) {
                returnValue.add(iterator.next().getValue());
            }
        }

        return returnValue;
    }

    public void rehash() {
        LinkedListDAD<Entry<K, V>>[] oldBuckets = buckets;
        buckets = new LinkedListDAD[oldBuckets.length * 2];
        count = 0;
        capacityFactor = (int)(buckets.length * 0.75);
    
        // Re-initialize new empty buckets
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedListDAD<>();
        }

        for (LinkedListDAD<Entry<K, V>> oldBucket : oldBuckets) {
            IteratorInterface<Entry<K, V>> iterator = oldBucket.iterator();
    
            while (iterator.hasNext()) {
                Entry<K, V> entry = iterator.next();
                put(entry.getKey(), entry.getValue()); // This will go into new buckets
            }
        }
    }

}
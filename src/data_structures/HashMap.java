package data_structures;

import java.util.ArrayList;

public class HashMap<K, V> {
	public int size;
	public ArrayList<HashNode<K, V>> bucketArray;
	public int bucketSize;
	private final double limit = 7.0;
	public HashMap() {
		size = 0;
		bucketSize = 10;
		bucketArray = new ArrayList<HashNode<K, V>>();
		for (int i = 0; i < bucketSize; i++) {
			bucketArray.add(i, null);
		}
	}
	public boolean isEmpty() {
		return size == 0;
	}
	public int getIndex(K key) {
		return key.hashCode() % bucketSize;
	}
	
	public V removeKey(K key) {
		if (key == null) {
			return null;
		}
		int ind = getIndex(key);
		if (bucketArray.get(ind) == null) { // 2
			return null;
		}
		HashNode<K, V> current = bucketArray.get(ind);
		V value = null;
		boolean found = false;
		HashNode<K, V> prev = null;
		while (current.next != null) {
			if (current.key.equals(key)) {
				value = current.value;
				found = true;
				size--;
				break;
			}
			prev = current;
			current = current.next;
		}
		
		if (!found) {
			return null;
		} else {
			if (prev == null) { 
				bucketArray.set(ind, current.next);
			} else {
				prev.next = current.next;
			}
		}
		return value;
	}
	
	public V getValue(K key) throws Exception {
		if (key == null) {
			throw new Exception("key doesn't exist!");
		}
		int ind = getIndex(key);
		HashNode<K, V> current = bucketArray.get(ind);
		if (current == null) {
			throw new Exception("key doesn't exist!");
		}
		while (current != null) {
			if (current.key.equals(key)) {
				return current.value;
			}
			current = current.next;
		}
		throw new Exception("key doesn't exist!");
	}
	
	public void add(K key, V value) throws Exception {
		// first add
		if (key == null) {
			throw new Exception("key can't be null!");
		}
		int ind = getIndex(key);
		HashNode<K, V> current = bucketArray.get(ind);
		if (current == null) {
			bucketArray.set(ind, new HashNode<K, V>(key, value));
		} else {
			if (current.key.equals(key)) {
				current.value = value;
				return;
			}
			while (current.next != null) {
				if (current.key.equals(key)) {
					current.value = value;
					return;
				}
				current = current.next;
			}
			current.next = new HashNode<K, V>(key, value);
		}
		size++;
		//expand/rearrange if needed
		if (1.0 * size / bucketSize > limit) {
			ArrayList<HashNode<K, V>> temp = bucketArray;
			bucketSize *= 2;
			size = 0;
			bucketArray = new ArrayList<HashNode<K, V>>();
			for (int i = 0; i < bucketSize; i++) {
				bucketArray.add(i, null);
			}
			for (HashNode<K, V> node: temp) {
				while (node != null) {
					add(node.key, node.value);
					node = node.next;
				}
			}
		}
	}
	
	public static void main(String[] ar) throws Exception {
		HashMap<String, Integer> HM = new HashMap<String, Integer>();
//		HM.add("a66", 1);

		for (int i = 0; i < 100; i++) {
			HM.add("a" + i, i);
//			System.out.println(HM.size);
		}
		HM.removeKey("aj111");
		System.out.println("v: " + HM.getValue("a61"));
		System.out.println();
		System.out.println("s:" + HM.size);
//		for (int i = 0; i < 100; i++) {
//			System.out.println(HM.getValue("a" + i));
//		}
		
	}
	
}

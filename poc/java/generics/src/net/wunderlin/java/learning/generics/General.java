package net.wunderlin.java.learning.generics;

import java.util.*;

/**
 * Example for double Generics key/value List Entry
 * <p>
 * This Constructor takes two generic variable one for 
 * the key and one for the entry.
 * 
 * @author wus
 *
 * @param <KeyType>
 * @param <ValueType>
 */
class Entry<KeyType, ValueType> {
	private final KeyType key;
	private final ValueType value;
	
	public Entry(KeyType key, ValueType value) {
		this.key = key;
		this.value = value;
	}

	public KeyType getKey() {
		return key;
	}

	public ValueType getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "Entry [("+ key.getClass().getComponentType() +") key=" + key + ", (" +
				value.getClass().getComponentType() + ") value=" + value + "]";
	}
	
}

/*
class IntEntry<KeyType, Integer> extends Entry<KeyType, Integer> {
	private final KeyType key;
	private final Integer value;	
	
	public IntEntry(KeyType key, Integer value) {
		super(key, value);
	}
}
*/

public class General {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		List<Entry> list = new ArrayList<Entry>();
		list.add(new Entry<>("k1", 1));
		list.add(new Entry<>("k2", "String"));
		list.add(new Entry<>("k3", 3.1416));
		
		for(Entry e: list) {
			System.out.println(e);
		}
	}

}

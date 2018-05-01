package net.wunderlin.java.learning.generics;

import java.util.*;

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
		return "Entry [key=" + key + ", value=" + value + "]";
	}
	
}

public class General {

	public static void main(String[] args) {
		ArrayList<Entry> list = new ArrayList<>();
		list.add(new Entry<>("k1", 1));
		list.add(new Entry<>("k2", "String"));
		list.add(new Entry<>("k3", 3.1416));
		
		for(Entry e: list) {
			System.out.println(e);
		}
	}

}

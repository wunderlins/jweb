package net.wunderlin.java.learning.generics;

import java.util.ArrayList;
import java.util.Collection;

abstract class Animal {protected String type = ""; String getType() {return type;}}
class Mouse extends Animal {public Mouse() {type = "Mouse";}}
class Bear  extends Animal {public Bear()  {type = "Bear"; }}
class Bird  extends Animal {public Bird()  {type = "Bird"; }}

class AnimalList<E extends Animal> extends ArrayList<E> {
	private static final long serialVersionUID = -5266611404279884819L;

	public AnimalList() {
		super();
	}

	public AnimalList(Collection<? extends E> c) {
		super(c);
	}
	
}

class Trap<T extends Animal> {
	T trapped;
	public void snare(T trapped) { this.trapped = trapped; }
	public T release() {return trapped;}
}

class MultiTrap<T extends AnimalList<Animal>> {
	public T animalList;
	
	public MultiTrap() {
		super();
		
		@SuppressWarnings("unchecked")
		T t = (T) new AnimalList<Animal>();
		animalList = t;
	}
	public void snare(T animals) {
		animalList.addAll(animals);
	}
	
	public T release() {
		@SuppressWarnings("unchecked")
		T tmpList = (T) animalList.clone();
		animalList.clear();
		return tmpList;
	}
}

public class Classes {
	
	public static void main(String[] args) {
		
		Trap<Mouse> mouseTrap = new Trap<>();
		mouseTrap.snare(new Mouse());
		Animal mouse = mouseTrap.release();
		System.out.println("We cought a " + mouse.type + "\n");
		
		AnimalList<Animal> animalList = new AnimalList<>();
		animalList.add(new Bear());
		animalList.add(new Bird());
		
		MultiTrap<AnimalList<Animal>> multiTrap = new MultiTrap<>();
		//multiTrap.animalList.add(new Mouse());
		
		
		multiTrap.snare(animalList);
		System.out.println("We have mutliple animals trapped and are now releasing them:");
		for(Animal a:multiTrap.release())
			System.out.println(" - " + a.type);
		
		System.out.println("There are " + multiTrap.animalList.size() + " left in the trap");
	}

}

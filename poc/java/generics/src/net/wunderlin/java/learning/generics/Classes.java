package net.wunderlin.java.learning.generics;

abstract class Animal {protected String type = ""; String getType() {return type;}}
class Mouse extends Animal {public Mouse() {type = "Mouse";}}
class Bear  extends Animal {public Bear()  {type = "Bear"; }}

class Trap<T extends Animal> {
	T trapped;
	public void snare(T trapped) { this.trapped = trapped; }
	public T release() {return trapped;}
}

public class Classes {
	
	public static void main(String[] args) {
		
		Trap<Mouse> mouseTrap = new Trap<>();
		mouseTrap.snare(new Mouse());
		Animal mouse = mouseTrap.release();
		System.out.println("We cought a " + mouse.type);
	}

}

package net.wunderlin.jweb.shared;

/**
 * @author wus
 *
 */
public class global {
	private static String sirname = "";
	private static String firstname = "";
	
	public String toString() {
		return "global [sirname=" + sirname + ", firstname=" + firstname + "]";
	}
	
	public static String getSirname() {
		return sirname;
	}
	public static void setSirname(String sn) {
		sirname = sn;
	}
	public static String getFirstname() {
		return firstname;
	}
	public static void setFirstname(String fn) {
		firstname = fn;
	}
	
	
}

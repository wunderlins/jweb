package net.wunderlin.jweb.server;

import net.wunderlin.jweb.client.GreetingService;
import net.wunderlin.jweb.shared.FieldVerifier;
import net.wunderlin.jweb.shared.global;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements GreetingService {
	/*
	public GreetingServiceImpl(Object delegate) {
		super(delegate);
		// TODO Auto-generated constructor stub
	}
	*/
	
	public String[] getValues() throws IllegalArgumentException {
		String[] values = new String[2];
		values[0] = global.getFirstname();
		values[1] = global.getSirname();
		
		return values;
	}
	
	public Boolean setValues(String firstname, String sirname) throws IllegalArgumentException {
		// Verify that the input is valid. 
		if (!FieldVerifier.isValidName(firstname)) {
			// If the input is not valid, throw an IllegalArgumentException back to
			// the client.
			throw new IllegalArgumentException("firstname must be at least 4 characters long");
		}
		// Verify that the input is valid. 
		if (!FieldVerifier.isValidName(sirname)) {
			// If the input is not valid, throw an IllegalArgumentException back to
			// the client.
			throw new IllegalArgumentException("sirname must be at least 4 characters long");
		}

		global.setFirstname(firstname);
		global.setSirname(sirname);
		
		System.out.println("Global [ " + global.getFirstname() + ", "+ global.getSirname() + "]");
		
		return true;
	}
	/*
	public String greetServer(String input) throws IllegalArgumentException {
		// Verify that the input is valid. 
		if (!FieldVerifier.isValidName(input)) {
			// If the input is not valid, throw an IllegalArgumentException back to
			// the client.
			throw new IllegalArgumentException("Name must be at least 4 characters long");
		}
		
		global.setSirname(input);

		String serverInfo = getServletContext().getServerInfo();
		String userAgent = getThreadLocalRequest().getHeader("User-Agent");

		// Escape data from the client to avoid cross-site script vulnerabilities.
		input = escapeHtml(input);
		userAgent = escapeHtml(userAgent);

		return "Hello, " + input + "!<br><br>I am running " + serverInfo + ".<br><br>It looks like you are using:<br>"
				+ userAgent;
	}
	*/
	
	/**
	 * Escape an html string. Escaping data received from the client helps to
	 * prevent cross-site script vulnerabilities.
	 * 
	 * @param html the html string to escape
	 * @return the escaped string
	 */
	private String escapeHtml(String html) {
		if (html == null) {
			return null;
		}
		return html.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;");
	}
}

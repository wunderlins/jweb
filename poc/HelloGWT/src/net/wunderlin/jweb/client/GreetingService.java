package net.wunderlin.jweb.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface GreetingService extends RemoteService {
	String[] getValues() throws IllegalArgumentException;
	Boolean setValues(String firstname, String sirname) throws IllegalArgumentException;
}

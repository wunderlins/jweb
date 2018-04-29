package net.wunderlin.jweb.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GreetingServiceAsync {
	void getValues(AsyncCallback<String[]> callback) throws IllegalArgumentException;
	void setValues(String firstname, String sirname, AsyncCallback<Boolean> callback) throws IllegalArgumentException;
}

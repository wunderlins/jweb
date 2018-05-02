package net.wunderlin.jweb.client;

import net.wunderlin.jweb.shared.FieldVerifier;
import net.wunderlin.jweb.shared.global;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class HelloGWT implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network " + "connection and try again.";

	/**
	 * Create a remote service proxy to talk to the server-side Greeting service.
	 */
	private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		
		// add name input fields
		final TextBox firstname = new TextBox();
		final TextBox sirname = new TextBox();
		final Button btnSave = new Button("Save»");
		final Button btnUpdate = new Button("Update");
		firstname.setText(global.getFirstname());
		sirname.setText(global.getSirname());
		
		RootPanel.get("inpFirstname").add(firstname);
		RootPanel.get("inpSirname").add(sirname);
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.add(btnSave);
		horizontalPanel.add(btnUpdate);
		RootPanel.get("buttons").add(horizontalPanel);
		
		// Create the popup dialog box
		final DialogBox dialogBox = new DialogBox();
		dialogBox.setText("Remote Procedure Call");
		dialogBox.setAnimationEnabled(true);
		final Button closeButton = new Button("Close");
		// We can set the id of a widget by accessing its Element
		closeButton.getElement().setId("closeButton");
		final Label textToServerLabel = new Label();
		final HTML serverResponseLabel = new HTML();
		VerticalPanel dialogVPanel = new VerticalPanel();
		dialogVPanel.addStyleName("dialogVPanel");
		dialogVPanel.add(new HTML("<b>Sending name to the server:</b>"));
		dialogVPanel.add(textToServerLabel);
		dialogVPanel.add(new HTML("<br><b>Server replies:</b>"));
		dialogVPanel.add(serverResponseLabel);
		dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
		dialogVPanel.add(closeButton);
		dialogBox.setWidget(dialogVPanel);
		
		// dialog close handler
		closeButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
            	dialogBox.hide();
            }
        });

		// event handler
		class saveHandler implements ClickHandler {
			public void onClick(ClickEvent event) {
				sendData();
			}
			
			private void sendData() {
				String fn = firstname.getText();
				String sn = sirname.getText();
				btnSave.setEnabled(false);
				
				greetingService.setValues(fn, sn, new AsyncCallback<Boolean>() {
					public void onFailure(Throwable caught) {
						// Show the RPC error message to the user
						dialogBox.setText("Remote Procedure Call - Failure");
						serverResponseLabel.addStyleName("serverResponseLabelError");
						serverResponseLabel.setHTML(caught.getMessage());
						dialogBox.center();
						closeButton.setFocus(true);
						btnSave.setEnabled(true);
					}
	
					public void onSuccess(Boolean truth) {
						btnSave.setEnabled(true);
					}
				});
			}
		}
		// Add a handler to send the name to the server
		saveHandler sHandler = new saveHandler();
		btnSave.addClickHandler(sHandler);

		class updateHandler implements ClickHandler {
			public void onClick(ClickEvent event) {
				getData();
			}
			
			private void getData() {
				greetingService.getValues(new AsyncCallback<String[]>() {
					public void onFailure(Throwable caught) {
						// Show the RPC error message to the user
						dialogBox.setText("Remote Procedure Call - Failure");
						serverResponseLabel.addStyleName("serverResponseLabelError");
						serverResponseLabel.setHTML(SERVER_ERROR);
						dialogBox.center();
						closeButton.setFocus(true);
						//btnSave.setEnabled(true);
					}
	
					public void onSuccess(String[] res) {
						firstname.setText(res[0]);
						sirname.setText(res[1]);
					}
				});
			}
		}
		
		// Add a handler to send the name to the server
		updateHandler uHandler = new updateHandler();
		btnUpdate.addClickHandler(uHandler);
		
		// populate widget with data
		updateHandler uh = new updateHandler();
		uh.getData();
		
	}
}

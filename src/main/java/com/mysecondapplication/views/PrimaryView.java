package com.mysecondapplication.views;

import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.control.Icon;
import com.mysecondapplication.views.Session;
import com.mysecondapplication.views.Sessions;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import com.gluonhq.cloudlink.enterprise.sdk.javaee.CloudLinkClient;
import com.gluonhq.cloudlink.enterprise.sdk.javaee.CloudLinkClientConfig;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class PrimaryView extends View {

    public PrimaryView() {
        
        getStylesheets().add(PrimaryView.class.getResource("primary.css").toExternalForm());
        
                //CloudLinkClientConfig config = new CloudLinkClientConfig("MHwwDQYJKoZIhvcNAQEBBQADawAwaAJhAIiBpmBMMd9b91ODbu0vI4uB5BNIbdsi9Fi-tjXPH9xG0bruyhhwSP5bxsHa-k9mdws7qnTEn8SzaFL8d_hgWvKWtTVKQlPu7QuS144xCjfKXhDQukHBebgFvkmaMLGeIQIDAQAB");
                //CloudLinkClient client = new CloudLinkClient(config);
              /*  UserClient authenticationClient = new UserClient();
                DataClient dataClient = DataClientBuilder.create()
        .operationMode(OperationMode.LOCAL_ONLY)
        .authenticateWith(authenticationClient)
        .build();
                
                // store the object
Note note = new Note();
note.setContent("This is the content for the note.");
GluonObservableObject<Note> gluonNote = DataProvider.storeObject(note, dataClient.createObjectDataWriter("a-single-note", Note.class));

// retrieve the object
GluonObservableObject<Note> gluonNote = DataProvider.retrieveObject(dataClient.createObjectDataReader("a-single-note", Note.class));

// remove the object
DataProvider.removeObject(gluonNote, dataClient.createObjectDataRemover());

GluonObservableObject<Note> gluonNote = DataProvider.retrieveObject(dataClient.createObjectDataReader("a-single-note", Note.class));
gluonNote.initializedProperty().addListener((observable, ov, nv) -> {
    if (nv) {
        if (gluonNote.get() == null) {
            // object not yet stored, initiate it now with a new object and store it
            gluonNote.set(new Note("This is some text for the note"));
            dataClient.push(gluonNote);
        } else {
            // object already stored previously
            Note note = gluonNote.get();
            System.out.println("Stored note: " + note.getContent());
        }
    }
});*/

                
                Font font = new Font("Comfortaa", 15);
		Font font1 = new Font("Comfortaa", 24);
        // Use a GridPane to create a login interface
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		//grid.setStyle("-fx-background-color: white;");

		Label scenetitle = new Label("Log In");
		scenetitle.setFont(font1);
                grid.add(scenetitle, 0, 0);
                Label userID = new Label("User ID:");
		userID.setFont(font);
		// Show User ID at grid entry (0,1)
		grid.add(userID, 0, 1);
		TextField userIDTextField = new TextField();
		userIDTextField.setFont(font);
		userIDTextField.setPromptText("Enter User ID");
		// Show userID text field at grid entry (1,1)
		grid.add(userIDTextField, 1, 1);
		Label pw = new Label("Password:");
		pw.setFont(font);

		// Show Password at grid entry (0,2)
		grid.add(pw, 0, 2);
		// Use a text field that masks entered password
		PasswordField pwBox = new PasswordField();
		pwBox.setFont(font);
		pwBox.setPromptText("Enter Password");
		// Show typed in password at grid entry (1,2)
		grid.add(pwBox, 1, 2);

		// Create a button that when pressed will sign in a user
		Button btn = new Button("Sign in");
		btn.setFont(font);
		btn.setStyle("-fx-background-color: rgb(253, 181, 21);");
		// Add the button to an HBox so it can be positioned appropriately
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().addAll(btn);
		// Show the buttons at grid entry (1,3)
		grid.add(hbBtn, 1, 3);

                // https://termsandconditionsfortherabot.5pengoo.repl.co/
		// Display an appropriate message welcoming the user
		Text actiontext = new Text();
		actiontext.setFont(font);
		// Show the message at grid entry (1,4)
                grid.add(actiontext, 1, 4);
		
		// Put the grid in a 400x300 scene and display the scene
		grid.setAlignment(Pos.CENTER);
                setCenter(grid);
                
		// Event handler for btn1
		btn.setOnAction(e -> {
			// Get User ID and Password
			String uid = userIDTextField.getText();
			String pass = pwBox.getText();
			
			// Create an empty list of sessions
			Sessions sessions = null;

			// If user has typed in both User ID and Password
			if (uid.length() > 0 && pass.length() > 0) {
				Session session = new Session(uid, pass);
				// CREATE A LOGIN FOR USER
				String filename = "./" + uid + pass.hashCode() + ".dat";
				
				try {
                                    try {
                                        // If a returning user, read in past sessions from file
                                        sessions = new Sessions(filename);
                                    } catch (ClassNotFoundException ex) {
                                        Logger.getLogger(PrimaryView.class.getName()).log(Level.SEVERE, null, ex);
                                    }
				} catch (IOException ioe) {
				}
                                
                                
				// If the user is a known user
				if (sessions.isUserKnown(session)) {
					//actiontext.setText("Welcome back " + uid + "!");
                                        MobileApplication.getInstance().switchView("Tertiary");
                                        System.out.println("User is known");
                                        //System.out.println("Switch to tertiary view. (change mobile app code above)");
				} else { // If the user is not known
					//actiontext.setText("Welcome " + uid + "!");
                                        actiontext.setFill(Color.rgb(255, 0, 0));
                                        actiontext.setText("Unknown log in");
                                        //MobileApplication.getInstance().switchView("Tertiary");
                                        //System.out.println("Switch to tertiary view. (change mobile app code above)");
				}
			} else if(uid.length() <= 0) {// If user has not typed in User ID and/or Password
				actiontext.setText("Enter User ID");}
                        else 
                            actiontext.setText("Enter password");
		});
    }
	
        @Override
    protected void updateAppBar(AppBar appBar) {
        appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> getApplication().getDrawer().open()));
        appBar.setTitleText("No Account? Create one! ->");
        appBar.getActionItems().add(MaterialDesignIcon.PERSON_ADD.button(e -> {
            //System.out.println("Switch to secondary view.");
            MobileApplication.getInstance().switchView("Secondary");
        }));
    }
        /*Label label = new Label("Hello JavaFX World!");

        Button button = new Button("Change the World!");
        button.setGraphic(new Icon(MaterialDesignIcon.LANGUAGE));
        button.setOnAction(e -> label.setText("Hello JavaFX Universe!"));
        
        VBox controls = new VBox(15.0, label, button);
        controls.setAlignment(Pos.CENTER);
        
        setCenter(controls);*/
    
}

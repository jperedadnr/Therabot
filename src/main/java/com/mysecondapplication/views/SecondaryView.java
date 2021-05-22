package com.mysecondapplication.views;

import com.gluonhq.charm.glisten.animation.BounceInRightTransition;
import com.gluonhq.charm.glisten.application.MobileApplication;
import static com.gluonhq.charm.glisten.application.MobileApplication.HOME_VIEW;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.control.FloatingActionButton;
import com.mysecondapplication.views.Session;
import com.mysecondapplication.views.Sessions;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
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

public class SecondaryView extends View {

    public SecondaryView() {
        
        getStylesheets().add(SecondaryView.class.getResource("secondary.css").toExternalForm());
                
                Font font = new Font("Comfortaa", 15);
		Font font1 = new Font("Comfortaa", 24);
        // Use a GridPane to create a login interface
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		//grid.setStyle("-fx-background-color: white;");

		Label scenetitle = new Label("Sign Up");
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
                                        actiontext.setFill(Color.rgb(255, 0, 0));
                                        actiontext.setText("Log in is already in use");
                                        //System.out.println("Switch to tertiary view. (change mobile app code above)");
				} else { // If the user is not known
					//actiontext.setText("Welcome " + uid + "!");
                                        System.out.println("User is not known");
                                        MobileApplication.getInstance().switchView("Tertiary");
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
        appBar.setTitleText("Have an Account? Log In! ->");
        appBar.getActionItems().add(MaterialDesignIcon.PEOPLE.button(e -> {
            MobileApplication.getInstance().switchView(HOME_VIEW);
        }));
    }
    
}

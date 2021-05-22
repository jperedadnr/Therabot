package com.mysecondapplication.views;

import com.gluonhq.charm.glisten.animation.BounceInRightTransition;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.control.BottomNavigation;
import com.gluonhq.charm.glisten.control.FloatingActionButton;
import com.gluonhq.charm.glisten.mvc.View;
import com.mysecondapplication.views.Session;
import com.mysecondapplication.views.Sessions;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.Slider;
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

public class QuaternaryView extends View {
    
    int m = 0;

    public QuaternaryView(Session session, Sessions sessions) {
        
        getStylesheets().add(QuaternaryView.class.getResource("quaternary.css").toExternalForm());
        
        
        
        Font font = new Font("Comfortaa", 20);
		Font font1 = new Font("Comfortaa", 15);
		
		TextField speak = new TextField();
		speak.setPromptText("you got this!");
		String[] msgs = new String[4];
		msgs[1] = "What was something new that you learned today?";
		msgs[3] = "Is there anything else you would like to tell me? If not, press done.";
		// Image image1 = new Image(file1);
		// buttons for first scene
		Button next = new Button("Next");
		next.setFont(font);
		next.setStyle("-fx-background-color: rgb(253, 181, 21);");
		// next.setGraphic(new ImageView(image1));
		// Image image2 = new Image(file2);
		Button clear = new Button("Clear");
		clear.setFont(font);
		clear.setStyle("-fx-background-color: rgb(253, 181, 21);");
		// clear.setGraphic(new ImageView(image2));
		// Image image3 = new Image(file3);
		Button done = new Button("Done");
		done.setFont(font);
		done.setStyle("-fx-background-color: rgb(253, 181, 21);");
		// done.setGraphic(new ImageView(image3));

		// additional button for use in second scene
		Button clear1 = new Button("Clear");
		clear1.setFont(font);
		clear1.setStyle("-fx-background-color: rgb(253, 181, 21);");
		// clear1.setGraphic(new ImageView(image2));

		// Image image4 = new Image(file4);
		Button exit = new Button("Exit");
		exit.setFont(font);
		exit.setStyle("-fx-background-color: rgb(253, 181, 21);");
		Button next2 = new Button("Next");
		next2.setFont(font);
		next2.setStyle("-fx-background-color: rgb(253, 181, 21);");
		// next2.setGraphic(new ImageView(image1));
		Button next1 = new Button("Next");
		next1.setFont(font);
		next1.setStyle("-fx-background-color: rgb(253, 181, 21);");
		// next1.setGraphic(new ImageView(image1));
		GridPane gridpane = new GridPane();
		gridpane.setStyle("-fx-background-color: white;");
		gridpane.setAlignment(Pos.CENTER);
		Insets insets = new Insets(10, 10, 10, 10);
		gridpane.setPadding(insets);
		gridpane.setVgap(10);
		Label sFName = new Label("Hi, "+ session.getID() + "! Welcome to your judgement-free session. Let's get started.");
		sFName.setFont(font);
		Label mood = new Label("Rate your day from 1-100. ");
		mood.setFont(font);
		Label talk = new Label("Tell me a bit about your day.");
		talk.setFont(font);
		Slider sb1 = new Slider();
		sb1.setShowTickMarks(true);
		sb1.setShowTickLabels(true);
		sb1.setMinorTickCount(5);
		sb1.setMajorTickUnit(20);
		sb1.setOrientation(Orientation.HORIZONTAL);
		sb1.setMax(100); // divide by 5 to get five moods (shown later)
		sb1.setMin(0);
		sb1.valueProperty().addListener(ov -> {
			double feeling1 = sb1.getValue();
			session.setFeeling1(feeling1);
			
			// if you want to save type of mood in future updates, make f1 global
			/*if (feeling1 < 20) {
				f1 = "terrible";
			} else if (feeling1 >= 20 && feeling1 < 40) {
				f1 = "bad";
			} else if (feeling1 >= 40 && feeling1 < 60) {
				f1 = "average";
			} else if (feeling1 >= 60 && feeling1 < 80) {
				f1 = "good";
			} else if (feeling1 >= 80 && feeling1 < 100) {
				f1 = "wonderful";
			}*/
			
			if (feeling1 > 49) {
				//int num0 = (int) (Math.random()*2);
				//int num2 = (int) (Math.random()*2);
				
				/*switch (num0) {
				case 0: msgs[0] = "a";
				break;
				case 1: msgs[0] = "b";
				break;
				case 2: msgs[0] = "c";
				break;
				}
				
				switch (num2) {
				case 0: msgs[2] = "d";
				break;
				case 1: msgs[2] = "e";
				break;
				case 2: msgs[2] = "f";
				break;
				}*/
				msgs[0] = "What do you think you can do tomorrow to have an even better day?";
				msgs[2] = "Let's take a deep breath. What inspired you today?";
			} else {
				msgs[0] = "What do you think you can do tomorrow to have a better day?";
				msgs[2] = "Use this moment to reflect, and tell me about a good thing that happened to you recently.";
			}
			// System.out.println(f1);
		});
		Slider sb2 = new Slider();
		sb2.setShowTickMarks(true);
		sb2.setShowTickLabels(true);
		sb2.setMinorTickCount(5);
		sb2.setMajorTickUnit(20);
		sb2.setOrientation(Orientation.HORIZONTAL);
		sb2.setMax(100); // divide by 4
		sb2.setMin(0);
		sb2.valueProperty().addListener(ov -> {
			double feeling2 = sb2.getValue();
			session.setFeeling2(feeling2);
			
			// if you want to save type of mood in future updates, make f2 global
			/*if (feeling2 < 20) {
				f2 = "terrible";
			} else if (feeling2 >= 20 && feeling2 < 40) {
				f2 = "bad";
			} else if (feeling2 >= 40 && feeling2 < 60) {
				f2 = "average";
			} else if (feeling2 >= 60 && feeling2 < 80) {
				f2 = "good";
			} else if (feeling2 >= 80 && feeling2 < 100) {
				f2 = "wonderful";
			}*/
			// System.out.println(f2);
		});
		gridpane.setAlignment(Pos.CENTER);
		gridpane.add(sFName, 0, 0);
		gridpane.add(mood, 0, 1);
		gridpane.add(sb1, 1, 1);
		gridpane.add(talk, 0, 3);
		gridpane.add(speak, 1, 3);
		// Include an HBox as a part of the interface
		HBox hBox = new HBox(5);// Leave 5 pixels gap between adjacent objects
		hBox.setAlignment(Pos.CENTER);
		// Include next, clear, and done in the HBox
		hBox.setSpacing(5);
		hBox.getChildren().addAll(clear, done, next);
		gridpane.add(hBox, 1, 4);// Place hBox within the GridPane at column 1 and row 3
		setCenter(gridpane);
		
		// Take appropriate actions when pressing one of the buttons
		// make two next buttons and revise this code below, which is copy of done
		// button

		next.setOnAction(e -> {
			String sentence = speak.getText();
			session.addSentence(sentence);
			GridPane gridpane2 = new GridPane();
			gridpane2.setStyle("-fx-background-color: white;");
			gridpane2.setAlignment(Pos.CENTER);
			Insets inset = new Insets(10, 10, 10, 10);
			gridpane2.setPadding(inset);
			gridpane2.setVgap(10);
			gridpane2.setHgap(10);
			if (session.getFeeling1() > 49) {
				Label talk2 = new Label("Ok, what made today good?");
				talk2.setFont(font);
				gridpane2.add(talk2, 0, 0);
			} else {
				Label talk2 = new Label("Let's take a deep breath. What was not good about today?");
				talk2.setFont(font);
				gridpane2.add(talk2, 0, 0);
			}
			// "Ok! Tell me more about your day."
			// + "What was something new that happened today?"
			gridpane2.add(speak, 0, 1);
			speak.clear();
			HBox hbox = new HBox(5);
			hbox.setAlignment(Pos.CENTER);
			hbox.getChildren().addAll(clear1, done, next1);
			gridpane2.add(hbox, 0, 2);
			setCenter(gridpane2);
		});

		// Scene1 Clear Button
		clear.setOnAction(e -> {// code to be executed when clear button is pressed
			speak.clear();
		});
		// Scene 2 Clear Button
		clear1.setOnAction(e -> {// code to be executed when clear button is pressed
			speak.clear();
		});
		done.setOnAction(e -> {
			String sentence = speak.getText();
			session.addSentence(sentence);
			
			GridPane gridpane1 = new GridPane();
			gridpane1.setStyle("-fx-background-color: white;");
			gridpane1.setAlignment(Pos.CENTER);
			Insets inset = new Insets(10, 10, 10, 10);
			gridpane1.setPadding(inset);
			gridpane1.setVgap(10);
			gridpane1.setHgap(10);
			Label newmood = new Label("Take a moment to reflect. How are you feeling after our session?");
			newmood.setFont(font);
			gridpane1.add(newmood, 0, 0);
			gridpane1.add(sb2, 0, 1);
			gridpane1.add(next2, 2, 2);
			setCenter(gridpane1);
		});
		next1.setOnAction(e -> {
			String sentence = speak.getText();
			session.addSentence(sentence);

			GridPane gridpane2 = new GridPane();
			gridpane2.setStyle("-fx-background-color: white;");
			gridpane2.setAlignment(Pos.CENTER);
			Insets inset = new Insets(10, 10, 10, 10);
			gridpane2.setPadding(inset);
			gridpane2.setVgap(10);
			gridpane2.setHgap(10);
			Label talk3 = new Label(msgs[m]);
			talk3.setFont(font);
			gridpane2.add(talk3, 0, 0);
			gridpane2.add(speak, 0, 1);
			speak.clear();
			HBox hbox = new HBox(5);
			hbox.setAlignment(Pos.CENTER);
			hbox.getChildren().addAll(clear1, done, next1);
			gridpane2.add(hbox, 0, 2);
                        
			setCenter(gridpane2);
			
			if (m < 3)
				m++;
		});
		
		next2.setOnAction(e -> {
			MobileApplication.getInstance().switchView("Quinary");
		});
        
        
        
        
                
                /*Font font = new Font("Comfortaa", 15);
		Font font1 = new Font("Comfortaa", 24);
        // Use a GridPane to create a login interface insights 
		VBox grid = new VBox();
		grid.setAlignment(Pos.CENTER);
		grid.setPadding(new Insets(25, 25, 25, 25));
		//grid.setStyle("-fx-background-color: black;");
                

		Label scenetitle = new Label("Rate your day from 1-100.");
		scenetitle.setFont(font1);
                //scenetitle.setAlignment(Pos.TOP_LEFT);
                grid.getChildren().add(scenetitle);
                //scenetitle.setStyle("-fx-text-fill: grey;");
                Label h2 = new Label("Tell me a bit about your day.");
		h2.setFont(font);
                //scenetitle.setStyle("-fx-text-fill: grey;");
                grid.getChildren().add(h2);
                
                setCenter(grid);*/
    }
    
    

    @Override
    protected void updateAppBar(AppBar appBar) {
        appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> getApplication().getDrawer().open()));
        appBar.setTitleText("Home");
        appBar.getActionItems().add(MaterialDesignIcon.HOME.button(e -> { 
            getApplication().getDrawer().open();
        }));
    }
    
}

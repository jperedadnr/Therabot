package com.mysecondapplication.views;

import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.control.Icon;
import com.mysecondapplication.views.Session;
import com.mysecondapplication.views.Sessions;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import static com.gluonhq.charm.glisten.visual.Theme.DARK;
import static com.gluonhq.charm.glisten.visual.Theme.LIGHT;
import com.gluonhq.cloudlink.enterprise.sdk.javaee.CloudLinkClient;
import com.gluonhq.cloudlink.enterprise.sdk.javaee.CloudLinkClientConfig;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.TranslateTransition;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;

public class PrimaryView extends View {

    Sessions sessions;
    Session session;
    int m = 0;
    VBox grid1 = new VBox();

    public PrimaryView() {
        getStylesheets().add(PrimaryView.class.getResource("primary.css").toExternalForm());
        Font font = new Font("Comfortaa", 15);
        Font font1 = new Font("Comfortaa", 24);
        // Use a GridPane to create a login interface
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        //grid.setStyle("-fx-background-color: white;");

        // Read in the image to be used as background to the pane
        Image image = new Image(PrimaryView.class.getResourceAsStream("/newbackground.png"));
        // Specify position in pane to paste the image
        BackgroundPosition backgroundPosition = new BackgroundPosition(
                // Fill area starting from upper-left corner
                Side.LEFT, 0, false, Side.TOP, 0, false);
        // Associate the image with the background
        BackgroundImage backgroundImage = new BackgroundImage(image,
                // If image is too small, repeat it horizontally
                // and vertically as needed to fill the area
                BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
                backgroundPosition, BackgroundSize.DEFAULT);
        // Associate the background with the grid pane
        Background background = new Background(backgroundImage);
        grid.setBackground(background);

        Label scenetitle = new Label("Log In");
        scenetitle.setFont(font1);
        Pane title = new Pane();
        title.getChildren().add(scenetitle);
        grid.add(title, 0, 0);
        Label userID = new Label("User ID:");
        userID.setFont(font);
        Pane user = new Pane(userID);
        // Show User ID at grid entry (0,1)
        grid.add(user, 0, 1);
        TextField userIDTextField = new TextField();
        userIDTextField.setFont(font);
        userIDTextField.setPromptText("Enter User ID");
        // Show userID text field at grid entry (1,1)
        grid.add(userIDTextField, 1, 1);

        Label pw = new Label("Password:");
        pw.setFont(font);
        Pane pass1 = new Pane(pw);
        // Show Password at grid entry (0,2)
        grid.add(pass1, 0, 2);
        // Use a text field that masks entered password
        PasswordField pwBox = new PasswordField();
        pwBox.setFont(font);
        pwBox.setPromptText("Enter Password");
        // Show typed in password at grid entry (1,2)
        grid.add(pwBox, 1, 2);

        Button sign = new Button("Create your account");
        sign.setFont(font);
        sign.setStyle("-fx-background-color: rgb(253, 181, 21);");
        // Create a button that when pressed will sign in a user
        Button btn = new Button("Log in");
        btn.setFont(font);
        btn.setStyle("-fx-background-color: rgb(253, 181, 21);");
        // Add the button to an HBox so it can be positioned appropriately
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().addAll(btn, sign);
        // Show the buttons at grid entry (1,3)
        grid.add(hbBtn, 1, 3);

        // https://termsandconditionsfortherabot.5pengoo.repl.co/
        // Display an appropriate message welcoming the user
        Text actiontext = new Text();
        actiontext.setFont(font);
        actiontext.setFill(Color.rgb(255, 0, 0));
        // Show the message at grid entry (1,4)
        grid.add(actiontext, 1, 4);

        // Put the grid in a 400x300 scene and display the scene
        grid.setAlignment(Pos.CENTER);
        setCenter(grid);
        
        VBox vbox = new VBox();

        // Event handler for btn1
        btn.setOnAction(e -> {
            // Get User ID and Password
            String uid = userIDTextField.getText();
            String pass = pwBox.getText();

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
                        System.out.println("Logger in btn; log in");
                    }
                } catch (IOException ioe) {
                    System.out.println("IOException in btn; log in");
                }

                // If the user is a known user
                if (sessions.isUserKnown(session)) {
                    //actiontext.setText("Welcome back " + uid + "!");
                    System.out.println("User is known");
                    try {
                        // If a returning user, read in past sessions from file
                        sessions = new Sessions(filename);
                        homeScreen(sessions, session, uid, pass);
                    } catch (IOException ioe) {
                        System.out.println("IOException in btn; log in");
                    } catch (ClassNotFoundException ee) {
                        System.out.println("ClassNotFoundException in btn; log in");
                    }
                    homeScreen(sessions, session, uid, pass);
                    //System.out.println("Switch to tertiary view. (change mobile app code above)");
                } else { // If the user is not known
                    //actiontext.setText("Welcome " + uid + "!");

                    actiontext.setText("Unknown log in.");
                }
            } else if (uid.length() <= 0) {// If user has not typed in User ID and/or Password
                actiontext.setText("Enter User ID");
            } else {
                actiontext.setText("Enter password");
            }
        });

        sign.setOnAction(e -> {
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
                        System.out.println("Logger in btn; log in");
                    }
                } catch (IOException ioe) {
                    System.out.println("IOException in btn; log in");
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
                    homeScreen(sessions, session, uid, pass);
                    //System.out.println("Switch to tertiary view. (change mobile app code above)");
                }
            } else if (uid.length() <= 0) {// If user has not typed in User ID and/or Password
                actiontext.setText("Enter User ID");
            } else {
                actiontext.setText("Enter password");
            }
        });
    }

    /**
     * only parameter used is sessions, but we need the others if the user
     * decides to switch to session (to import to method)
     *
     * @param sessions collection of all past sessions
     * @param session current session
     * @param uid user id
     * @param pass password
     * @param grid VBox so Scene is not null
     */
    public void homeScreen(Sessions sessions, Session session, String uid, String pass) {
        
        VBox grid1 = new VBox();

        HBox tabBar = bottomNav(sessions, session, uid, pass);

        Font font = new Font("Comfortaa", 15);
        Font font1 = new Font("Comfortaa", 24);

        // Use a GridPane to create a login interface insights 
        
        //grid.setStyle("-fx-background-color: black;");
        grid1.setAlignment(Pos.CENTER);
        Insets snI = new Insets(10, 10, 10, 10);
        grid1.setPadding(snI);
        
        Button button = new Button();
        
        if(sessions.isUserKnown(session)) {
            grid1.getChildren().add(button);
        if (sessions.getMode() == true) {
            grid1.sceneProperty().addListener((obs, ov, nv) -> { if (nv != null) { System.out.println("YAY! nv is not null!"); LIGHT.assignTo(nv); } else System.out.println("nv is null"); }); // ERROR IS POINTING TO THIS LINE
            button.setGraphic(new Icon(MaterialDesignIcon.BRIGHTNESS_2));
            button.setStyle("-fx-text-fill: #000;");
        } else {
            grid1.sceneProperty().addListener((obs, ov, nv) -> { if (nv != null) { System.out.println("YAY! nv is not null!"); DARK.assignTo(nv); } else System.out.println("nv is null");});
            button.setGraphic(new Icon(MaterialDesignIcon.WB_SUNNY));
            button.setStyle("-fx-text-fill: #fdb515;");
        }
        }
        
        button.setOnMousePressed(e -> {
            if(sessions.isUserKnown(session)) {
            if (sessions.getMode() == true) {
                System.out.println("Mode is (it should be) true: " + sessions.getMode());
		boolean mode = sessions.getMode(); //Save in mode the value of light in sessions
		System.out.println("Current mode is "+mode);
		mode = !mode; // Reverse the value in mode
		System.out.println("Set mode to "+mode);
		sessions.setMode(mode); //Set the value of light in sessions to value in mode
		sessions.saveSessions();	
                button.setStyle("-fx-text-fill: #fdb515;");
                DARK.assignTo(grid1.getScene());
                button.setGraphic(new Icon(MaterialDesignIcon.WB_SUNNY));
                /*button.setOnMousePressed(eh -> {
                    light = false;
                    DARK.assignTo(button.getScene());
                    button.setText("Light Mode");
                    button.setOnMousePressed(b -> {
                        light = true;
                        button.setText("This button has been disabled due to\nspam concerns. Check back later!");
                        button.setWrapText(true);
                        LIGHT.assignTo(button.getScene());
                    });
                });*/
            } else {
                System.out.println("Mode is (it should be) false: " + sessions.getMode());
		boolean mode = sessions.getMode(); //Save in mode the value of light in sessions
		System.out.println("Current mode is "+mode);
		mode = !mode; // Reverse the value in mode
		System.out.println("Set mode to "+mode);
		sessions.setMode(mode); //Set the value of light in sessions to value in mode
                sessions.saveSessions();
                button.setStyle("-fx-text-fill: #000;");
                LIGHT.assignTo(grid1.getScene());
                button.setGraphic(new Icon(MaterialDesignIcon.BRIGHTNESS_2));
                /*button.setOnMousePressed(eh -> {
                    light = true;
                    LIGHT.assignTo(button.getScene());
                    button.setText("Dark Mode");
                    button.setOnMousePressed(b -> {
                        light = false;
                        button.setText("This button has been disabled due to\nspam concerns. Check back later!");
                        button.setWrapText(true);
                        DARK.assignTo(button.getScene());
                    });
                });*/
            }
            } else {
		Label l = new Label("Please complete a session before changing mode.");
                l.setWrapText(true);
                grid1.getChildren().add(l);
            }
        });

        Label scenetitle = new Label("Hello, " + uid + "!");
        scenetitle.setFont(font1);
        //scenetitle.setAlignment(Pos.TOP_LEFT);
        grid1.getChildren().add(scenetitle);
        //scenetitle.setStyle("-fx-text-fill: grey;");
        Label h2 = new Label("Here are your insights for today.");
        h2.setFont(font);
        VBox vbox = new VBox(); // make sure name read in is same as file name
        vbox.setAlignment(Pos.CENTER);
        Insets ssnI = new Insets(10, 10, 10, 10);
        vbox.setPadding(snI);
        ArrayList<Double> feelings1 = sessions.getFeelings1();
        ArrayList<Double> feelings2 = sessions.getFeelings2();
        ArrayList<Double> differences = new ArrayList<Double>();
        for (int i = 0; i < feelings1.size(); i++) {
            differences.add(feelings2.get(i) - feelings1.get(i));
        }

        if (feelings1.size() > 0) {
            Label[] datatxt = new Label[feelings1.size()]; //THIS IS IT?

            //Let x-axis show categories
            CategoryAxis xAxis = new CategoryAxis();
            //Let y-axis show numbers
            NumberAxis yAxis = new NumberAxis();
            //Specify the label of x-axis
            //Show the x-axis labels on bottom
            //Specify the title of y-axis
            yAxis.setLabel("Your Mood Change");
            //Instantiate the LineChart class
            LineChart<String, Number> lineChart = new LineChart<String, Number>(xAxis, yAxis);
            //Provide a title for the chart       
            //Display symbols at data points (or don't)
            lineChart.setCreateSymbols(false);  //  Y / N ?
            //Define an XYChart.Series    
            XYChart.Series series = new XYChart.Series();
            //Specify a name for the series
            series.setName("Data for " + uid);

            //Specify data to go with the XYChart.Series
            //Assign series to the chart
            lineChart.setPrefSize(280.2, 280.2);
            lineChart.setMinSize(220.2, 220.2);
            lineChart.setMaxSize(320.2, 320.2);
            lineChart.getData().add(series);
            vbox.getChildren().addAll(lineChart);

            for (int i = 0; i < feelings1.size(); i++) {
                double d1 = feelings1.get(i).doubleValue();
                d1 = (int) d1;
                double d2 = feelings2.get(i).doubleValue();
                d2 = (int) d2;										// Day "names.get(i), differences.get(i)
                double d = differences.get(i).doubleValue();
                d = (int) d;
                int day = i + 1;
                String str = d1 + " " + d2 + " " + d; //NO THIS IS IT!
                series.getData().addAll(new XYChart.Data("Day " + day, d));
                datatxt[i] = new Label(str);

                //vbox.getChildren().add(datatxt[i]);
            }
        } else {

        }//scenetitle.setStyle("-fx-text-fill: grey;");
        String analyzedData = analyzeData(sessions);
        Label h5 = new Label(analyzedData);
        h5.setFont(font);
        //Setting the alignment to the label
        h5.setTextAlignment(TextAlignment.JUSTIFY);
        h5.setAlignment(Pos.CENTER);
        h5.setWrapText(true);
        // scenetitle added earlier : scenetitle = hello name
        // h2 = here are you insights
        // vbox = graph
        // h5 = analyzed data
        // sessiontime = button that starts a session
        grid1.setPadding(ssnI);
        grid1.getChildren().addAll(h2, vbox, h5);
        setCenter(grid1);
        setBottom(tabBar);
    }

    public String analyzeData(Sessions sessions) {
        ArrayList<Double> feeling1 = sessions.getFeelings1();
        ArrayList<Double> feeling2 = sessions.getFeelings2();
        String response = "";
        int n = feeling1.size();
        double errthd = 4;
        int nP = 0;
        int nN = 0;
        ArrayList<Double> differences = new ArrayList<Double>();
        for (int i = 0; i < n - 1; i++) {
            differences.add(i, (feeling2.get(i)) - (feeling1.get(i)));
            if (differences.get(i).doubleValue() > errthd) {
                nP++;
            } else if (differences.get(i).doubleValue() < -errthd) {
                nN++;
            }
        }
        
        if(n != 1) {
        switch (nP - nN) {
            case 4:
                response = "You have shown amazing progress. I'm so proud of all that you have accomplished!";
                break;
            case 3:
                response = "Our sessions have helped you a lot since our first visit! I'm glad I was able to help.";
                break;
            case 2:
                response = "You have shown great progress. Keep it up!";
                break;
            case 1:
                response = "You have been slowly improving since our first session! Keep going, you are doing well.";
                break;
            case 0: //                                                                                                                                                       Therabot has recorded your session.                                                                                                                                                                                                                                                                                                                                                                                                                                                               Therabot has recorded your session. 
                response = "Welcome! I'm Therabot, and I'm here to provide you with unlimited, judgement-free sessions for you to reflect on whatever you would like to discuss. I'm so glad that you're here! Feel free to explore the app and make it your own. I want you to feel comfortable here, so if you have any questions, comments, or concerns, reach out to our CEO and founder, Arietta Goshtasby, at apptherabot@gmail.com. Oh, and one more thing: over time, you will start to see your data pop up here, so feel free to start some sessions and observe your progress over here!";
                break;
            case -1:
                response = "It seems that our sessions have not helped your mood increase. Hopefully we can change that!";
                break;
            case -2:
                response = "Looks like you have not shown much  improvement since our first session. Let's try again next time!";
                break;
            case -3:
                response = "It appears that your sessions have not improved your mood. Ion't give up!";
                break;
            case -4:
                response = "It seems as though you have not been improving since our first session. Let's keep trying!";
                break;
            default:
                if (nP - nN > 4) {
                    response = "You are progressing outstandingly! I'm so glad that I could support you.";
                } else if (nP - nN < -4) {
                    response = "It looks as though you have not improved over the course of our sessions. Let's stay motivated for next time!";
                } else {
                    response = "Sorry, there's a problem. Please check back tomorrow!";
                }
        }
        } else {
            response = "I don't have enough data to calculate a progress report yet, but once you complete your second session, I will display it here!";
        }
        return response;
    }

    public void startSession(Sessions sessions, Session session, String uid, String pass) {
        HBox tabBar = bottomNav(sessions, session, uid, pass);
        Font font = new Font("Comfortaa", 20);
        Font font1 = new Font("Comfortaa", 15);

        TextField speak = new TextField();
        speak.setId("speak");
//        speak.setStyle("-fx-text-fill: white;");
//        speak.setStyle("-fx-text-inner-color: white;");
//        if("DARK".equals(grid1.getScene())) {
//            speak.setStyle("-fx-text-fill: white;");
//        }
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

        Button next2 = new Button("Next");
        next2.setFont(font);
        next2.setStyle("-fx-background-color: rgb(253, 181, 21);");
        // next2.setGraphic(new ImageView(image1));
        Button next1 = new Button("Next");
        next1.setFont(font);
        next1.setStyle("-fx-background-color: rgb(253, 181, 21);");
        // next1.setGraphic(new ImageView(image1));
        VBox gridpane = new VBox();
        gridpane.setAlignment(Pos.CENTER);
        Insets insets = new Insets(10, 10, 10, 10);
        gridpane.setPadding(insets);
        Label sFNam = new Label("Hi, " + uid + "! Welcome to your \njudgement-free session. Let's get\nstarted.\n\n");
        sFNam.setFont(font);
        sFNam.setTextAlignment(TextAlignment.JUSTIFY);
        sFNam.setAlignment(Pos.CENTER);
        sFNam.setWrapText(true);
        Pane sFName = new Pane(sFNam);

        Label mood = new Label("Rate your day from 1-100.\n\n");
        mood.setFont(font1);
        Label talk = new Label("\n\nTell me a bit about your day.\n\n");
        talk.setFont(font1);
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
        gridpane.getChildren().add(sFName);
        gridpane.getChildren().add(mood);
        gridpane.getChildren().add(sb1);
        gridpane.getChildren().add(talk);
        gridpane.getChildren().add(speak);
        Label label = new Label("\n");
        // Include an HBox as a part of the interface
        HBox hBox = new HBox(5);// Leave 5 pixels gap between adjacent objects
        hBox.setAlignment(Pos.CENTER);
        // Include next, clear, and done in the HBox
        hBox.setSpacing(5);
        hBox.getChildren().addAll(clear, done, next);
        gridpane.getChildren().add(label);
        gridpane.getChildren().add(hBox);// Place hBox within the GridPane at column 1 and row 3
        setBottom(tabBar);
        setCenter(gridpane);

        // Take appropriate actions when pressing one of the buttons
        // make two next buttons and revise this code below, which is copy of done
        // button
        next.setOnAction(e -> {
            String sentence = speak.getText();
            session.addSentence(sentence);
            GridPane gridpane2 = new GridPane();
            gridpane2.setAlignment(Pos.CENTER);
            Insets inset = new Insets(10, 10, 10, 10);
            gridpane2.setPadding(inset);
            gridpane2.setVgap(10);
            gridpane2.setHgap(10);
            if (session.getFeeling1() > 49) {
                Label talk2 = new Label("Ok, what made today good?");
                talk2.setFont(font);
                talk2.setWrapText(true);
                gridpane2.add(talk2, 0, 0);
            } else {
                Label talk2 = new Label("Let's take a deep breath. What was not good about today?");
                talk2.setFont(font);
                talk2.setWrapText(true);
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
            gridpane1.setAlignment(Pos.CENTER);
            Insets inset = new Insets(10, 10, 10, 10);
            gridpane1.setPadding(inset);
            gridpane1.setVgap(10);
            gridpane1.setHgap(10);
            Label newmood = new Label("Take a moment to reflect. How are you feeling after our session?");
            newmood.setWrapText(true);
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
            gridpane2.setAlignment(Pos.CENTER);
            Insets inset = new Insets(10, 10, 10, 10);
            gridpane2.setPadding(inset);
            gridpane2.setVgap(10);
            gridpane2.setHgap(10);
            Label talk3 = new Label(msgs[m]);
            talk3.setWrapText(true);
            talk3.setFont(font);
            gridpane2.add(talk3, 0, 0);
            gridpane2.add(speak, 0, 1);
            speak.clear();
            HBox hbox = new HBox(5);
            hbox.setAlignment(Pos.CENTER);
            hbox.getChildren().addAll(clear1, done, next1);
            gridpane2.add(hbox, 0, 2);

            setCenter(gridpane2);

            if (m < 3) {
                m++;
            }
        });

        next2.setOnAction(e -> {
            //System.out.println(sessions.getMode());
            sessions.addSession(session);
            sessions.saveSessions();
            // Use a GridPane to create a login interface insights 
            VBox grid = new VBox();
            grid.setAlignment(Pos.CENTER);
            grid.setPadding(new Insets(25, 25, 25, 25));
            //grid.setStyle("-fx-background-color: black;");

            // START OF LINES
            Line line = new Line(10, 10, 10, 20);
            line.setStrokeWidth(5);
            line.setRotate(25);
            line.setStroke(Color.YELLOW);
            line.setLayoutX(10);
            line.setLayoutY(0);
            TranslateTransition t = new TranslateTransition();
            t.setDuration(Duration.seconds(8));
            t.setAutoReverse(false);
            t.setCycleCount(8000);
            t.setToX(0);
            t.setToY(100);
            t.setNode(line);
            t.play();

            Line line1 = new Line(10, 10, 10, 20);
            line1.setStrokeWidth(5);
            line1.setRotate(-25);
            line1.setStroke(Color.PURPLE);
            line1.setLayoutX(55);
            line1.setLayoutY(20);
            TranslateTransition t1 = new TranslateTransition();
            t1.setDuration(Duration.seconds(8));
            t1.setAutoReverse(false);
            t1.setCycleCount(8000);
            t1.setToX(35);
            t1.setToY(100);
            t1.setNode(line1);
            t1.play();

            /*Line line2 = new Line(10,10,10,20);
		line2.setStrokeWidth(5);
		line2.setRotate(30);
		line2.setStroke(Color.PURPLE);
		line2.setLayoutX(70);
		line2.setLayoutY(10);
		TranslateTransition t2 = new TranslateTransition();
		t2.setDuration(Duration.seconds(8));
		t2.setAutoReverse(false);
		t2.setCycleCount(8000);
		t2.setToX(40);
		t2.setToY(100);
		t2.setNode(line2);
		t2.play();*/
            Line line3 = new Line(10, 10, 10, 20);
            line3.setStrokeWidth(5);
            line3.setRotate(10);
            line3.setStroke(Color.GREENYELLOW);
            line3.setLayoutX(80);
            line3.setLayoutY(10);
            TranslateTransition t3 = new TranslateTransition();
            t3.setDuration(Duration.seconds(8));
            t3.setAutoReverse(false);
            t3.setCycleCount(8000);
            t3.setToX(60);
            t3.setToY(100);
            t3.setNode(line3);
            t3.play();

            Line line4 = new Line(10, 10, 10, 20);
            line4.setStrokeWidth(5);
            line4.setRotate(10);
            line4.setStroke(Color.RED);
            line4.setLayoutX(100);
            line4.setLayoutY(5);
            TranslateTransition t4 = new TranslateTransition();
            t4.setDuration(Duration.seconds(8));
            t4.setAutoReverse(false);
            t4.setCycleCount(8000);
            t4.setToX(80);
            t4.setToY(100);
            t4.setNode(line4);
            t4.play();

            Line line5 = new Line(10, 10, 10, 20);
            line5.setStrokeWidth(5);
            line5.setRotate(-20);
            line5.setStroke(Color.LIGHTSKYBLUE);
            line5.setLayoutX(150);
            line5.setLayoutY(20);
            TranslateTransition t5 = new TranslateTransition();
            t5.setDuration(Duration.seconds(8));
            t5.setAutoReverse(false);
            t5.setCycleCount(8000);
            t5.setToX(120);
            t5.setToY(100);
            t5.setNode(line5);
            t5.play();

            Line line6 = new Line(10, 10, 10, 20);
            line6.setStrokeWidth(5);
            line6.setRotate(-10);
            line6.setStroke(Color.ORANGE);
            line6.setLayoutX(190);
            line6.setLayoutY(0);
            TranslateTransition t6 = new TranslateTransition();
            t6.setDuration(Duration.seconds(8));
            t6.setAutoReverse(false);
            t6.setCycleCount(8000);
            t6.setToX(160);
            t6.setToY(100);
            t6.setNode(line6);
            t6.play();
            // END OF LINES

            Pane root = new Pane();

            root.getChildren().addAll(line, line1, line3, line4, line5, line6);
            grid.getChildren().add(root);

            Label scenetitle = new Label("Woohoo! You did it!");
            scenetitle.setFont(font);
            scenetitle.setWrapText(true);
            //scenetitle.setAlignment(Pos.TOP_LEFT);
            grid.getChildren().add(scenetitle);
            //scenetitle.setStyle("-fx-text-fill: grey;");
            Label h2 = new Label("Therabot has recorded your session.");
            h2.setWrapText(true);
            h2.setFont(font1);

            //scenetitle.setStyle("-fx-text-fill: grey;"); 
            grid.getChildren().addAll(h2);

            setCenter(grid);
            setBottom(tabBar);
            m = 0;
        });
    }

    public HBox bottomNav(Sessions sessions, Session session, String uid, String pass) {
        HBox tabBar = new HBox();
        tabBar.setAlignment(Pos.CENTER);
        tabBar.setSpacing(40);
        tabBar.setPrefHeight(50);
        Button home = new Button();
        home.setStyle("-fx-background-radius: 50; -fx-background-color: rgb(0, 0, 0, 0);");
        Icon homeicon = new Icon(MaterialDesignIcon.HOME);
        home.setGraphic(homeicon);
        home.setOnAction(e -> {
            homeScreen(sessions, session, uid, pass);
        });
        Button newSession = new Button();
        newSession.setId("newSession");
        //newSession.setStyle("-fx-background-radius: 50;");
        newSession.setPrefSize(50, 50);
        Pane pane = new Pane(newSession);
        // or ADD_CIRCLE
        Icon sessionicon = new Icon(MaterialDesignIcon.ADD_CIRCLE_OUTLINE);
        newSession.setGraphic(sessionicon);
        newSession.setOnAction(e -> {
            sessionicon.setStyle("-fx-background-color: rgb(253, 181, 21);");
            startSession(sessions, session, uid, pass);
        });
        Button settings = new Button();
        settings.setStyle("-fx-background-radius: 50; -fx-background-color: rgb(0, 0, 0, 0);");
        Icon settingsicon = new Icon(MaterialDesignIcon.SETTINGS);
        settings.setGraphic(settingsicon);
        settings.setOnAction(e -> {
            getApplication().getDrawer().open();
        });
        tabBar.getChildren().addAll(home, pane, settings);
        tabBar.setStyle("-fx-background-color: rgb(253, 181, 21, 0.5);");
        return tabBar;
    }

    @Override
    protected void updateAppBar(AppBar appBar) {
        appBar.setManaged(false);
        appBar.setVisible(false);
    }

}

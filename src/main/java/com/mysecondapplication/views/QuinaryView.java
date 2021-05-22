package com.mysecondapplication.views;

import com.gluonhq.charm.glisten.animation.BounceInRightTransition;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.control.BottomNavigation;
import com.gluonhq.charm.glisten.control.FloatingActionButton;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import com.mysecondapplication.views.Session;
import com.mysecondapplication.views.Sessions;
import javafx.animation.TranslateTransition;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class QuinaryView extends View {

    public QuinaryView() {
        
        getStylesheets().add(TertiaryView.class.getResource("quinary.css").toExternalForm());
         
        Font font = new Font("Comfortaa", 15);
        Font font1 = new Font("Comfortaa", 24);
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
        root.setStyle("-fx-background-color: white;");
        root.getChildren().addAll(line, line1, line3, line4, line5, line6);
        grid.getChildren().add(root);

        Label scenetitle = new Label("Woohoo! You did it!");
        scenetitle.setFont(font1);
        //scenetitle.setAlignment(Pos.TOP_LEFT);
        grid.getChildren().add(scenetitle);
        //scenetitle.setStyle("-fx-text-fill: grey;");
        Label h2 = new Label("Therabot has recorded your session.");
        h2.setFont(font);
        //scenetitle.setStyle("-fx-text-fill: grey;"); 
        grid.getChildren().add(h2);

        setCenter(grid);
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

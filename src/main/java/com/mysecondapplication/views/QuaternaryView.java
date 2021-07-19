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
import static com.gluonhq.charm.glisten.visual.Theme.DARK;
import static com.gluonhq.charm.glisten.visual.Theme.LIGHT;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.Slider;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import com.mysecondapplication.views.Session;
import com.mysecondapplication.views.Sessions;
import javafx.scene.text.Text;

public class QuaternaryView extends View {
    
    boolean light = true;

    public QuaternaryView() {

        getStylesheets().add(QuaternaryView.class.getResource("quaternary.css").toExternalForm());

        Font font = new Font("Comfortaa", 15);
        Font font1 = new Font("Comfortaa", 24);
        // Use a GridPane to create a login interface insights 
        VBox grid = new VBox();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(25, 25, 25, 25));
        //grid.setStyle("-fx-background-color: black;");

        Label scenetitle = new Label("Appearance");
        scenetitle.setFont(font1);
        //scenetitle.setAlignment(Pos.TOP_LEFT);
        grid.getChildren().add(scenetitle);
        //scenetitle.setStyle("-fx-text-fill: grey;");
        Label h2 = new Label("Change the appearence of your sessions:");
        h2.setWrapText(true);
        h2.setFont(font);
        //scenetitle.setStyle("-fx-text-fill: grey;");
//        if(Session.getMode() = true) {
//            
//        }
        Pane mode = mode();
        grid.getChildren().addAll(h2, mode);
        
        setCenter(grid);
    }
    
    // flag boolean based on current setting???
    
    //Session session = new Session(id, pass);
    
    public Pane mode() {
        Pane but = new Pane();
        CheckBox button = new CheckBox();
        if("LIGHT".equals(but.getScene())) {
            light = true;
            //session.setMode(light);
        } else if("DARK".equals(but.getScene())) {
            light = false;
        } else {
            System.out.println("but.getScene().toString() is neither LIGHT nor DARK");
        }
        System.out.println(light + " :should be true.");
        if(light = true) {
            button.setText("Dark Mode");
            button.setOnMousePressed( e -> {
                light = false;
                DARK.assignTo(button.getScene());
                button.setText("Light Mode");
                button.setOnMousePressed( b -> {
                    light = true;
                    button.setText("This button has been disabled due to\nspam concerns. Check back later!");
                    button.setWrapText(true);
                    LIGHT.assignTo(button.getScene());
                });
            });
        } else {
            button.setText("Light Mode");
            button.setOnMousePressed( e -> {
                light = true;
                LIGHT.assignTo(button.getScene());
                button.setText("Dark Mode");
                    button.setOnMousePressed( b -> {
                    light = false;
                    button.setText("This button has been disabled due to\nspam concerns. Check back later!");
                    button.setWrapText(true);
                    DARK.assignTo(button.getScene());
                });
            });
        }
        but.getChildren().add(button);
        return but;
    }
    
//    public static void changeMode(boolean light, CheckBox button) {
//        if(light = true) {
//            light = false;
//            DARK.assignTo(button.getScene());
//            button.setText("Light Mode");
//        } else if(light = false) {
//            light = true;
//            LIGHT.assignTo(button.getScene());
//            button.setText("Dark Mode");
//        } else {
//            System.out.println("Error. Light is neither true nor false.");
//        }
//    }
    
    @Override
    protected void updateAppBar(AppBar appBar) {
        appBar.setNavIcon(MaterialDesignIcon.DRAG_HANDLE.button(e -> getApplication().getDrawer().open()));
        appBar.setTitleText("Settings/Appearance");
    }
}

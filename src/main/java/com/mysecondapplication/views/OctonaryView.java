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

public class OctonaryView extends View {

    public OctonaryView() {
        
        getStylesheets().add(QuaternaryView.class.getResource("octonary.css").toExternalForm());
                
       Font font = new Font("Comfortaa", 15);
		Font font1 = new Font("Comfortaa", 24);
        // Use a GridPane to create a login interface insights 
		VBox grid = new VBox();
		grid.setAlignment(Pos.CENTER);
		grid.setPadding(new Insets(25, 25, 25, 25));
		//grid.setStyle("-fx-background-color: black;");
                

		Label scenetitle = new Label("Settings");
		scenetitle.setFont(font1);
                //scenetitle.setAlignment(Pos.TOP_LEFT);
                grid.getChildren().add(scenetitle);
                //scenetitle.setStyle("-fx-text-fill: grey;");
                Label h2 = new Label("Your profile\nLight/dark mode\nSee our Terms and Conditions");
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

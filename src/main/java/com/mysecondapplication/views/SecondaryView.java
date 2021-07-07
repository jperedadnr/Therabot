package com.mysecondapplication.views;

import com.gluonhq.charm.glisten.animation.BounceInRightTransition;
import com.gluonhq.charm.glisten.application.MobileApplication;
import static com.gluonhq.charm.glisten.application.MobileApplication.HOME_VIEW;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.control.FloatingActionButton;
import com.gluonhq.charm.glisten.control.Icon;
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
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class SecondaryView extends View {

    public SecondaryView() {

        getStylesheets().add(SecondaryView.class.getResource("secondary.css").toExternalForm());

        Font font = new Font("Comfortaa", 15);
        Font font1 = new Font("Comfortaa", 24);
        // Use a GridPane to create a login interface insights 
        VBox main = new VBox();
        main.setAlignment(Pos.CENTER);
        Insets insets = new Insets(25, 25, 25, 25);
        main.setPadding(insets);
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(insets);
        
        //grid.setStyle("-fx-background-color: black;");

        Label scenetitle = new Label("Account");
        scenetitle.setFont(font1);
        //scenetitle.setAlignment(Pos.TOP_LEFT);
        main.getChildren().add(scenetitle);
        //scenetitle.setStyle("-fx-text-fill: grey;");
        Icon icon = new Icon(MaterialDesignIcon.MOOD);
        icon.setScaleX(5);
        icon.setScaleY(5);
        icon.setStyle("-fx-fill: rgb(253, 181, 21);");
        grid.add(icon, 0, 0);
        
        main.getChildren().add(grid);

        setCenter(main);
    }
    
    @Override
    protected void updateAppBar(AppBar appBar) {
        appBar.setNavIcon(MaterialDesignIcon.DRAG_HANDLE.button(e -> getApplication().getDrawer().open()));
        appBar.setTitleText("Settings/Account");
    }

}

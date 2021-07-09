package com.mysecondapplication.views;

import com.gluonhq.charm.glisten.animation.BounceInRightTransition;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.control.BottomNavigation;
import com.gluonhq.charm.glisten.control.FloatingActionButton;
import com.gluonhq.charm.glisten.control.Icon;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
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
        String s = "https://therabot.ml";
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.browse(URI.create(s));
            } catch (IOException ex) {
                Logger.getLogger(QuinaryView.class.getName()).log(Level.SEVERE, null, ex);
            }

        Label scenetitle = new Label("Our Website");
        scenetitle.setFont(font1);
        //scenetitle.setAlignment(Pos.TOP_LEFT);
        grid.getChildren().add(scenetitle);
        //scenetitle.setStyle("-fx-text-fill: grey;");
        Label h2 = new Label("\n\n");
        h2.setFont(font);
        Label label = new Label("https://therabot.ml");
        Button button = new Button("Visit Our Website!");
        button.setGraphic(new Icon(MaterialDesignIcon.ASSIGNMENT));
        button.setOnAction(e -> {
            try {
                desktop.browse(URI.create(s));
            } catch (IOException ex) {
                Logger.getLogger(QuinaryView.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        //scenetitle.setStyle("-fx-text-fill: grey;");
        grid.getChildren().addAll(h2, label, button);

        setCenter(grid);
    }

   @Override
    protected void updateAppBar(AppBar appBar) {
        appBar.setNavIcon(MaterialDesignIcon.DRAG_HANDLE.button(e -> getApplication().getDrawer().open()));
        appBar.setTitleText("Settings/Our Website");
    }
}

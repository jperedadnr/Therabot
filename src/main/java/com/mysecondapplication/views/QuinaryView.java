package com.mysecondapplication.views;

import com.gluonhq.charm.glisten.animation.BounceInRightTransition;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.control.BottomNavigation;
import com.gluonhq.charm.glisten.control.FloatingActionButton;
import com.gluonhq.charm.glisten.control.Icon;
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
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;

public class QuinaryView extends View {

    public QuinaryView() {

        getStylesheets().add(TertiaryView.class.getResource("quinary.css").toExternalForm());

        getStylesheets().add(QuaternaryView.class.getResource("senary.css").toExternalForm());

        Font font = new Font("Comfortaa", 15);
        Font font1 = new Font("Comfortaa", 24);
        // Use a GridPane to create a login interface insights 
        VBox grid = new VBox();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(25, 25, 25, 25));
        //grid.setStyle("-fx-background-color: black;");

        Label scenetitle = new Label("Credits");
        scenetitle.setFont(font1);
        scenetitle.setTextAlignment(TextAlignment.JUSTIFY);
        scenetitle.setAlignment(Pos.CENTER);
        scenetitle.setWrapText(true);
        //scenetitle.setAlignment(Pos.TOP_LEFT);
        grid.getChildren().add(scenetitle);
        Label h2 = new Label("\n\n\nAll the best,\nThe Therabot Team");
        h2.setTextAlignment(TextAlignment.JUSTIFY);
        h2.setAlignment(Pos.CENTER);
        h2.setWrapText(true);
        h2.setFont(font);
        grid.getChildren().add(h2);

        setCenter(grid);
    }

    @Override
    protected void updateAppBar(AppBar appBar) {
        appBar.setNavIcon(MaterialDesignIcon.DRAG_HANDLE.button(e -> getApplication().getDrawer().open()));
        appBar.setTitleText("Settings/Credits");
    }
    
}

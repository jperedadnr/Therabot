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
        Label h1 = new Label("Firstly, thank you to Gluon for providing me with a free developer license for this project. Furthermore, I would like to thank the Gluon staff for all of their support. Secondly, I would like to give a huge shoutout and thank you to the Invisalign company for seeing my potential and awarding me with a generous grant to continue Therabot's development. Thirdly, I want to extend a very special thank you to my grandfather, Arthur Goshtasby, PhD., for his guidence during this project, as well as fostering my inital spark of interest in coding. I would also like to thank to my parents for all of the love and encouragement extended to me during the making of this project. Similarly, I would like to thank my friends for lifting me up during times when I felt discouraged. Lastly, I would especially like to thank you, the app user, for allowing my dream to become a reality. You are the reason why I keep going.");
        h1.setTextAlignment(TextAlignment.JUSTIFY);
        h1.setAlignment(Pos.CENTER);
        h1.setWrapText(true);
        Font small = new Font("Comfortaa", 13);
        h1.setFont(small);
        grid.getChildren().add(h1);
        Label h2 = new Label("\nSincerely,\nArietta Goshtasby, Founder and CEO of Therabot");
        h2.setTextAlignment(TextAlignment.JUSTIFY);
        h2.setAlignment(Pos.CENTER);
        h2.setWrapText(true);
        h2.setFont(small);
        grid.getChildren().add(h2);

        setCenter(grid);
    }

    @Override
    protected void updateAppBar(AppBar appBar) {
        appBar.setNavIcon(MaterialDesignIcon.DRAG_HANDLE.button(e -> getApplication().getDrawer().open()));
        appBar.setTitleText("Settings/Credits");
    }
    
}

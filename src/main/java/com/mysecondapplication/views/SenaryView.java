package com.mysecondapplication.views;

import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.control.Icon;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import com.mysecondapplication.utils.BrowseUtils;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class SenaryView extends View {

    public SenaryView() {

        getStylesheets().add(QuaternaryView.class.getResource("senary.css").toExternalForm());

        Font font = new Font("Comfortaa", 15);
        Font font1 = new Font("Comfortaa", 24);
        // Use a GridPane to create a login interface insights 
        VBox grid = new VBox();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(25, 25, 25, 25));
        //grid.setStyle("-fx-background-color: black;");
        String s = "https://therabot.ml/help.html";
        BrowseUtils.browse(s);

        Label scenetitle = new Label("Our FAQ Page");
        scenetitle.setFont(font1);
        //scenetitle.setAlignment(Pos.TOP_LEFT);
        grid.getChildren().add(scenetitle);
        //scenetitle.setStyle("-fx-text-fill: grey;");
        Label h2 = new Label("\n\n");
        h2.setFont(font);
        Label label = new Label("https://therabot.ml/help.html");
        Button button = new Button("See Our FAQ Page");
        button.setGraphic(new Icon(MaterialDesignIcon.LANGUAGE));
        button.setOnAction(e -> BrowseUtils.browse(s));
        //scenetitle.setStyle("-fx-text-fill: grey;");
        grid.getChildren().addAll(h2, label, button);

        setCenter(grid);
    }

    @Override
    protected void updateAppBar(AppBar appBar) {
        appBar.setNavIcon(MaterialDesignIcon.DRAG_HANDLE.button(e -> getApplication().getDrawer().open()));
        appBar.setTitleText("Settings/Help");
    }
    
}

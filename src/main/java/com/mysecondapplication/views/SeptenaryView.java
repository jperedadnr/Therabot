package com.mysecondapplication.views;

import com.gluonhq.charm.glisten.animation.BounceInRightTransition;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.control.BottomNavigation;
import com.gluonhq.charm.glisten.control.FloatingActionButton;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import java.io.IOException;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.PointLight;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.TranslateTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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

public class SeptenaryView extends View {

    public SeptenaryView() {

        getStylesheets().add(QuaternaryView.class.getResource("septenary.css").toExternalForm());

        Font font = new Font("Comfortaa", 15);
        Font font1 = new Font("Comfortaa", 24);
        // Use a GridPane to create a login interface insights 
        VBox grid = new VBox();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(25, 25, 25, 25));
        //grid.setStyle("-fx-background-color: black;");

        Label scenetitle = new Label("Other Resources");
        scenetitle.setFont(font1);
        //scenetitle.setAlignment(Pos.TOP_LEFT);
        grid.getChildren().add(scenetitle);
        //scenetitle.setStyle("-fx-text-fill: grey;");
        Label h2 = new Label("\nNational Alliance on Mental Illness: 800-950-6264\n"
					+ "Suicide Prevention Line: 1-877-727-4747\n"
					+ "Crisis Assessment Team: 866-830-6011\n"
					+ "Crisis Center: 1-800-273-8255\n"
					+ "Disaster Distress Helpline: 1-800-985-5990\n"
					+ "Mental Health Hotline: 800-662-4357\n"
					+ "National Institute of Mental Health: 866-615-6464\n\n"
					+ "Know that you are not alone in anything that you are feeling. "
                + "If your mental health is not at it's best, please do not hesitate to reach out to any of the "
                + "above resources. These resources exist to support you and people just "
                + "like you.\n\nAll the best,\nThe Therabot Team");
        h2.setTextAlignment(TextAlignment.JUSTIFY);
        h2.setAlignment(Pos.CENTER);
        h2.setWrapText(true);
        h2.setFont(font);
        //scenetitle.setStyle("-fx-text-fill: grey;");
        grid.getChildren().add(h2);

        setCenter(grid);
    }

    @Override
    protected void updateAppBar(AppBar appBar) {
        appBar.setNavIcon(MaterialDesignIcon.DRAG_HANDLE.button(e -> getApplication().getDrawer().open()));
        appBar.setTitleText("Settings/Other Resources");
    }
    
}

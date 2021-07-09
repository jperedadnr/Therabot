package com.mysecondapplication;

import com.mysecondapplication.views.PrimaryView;
import com.mysecondapplication.views.SecondaryView;
import com.mysecondapplication.views.TertiaryView;
import com.mysecondapplication.views.QuaternaryView;
//import com.mysecondapplication.views.TertiaryView;
import com.mysecondapplication.views.QuinaryView;
import com.mysecondapplication.views.SenaryView;
import com.mysecondapplication.views.SeptenaryView;
import com.mysecondapplication.views.OctonaryView;
import com.mysecondapplication.views.Session;
import com.mysecondapplication.views.Sessions;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.visual.Swatch;
import static com.gluonhq.charm.glisten.visual.Theme.DARK;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import com.gluonhq.charm.glisten.license.License;
import com.gluonhq.charm.glisten.mvc.SplashView;
import com.gluonhq.charm.glisten.visual.Theme;
import static com.gluonhq.charm.glisten.visual.Theme.LIGHT;
import java.awt.Dimension;
import java.awt.Toolkit;
import javafx.geometry.Insets;
import javafx.geometry.Pos;


import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;

@License(key="e2867f39-916d-43dd-9072-b351a9280c7f")

public class MySecondApplication extends MobileApplication {

    public static final String PRIMARY_VIEW = HOME_VIEW;
    public static final String SECONDARY_VIEW = "Secondary";
    public static final String TERTIARY_VIEW = "Tertiary";
    public static final String QUATERNARY_VIEW = "Quaternary";
    //public static final String TERTIARY_VIEW = "Tertiary";
    public static final String QUINARY_VIEW = "Quinary";
    public static final String SENARY_VIEW = "Senary";
    public static final String SEPTENARY_VIEW = "Septenary";
    public static final String OCTONARY_VIEW = "Octonary";

    @Override
    public void init() {
        // it doesn't like the addViewFactory's
        addViewFactory(PRIMARY_VIEW, PrimaryView::new);
        addViewFactory(SECONDARY_VIEW, SecondaryView::new);
        addViewFactory(TERTIARY_VIEW, TertiaryView::new);
        addViewFactory(QUATERNARY_VIEW, QuaternaryView::new);
        //addViewFactory(TERTIARY_VIEW, TertiaryView::new);
        addViewFactory(QUINARY_VIEW, QuinaryView::new);
        addViewFactory(SENARY_VIEW, SenaryView::new);
        addViewFactory(SEPTENARY_VIEW, SeptenaryView::new);
        addViewFactory(OCTONARY_VIEW, OctonaryView::new);
        
        Image icon = new Image("/icon.png");
        ImageView theraboticon = new ImageView(icon);
        
        addViewFactory(MobileApplication.SPLASH_VIEW, () -> {
            return new SplashView(HOME_VIEW, 
            theraboticon, 
            Duration.seconds(3));
        });

        DrawerManager.buildDrawer(this);
    }
    

    @Override
    public void postInit(Scene scene) {
        Swatch.AMBER.assignTo(scene);
        LIGHT.assignTo(scene);
//        for (Theme c : Theme.values())
//            System.out.println(c);

        scene.getStylesheets().add(MySecondApplication.class.getResource("style.css").toExternalForm());
        ((Stage) scene.getWindow()).getIcons().add(new Image(MySecondApplication.class.getResourceAsStream("/icon.png")));
    }

    public static void main(String args[]) {
        launch(args);
    }
}

package com.mysecondapplication;

import com.gluonhq.attach.lifecycle.LifecycleService;
import com.gluonhq.attach.util.Platform;
import com.gluonhq.attach.util.Services;
import com.mysecondapplication.views.Session;
import com.mysecondapplication.views.Sessions;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.application.ViewStackPolicy;
import com.gluonhq.charm.glisten.control.Avatar;
import com.gluonhq.charm.glisten.control.NavigationDrawer;
import com.gluonhq.charm.glisten.control.NavigationDrawer.Item;
import com.gluonhq.charm.glisten.control.NavigationDrawer.ViewItem;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import javafx.scene.image.Image;

import static com.mysecondapplication.MySecondApplication.PRIMARY_VIEW;
import static com.mysecondapplication.MySecondApplication.SECONDARY_VIEW;
import static com.mysecondapplication.MySecondApplication.TERTIARY_VIEW;
import static com.mysecondapplication.MySecondApplication.QUATERNARY_VIEW;
//import static com.mysecondapplication.MySecondApplication.TERTIARY_VIEW;
import static com.mysecondapplication.MySecondApplication.QUINARY_VIEW;
import static com.mysecondapplication.MySecondApplication.SENARY_VIEW;
import static com.mysecondapplication.MySecondApplication.SEPTENARY_VIEW;
import static com.mysecondapplication.MySecondApplication.OCTONARY_VIEW;

public class DrawerManager {

    public static void buildDrawer(MobileApplication app) {
        NavigationDrawer drawer = app.getDrawer();
        
        NavigationDrawer.Header header = new NavigationDrawer.Header("Therabot",
                "A Self-Reflection Application",
                new Avatar(21, new Image(DrawerManager.class.getResourceAsStream("/icon.png"))));
        drawer.setHeader(header);
        
        final Item primaryItem = new ViewItem("Log In", MaterialDesignIcon.ADD.graphic(), PRIMARY_VIEW, ViewStackPolicy.SKIP);
        final Item secondaryItem = new ViewItem("Sign In", MaterialDesignIcon.LOCAL_FLORIST.graphic(), SECONDARY_VIEW);
        final Item tertiaryItem = new ViewItem("Home", MaterialDesignIcon.HOME.graphic(), TERTIARY_VIEW);
        final Item quaternaryItem = new ViewItem("Session Start", MaterialDesignIcon.CHAT.graphic(), QUATERNARY_VIEW);
        //final Item tertiaryItem = new ViewItem("Home", MaterialDesignIcon.HOME.graphic(), TERTIARY_VIEW);
        final Item quinaryItem = new ViewItem("Session Journals", MaterialDesignIcon.SETTINGS.graphic(), QUINARY_VIEW);
        final Item senaryItem = new ViewItem("Session End", MaterialDesignIcon.MOOD_BAD.graphic(), SENARY_VIEW);
        final Item septenaryItem = new ViewItem("Thank You", MaterialDesignIcon.PHONE_IPHONE.graphic(), SEPTENARY_VIEW);
        final Item octonaryItem = new ViewItem("Settings", MaterialDesignIcon.PHONE_ANDROID.graphic(), OCTONARY_VIEW);
        //final Item octonaryItem = new ViewItem("Settings", MaterialDesignIcon.PHONE_ANDROID.graphic(), OCTONARY_VIEW);
        drawer.getItems().addAll(primaryItem, secondaryItem, tertiaryItem, quaternaryItem, quinaryItem, senaryItem, septenaryItem, octonaryItem);
        
        if (Platform.isDesktop()) {
            final Item quitItem = new Item("Quit", MaterialDesignIcon.EXIT_TO_APP.graphic());
            quitItem.selectedProperty().addListener((obs, ov, nv) -> {
                if (nv) {
                    Services.get(LifecycleService.class).ifPresent(LifecycleService::shutdown);
                }
            });
            drawer.getItems().add(quitItem);
        }
    }
}

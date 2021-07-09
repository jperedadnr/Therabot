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
        
        final Item primaryItem = new ViewItem("Back to Therabot", MaterialDesignIcon.ARROW_BACK.graphic(), PRIMARY_VIEW, ViewStackPolicy.SKIP);
        //final Item secondaryItem = new ViewItem("My Account", MaterialDesignIcon.LOCAL_FLORIST.graphic(), SECONDARY_VIEW);
        final Item tertiaryItem = new ViewItem("Terms of Service", MaterialDesignIcon.ASSIGNMENT.graphic(), TERTIARY_VIEW);
        final Item quaternaryItem = new ViewItem("Appearance", MaterialDesignIcon.FACE.graphic(), QUATERNARY_VIEW);
        //final Item tertiaryItem = new ViewItem("Home", MaterialDesignIcon.HOME.graphic(), TERTIARY_VIEW);
        //final Item quinaryItem = new ViewItem("Credits", MaterialDesignIcon.CARD_GIFTCARD.graphic(), QUINARY_VIEW);
        final Item senaryItem = new ViewItem("Help", MaterialDesignIcon.HELP.graphic(), SENARY_VIEW);
        final Item septenaryItem = new ViewItem("Other Resources", MaterialDesignIcon.FAVORITE.graphic(), SEPTENARY_VIEW);
        final Item octonaryItem = new ViewItem("Our Website", MaterialDesignIcon.WEB.graphic(), OCTONARY_VIEW);
        //final Item octonaryItem = new ViewItem("Settings", MaterialDesignIcon.PHONE_ANDROID.graphic(), OCTONARY_VIEW);
        drawer.getItems().addAll(primaryItem, tertiaryItem, quaternaryItem, senaryItem, septenaryItem, octonaryItem);
        
    }
}

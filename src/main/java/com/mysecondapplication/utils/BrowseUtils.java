package com.mysecondapplication.utils;


import com.gluonhq.attach.browser.BrowserService;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BrowseUtils {

    public static void browse(String url) {
        BrowserService.create()
            .ifPresentOrElse(service -> {
                // mobile
                    try {
                        service.launchExternalBrowser(url);
                    } catch (IOException | URISyntaxException ex) {
                        Logger.getLogger(BrowseUtils.class.getName()).log(Level.SEVERE, null, ex);
                    }
                },
            () -> {
                    // desktop
                    String os = System.getProperty("os.name").toLowerCase(Locale.ROOT);
                    try {
                        List<String> command = os.contains("mac") ? List.of("open", url) :
                                os.contains("win") ? List.of("rundll32", "url.dll,FileProtocolHandler", url) :
                                        List.of("xdg-open", url);
                        new ProcessBuilder(command).start();
                    } catch (IOException ex) {
                        Logger.getLogger(BrowseUtils.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });
    }
}

import javafx.application.Platform;
import javafx.scene.control.*;;
import javafx.scene.control.ScrollPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.awt.*;

public class mapPane extends ScrollPane {
    private WebView webView;
    private WebEngine webEngine;

    public mapPane(String name) {
        Platform.runLater(() -> {
            initialiseJavaFXScene(name);
        });
    }

    private void initialiseJavaFXScene(String name) {
        webView = new WebView();
        webEngine = webView.getEngine();
        webEngine.load("http://map.google.com/maps/place/"+name);
        setContent(webView);
        setPrefSize(300,300);
    }
}
import javafx.application.Platform;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class WebDemo extends Pane {
    private WebView webView;
    private WebEngine webEngine;

    public WebDemo() {
        Platform.runLater(() -> {
            initialiseJavaFXScene();
        });
    }

    private void initialiseJavaFXScene() {
        webView = new WebView();
        webEngine = webView.getEngine();
        webEngine.load("http://map.google.com");
        setPrefSize(300,300);
        getChildren().addAll(webView);
    }
}

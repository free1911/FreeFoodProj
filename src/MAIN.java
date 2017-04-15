
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import java.util.ArrayList;

/**
 * This is the main class
 * Call the methods to do the jobs
 */
public class MAIN extends Application{

    private Group root;
    @Override
    public void start(Stage primaryStage) throws Exception {
        Stage window=new Stage();
        window.setTitle("FreeFoodOnCampus");
        window.setResizable(false);
        root =new Group();
        Label label=new Label("FreeFoodOnCampus");
        ScrollBar sc = new ScrollBar();

        dataImport in=new dataImport();
        ArrayList<Event> event=in.getDataBase();
        Button[] jbtEvent=new Button[event.size()];
        for(int i=0;i<event.size();i++){
            jbtEvent[i] =new Button();
            jbtEvent[i].setText(event.get(i).title);
            int id=i;
            jbtEvent[i].setPrefSize(290,50);
        }
        VBox layout=new VBox(0);
        layout.setAlignment(Pos.CENTER);
        for(int i=0;i<event.size();i++)layout.getChildren().add(jbtEvent[i]);
        root.getChildren().addAll(layout,sc);
        Scene scene=new Scene(root,300,400);

        sc.setLayoutX(scene.getWidth()-5);
        sc.setMin(0);
        sc.setOrientation(Orientation.VERTICAL);
        sc.setPrefWidth(5);
        sc.setMax(360);
        sc.setPrefHeight(400);
        sc.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                layout.setLayoutY(-newValue.doubleValue());
            }
        });

        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args){
        launch();
    }
}

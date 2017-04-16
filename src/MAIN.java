import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;



public class MAIN extends Application{
    private Scene eventScene;
    private Scene detailScene;
    private Stage window=new Stage();
    private ArrayList<Event> event=new ArrayList<>();

    public static void main(String[] args){
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        dataImport in=new dataImport();
        event=in.getDataBase();
        VBox layout=new VBox();
        ScrollBar scrollBar=new ScrollBar();
        Pane group1=new Pane();
        Group root=new Group();
        Button[] jbtEvent=new Button[event.size()];
        for(int i=0;i<event.size();i++){
            jbtEvent[i]=new Button(event.get(i).title);
            jbtEvent[i].setFont(new Font("Calibri",24));
            jbtEvent[i].setPrefSize(280,50);
            int id=i;
            jbtEvent[i].setOnAction(e->{
                initialScene(id);
                window.setScene(detailScene);
            });
            layout.getChildren().add(jbtEvent[i]);
        }

        scrollBar.setOrientation(Orientation.VERTICAL);
        scrollBar.setMax(event.size()*20);
        scrollBar.setMin(0);
        scrollBar.setPrefHeight(350);
        scrollBar.setPrefWidth(10);
        scrollBar.setLayoutX(285);
        scrollBar.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                layout.setLayoutY(-newValue.doubleValue());
            }
        });
        root.getChildren().addAll(layout,scrollBar);
        group1.getChildren().add(root);

        Label title=new Label("FreeFood");
        title.setStyle("-fx-background-color: blue;");
        title.setTextFill(Color.YELLOW);
        title.setAlignment(Pos.BASELINE_CENTER);
        title.setPrefSize(300,50);
        title.setFont(new Font("Calibri",36));
        BorderPane layout2=new BorderPane();


        layout2.setCenter(group1);
        layout2.setTop(title);
        eventScene=new Scene(layout2,300,400);
        window.setScene(eventScene);
        window.setTitle("FreeFood");
        window.show();
    }

    public void initialScene(int id){
        Label lb1=new Label(event.get(id).title);
        Label lb2=new Label(event.get(id).location);
        Label lb3=new Label(event.get(id).date);
        Label lb4=new Label(event.get(id).hoster);
        Label lb5=new Label(event.get(id).discription);
        Label lb6=new Label(event.get(id).source);
        Button back=new Button("Back");
        back.setOnAction(event1 -> {
            window.setScene(eventScene);
        });
        VBox layout=new VBox();
        layout.getChildren().addAll(lb1,lb2,lb3,lb4,lb5,lb6,new WebDemo(),back);
        detailScene=new Scene(layout,300,400);
    }

}

package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.geometry.Pos;

public class Main extends Application {
    protected Button Startbtn = new Button("Start");
    protected Button Clearbtn = new Button("Clear");

    @Override
    public void start(Stage primaryStage) {
        HBox paneForButtons = new HBox(5);
        paneForButtons.setAlignment(Pos.CENTER);
        paneForButtons.getChildren().addAll(Startbtn, Clearbtn);
        StopWatch stopWatch = new StopWatch();
        BorderPane pane = new BorderPane();
        pane.setBottom(paneForButtons);
        pane.setCenter(stopWatch);

        Startbtn.setOnAction(e -> {
            if (Startbtn.getText().equals("Start") ||
                    Startbtn.getText().equals("Resume")) {
                stopWatch.play();
                Startbtn.setText("Pause");
            } else {
                stopWatch.pause();
                Startbtn.setText("Resume");
            }
        });

        Clearbtn.setOnAction(e -> {
            stopWatch.clear();
        });

        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}


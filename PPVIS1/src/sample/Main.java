package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sample.task1.Director;

public class Main extends Application {

    private final static String PROGRAM_NAME = "Simple GUI Examples";
    private final static int START_WINDOW_WIDTH = 1000;
    private final static int START_WINDOW_HEIGHT = 700;

    @Override
    public void start(Stage primaryStage){
        AnchorPane root = new AnchorPane();
        primaryStage.setTitle(PROGRAM_NAME);
        primaryStage.setScene(new Scene(root, START_WINDOW_WIDTH, START_WINDOW_HEIGHT));
        primaryStage.show();
        new sample.task1.Director(root);
        new sample.task2.Director(root);
        new sample.task3.Director(root);
        new sample.task4.Director(root);
        new sample.task5.Director(root);
    }


    public static void main(String[] args) {
        launch(args);
    }
}

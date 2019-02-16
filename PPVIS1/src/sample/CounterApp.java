package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class CounterApp extends Application {

    private int count1 = 2;
    private final Text text = new Text("vlad");
    private final Text text1 = new Text(Integer.toString(count1));
    private HBox hbox;
    private Integer COMPONENTS_NUMBER = 2;

    private void incrementCount() {
        List<Node> nodes = hbox.getChildren();
        List<Node> newNodes = new ArrayList<>();
        newNodes.add(nodes.get(COMPONENTS_NUMBER - 1));
        for (int i = 0; i < COMPONENTS_NUMBER-1; i++) {
            newNodes.add(nodes.get(i));
        }
        hbox.getChildren().removeAll(nodes);
        hbox.getChildren().addAll(newNodes);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void start(Stage primaryStage) {
        HBox root = new HBox();
        this.hbox = root;
        root.getChildren().add(text);
        root.getChildren().add(text1);

        Scene scene = new Scene(root, 200, 200);

        // longrunning operation runs on different thread
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                Runnable updater = new Runnable() {

                    @Override
                    public void run() {
                        incrementCount();
                    }
                };

                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                    }

                    // UI update is run on the Application thread
                    Platform.runLater(updater);
                }
            }

        });
        // don't let thread prevent JVM shutdown
        thread.setDaemon(true);
        thread.start();

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
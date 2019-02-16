package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

public class ApplicationConfig extends Application {

    private final static String PROGRAM_NAME = "Simple GUI Examples";
    private final static int START_WINDOW_WIDTH = 1000;
    private final static int START_WINDOW_HEIGHT = 700;
    private ExecutorService executorService;
    private Button startButton;
    private Button stopButton;

    @Override
    public void start(Stage primaryStage){
        AnchorPane root = new AnchorPane();
        primaryStage.setTitle(PROGRAM_NAME);
        primaryStage.setScene(new Scene(root, START_WINDOW_WIDTH, START_WINDOW_HEIGHT));
        List<Pane> paneList = new ArrayList<>();
        paneList.add(new sample.task1.Director(root).getPane());
        paneList.add(new sample.task2.Director(root).getPane());
        paneList.add(new sample.task3.Director(root).getPane());
        paneList.add(new sample.task4.Director(root).getPane());
        paneList.add(new sample.task5.Director(root).getPane());
        addStartEndButtons(root);
        startMixComponents(root,paneList);
        primaryStage.show();
    }

    private void addStartEndButtons(AnchorPane pane){
        Button startButton = new Button("start");
        this.startButton = startButton;
        Button stopButton = new Button("stop");
        this.stopButton = stopButton;
        pane.getChildren().addAll(startButton, stopButton);
        AnchorPane.setLeftAnchor(startButton, 100d);
    }

    private void startMixComponents(AnchorPane pane,List<Pane> paneList) {
        AtomicBoolean isStop = new AtomicBoolean(false);
        startButton.setOnAction(event -> {
            isStop.set(false);
            System.out.println("start");
            executorService = Executors.newFixedThreadPool(5);
            for(int i = 0; i < 5;i++){
                int finalI = i;
                Thread thread = new Thread(() -> {
                    Runnable updater = () -> move(paneList.get(finalI));
                    while (!isStop.get()) {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException ex) {

                        }
                        Platform.runLater(updater);
                    }
                });
                executorService.execute(thread);
            }
        });

        stopButton.setOnAction(event -> {
            System.out.println("stop");
            isStop.set(true);
            executorService.shutdown();
        });
    }

    private void move(Pane pane) {
        int componentsNumber = pane.getChildren().size();
        List<Node> nodes = pane.getChildren();
        List<Node> newNodes = new ArrayList<>();
        newNodes.add(nodes.get(componentsNumber - 1));
        for (int i = 0; i < componentsNumber-1; i++) {
            newNodes.add(nodes.get(i));
        }
        pane.getChildren().removeAll(nodes);
        pane.getChildren().addAll(newNodes);

    }

    public static void main(String[] args) {
        launch(args);
    }
}

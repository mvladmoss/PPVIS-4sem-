package sample.task2;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class Director {

    private final static String FIRST_BUTTON_NAME = "Change 2 button";
    private final static String SECOND_BUTTON_NAME = "Swap text with first button";

    private ComponentCustomizer customizer = new ComponentCustomizer();
    private Button firstButton;
    private Button secondButton;
    private TextField textField;

    public Director(Pane pane){
        HBox hBox = new HBox();
        customizer.customizeMainPane(hBox);
        pane.getChildren().add(hBox);
        customizeComponents(hBox);
        setListeners();
    }

    private void setListeners(){
        LogicImplementation logicImplementation = new LogicImplementation();
        firstButton.setOnAction(event -> {
            logicImplementation.setActionOnFirstButton(secondButton,textField);
        });

        secondButton.setOnAction(event -> {
            logicImplementation.setActionOnSecondButton(firstButton,secondButton);
        });
    }

    private void customizeComponents(Pane pane){
        addFirstButton(pane);
        addSecondButton(pane);
        addTextField(pane);
    }

    private void addFirstButton(Pane pane){
        Button firstButton = new Button();
        this.firstButton = firstButton;
        customizer.customizeButton(firstButton,FIRST_BUTTON_NAME);
        pane.getChildren().add(firstButton);

    }

    private void addSecondButton(Pane pane){
        Button secondButton = new Button();
        this.secondButton = secondButton;
        customizer.customizeButton(secondButton,SECOND_BUTTON_NAME);
        pane.getChildren().add(secondButton);
    }

    private void addTextField(Pane pane){
        TextField textField = new TextField();
        this.textField = textField;
        customizer.customizeTextField(textField);
        pane.getChildren().add(textField);
    }

}

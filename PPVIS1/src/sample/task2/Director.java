package sample.task2;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class Director {

    private final static String FIRST_BUTTON_NAME = "Change 2 button";
    private final static String SECOND_BUTTON_NAME = "Swap text with first button";
    private final static Integer PREF_WIDTH = 400;
    private final static Integer PREF_HEIGHT = 150;
    private final static Double TOP_ANCHOR = 20d;
    private final static Double LEFT_ANCHOR = 500d;
    private final static Integer MIN_WIDTH = 100;

    private final static Integer MARGIN_TOP = 50;
    private final static Integer MARGIN_BOTTOM = 0;
    private final static Integer MARGIN_RIGHT = 0;
    private final static Integer MARGIN_LEFT = 10;

    private ComponentCustomizer customizer = new ComponentCustomizer();
    private Button firstButton;
    private Button secondButton;
    private TextField textField;

    public Director(Pane pane){
        HBox hBox = new HBox();
        hBox.setPrefSize(PREF_WIDTH,PREF_HEIGHT);
        hBox.setStyle("-fx-background-color: gray");
        AnchorPane.setTopAnchor(hBox,TOP_ANCHOR);
        AnchorPane.setLeftAnchor(hBox,LEFT_ANCHOR);
        pane.getChildren().add(hBox);
        customizeComponents(hBox);
        setListeners();
    }

    private void setListeners(){
        firstButton.setOnAction(event -> {
            String textFieldText = textField.getText();
            secondButton.setText(textFieldText);});
        secondButton.setOnAction(event -> {
            String firstButtonText = firstButton.getText();
            String secondButtonText = secondButton.getText();
            firstButton.setText(secondButtonText);
            secondButton.setText(firstButtonText);});
    }

    private void customizeComponents(Pane pane){
        Button firstButton = new Button();
        this.firstButton = firstButton;
        firstButton.setMinWidth(MIN_WIDTH);
        firstButton.setId(FIRST_BUTTON_NAME);
        firstButton.setText(FIRST_BUTTON_NAME);
        HBox.setMargin(firstButton,new Insets(MARGIN_TOP,MARGIN_RIGHT,MARGIN_BOTTOM,MARGIN_LEFT));
        pane.getChildren().add(firstButton);

        Button secondButton = new Button();
        this.secondButton = secondButton;
        customizer.customizeButton(secondButton,SECOND_BUTTON_NAME);
        pane.getChildren().add(secondButton);
        secondButton.setMinWidth(MIN_WIDTH);
        secondButton.setId(SECOND_BUTTON_NAME);
        secondButton.setText(SECOND_BUTTON_NAME);
        HBox.setMargin(secondButton,new Insets(MARGIN_TOP,MARGIN_RIGHT,MARGIN_BOTTOM,MARGIN_LEFT));

        TextField textField = new TextField();
        this.textField = textField;
        customizer.customizeTextField(textField);
        pane.getChildren().add(textField);
        textField.setMinWidth(MIN_WIDTH);
        HBox.setMargin(textField,new Insets(MARGIN_TOP,MARGIN_RIGHT,MARGIN_BOTTOM,MARGIN_LEFT));
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

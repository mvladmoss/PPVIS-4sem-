package sample.task3;

import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import sample.Customizer;

import java.util.ArrayList;
import java.util.List;

public class ComponentCustomizer implements Customizer {

    private final static Integer PREF_WIDTH = 400;
    private final static Integer PREF_HEIGHT = 150;
    private final static Double TOP_ANCHOR = 200d;
    private final static Double LEFT_ANCHOR = 20d;
    private final static Integer MIN_WIDTH = 100;

    @Override
    public void customizeMainPane(Pane pane) {
        pane.setPrefSize(PREF_WIDTH,PREF_HEIGHT);
        pane.setStyle("-fx-background-color: gray");
        AnchorPane.setTopAnchor(pane,TOP_ANCHOR);
        AnchorPane.setLeftAnchor(pane,LEFT_ANCHOR);
    }

    void customizeRadioButton(RadioButton radioButton,String name){
        radioButton.setMinWidth(MIN_WIDTH);
        radioButton.setText(name);
    }

    void customizeTextField(TextField textField){
        textField.setMinWidth(MIN_WIDTH);
    }

    public void customizeButton(Button button,String name){
        button.setMinWidth(MIN_WIDTH);
        button.setText(name);
    }
}

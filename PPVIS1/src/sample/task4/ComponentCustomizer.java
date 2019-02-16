package sample.task4;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import sample.Customizer;

public class ComponentCustomizer implements Customizer {

    private final static Integer PREF_WIDTH = 400;
    private final static Integer PREF_HEIGHT = 150;
    private final static Double TOP_ANCHOR = 200d;
    private final static Double LEFT_ANCHOR = 500d;
    private final static Integer MIN_WIDTH = 100;

    @Override
    public void customizeMainPane(Pane pane) {
        pane.setPrefSize(PREF_WIDTH,PREF_HEIGHT);
        pane.setStyle("-fx-background-color: gray");
        AnchorPane.setTopAnchor(pane,TOP_ANCHOR);
        AnchorPane.setLeftAnchor(pane,LEFT_ANCHOR);
    }

    void customizeCheckBox(CheckBox checkBox, String name){
        checkBox.setMinWidth(MIN_WIDTH);
        checkBox.setText(name);
    }

    void customizeTextField(TextField textField){
        textField.setMinWidth(MIN_WIDTH);
    }

    public void customizeButton(Button button,String name){
        button.setMinWidth(MIN_WIDTH);
        button.setText(name);
    }
}

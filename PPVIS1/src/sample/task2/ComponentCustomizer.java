package sample.task2;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import sample.Customizer;

public class ComponentCustomizer implements Customizer {

    private final static Integer PREF_WIDTH = 400;
    private final static Integer PREF_HEIGHT = 150;
    private final static Double TOP_ANCHOR = 20d;
    private final static Double LEFT_ANCHOR = 500d;
    private final static Integer MIN_WIDTH = 100;

    private final static Integer MARGIN_TOP = 50;
    private final static Integer MARGIN_BOTTOM = 0;
    private final static Integer MARGIN_RIGHT = 0;
    private final static Integer MARGIN_LEFT = 10;

    @Override
    public void customizeMainPane(Pane pane) {
        pane.setPrefSize(PREF_WIDTH,PREF_HEIGHT);
        pane.setStyle("-fx-background-color: gray");
        AnchorPane.setTopAnchor(pane,TOP_ANCHOR);
        AnchorPane.setLeftAnchor(pane,LEFT_ANCHOR);
    }

    public void customizeButton(Button button,String buttonName){
        button.setMinWidth(MIN_WIDTH);
        button.setId(buttonName);
        button.setText(buttonName);
        HBox.setMargin(button,new Insets(MARGIN_TOP,MARGIN_RIGHT,MARGIN_BOTTOM,MARGIN_LEFT));
    }

    void customizeTextField(TextField textField){
        textField.setMinWidth(MIN_WIDTH);
        HBox.setMargin(textField,new Insets(MARGIN_TOP,MARGIN_RIGHT,MARGIN_BOTTOM,MARGIN_LEFT));
    }
}

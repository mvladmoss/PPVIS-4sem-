package sample.task1;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import sample.Customizer;

public class ComponentCustomizer implements Customizer {

    private final static Integer PREF_WIDTH = 400;
    private final static Integer PREF_HEIGHT = 150;
    private final static Double ANCHOR = 20d;
    private final static Integer MIN_WIDTH = 100;

    private final static Integer MARGIN_TOP = 50;
    private final static Integer MARGIN_BOTTOM = 0;
    private final static Integer MARGIN_RIGHT = 0;
    private final static Integer MARGIN_LEFT = 10;

    private final static String BUTTON_TEXT = "Add";

    public void customizeMainPane(Pane pane){
        pane.setPrefSize(PREF_WIDTH,PREF_HEIGHT);
        pane.setStyle("-fx-background-color: gray");
        AnchorPane.setTopAnchor(pane,ANCHOR);
        AnchorPane.setLeftAnchor(pane,ANCHOR);
    }

    void customizeComboBox(ComboBox comboBox){
        comboBox.setMinWidth(MIN_WIDTH);
        HBox.setMargin(comboBox,new Insets(MARGIN_TOP,MARGIN_RIGHT,MARGIN_BOTTOM,MARGIN_LEFT));
    }

    void customizeTextField(TextField textField){
        textField.setMinWidth(MIN_WIDTH);
        HBox.setMargin(textField,new Insets(MARGIN_TOP,MARGIN_RIGHT,MARGIN_BOTTOM,MARGIN_LEFT));
    }

    void customizeButton(Button button){
        button.setMinWidth(MIN_WIDTH);
        HBox.setMargin(button,new Insets(MARGIN_TOP,MARGIN_RIGHT,MARGIN_BOTTOM,MARGIN_LEFT));
        button.setText(BUTTON_TEXT);
    }
}

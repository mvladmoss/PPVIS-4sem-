package sample.task3;

import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Director implements sample.Director {

    private final static String FIRST_RADIO_BUTTON_NAME = "First choice";
    private final static String SECOND_RADIO_BUTTON_NAME = "Second choice";
    private final static String THIRD_RADIO_BUTTON_NAME = "Third choice";
    private final static String INCORRECT_RADIO_BUTTON_NAME = "You was enter incorrect radio button name";
    private final static String BUTTON_NAME = "Choose";
    private final static Integer PREF_WIDTH = 400;
    private final static Integer PREF_HEIGHT = 150;
    private final static Double TOP_ANCHOR = 200d;
    private final static Double LEFT_ANCHOR = 20d;
    private final static Integer MIN_WIDTH = 100;

    private ToggleGroup toggleGroup;
    private Button button;
    private TextField textField;
    private List<RadioButton> radioButtonList = new ArrayList<>();
    private Pane pane;

    public Director(Pane pane){
        VBox hBox = new VBox();
        this.pane = hBox;
        toggleGroup = new ToggleGroup();
        hBox.setPrefSize(PREF_WIDTH,PREF_HEIGHT);
        hBox.setStyle("-fx-background-color: gray");
        AnchorPane.setTopAnchor(hBox,TOP_ANCHOR);
        AnchorPane.setLeftAnchor(hBox,LEFT_ANCHOR);
        pane.getChildren().add(hBox);
        customizeComponents(hBox);
        setListener();
    }

    private void setListener(){
        button.setOnAction(event -> {
            String textFieldString = textField.getText();
            Map<String,RadioButton> radioButtonNamesMap = new HashMap<>();
            radioButtonList.forEach(radioButton -> radioButtonNamesMap.put(radioButton.getText(),radioButton));
            if(radioButtonNamesMap.containsKey(textFieldString)){
                RadioButton radioButton = radioButtonNamesMap.get(textFieldString);
                radioButton.fire();
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText(INCORRECT_RADIO_BUTTON_NAME);
                alert.showAndWait();
            }
        });
    }

    public void customizeComponents(Pane pane){
        addRadioButton(pane,FIRST_RADIO_BUTTON_NAME);
        addRadioButton(pane,SECOND_RADIO_BUTTON_NAME);
        addRadioButton(pane,THIRD_RADIO_BUTTON_NAME);

        Button button = new Button();
        this.button = button;
        button.setMinWidth(MIN_WIDTH);
        button.setText(BUTTON_NAME);
        pane.getChildren().add(button);

        TextField textField = new TextField();
        this.textField = textField;
        textField.setMinWidth(MIN_WIDTH);
        pane.getChildren().add(textField);
    }


    private void addRadioButton(Pane pane,String buttonName){
        RadioButton radioButton = new RadioButton();
        radioButton.setToggleGroup(toggleGroup);
        radioButton.setMinWidth(MIN_WIDTH);
        radioButton.setText(buttonName);
        pane.getChildren().add(radioButton);
        radioButtonList.add(radioButton);
    }

    public Pane getPane(){
        return pane;
    }

}

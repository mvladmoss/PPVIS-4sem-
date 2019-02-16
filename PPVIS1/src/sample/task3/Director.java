package sample.task3;

import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class Director {

    private final static String FIRST_RADIO_BUTTON_NAME = "First choice";
    private final static String SECOND_RADIO_BUTTON_NAME = "Second choice";
    private final static String THIRD_RADIO_BUTTON_NAME = "Third choice";
    private final static String BUTTON_NAME = "Choose";

    private ComponentCustomizer customizer = new ComponentCustomizer();
    private ToggleGroup toggleGroup;
    private Button button;
    private TextField textField;
    private List<RadioButton> radioButtonList = new ArrayList<>();

    public Director(Pane pane){
        VBox hBox = new VBox();
        toggleGroup = new ToggleGroup();
        customizer.customizeMainPane(hBox);
        pane.getChildren().add(hBox);
        customizeComponents(hBox);
        setListener();
    }

    private void setListener(){
        button.setOnAction(event -> {
            LogicImplementation logicImplementation = new LogicImplementation();
            logicImplementation.setActionOnButton(radioButtonList,textField);
        });
    }

    private void customizeComponents(Pane pane){
        addRadioButton(pane,FIRST_RADIO_BUTTON_NAME);
        addRadioButton(pane,SECOND_RADIO_BUTTON_NAME);
        addRadioButton(pane,THIRD_RADIO_BUTTON_NAME);
        addButton(pane);
        addTextField(pane);
    }

    private void addButton(Pane pane){
        Button button = new Button();
        this.button = button;
        customizer.customizeButton(button,BUTTON_NAME);
        pane.getChildren().add(button);
    }

    private void addRadioButton(Pane pane,String buttonName){
        RadioButton firstRadioButton = new RadioButton();
        firstRadioButton.setToggleGroup(toggleGroup);
        customizer.customizeRadioButton(firstRadioButton,buttonName);
        pane.getChildren().add(firstRadioButton);
        radioButtonList.add(firstRadioButton);

    }

    private void addTextField(Pane pane){
        TextField textField = new TextField();
        this.textField = textField;
        customizer.customizeTextField(textField);
        pane.getChildren().add(textField);
    }

}

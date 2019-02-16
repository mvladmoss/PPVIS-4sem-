package sample.task4;

import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class Director {

    private final static String FIRST_CHECKBOX__NAME = "Java";
    private final static String SECOND_CHECKBOX_NAME = "JavaScript";
    private final static String THIRD_CHECKBOX_NAME = "C++";
    private final static String BUTTON_NAME = "Choose";

    private ComponentCustomizer customizer = new ComponentCustomizer();
    private Button button;
    private TextField textField;
    private List<CheckBox> checkBoxList = new ArrayList<>();

    public Director(Pane pane){
        VBox hBox = new VBox();
        customizer.customizeMainPane(hBox);
        pane.getChildren().add(hBox);
        customizeComponents(hBox);
        setListener();
    }

    private void setListener(){
        button.setOnAction(event -> {
            LogicImplementation logicImplementation = new LogicImplementation();
            logicImplementation.setActionOnButton(checkBoxList,textField);
        });
    }

    private void customizeComponents(Pane pane){
        addCheckBox(pane,FIRST_CHECKBOX__NAME);
        addCheckBox(pane,SECOND_CHECKBOX_NAME);
        addCheckBox(pane,THIRD_CHECKBOX_NAME);
        addButton(pane);
        addTextField(pane);
    }

    private void addButton(Pane pane){
        Button button = new Button();
        this.button = button;
        customizer.customizeButton(button,BUTTON_NAME);
        pane.getChildren().add(button);
    }

    private void addCheckBox(Pane pane,String checkBoxName){
        CheckBox checkBox = new CheckBox();
        customizer.customizeCheckBox(checkBox,checkBoxName);
        pane.getChildren().add(checkBox);
        checkBoxList.add(checkBox);
    }

    private void addTextField(Pane pane){
        TextField textField = new TextField();
        this.textField = textField;
        customizer.customizeTextField(textField);
        pane.getChildren().add(textField);
    }

}

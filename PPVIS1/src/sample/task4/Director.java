package sample.task4;

import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.util.*;

public class Director implements sample.Director {

    private final static String FIRST_CHECKBOX__NAME = "Java";
    private final static String SECOND_CHECKBOX_NAME = "JavaScript";
    private final static String THIRD_CHECKBOX_NAME = "C++";
    private final static String BUTTON_NAME = "Choose";
    private final static String INCORRECT_CHECKBOX_NAME = "You was enter incorrect checkbox name:";
    private final static String TEXT_DELIMITER = ",";
    private final static Integer PREF_WIDTH = 400;
    private final static Integer PREF_HEIGHT = 150;
    private final static Double TOP_ANCHOR = 200d;
    private final static Double LEFT_ANCHOR = 500d;
    private final static Integer MIN_WIDTH = 100;

    private Button button;
    private TextField textField;
    private List<CheckBox> checkBoxList = new ArrayList<>();
    private Pane pane;

    public Director(Pane pane){
        VBox hBox = new VBox();
        this.pane = hBox;
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
            List<String> checkBoxNames = getCheckBoxNames(textFieldString);
            Map<String,CheckBox> checkBoxNamesMap = new HashMap<>();
            checkBoxList.forEach(checkBox -> checkBoxNamesMap.put(checkBox.getText(),checkBox));
            for(String checkBoxName : checkBoxNames){
                if(checkBoxNamesMap.containsKey(checkBoxName)){
                    CheckBox checkBox = checkBoxNamesMap.get(checkBoxName);
                    checkBox.fire();
                }else{
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText(INCORRECT_CHECKBOX_NAME + checkBoxName);
                    alert.showAndWait();
                }
            }
        });
    }

    private List<String> getCheckBoxNames(String textFieldString){
        List<String> checkBoxNames = new ArrayList<>();
        Arrays.stream(textFieldString.split(TEXT_DELIMITER)).forEach(name -> checkBoxNames.add(name));
        return checkBoxNames;
    }

    public void customizeComponents(Pane pane){
        addCheckBox(pane,FIRST_CHECKBOX__NAME);
        addCheckBox(pane,SECOND_CHECKBOX_NAME);
        addCheckBox(pane,THIRD_CHECKBOX_NAME);

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


    private void addCheckBox(Pane pane,String checkBoxName){
        CheckBox checkBox = new CheckBox();
        checkBox.setMinWidth(MIN_WIDTH);
        checkBox.setText(checkBoxName);
        pane.getChildren().add(checkBox);
        checkBoxList.add(checkBox);
    }

    public Pane getPane(){
        return pane;
    }


}

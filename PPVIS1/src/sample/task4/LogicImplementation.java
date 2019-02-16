package sample.task4;

import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

import java.util.*;

class LogicImplementation {

    private final static String INCORRECT_CHECKBOX_NAME = "You was enter incorrect checkbox name:";
    private final static String TEXT_DELIMITER = ",";


    void setActionOnButton(List<CheckBox> checkBoxList, TextField textField){
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

    }

    private List<String> getCheckBoxNames(String textFieldString){
        List<String> checkBoxNames = new ArrayList<>();
        Arrays.stream(textFieldString.split(TEXT_DELIMITER)).forEach(name -> checkBoxNames.add(name));
        return checkBoxNames;
    }
}

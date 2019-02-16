package sample.task3;

import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LogicImplementation {

    private final static String INCORRECT_RADIO_BUTTON_NAME = "You was enter incorrect radio button name";

    public void setActionOnButton(List<RadioButton> radioButtonList, TextField textField){
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
    }
}

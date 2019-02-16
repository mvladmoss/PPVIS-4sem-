package sample.task1;

import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

class LogicImplementation {

    private final static String WARNING = "WARNING";
    private final static String WARNING_MESSAGE_DUPLICATE = "WARNING!Such string already exists";

    void setActionOnButton(ComboBox comboBox, TextField textField){
        String textToAdd = textField.getText();
        ObservableList listOfAddStrings = comboBox.getItems();
        Alert alert;
        if(listOfAddStrings.contains(textToAdd)){
            alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle(WARNING);
            alert.setContentText(WARNING_MESSAGE_DUPLICATE);
            alert.showAndWait();
        }else{
            comboBox.getItems().add(textToAdd);
        }
    }
}

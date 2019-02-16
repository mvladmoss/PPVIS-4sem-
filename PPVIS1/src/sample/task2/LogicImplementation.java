package sample.task2;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

class LogicImplementation {

    void setActionOnFirstButton(Button secondButton, TextField textField){
        String textFieldText = textField.getText();
        secondButton.setText(textFieldText);
    }

    void setActionOnSecondButton(Button firstButton,Button secondButton){
        String firstButtonText = firstButton.getText();
        String secondButtonText = secondButton.getText();
        firstButton.setText(secondButtonText);
        secondButton.setText(firstButtonText);
    }
}

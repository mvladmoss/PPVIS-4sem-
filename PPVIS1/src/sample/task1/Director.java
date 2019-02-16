package sample.task1;


import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class Director {

    private ComponentCustomizer customizer = new ComponentCustomizer();
    private ComboBox comboBox;
    private TextField textField;
    private Button button;

    public Director(Pane pane){
        HBox hBox = new HBox();
        customizer.customizeMainPane(hBox);
        pane.getChildren().add(hBox);
        customizeComponents(hBox);
        setButtonListener();
    }

    private void customizeComponents(Pane pane){
        addComboBox(pane);
        addTextField(pane);
        addButton(pane);
    }

    private void addComboBox(Pane pane){
        ComboBox comboBox = new ComboBox();
        this.comboBox = comboBox;
        customizer.customizeComboBox(comboBox);
        pane.getChildren().add(comboBox);

    }

    private void addTextField(Pane pane){
        TextField textField = new TextField();
        this.textField = textField;
        customizer.customizeTextField(textField);
        pane.getChildren().add(textField);
    }

    private void addButton(Pane pane){
        Button button = new Button();
        this.button = button;
        customizer.customizeButton(button);
        pane.getChildren().add(button);
    }

    private void setButtonListener(){
        button.setOnAction(event -> {
            LogicImplementation logicImplementation = new LogicImplementation();
            logicImplementation.setActionOnButton(comboBox,textField);
        });
    }

}
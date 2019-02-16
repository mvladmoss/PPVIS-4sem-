package sample.task1;


import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class Director {

    private final static Integer PREF_WIDTH = 400;
    private final static Integer PREF_HEIGHT = 150;
    private final static Double ANCHOR = 20d;
    private final static Integer MIN_WIDTH = 100;
    private final static Integer MARGIN_TOP = 50;
    private final static Integer MARGIN_BOTTOM = 0;
    private final static Integer MARGIN_RIGHT = 0;
    private final static Integer MARGIN_LEFT = 10;
    private final static String BUTTON_TEXT = "Add";
    private final static String WARNING = "WARNING";
    private final static String WARNING_MESSAGE_DUPLICATE = "WARNING!Such string already exists";

    private ComboBox comboBox;
    private TextField textField;
    private Button button;

    public Director(Pane pane){
        HBox hBox = new HBox();
        hBox.setPrefSize(PREF_WIDTH,PREF_HEIGHT);
        hBox.setStyle("-fx-background-color: gray");
        AnchorPane.setTopAnchor(hBox,ANCHOR);
        AnchorPane.setLeftAnchor(hBox,ANCHOR);
        pane.getChildren().add(hBox);
        customizeComponents(hBox);
        setButtonListener();
    }

    private void customizeComponents(Pane pane){
        ComboBox comboBox = new ComboBox();
        this.comboBox = comboBox;
        pane.getChildren().add(comboBox);
        comboBox.setMinWidth(MIN_WIDTH);
        HBox.setMargin(comboBox,new Insets(MARGIN_TOP,MARGIN_RIGHT,MARGIN_BOTTOM,MARGIN_LEFT));

        TextField textField = new TextField();
        this.textField = textField;
        pane.getChildren().add(textField);
        textField.setMinWidth(MIN_WIDTH);
        HBox.setMargin(textField,new Insets(MARGIN_TOP,MARGIN_RIGHT,MARGIN_BOTTOM,MARGIN_LEFT));

        Button button = new Button();
        this.button = button;
        pane.getChildren().add(button);
        button.setMinWidth(MIN_WIDTH);
        HBox.setMargin(button,new Insets(MARGIN_TOP,MARGIN_RIGHT,MARGIN_BOTTOM,MARGIN_LEFT));
        button.setText(BUTTON_TEXT);
    }


    private void setButtonListener(){
        button.setOnAction(event -> {
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
        });
    }

}
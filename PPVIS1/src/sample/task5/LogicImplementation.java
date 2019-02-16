package sample.task5;

import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;


public class LogicImplementation {

    private final static String EMPTY_STRING = "";

    void setActionOnButtonAddData(TextField textField, ObservableList observableList){
        String textFieldString = textField.getText();
        System.out.println(textFieldString);
        observableList.add(new Model(textFieldString));
    }

    void setActionOnMoveSecondColumnButton(TableView table){
        TableView.TableViewSelectionModel selectionModel = table.getSelectionModel();
        Model selectedModel = (Model) selectionModel.getSelectedItem();
        if(selectedModel.getName().equals("") && !selectedModel.getSurname().equals("")){
            return;
        }
        selectedModel.setSurname(selectedModel.getName());
        selectedModel.setName(EMPTY_STRING);
        table.refresh();
    }

    void setActionOnMoveFirstColumnButton(TableView table){
        TableView.TableViewSelectionModel selectionModel = table.getSelectionModel();
        Model selectedModel = (Model) selectionModel.getSelectedItem();
        if(selectedModel.getSurname().equals("") && !selectedModel.getName().equals("")) {
            return;
        }
        selectedModel.setName(selectedModel.getSurname());
        selectedModel.setSurname(EMPTY_STRING);
        table.refresh();
    }
}

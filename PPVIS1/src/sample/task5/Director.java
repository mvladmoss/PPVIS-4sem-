package sample.task5;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class Director implements sample.Director {

    private final static String NAME = "name";
    private final static String SURNAME = "surname";
    private final static String ADD_DATA_BUTTON = "Add data";
    private final static String MOVE_DATA_TO_SECOND_COLUMN = "Move data to 2 column";
    private final static String MOVE_DATA_TO_FIRST_COLUMN = "Move data to 1 column";
    private final static String EMPTY_STRING = "";

    private final static Integer PREF_WIDTH = 500;
    private final static Integer PREF_HEIGHT = 350;
    private final static Double TOP_ANCHOR = 400d;
    private final static Double LEFT_ANCHOR = 200d;
    private final static Integer PANE_WIDTH = 500;
    private final static Integer PANE_HEIGHT = 200;
    private final static Integer TABLE_COLUMN_WIDTH = 250;
    private final static Integer BUTTON_WIDTH = 300;

    private TableView<Model> tableView;
    private ObservableList observableList = FXCollections.observableArrayList();
    private Button addDataButton;
    private Button moveToSecondColumnButton;
    private Button moveToFirstColumnButton;
    private TextField textField;
    private Pane pane;

    public Director(Pane pane){
        VBox hBox = new VBox();
        this.pane = hBox;
        hBox.setMinSize(PREF_WIDTH,PREF_HEIGHT);
        hBox.setStyle("-fx-background-color: gray");
        AnchorPane.setTopAnchor(hBox,TOP_ANCHOR);
        AnchorPane.setLeftAnchor(hBox,LEFT_ANCHOR);
        pane.getChildren().add(hBox);
        customizeComponents(hBox);
        setListeners();
        System.out.println(hBox.getChildren().size());
    }

    public void customizeComponents(Pane pane){
        addTableView(pane);
        addTableColumns();
        addButtonAddData(pane,ADD_DATA_BUTTON);
        addButtonMoveSecondColumn(pane,MOVE_DATA_TO_SECOND_COLUMN);
        addButtonMoveFirstColumn(pane,MOVE_DATA_TO_FIRST_COLUMN);
        addTextField(pane);
    }

    private void setListeners(){

        addDataButton.setOnAction(event -> {
            String textFieldString = textField.getText();
            System.out.println(textFieldString);
            observableList.add(new Model(textFieldString));
        });
        moveToSecondColumnButton.setOnAction(event -> {
            TableView.TableViewSelectionModel selectionModel = tableView.getSelectionModel();
            Model selectedModel = (Model) selectionModel.getSelectedItem();
            if(selectedModel.getName().equals("") && !selectedModel.getSurname().equals("")){
                return;
            }
            selectedModel.setSurname(selectedModel.getName());
            selectedModel.setName(EMPTY_STRING);
            tableView.refresh();
        });
        moveToFirstColumnButton.setOnAction(event -> {
            TableView.TableViewSelectionModel selectionModel = tableView.getSelectionModel();
            Model selectedModel = (Model) selectionModel.getSelectedItem();
            if(selectedModel.getSurname().equals("") && !selectedModel.getName().equals("")) {
                return;
            }
            selectedModel.setName(selectedModel.getSurname());
            selectedModel.setSurname(EMPTY_STRING);
            tableView.refresh();
        });
    }

    private void addTextField(Pane pane){
        TextField textField = new TextField();
        this.textField = textField;
        pane.getChildren().add(textField);
    }

    private void addTableView(Pane pane){
        tableView = new TableView<>(observableList);
        tableView.setMaxWidth(PANE_WIDTH);
        tableView.setMaxHeight(PANE_HEIGHT);
        pane.getChildren().add(tableView);
    }

    private void addButtonAddData(Pane pane,String name){
        Button buttonToAdd = new Button();
        this.addDataButton = buttonToAdd;
        buttonToAdd.setMaxWidth(BUTTON_WIDTH);
        buttonToAdd.setText(name);
        pane.getChildren().add(buttonToAdd);
    }

    private void addButtonMoveSecondColumn(Pane pane,String name){
        Button moveButton = new Button();
        this.moveToSecondColumnButton = moveButton;
        moveButton.setMaxWidth(BUTTON_WIDTH);
        moveButton.setText(name);
        pane.getChildren().add(moveButton);
    }

    private void addButtonMoveFirstColumn(Pane pane,String name){
        Button moveButton = new Button();
        this.moveToFirstColumnButton = moveButton;
        moveButton.setMaxWidth(BUTTON_WIDTH);
        moveButton.setText(name);
        pane.getChildren().add(moveButton);
    }

    private void addTableColumns() {
        TableColumn<Model, String> firstColumn = new TableColumn<>(NAME);
        firstColumn.setCellValueFactory(new PropertyValueFactory<>(NAME));
        TableColumn<Model, String> secondColumn = new TableColumn<>(SURNAME);
        secondColumn.setCellValueFactory(new PropertyValueFactory<>(SURNAME));
        firstColumn.setMinWidth(TABLE_COLUMN_WIDTH);
        secondColumn.setMinWidth(TABLE_COLUMN_WIDTH);
        tableView.getColumns().addAll(firstColumn, secondColumn);
    }

    public Pane getPane(){
        return pane;
    }

}

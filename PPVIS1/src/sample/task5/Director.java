package sample.task5;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class Director {

    private final static String NAME = "name";
    private final static String SURNAME = "surname";
    private final static String ADD_DATA_BUTTON = "Add data";
    private final static String MOVE_DATA_TO_SECOND_COLUMN = "Move data to 2 column";
    private final static String MOVE_DATA_TO_FIRST_COLUMN = "Move data to 1 column";

    private ComponentCustomizer customizer = new ComponentCustomizer();
    private TableView<Model> tableView;
    private ObservableList observableList = FXCollections.observableArrayList();
    private Button addDataButton;
    private Button moveToSecondColumnButton;
    private Button moveToFirstColumnButton;
    private TextField textField;

    public Director(Pane pane){
        VBox hBox = new VBox();
        customizer.customizeMainPane(hBox);
        pane.getChildren().add(hBox);
        addTableView(hBox);
        addTableColumns();
        addButtonAddData(hBox,ADD_DATA_BUTTON);
        addButtonMoveSecondColumn(hBox,MOVE_DATA_TO_SECOND_COLUMN);
        addButtonMoveFirstColumn(hBox,MOVE_DATA_TO_FIRST_COLUMN);
        addTextField(hBox);
        setListeners();
    }

    private void setListeners(){
        LogicImplementation logicImplementation = new LogicImplementation();

        addDataButton.setOnAction(event -> logicImplementation.setActionOnButtonAddData(textField,observableList));
        moveToSecondColumnButton.setOnAction(event -> logicImplementation.setActionOnMoveSecondColumnButton(tableView));
        moveToFirstColumnButton.setOnAction(event -> logicImplementation.setActionOnMoveFirstColumnButton(tableView));
    }

    private void addTextField(Pane pane){
        TextField textField = new TextField();
        this.textField = textField;
        pane.getChildren().add(textField);
    }

    private void addTableView(Pane pane){
        tableView = new TableView<>(observableList);
        customizer.customizeTableView(tableView);
        pane.getChildren().add(tableView);
    }

    private void addButtonAddData(Pane pane,String name){
        Button buttonToAdd = new Button();
        this.addDataButton = buttonToAdd;
        customizer.customizeButton(buttonToAdd,name);
        pane.getChildren().add(buttonToAdd);
    }

    private void addButtonMoveSecondColumn(Pane pane,String name){
        Button moveButton = new Button();
        this.moveToSecondColumnButton = moveButton;
        customizer.customizeButton(moveButton,name);
        pane.getChildren().add(moveButton);
    }

    private void addButtonMoveFirstColumn(Pane pane,String name){
        Button moveButton = new Button();
        this.moveToFirstColumnButton = moveButton;
        customizer.customizeButton(moveButton,name);
        pane.getChildren().add(moveButton);
    }

    private void addTableColumns(){
        TableColumn<Model,String> firstColumn = new TableColumn<>(NAME);
        firstColumn.setCellValueFactory(new PropertyValueFactory<>(NAME));
        TableColumn<Model,String> secondColumn = new TableColumn<>(SURNAME);
        secondColumn.setCellValueFactory(new PropertyValueFactory<>(SURNAME));
        customizer.customizeTableColumn(firstColumn,secondColumn);
        tableView.getColumns().addAll(firstColumn,secondColumn);
    }




}

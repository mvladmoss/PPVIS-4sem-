package sample.task5;

import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import sample.Customizer;


public class ComponentCustomizer implements Customizer {

    private final static Integer PREF_WIDTH = 500;
    private final static Integer PREF_HEIGHT = 350;
    private final static Double TOP_ANCHOR = 400d;
    private final static Double LEFT_ANCHOR = 200d;
    private final static Integer PANE_WIDTH = 500;
    private final static Integer PANE_HEIGHT = 200;
    private final static Integer TABLE_COLUMN_WIDTH = 250;
    private final static Integer BUTTON_WIDTH = 300;

    @Override
    public void customizeMainPane(Pane pane) {
        pane.setMinSize(PREF_WIDTH,PREF_HEIGHT);
        pane.setStyle("-fx-background-color: gray");
        AnchorPane.setTopAnchor(pane,TOP_ANCHOR);
        AnchorPane.setLeftAnchor(pane,LEFT_ANCHOR);
    }

    void customizeTableView(TableView tableView){
        tableView.setMaxWidth(PANE_WIDTH);
        tableView.setMaxHeight(PANE_HEIGHT);
    }

    void customizeTableColumn(TableColumn ...tableColumns ){
        for(TableColumn tableColumn : tableColumns){
            tableColumn.setMinWidth(TABLE_COLUMN_WIDTH);
        }
    }

    void customizeButton(Button button,String name){
        button.setMaxWidth(BUTTON_WIDTH);
        button.setText(name);
    }

}

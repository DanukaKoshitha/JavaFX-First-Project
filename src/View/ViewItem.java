package View;

import Model.Item;
import db.dbCollection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.awt.*;

public class ViewItem {
    public TableColumn colName;
    public TableColumn colPrice;
    public TableView tblView;
    public TableColumn colId;
    public TableColumn colDescription;
    public TableColumn colQty;
    public TableColumn colAction;

    public void btnReloadOnAction(ActionEvent actionEvent) {
        ObservableList<Item> itemObservableList = FXCollections.observableArrayList();
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));

        colAction.setCellFactory(param -> new TableCell<Item, Void>() {
            private final Button btn = new Button("Remove");

            {
                btn.setStyle("-fx-background-color: rgb(250, 3, 67);");

                btn.setOnAction(event -> {
                    Item item = getTableView().getItems().get(getIndex());
                    getTableView().getItems().remove(item);
                    dbCollection.getInstance().getConnection().remove(item);
                });
            }

            @Override
            protected void updateItem(Void unused, boolean empty) {
                super.updateItem(unused, empty);
                setGraphic(empty ? null : btn);
            }
        });


        ////////////// get connetion form dbCollection  //////////////

        dbCollection.getInstance().getConnection().forEach(obj ->{
            itemObservableList.add(obj);
        });

        //////////////////////////////////////////////////////////////

        tblView.setItems(itemObservableList);
    }
}

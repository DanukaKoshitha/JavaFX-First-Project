package View;

import Model.Item;
import db.dbCollection;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class AddItem {

    public TextField txtName;
    public TextField txtPrice;
    public TextField txtQTY;
    public TextField txtDescription;
    public TextField txtID;

    ArrayList<Item> itemArrayList = new ArrayList<>();

    public void btnAddItemOnAction(ActionEvent actionEvent) {
        String id = txtID.getText();
        String name = txtName.getText();
        int qty = Integer.parseInt(txtQTY.getText());
        double price = Double.parseDouble(txtPrice.getText());
        String description = txtDescription.getText();

        /////////////////  send to connetion  ///////////////////

        dbCollection.getInstance().getConnection().add(new Item(id,name,price,qty,description));

        ////////////////////////////////////////////////////////

        itemArrayList.add(new Item(id,name,price,qty,description));
        System.out.println(itemArrayList);

    }

    public void btnViewOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("view_item.fxml"))));
        stage.show();
    }
}

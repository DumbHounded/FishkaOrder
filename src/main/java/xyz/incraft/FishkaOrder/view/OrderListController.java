package xyz.incraft.FishkaOrder.view;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.util.Callback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xyz.incraft.FishkaOrder.model.order.OrderItem;
import xyz.incraft.FishkaOrder.model.order.OrderList;

/**
 * Created by Михаил on 19.01.2016.
 */
@Component
public class OrderListController implements Callback<Class<?>, Object> {

    @Autowired
    private OrderList orderList;

    @FXML
    private TableView<OrderItem> tableView;
    @FXML
    private TableColumn<OrderItem, String> idColumn;
    @FXML
    private TableColumn<OrderItem, String> nameColumn;
    @FXML
    private TableColumn<OrderItem, String> priceColumn;
    @FXML
    private TableColumn<OrderItem, String> costColumn;
    @FXML
    private TableColumn<OrderItem, String> quantityColumn;


    @FXML
    private void initialize() {
        tableView.setItems(orderList.getList());
        idColumn.setCellValueFactory(cellData -> cellData.getValue().getIdProperty());
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().getNameProperty());
        priceColumn.setCellValueFactory(cellData -> cellData.getValue().getPriceProperty());
        costColumn.setCellValueFactory(cellData -> cellData.getValue().getCostProperty());
        quantityColumn.setCellValueFactory(cellData -> cellData.getValue().getQuantityProperty());
    }

    private Integer getSelectedId() {
        ObservableList<OrderItem> list = tableView.getSelectionModel().getSelectedItems();
        if (list.size() == 0) return -1;
        return list.get(0).getId();
    }


    @FXML
    private void OnKeyPressed(KeyEvent keyEvent) {
        KeyCode keyCode = keyEvent.getCode();

        if (keyCode == KeyCode.ADD) {
            orderList.addItem(getSelectedId());
        } else if (keyCode == KeyCode.SUBTRACT) {
            orderList.removeItem(getSelectedId());
        }
    }


    @Override
    public Object call(Class<?> param) {
        return this;
    }
}

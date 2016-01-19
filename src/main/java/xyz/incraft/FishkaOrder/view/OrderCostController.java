package xyz.incraft.FishkaOrder.view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.util.Callback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xyz.incraft.FishkaOrder.model.order.OrderList;

/**
 * Created by Михаил on 19.01.2016.
 */
@Component
public class OrderCostController implements Callback<Class<?>, Object> {

    @Autowired
    private OrderList orderList;

    @FXML
    private Label cost;

    @FXML
    private void initialize() {
        cost.textProperty().bindBidirectional(orderList.getCost());
    }

    @Override
    public Object call(Class<?> param) {
        return this;
    }
}

package xyz.incraft.FishkaOrder.view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.Callback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xyz.incraft.FishkaOrder.model.adapter.PriceAdapter;
import xyz.incraft.FishkaOrder.model.menu.Menu;
import xyz.incraft.FishkaOrder.model.menu.MenuItem;
import xyz.incraft.FishkaOrder.model.order.OrderList;

/**
 * Created by Михаил on 19.01.2016.
 */
@Component
public class ProductCodeController implements Callback<Class<?>, Object> {

    @Autowired
    private Menu menu;
    @Autowired
    private OrderList orderList;

    private String defaultTextStyle = "";

    @FXML
    private TextField textField;

    @FXML
    private Label labelDescription;
    @FXML
    private Label labelPriceMenuItem;

    @FXML
    private void initialize() {
        defaultTextStyle = textField.getStyle();
    }

    @FXML
    private void OnTextChangedFromKeyboard() {
        String st = textField.getText();
        TestEnterCode(st);
    }

    public void ProductAction() {
        OnTextAction();
    }

    @FXML
    private void OnTextAction() {
        try {
            Integer id = Integer.parseInt(textField.getText());
            if (menu.isValidId(id)) {
                orderList.addItem(id);
            }
        } catch (NumberFormatException e) {
        }
        textField.setText("");
        DefaultPosition();
    }

    public void TestAndSetCode(Integer id) {
        if (menu.isValidId(id)) {
            ValidPosition(id);
            textField.setText(id.toString());
        }
    }

    private void TestEnterCode(String st) {
        if (st.isEmpty()) {
            DefaultPosition();
            return;
        }
        try {
            Integer id = Integer.parseInt(st);
            TestEnterCode(id);
        } catch (NumberFormatException e) {
            InvalidPosition();
        }
    }

    private void TestEnterCode(Integer id) {
        if (menu.isValidId(id)) ValidPosition(id);
        else DefaultPosition();
    }

    private void InvalidPosition() {
        textField.setStyle("-fx-background-color: lightcoral");
        labelDescription.setText("");
        labelPriceMenuItem.setText("");
    }

    private void ValidPosition(Integer id) {
        textField.setStyle("-fx-background-color: aquamarine");
        MenuItem menuItem = menu.getMenuItem(id);
        labelDescription.setText(menuItem.getName());
        String price = PriceAdapter.PriceToString(menuItem.getClientPrice());
        labelPriceMenuItem.setText(price);
    }

    private void DefaultPosition() {
        textField.setStyle(defaultTextStyle);
        labelPriceMenuItem.setText("");
        labelDescription.setText("");
    }


    @Override
    public Object call(Class<?> param) {
        return this;
    }
}

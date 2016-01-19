package xyz.incraft.FishkaOrder.model.order;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xyz.incraft.FishkaOrder.model.adapter.PriceAdapter;
import xyz.incraft.FishkaOrder.model.menu.Menu;
import xyz.incraft.FishkaOrder.model.menu.MenuItem;

/**
 * Created by Михаил on 19.01.2016.
 */
@Component
public class OrderList {
    @Autowired
    private Menu menu;

    private ObservableList<OrderItem> list = FXCollections.observableArrayList();

    private StringProperty Cost = new SimpleStringProperty(PriceAdapter.PriceToString(0));

    public void clear() {
        list.clear();
    }

    public ObservableList<OrderItem> getList() {
        return list;
    }

    public StringProperty getCost() {
        return Cost;
    }

    public OrderItem getItem(Integer id) {
        for (OrderItem orderItem : list) {
            if (orderItem.getId().equals(id)) return orderItem;
        }
        return null;
    }

    public void addItem(Integer id) {
        OrderItem item = getItem(id);
        if (item != null) item.IncrementQuantity();
        else addNewItem(id);
        CalculateCost();
    }

    public void removeItem(Integer id) {
        OrderItem item = getItem(id);
        if (item != null) {
            Integer quantity = item.DecrementQuantity();
            if (quantity == 0) list.remove(item);
            CalculateCost();
        }
    }

    private void addNewItem(Integer id) {
        MenuItem item = menu.getMenuItem(id);
        if (item == null) return;
        String name = item.getName();
        Integer price = item.getClientPrice();
        list.add(new OrderItem(id, name, price));
    }

    private void CalculateCost() {
        Integer cost = 0;
        for (OrderItem orderItem : list) {
            cost += orderItem.getCost();
        }
        Cost.setValue(PriceAdapter.PriceToString(cost));
    }
}

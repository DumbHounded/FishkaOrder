package xyz.incraft.FishkaOrder.model.order;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
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

    public void clear() {
        list.clear();
    }

    public ObservableList<OrderItem> getList() {
        return list;
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
    }

    public void removeItem(Integer id) {
        OrderItem item = getItem(id);
        if (item != null) list.remove(item);
    }

    private void addNewItem(Integer id) {
        MenuItem item = menu.getMenuItem(id);
        if (item == null) return;
        String name = item.getName();
        Integer price = item.getClientPrice();
        list.add(new OrderItem(id, name, price));
    }
}

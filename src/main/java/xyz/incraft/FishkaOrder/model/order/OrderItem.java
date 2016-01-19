package xyz.incraft.FishkaOrder.model.order;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import xyz.incraft.FishkaOrder.model.adapter.PriceAdapter;

/**
 * Created by Михаил on 19.01.2016.
 */
public class OrderItem {
    private Integer id;
    private String name;
    private Integer quantity;
    private Integer price;

    private StringProperty idProperty;
    private StringProperty nameProperty;
    private StringProperty quantityProperty;
    private StringProperty priceProperty;
    private StringProperty costProperty;

    public OrderItem(Integer id, String name, Integer quantity, Integer price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;

        this.idProperty = new SimpleStringProperty(id.toString());
        this.nameProperty = new SimpleStringProperty(name);
        this.quantityProperty = new SimpleStringProperty(quantity.toString());
        this.priceProperty = new SimpleStringProperty(PriceAdapter.PriceToString(price));
        this.costProperty = new SimpleStringProperty();
    }

    private Integer CalculateCost() {
        return price * quantity;
    }

    public OrderItem(Integer id, String name, Integer price) {
        this(id, name, 1, price);
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer IncrementQuantity() {
        ++quantity;
        quantityProperty.setValue(quantity.toString());
        return quantity;
    }

    public Integer DecrementQuantity() {
        --quantity;
        quantityProperty.setValue(quantity.toString());
        return quantity;
    }

    public Integer getCost() {
        return CalculateCost();
    }

    public StringProperty getIdProperty() {
        return idProperty;
    }

    public StringProperty getNameProperty() {
        return nameProperty;
    }

    public StringProperty getQuantityProperty() {
        return quantityProperty;
    }

    public StringProperty getPriceProperty() {
        return priceProperty;
    }

    public StringProperty getCostProperty() {
        costProperty.setValue(PriceAdapter.PriceToString(CalculateCost()));
        return costProperty;
    }
}

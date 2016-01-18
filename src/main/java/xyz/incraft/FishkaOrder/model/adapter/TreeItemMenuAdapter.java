package xyz.incraft.FishkaOrder.model.adapter;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.Node;
import javafx.scene.control.TreeItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xyz.incraft.FishkaOrder.model.menu.Menu;
import xyz.incraft.FishkaOrder.model.menu.MenuGroup;
import xyz.incraft.FishkaOrder.model.menu.MenuItem;

import java.util.List;

/**
 * Created by Михаил on 18.01.2016.
 */
@Component
public class TreeItemMenuAdapter {
    @Autowired()
    private Menu menu;

    private TreeItem<MenuItemAdapter> treeItem = new TreeItem<>(new MenuItemAdapter("","Меню",""));

    public TreeItem<MenuItemAdapter> getTreeItem() {
        return treeItem;
    }

    private String PriceToString(Integer price){
        return String.format("%.2f",price.doubleValue()/100.0);
    }

    public void rebuild(){
        treeItem.getChildren().clear();
        List<MenuGroup> groups = menu.getGroups();
        for (MenuGroup group : groups) {
            List<MenuItem> itemsGroup = menu.getItemsForGroup(group);
            TreeItem<MenuItemAdapter> g = new TreeItem<>(new MenuItemAdapter("",group.getName(),""));
            for (MenuItem menuItem : itemsGroup) {
                g.getChildren().add(new TreeItem<>(
                        new MenuItemAdapter(menuItem.getIdItem(),
                                menuItem.getName(),
                                PriceToString(menuItem.getClientPrice()))));
            }
            g.setExpanded(true);
            treeItem.getChildren().add(g);
        }
    }

    public class MenuItemAdapter{
        private Integer integerID;
        private SimpleStringProperty id;
        private SimpleStringProperty name;
        private SimpleStringProperty price;

        public MenuItemAdapter(String id, String name, String price) {
            this.id = new SimpleStringProperty(id);
            this.name = new SimpleStringProperty(name);
            this.price = new SimpleStringProperty(price);
            this.integerID = -1;
        }
        public MenuItemAdapter(Integer id, String name, String price) {
            this.integerID = id;
            this.id = new SimpleStringProperty(id.toString());
            this.name = new SimpleStringProperty(name);
            this.price = new SimpleStringProperty(price);
        }

        public Integer getIntegerID() {
            return integerID;
        }

        public String getId() {
            return id.get();
        }

        public SimpleStringProperty idProperty() {
            return id;
        }

        public String getName() {
            return name.get();
        }

        public SimpleStringProperty nameProperty() {
            return name;
        }

        public String getPrice() {
            return price.get();
        }

        public SimpleStringProperty priceProperty() {
            return price;
        }
    }


}

package xyz.incraft.FishkaOrder.model.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xyz.incraft.FishkaOrder.model.menu.Menu;
import xyz.incraft.FishkaOrder.model.menu.MenuItem;

import java.util.List;

/**
 * Created by Михаил on 18.01.2016.
 */
@Component
public class PickMenuAdapter {
    @Autowired
    private Menu menu;

    public boolean isValidId(Integer id){
        List<MenuItem> itemList = menu.getItems();
        for (MenuItem menuItem : itemList) {
            if(menuItem.getIdItem().equals(id)) return true;
        }
        return false;
    }
}

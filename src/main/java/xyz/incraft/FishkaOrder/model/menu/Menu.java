package xyz.incraft.FishkaOrder.model.menu;

import org.springframework.stereotype.Component;
import xyz.incraft.FishkaOrder.util.excel.MenuLoadException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Михаил on 17.01.2016.
 *
 */
@Component(value = "fishkaMenu")
public class Menu {
    private Integer id;
    private List<MenuGroup> groups;
    private List<MenuItem> items;
    private Date menuDate;

    public Menu() {
        groups = new ArrayList<>();
        items = new ArrayList<>();
    }

    public Menu(Date menuDate) {
        this.menuDate = menuDate;
        groups = new ArrayList<>();
        items = new ArrayList<>();

    }

    public List<MenuGroup> getGroups() {
        return groups;
    }

    public List<MenuItem> getItemsForGroup(MenuGroup group){
        List<MenuItem> list = new ArrayList<>();
        for (MenuItem item : items) {
            if(item.getGroup() == group) list.add(item);
        }
        return list;
    }

    public boolean isValidId(Integer id) {
        return getMenuItem(id) != null;
    }

    public MenuItem getMenuItem(Integer id) {
        for (MenuItem menuItem : items) {
            if (menuItem.getIdItem().equals(id)) return menuItem;
        }
        return null;
    }

    public void clear(){
        groups.clear();
        items.clear();
    }
    public Menu SetDate(Date d){
        menuDate = d;
        return this;
    }

    public MenuRecord addMenuRecord(MenuRecord record){
        if(record instanceof MenuGroup) return addMenuGroup((MenuGroup) record);
        if(record instanceof MenuItem) return addMenuItemToLastGroup((MenuItem) record);
        throw new MenuLoadException();
    }

    public MenuGroup addMenuGroup(MenuGroup group){
        groups.add(group);
        return group;
    }
    public MenuItem addMenuItem(MenuItem item){
        items.add(item);
        return item;
    }
    public MenuItem addMenuItemToLastGroup(MenuItem item){
        MenuGroup g = groups.get(groups.size()-1);
        item.setGroup(g);
        return addMenuItem(item);
    }

    @Override
    public String toString() {
        String st = "";
        if(items.size()==0) return "-m- empty\n";
        else st += "-m- "+ items.size() + "\n";
        st += menuDate+"\n";
        for (MenuItem item : items) st += item + "\n";
        return st;
    }
}

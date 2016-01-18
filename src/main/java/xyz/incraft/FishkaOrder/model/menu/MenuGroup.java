package xyz.incraft.FishkaOrder.model.menu;

/**
 * Created by Михаил on 17.01.2016.
 */
public class MenuGroup implements MenuRecord{
    private String name;

    public MenuGroup(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "-g- "+name;
    }
}

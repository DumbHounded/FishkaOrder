package xyz.incraft.FishkaOrder.model.menu;

/**
 * Created by Михаил on 17.01.2016.
 */
public class MenuItem implements MenuRecord{
    private String name;
    private Integer idItem;
    private Integer ourPrice;
    private Integer clientPrice;
    private Integer packPrice;
    private MenuGroup group;

    public void setGroup(MenuGroup group) {
        this.group = group;
    }

    public MenuItem(String name, Integer idItem, Integer ourPrice, Integer clientPrice, Integer packPrice) {
        this.name = name;
        this.idItem = idItem;
        this.ourPrice = ourPrice;
        this.clientPrice = clientPrice;
        this.packPrice = packPrice;
    }

    @Override
    public String toString() {
        return String.format("-i- [id]%d %s [our]%d [client]%d [pack]%d %s",idItem,name,ourPrice,clientPrice,packPrice,group);
    }

    public MenuGroup getGroup() {
        return group;
    }

    public String getName() {
        return name;
    }

    public Integer getIdItem() {
        return idItem;
    }

    public Integer getOurPrice() {
        return ourPrice;
    }

    public Integer getClientPrice() {
        return clientPrice;
    }

    public Integer getPackPrice() {
        return packPrice;
    }
}

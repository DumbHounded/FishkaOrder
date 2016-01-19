package xyz.incraft.FishkaOrder.model.adapter;

/**
 * Created by Михаил on 19.01.2016.
 */
public class PriceAdapter {

    public static String PriceToString(Integer price) {
        return String.format("%.2f", price.doubleValue() / 100.0);
    }

}

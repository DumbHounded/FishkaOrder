package xyz.incraft.FishkaOrder.view;

import javafx.util.Callback;
import org.springframework.stereotype.Component;

/**
 * Created by Михаил on 18.01.2016.
 *
 */
@Component
public class OrderController implements Callback<Class<?>,Object>{

    public Object call(Class<?> param) {
        return this;
    }
}

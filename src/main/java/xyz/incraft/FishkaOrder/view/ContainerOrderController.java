package xyz.incraft.FishkaOrder.view;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.SplitPane;
import javafx.util.Callback;
import org.springframework.stereotype.Component;

/**
 * Created by Михаил on 18.01.2016.
 */
@Component
public class ContainerOrderController implements Callback<Class<?>,Object>{

    @FXML
    private SplitPane splitPane;

    public ObservableList<Node> getItems() {
        return splitPane.getItems();
    }

    public void setDividerPositions(double... positions) {
        splitPane.setDividerPositions(positions);
    }

    public Object call(Class<?> param) {
        return this;
    }
}

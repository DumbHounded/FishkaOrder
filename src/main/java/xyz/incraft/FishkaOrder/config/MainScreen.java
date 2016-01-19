package xyz.incraft.FishkaOrder.config;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import xyz.incraft.FishkaOrder.view.ContainerOrderController;

import javax.annotation.PostConstruct;
import java.io.IOException;

/**
 * Created by Михаил on 18.01.2016.
 *
 */
@Component
public class MainScreen {
    @Autowired
    private FXMLLoader rootLoader;
    @Autowired
    private FXMLLoader orderLoader;
    @Autowired
    private FXMLLoader menuItemSelectLoader;
    @Autowired
    private FXMLLoader containerOrderLoader;
    @Autowired
    private FXMLLoader productCodeLoader;
    @Autowired
    private FXMLLoader orderListLoader;
    @Autowired
    private FXMLLoader orderCostLoader;

    @Autowired
    private BorderPane rootLayout;
    @Autowired
    private BorderPane orderLayout;
    @Autowired
    private AnchorPane menuItemSelectLayout;
    @Autowired
    private AnchorPane containerOrderLayout;
    @Autowired
    private HBox productCodeLayout;
    @Autowired
    private AnchorPane orderListLayout;
    @Autowired
    private HBox orderCostLayout;

    @Bean(name = "rootLayout")
    public BorderPane RootLayout() throws IOException {
        return (BorderPane) rootLoader.load();
    }

    @Bean(name = "orderLayout")
    public BorderPane OrderLayout() throws IOException {
        return (BorderPane) orderLoader.load();
    }

    @Bean(name = "productCodeLayout")
    public HBox ProductCodeLayout() throws IOException {
        return (HBox) productCodeLoader.load();
    }

    @Bean(name = "orderListLayout")
    public AnchorPane OrderListLayout() throws IOException {
        return (AnchorPane) orderListLoader.load();
    }

    @Bean(name = "menuItemSelectLayout")
    public AnchorPane MenuItemSelectLayout() throws IOException {
        return (AnchorPane) menuItemSelectLoader.load();
    }

    @Bean(name = "containerOrderLayout")
    public AnchorPane ContainerOrderLayout() throws IOException {
        return (AnchorPane) containerOrderLoader.load();
    }

    @Bean(name = "orderCostLayout")
    public HBox OrderCostLayout() throws IOException {
        return (HBox) orderCostLoader.load();
    }

    @PostConstruct
    public void show(){
        rootLayout.setCenter(containerOrderLayout);
        ContainerOrderController containerOrderController = containerOrderLoader.getController();
        containerOrderController.getItems().add(0,menuItemSelectLayout);
        containerOrderController.getItems().add(1,orderLayout);
        containerOrderController.setDividerPositions(0.4);
        orderLayout.setTop(productCodeLayout);
        orderLayout.setCenter(orderListLayout);
        orderLayout.setBottom(orderCostLayout);
    }
}

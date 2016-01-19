package xyz.incraft.FishkaOrder.config;

import javafx.fxml.FXMLLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import xyz.incraft.FishkaOrder.MainApp;
import xyz.incraft.FishkaOrder.view.*;

/**
 * Created by Михаил on 18.01.2016.
 */
@Configuration
public class LoaderFX {
    private final ClassLoader mainResource = MainApp.class.getClassLoader();

    @Autowired
    private RootController rootController;
    @Autowired
    private OrderController orderController;
    @Autowired
    private MenuItemSelectController menuItemSelectController;
    @Autowired
    private ContainerOrderController containerOrderController;
    @Autowired
    private ProductCodeController productCodeController;
    @Autowired
    private OrderListController orderListController;

    @Bean(name = "rootLoader")
    public FXMLLoader RootLoader(){
        FXMLLoader loader = new FXMLLoader(mainResource.getResource("root.fxml"));
        loader.setControllerFactory(rootController);
        return loader;
    }

    @Bean(name = "orderLoader")
    public FXMLLoader OrderLoader(){
        FXMLLoader loader = new FXMLLoader(mainResource.getResource("order.fxml"));
        loader.setControllerFactory(orderController);
        return loader;
    }

    @Bean(name = "menuItemSelectLoader")
    public FXMLLoader MenuItemSelectLoader(){
        FXMLLoader loader = new FXMLLoader(mainResource.getResource("menuItemSelect.fxml"));
        loader.setControllerFactory(menuItemSelectController);
        return loader;
    }

    @Bean(name = "containerOrderLoader")
    public FXMLLoader ContainerOrderLoader(){
        FXMLLoader loader = new FXMLLoader(mainResource.getResource("containerOrder.fxml"));
        loader.setControllerFactory(containerOrderController);
        return loader;
    }

    @Bean(name = "productCodeLoader")
    public FXMLLoader ProductCodeLoader() {
        FXMLLoader loader = new FXMLLoader(mainResource.getResource("productCode.fxml"));
        loader.setControllerFactory(productCodeController);
        return loader;
    }

    @Bean(name = "orderListLoader")
    public FXMLLoader OrderListLoader() {
        FXMLLoader loader = new FXMLLoader(mainResource.getResource("orderList.fxml"));
        loader.setControllerFactory(orderListController);
        return loader;
    }
}

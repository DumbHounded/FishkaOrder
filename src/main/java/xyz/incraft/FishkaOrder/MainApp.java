package xyz.incraft.FishkaOrder;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Михаил on 18.01.2016.
 */
public class MainApp extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Формирование заказа");
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        BorderPane root = context.getBean("rootLayout",BorderPane.class);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

package xyz.incraft.FishkaOrder.view;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.util.Callback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xyz.incraft.FishkaOrder.model.adapter.PickMenuAdapter;

/**
 * Created by Михаил on 18.01.2016.
 */
@Component
public class OrderController implements Callback<Class<?>,Object>{

    @Autowired
    private PickMenuAdapter pickMenuAdapter;

    private String defaultTextStyle="";

    @FXML
    private TextField textField;

    @FXML
    private void initialize(){
        defaultTextStyle = textField.getStyle();
    }

    @FXML
    private void OnTextChangedFromKeyboard(){
        String st = textField.getText();
        TestEnterCode(st);
    }

    @FXML
    private void OnTextAction(){
        textField.setText("");
        DefaultColorTextField();
    }

    public void TestAndSetCode(Integer id){
        if(pickMenuAdapter.isValidId(id)) {
            ValidColorTextField();
            textField.setText(id.toString());
        }
    }

    private void TestEnterCode(String st){
        if(st.isEmpty()) {
            DefaultColorTextField();
            return;
        }
        try {
            Integer id = Integer.parseInt(st);
            TestEnterCode(id);
        } catch (NumberFormatException e){
            InvalidColorTextField();
        }
    }

    private void TestEnterCode(Integer id){
        if(pickMenuAdapter.isValidId(id)) ValidColorTextField();
        else DefaultColorTextField();
    }

    private void InvalidColorTextField(){
        textField.setStyle("-fx-background-color: lightcoral");
    }
    private void ValidColorTextField(){
        textField.setStyle("-fx-background-color: aquamarine");
    }
    private void DefaultColorTextField(){
        textField.setStyle(defaultTextStyle);
    }

    public Object call(Class<?> param) {
        return this;
    }
}

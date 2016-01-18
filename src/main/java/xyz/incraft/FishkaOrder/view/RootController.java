package xyz.incraft.FishkaOrder.view;

import javafx.fxml.FXML;
import javafx.stage.FileChooser;
import javafx.util.Callback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xyz.incraft.FishkaOrder.model.adapter.TreeItemMenuAdapter;
import xyz.incraft.FishkaOrder.model.menu.Menu;
import xyz.incraft.FishkaOrder.util.excel.ExcelMenuLoader;

import java.io.File;
import java.io.IOException;

/**
 * Created by Михаил on 18.01.2016.
 */
@Component
public class RootController implements Callback<Class<?>,Object>{

    @Autowired
    private ExcelMenuLoader excelMenuLoader;
    @Autowired
    private TreeItemMenuAdapter treeItemMenuAdapter;

    @FXML
    public void LoadFromExcel() throws IOException {
        System.out.println("Загрузка меню из Excel");
/*
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Выбери файл Excel для импорта");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Excel файлы", "*.xls"),
                new FileChooser.ExtensionFilter("Все файлы", "*.*"));
        File selectedFile = fileChooser.showOpenDialog(null);
        if(selectedFile == null) return;

        excelMenuLoader.ReadExcel(selectedFile.getPath());
*/
        excelMenuLoader.ReadExcel("c:/work/menu/Заявка на 16 декабря.xls");
        treeItemMenuAdapter.rebuild();
    }

    public Object call(Class<?> param) {
        return this;
    }
}

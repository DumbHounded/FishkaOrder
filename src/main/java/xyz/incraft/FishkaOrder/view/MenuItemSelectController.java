package xyz.incraft.FishkaOrder.view;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.util.Callback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xyz.incraft.FishkaOrder.model.adapter.TreeItemMenuAdapter;

/**
 * Created by Михаил on 18.01.2016.
 *
 */
@Component
public class MenuItemSelectController implements Callback<Class<?>,Object>{

    @Autowired
    private TreeItemMenuAdapter treeItemMenuAdapter;
    @Autowired
    private ProductCodeController productCodeController;

    @FXML
    private TreeTableView<TreeItemMenuAdapter.MenuItemAdapter> treeTableView;
    @FXML
    private TreeTableColumn<TreeItemMenuAdapter.MenuItemAdapter,String> idTableColumn;
    @FXML
    private TreeTableColumn<TreeItemMenuAdapter.MenuItemAdapter,String> nameTableColumn;
    @FXML
    private TreeTableColumn<TreeItemMenuAdapter.MenuItemAdapter,String> priceTableColumn;

    @FXML
    private void initialize() {
        idTableColumn.setCellValueFactory(
                (TreeTableColumn.CellDataFeatures<TreeItemMenuAdapter.MenuItemAdapter, String> param) ->
                        new ReadOnlyStringWrapper(param.getValue().getValue().getId()));
        nameTableColumn.setCellValueFactory(
                (TreeTableColumn.CellDataFeatures<TreeItemMenuAdapter.MenuItemAdapter, String> param) ->
                        new ReadOnlyStringWrapper(param.getValue().getValue().getName()));
        priceTableColumn.setCellValueFactory(
                (TreeTableColumn.CellDataFeatures<TreeItemMenuAdapter.MenuItemAdapter, String> param) ->
                        new ReadOnlyStringWrapper(param.getValue().getValue().getPrice()));

        treeTableView.setRoot(treeItemMenuAdapter.getTreeItem());

        treeTableView.setShowRoot(false);
    }

    @FXML
    private void OnMouseClicked(){
        ObservableList<TreeItem<TreeItemMenuAdapter.MenuItemAdapter>> list = treeTableView.getSelectionModel().getSelectedItems();
        if(list.size()==0) return;
        Integer id = list.get(0).getValue().getIntegerID();
        if(id == -1) return;
        productCodeController.TestAndSetCode(id);
    }

    public Object call(Class<?> param) {
        return this;
    }
}

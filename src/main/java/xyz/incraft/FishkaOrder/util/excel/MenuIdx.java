package xyz.incraft.FishkaOrder.util.excel;

import org.apache.poi.hssf.usermodel.HSSFCell;

/**
 * Created by Михаил on 17.01.2016.
 */
public enum MenuIdx {
    idMENU(0, HSSFCell.CELL_TYPE_NUMERIC),
    NAME(1, HSSFCell.CELL_TYPE_STRING),
    ourPRICE(3,HSSFCell.CELL_TYPE_NUMERIC),
    packPRICE(5,HSSFCell.CELL_TYPE_NUMERIC),
    clientPRICE(7,HSSFCell.CELL_TYPE_NUMERIC);

    int idx,type;
    MenuIdx(int idx,int type){
        this.idx = idx;
        this.type = type;
    }
}

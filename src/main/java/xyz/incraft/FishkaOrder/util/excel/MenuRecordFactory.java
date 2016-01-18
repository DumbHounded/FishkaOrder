package xyz.incraft.FishkaOrder.util.excel;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import xyz.incraft.FishkaOrder.model.menu.MenuGroup;
import xyz.incraft.FishkaOrder.model.menu.MenuItem;
import xyz.incraft.FishkaOrder.model.menu.MenuRecord;

/**
 * Created by Михаил on 17.01.2016.
 */
public class MenuRecordFactory {

    public static MenuRecord getMenuRecord(HSSFRow row) {
        HSSFCell c1 = row.getCell(MenuIdx.NAME.idx);
        if (c1 == null) return null;
        if (c1.getCellType() != MenuIdx.NAME.type) return null;
        HSSFCellStyle style = c1.getCellStyle();
        if (style.getAlignment() == HSSFCellStyle.ALIGN_CENTER) return new MenuGroup(c1.getStringCellValue());

        Integer id = 0, ourPrice = 0, packPrice = 0, clientPrice = 0;
        String name = "";

        try {
            for (MenuIdx menuIdx : MenuIdx.values()) {
                HSSFCell cx = row.getCell(menuIdx.idx);
                if (cx == null || cx.getCellType() != menuIdx.type) return null;
                if (menuIdx == MenuIdx.idMENU) id = (int) cx.getNumericCellValue();
                else if (menuIdx == MenuIdx.NAME) name = cx.getStringCellValue();
                else if (menuIdx == MenuIdx.ourPRICE) ourPrice = (int) (cx.getNumericCellValue() * 100.0);
                else if (menuIdx == MenuIdx.clientPRICE) clientPrice = (int) (cx.getNumericCellValue() * 100.0);
                else if (menuIdx == MenuIdx.packPRICE) packPrice = (int) (cx.getNumericCellValue() * 100.0);
            }
        } catch (NumberFormatException e) {
            return null;
        }
        return new MenuItem(name, id, ourPrice, clientPrice, packPrice);
    }
}

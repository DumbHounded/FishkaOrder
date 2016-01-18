package xyz.incraft.FishkaOrder.util.excel;

import org.apache.poi.hssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xyz.incraft.FishkaOrder.model.menu.Menu;
import xyz.incraft.FishkaOrder.model.menu.MenuRecord;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by Михаил on 17.01.2016.
 */
@Component(value = "excelMenuLoader")
public class ExcelMenuLoader {
    @Autowired
    private Menu menu;

    public void ReadExcel(String filename) throws IOException {
        menu.clear();
        try (HSSFWorkbook myExcelBook = new HSSFWorkbook(new FileInputStream(filename))) {
            int activeSheetIndex = myExcelBook.getActiveSheetIndex();
            HSSFSheet myExcelSheet = myExcelBook.getSheetAt(activeSheetIndex);
            String activeSheetName = myExcelSheet.getSheetName();
            System.out.println("Читается вкладка: " + activeSheetName);
            int rowCount = myExcelSheet.getPhysicalNumberOfRows();
            System.out.println(rowCount);

            for (int i = 0; i < rowCount; i++) {
                HSSFRow r = myExcelSheet.getRow(i);
                if (r == null) continue;
                MenuRecord menuRecord = MenuRecordFactory.getMenuRecord(r);
                if (menuRecord == null) continue;
                menu.addMenuRecord(menuRecord);
            }
        }
    }
}

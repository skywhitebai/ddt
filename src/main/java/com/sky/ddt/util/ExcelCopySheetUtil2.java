package com.sky.ddt.util;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.Region;

/**
 * @author baixueping
 * @description 复制sheet
 * @date 2020/10/30 11:17
 */
public class ExcelCopySheetUtil2 {
    public static void copySheets(HSSFSheet sheet, HSSFSheet newSheet) {
        copySheet(sheet, newSheet);

    }

    /**
     * 新增sheet，并且复制sheet内容到新增的sheet里
     */
    private static void copySheet(HSSFSheet fromsheet, HSSFSheet newSheet) {
        int firstrow = fromsheet.getFirstRowNum();
        int lasttrow = fromsheet.getLastRowNum();
        // 复制一个单元格样式到新建单元格
        if ((firstrow == -1) || (lasttrow == -1) || lasttrow < firstrow) {
            return;
        }
        // 复制合并的单元格
        Region region = null;
        for (int i = 0; i < fromsheet.getNumMergedRegions(); i++) {
            region = fromsheet.getMergedRegionAt(i);
            if ((region.getRowFrom() >= firstrow) && (region.getRowTo() <= lasttrow)) {
                newSheet.addMergedRegion(region);
            }
        }
        HSSFRow fromRow = null;
        HSSFRow newRow = null;
        HSSFCell newCell = null;
        HSSFCell fromCell = null;
        // 设置列宽
        for (int i = firstrow; i < lasttrow; i++) {
            fromRow = fromsheet.getRow(i);
            if (fromRow != null) {
                for (int j = fromRow.getLastCellNum(); j >= fromRow.getFirstCellNum(); j--) {
                    int colnum = fromsheet.getColumnWidth((short) j);
                    if (colnum > 100) {
                        newSheet.setColumnWidth((short) j, (short) colnum);
                    }
                    if (colnum == 0) {
                        newSheet.setColumnHidden((short) j, true);
                    } else {
                        newSheet.setColumnHidden((short) j, false);
                    }
                }
                break;
            }
        }
        // 复制行并填充数据
        for (int i = 0; i < lasttrow; i++) {
            fromRow = fromsheet.getRow(i);
            if (fromRow == null) {
                continue;
            }
            newRow = newSheet.createRow(i - firstrow);
            newRow.setHeight(fromRow.getHeight());
            for (int j = fromRow.getFirstCellNum(); j < fromRow.getPhysicalNumberOfCells(); j++) {
                fromCell = fromRow.getCell((short) j);
                if (fromCell == null) {
                    continue;
                }
                newCell = newRow.createCell((short) j);
                newCell.setCellStyle(fromCell.getCellStyle());
                int cType = fromCell.getCellType();
                newCell.setCellType(cType);
                switch (cType) {
                    case HSSFCell.CELL_TYPE_STRING:
                        newCell.setCellValue(fromCell.getRichStringCellValue());
                        break;
                    case HSSFCell.CELL_TYPE_NUMERIC:
                        newCell.setCellValue(fromCell.getNumericCellValue());
                        break;
                    case HSSFCell.CELL_TYPE_FORMULA:
                        newCell.setCellValue(fromCell.getCellFormula());
                        break;
                    case HSSFCell.CELL_TYPE_BOOLEAN:
                        newCell.setCellValue(fromCell.getBooleanCellValue());
                        break;
                    case HSSFCell.CELL_TYPE_ERROR:
                        newCell.setCellValue(fromCell.getErrorCellValue());
                        break;
                    default:
                        newCell.setCellValue(fromCell.getRichStringCellValue());
                        break;
                }
            }
        }
    }

}

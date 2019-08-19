package com.example.io.excel.Read;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Liao Feng
 * @Description //TODO
 * @Date 2019/8/19/019 19:07
 * @Version 1.0
 */
public class ExcelImport {
    public static void main(String args[]) {
        String filePath = "F://业务元数据12ccfe3200394c73a7c922d4c1de059e.xlsx";
        ExcelImport excelImport = new ExcelImport();
        try {
            excelImport.importExcelAction(filePath);
        } catch (Exception e) {
        // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    //导入Excel数据 (xlsx格式)

    public void importExcelAction(String filePath) throws Exception {

        //文件路径
        XSSFWorkbook wookbook = new XSSFWorkbook(new FileInputStream(filePath));
        XSSFSheet sheet = wookbook.getSheet("Sheet1");
        //获取到Excel文件中的所有行数
        int rows = sheet.getPhysicalNumberOfRows();
        //遍历行
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < rows; i++) {
            // 读取左上端单元格
            XSSFRow row = sheet.getRow(i);
            // 行不为空
            if (row != null) {

                Map<String, Object> map = new HashMap<String, Object>();
                //获取到Excel文件中的所有的列
                int cells = row.getPhysicalNumberOfCells();
                for (int j = 0; j < cells; j++) {
                    //i行第j列
                    XSSFCell value = row.getCell(j);
                    System.out.println(value.toString());
                    if("唯一id".equals(value.toString())) {
                        System.out.println(row.getCell(j+1));

                    }
                }
//                System.out.println(cells);
//                XSSFCell one = row.getCell(0);
//                map.put("0",one);
//                XSSFCell nameCell = row.getCell(1);
//                map.put("1",nameCell);
//
//                XSSFCell sexCell = row.getCell(2);
//                map.put("2",sexCell);
//
//                XSSFCell ageCell = row.getCell(3);
//                map.put("3",ageCell);
//
//                XSSFCell birthCell = row.getCell(4);
//                map.put("4",birthCell);
//                XSSFCell cell5 = row.getCell(5);
//                map.put("5",cell5);
//                XSSFCell cell6 = row.getCell(6);
//                map.put("6",cell6);
//                XSSFCell cell7 = row.getCell(7);
//                map.put("7",cell7);
//                XSSFCell cell8 = row.getCell(8);
//                map.put("8",cell8);
//                System.out.println(map);
            }
        }
    }
    public void importExcel(String filePath) throws Exception{
        Workbook workbook = new HSSFWorkbook(new FileInputStream(filePath));
    }
}

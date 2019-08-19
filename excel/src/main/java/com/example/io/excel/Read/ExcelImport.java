package com.example.io.excel.Read;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
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
    private static final String EXCEL_XLS = "xls";
    private static final String EXCEL_XLSX = "xlsx";
    public static void main(String args[]) {
        String filePath = "F://业务元数据12ccfe3200394c73a7c922d4c1de059e.xlsx";
        String dir = "F:" + File.separator + "test";

        ExcelImport excelImport = new ExcelImport();
        try {
            excelImport.readExcelAction(dir);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    //导入Excel数据 (xlsx格式)

    public void readExcelAction(String dir) throws Exception {
        File[] files = new File(dir).listFiles();
        String filePath;
        for (File file : files) {
            filePath = file.getPath();
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
                        if ("唯一id".equals(value.toString())) {
                            System.out.println(row.getCell(j + 1));
                        }
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

    public void readExcel(String filePath) throws Exception {
        Workbook workbook = new HSSFWorkbook(new FileInputStream(filePath));
    }
    public void writeExcel(List<Map> dataList, int cloumnCount,String finalXlsxPath) {
        String EXCEL_XLS = "xls";
        String EXCEL_XLSX = "xlsx";
        OutputStream out = null;
        try {
            // 获取总列数
            int columnNumCount = cloumnCount;
            // 读取Excel文档
            File finalXlsxFile = new File(finalXlsxPath);
            Workbook workBook = getWorkbok(finalXlsxFile);
            // sheet 对应一个工作页
            Sheet sheet = workBook.getSheetAt(0);
            /**
             * 删除原有数据，除了属性列
             */
            // 第一行从0开始算
            int rowNumber = sheet.getLastRowNum();
            System.out.println("原始数据总行数，除属性列：" + rowNumber);
            for (int i = 1; i <= rowNumber; i++) {
                Row row = sheet.getRow(i);
                sheet.removeRow(row);
            }
            // 创建文件输出流，输出电子表格：这个必须有，否则你在sheet上做的任何操作都不会有效
            out =  new FileOutputStream(finalXlsxPath);
            workBook.write(out);
            /**
             * 往Excel中写新数据
             */
            for (int j = 0; j < dataList.size(); j++) {
                // 创建一行：从第二行开始，跳过属性列
                Row row = sheet.createRow(j + 1);
                // 得到要插入的每一条记录
                Map dataMap = dataList.get(j);
                String name = dataMap.get("BankName").toString();
                String address = dataMap.get("Addr").toString();
                String phone = dataMap.get("Phone").toString();
                for (int k = 0; k <= columnNumCount; k++) {
                    // 在一行内循环
                    Cell first = row.createCell(0);
                    first.setCellValue(name);
                    Cell second = row.createCell(1);
                    second.setCellValue(address);
                    Cell third = row.createCell(2);
                    third.setCellValue(phone);
                }
            }
            // 创建文件输出流，准备输出电子表格：这个必须有，否则你在sheet上做的任何操作都不会有效
            out =  new FileOutputStream(finalXlsxPath);
            workBook.write(out);
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            try {
                if(out != null){
                    out.flush();
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("数据导出成功");
    }
    public static Workbook getWorkbok(File file) throws IOException{
        Workbook wb = null;
        FileInputStream in = new FileInputStream(file);
        //Excel&nbsp;2003
        if(file.getName().endsWith(EXCEL_XLS)){
            wb = new HSSFWorkbook(in);
            // Excel 2007/2010
        }else if(file.getName().endsWith(EXCEL_XLSX)){
            wb = new XSSFWorkbook(in);
        }
        return wb;
    }
}

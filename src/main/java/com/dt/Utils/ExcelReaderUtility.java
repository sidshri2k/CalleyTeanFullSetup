package com.dt.Utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReaderUtility {
    final static  String ecxeclfilepath="src/main/java/resources/TestData/siddhulogin.xlsx";

    static XSSFWorkbook workbook;
    static XSSFSheet sheet;
    static XSSFRow row;
    static XSSFCell cell;
    static  String sheetName="Sheet1";

    public  static String[][] getDataForExcel() throws IOException {

        workbook=new XSSFWorkbook(new FileInputStream(new File(ecxeclfilepath)));
        sheet=workbook.getSheet(sheetName);
        row=sheet.getRow(0);

        int noOfRow=sheet.getPhysicalNumberOfRows();
        int noOfcell=row.getLastCellNum();

        DataFormatter df=new DataFormatter();

        String [][]  logindata=new String[noOfRow-1][noOfcell];
        for (int i=1; i<noOfRow; i++)
        {
            for (int j=0; j<noOfcell; j++)
            {
                logindata[i-1][j]=df.formatCellValue(sheet.getRow(i).getCell(j));
            }
        }
        return  logindata;

    }


}

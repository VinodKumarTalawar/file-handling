package com.trilpillar;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class WriteExcel {
    public static void main(String[] args) {
        String excelFilePath = "example.xlsx";

        // Write to the Excel file
        writeToExcel(excelFilePath);


    }

    public static void writeToExcel(String filePath) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Sheet1");

        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Name");
        headerRow.createCell(1).setCellValue("Age");

        Row row1 = sheet.createRow(1);
        row1.createCell(0).setCellValue("Alice");
        row1.createCell(1).setCellValue(30);

        Row row2 = sheet.createRow(2);
        row2.createCell(0).setCellValue("Bob");
        row2.createCell(1).setCellValue(25);

        try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
            workbook.write(fileOut);
            System.out.println("Excel file written successfully.");
        } catch (IOException e) {
            System.err.println("Error writing to Excel file: " + e.getMessage());
        } finally {
            try {
                workbook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}

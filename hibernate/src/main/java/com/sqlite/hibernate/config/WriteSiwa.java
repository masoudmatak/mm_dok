package com.sqlite.hibernate.config;

import java.io.IOException;
import java.io.FileOutputStream;
import java.util.List;

import com.sqlite.hibernate.dao.SiswaDao;
import com.sqlite.hibernate.entity.SiswaEntity;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


/**
 * Created by Agus Suhardi on 4/16/2017.
 */
public class WriteSiwa {

    public static void main(String[] args) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("raport");

        SiswaDao dao = HibernateUtil.getSiswaDao();
        List<SiswaEntity> list = dao.findAll();

        Object[][] bookData = {
        };

        int rowCount = 0;

        for (Object[] aBook : bookData) {
            Row row = sheet.createRow(++rowCount);

            int columnCount = 0;

            for (Object field : aBook) {
                Cell cell = row.createCell(++columnCount);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                } else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);
                }
            }

        }


        try (FileOutputStream outputStream = new FileOutputStream("contoh.xlsx")) {
            workbook.write(outputStream);
        }
    }
}

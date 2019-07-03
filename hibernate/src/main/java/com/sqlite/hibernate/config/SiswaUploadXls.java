package com.sqlite.hibernate.config;

import com.sqlite.hibernate.dao.SiswaDao;
import com.sqlite.hibernate.entity.SiswaEntity;
import jxl.Sheet;
import jxl.Workbook;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Agus Suhardi on 2/17/2017.
 */
public class SiswaUploadXls {

    private static SiswaDao dao = HibernateUtil.getSiswaDao();


    private Workbook excelWorkbook;
    private Sheet excelSheet;

    SiswaUploadXls(String FilePath) throws Exception {
        File excelFile = new File(FilePath);
        excelWorkbook = Workbook.getWorkbook(excelFile);
        excelSheet = excelWorkbook.getSheet(0);
    }

    public String getString(int x, int y) throws Exception {
        try {
            return excelSheet.getCell(x, y).getContents();

        } catch (Exception ex) {
            throw new Exception("Data tidak ada");
        }
    }

    public SiswaUploadXls() {
    }

    //        public static void main(String[] args) throws Exception {
    public static void save(String path) throws Exception {
        SiswaEntity dataSiswa = new SiswaEntity();

        List<String> listData = new ArrayList<>();

        SiswaUploadXls tempExcel;
        tempExcel = new SiswaUploadXls(path);

        for (int i = 2; i < tempExcel.excelSheet.getRows(); i++) {

            for (int j = 0; j < tempExcel.excelSheet.getColumns(); j++) {
                listData.add(j, tempExcel.getString(j, i));
            }

            //set value
            dataSiswa.setNis(listData.get(0));
            dataSiswa.setNama(listData.get(1));
            dataSiswa.setNilai(Integer.parseInt(listData.get(2)));
            dataSiswa.setKelas(Integer.parseInt(listData.get(3)));
            dataSiswa.setGuru(listData.get(4));


            //simpan siswa
            dao.save(dataSiswa);

            //kosongkan object
            listData = new ArrayList<>();
            dataSiswa = new SiswaEntity();

        }
    }
}

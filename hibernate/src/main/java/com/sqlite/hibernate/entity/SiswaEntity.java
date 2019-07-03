package com.sqlite.hibernate.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by Agus Suhardi on 4/16/2017.
 */
@Entity
@Table(name = "siswa")
public class SiswaEntity extends user implements Serializable{

    public SiswaEntity() {
    }

    public SiswaEntity(String nis, String nama, int nilai, int kelas, String guru) {
        this.nis = nis;
        this.nama = nama;
        this.nilai = nilai;
        this.kelas = kelas;
        this.guru = guru;
    }



    @Id
    private String nis;
    private String nama;
    private int nilai;
    private int kelas;
    private String guru;

    public String getNis() {
        return nis;
    }

    public void setNis(String nis) {
        this.nis = nis;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getNilai() {
        return nilai;
    }

    public void setNilai(int nilai) {
        this.nilai = nilai;
    }

    public int getKelas() {
        return kelas;
    }

    public void setKelas(int kelas) {
        this.kelas = kelas;
    }

    public String getGuru() {
        return guru;
    }

    public void setGuru(String guru) {
        this.guru = guru;
    }
}

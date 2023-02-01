package com.example.mysqlite;

public class SinhVien {
    private String masv;
    private String tensv;
    private int tuoi;

    public SinhVien(String masv, String tensv, int tuoi) {
        this.masv = masv;
        this.tensv = tensv;
        this.tuoi = tuoi;
    }

    public SinhVien() {
    }

    public String getMasv() {
        return masv;
    }

    public void setMasv(String masv) {
        this.masv = masv;
    }

    public String getTensv() {
        return tensv;
    }

    public void setTensv(String tensv) {
        this.tensv = tensv;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }
}

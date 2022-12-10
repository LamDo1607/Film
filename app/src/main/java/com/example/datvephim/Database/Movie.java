package com.example.datvephim.Database;


public class Movie {

    String TenPhim, NoiDung, DaoDien, DienVien, NgonNgu, ThoiLuong, Id, NgayCongChieu;
    int Anh;

    public Movie(String tenPhim, String noiDung, String daoDien, String dienVien, String ngonNgu, String thoiLuong, String id, String ngayCongChieu, int anh) {
        TenPhim = tenPhim;
        NoiDung = noiDung;
        DaoDien = daoDien;
        DienVien = dienVien;
        NgonNgu = ngonNgu;
        ThoiLuong = thoiLuong;
        Id = id;
        NgayCongChieu = ngayCongChieu;
        Anh = anh;
    }

    public Movie(){}

    public int getAnh() {
        return Anh;
    }

    public int setAnh(int anh) {
        Anh = anh;
        return anh;
    }

    public String getTenPhim() {
        return TenPhim;
    }

    public CharSequence setTenPhim(String tenPhim) {
        TenPhim = tenPhim;
        return null;
    }

    public String getNoiDung() {
        return NoiDung;
    }

    public CharSequence setNoiDung(String noiDung) {
        NoiDung = noiDung;
        return null;
    }

    public String getDaoDien() {
        return DaoDien;
    }

    public CharSequence setDaoDien(String daoDien) {
        DaoDien = daoDien;
        return null;
    }

    public String getDienVien() {
        return DienVien;
    }

    public CharSequence setDienVien(String dienVien) {
        DienVien = dienVien;
        return null;
    }

    public String getNgonNgu() {
        return NgonNgu;
    }

    public CharSequence setNgonNgu(String ngonNgu) {
        NgonNgu = ngonNgu;
        return null;
    }

    public String getThoiLuong() {
        return ThoiLuong;
    }

    public CharSequence setThoiLuong(String thoiLuong) {
        ThoiLuong = thoiLuong;
        return null;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getNgayCongChieu() {
        return NgayCongChieu;
    }

    public int setNgayCongChieu(String ngayCongChieu) {
        NgayCongChieu = ngayCongChieu;
        return 0;
    }

}

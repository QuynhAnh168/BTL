package com.example.baitaplon.Model;

import android.database.Cursor;

import com.example.baitaplon.DataBase;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LichHen implements Serializable {
    private static final String TABLE_VAT_TU = "tblLichHen";
    private static final String COLUMN_ID = "idLichHen";
    private static final String COLUMN_ID_KHACH_HANG = "idKhachHang";
    private static final String COLUMN_ID_NHAN_VIEN = "idNhanVien";
    private static final String COLUMN_ID_DICH_VU = "idDichVu";
    private static final String COLUMN_NGAY_HEN = "ngayHen";
    private static final String COLUMN_THƠI_GIAN_HEN = "thoiGianHen";
    private static final String COLUMN_TRANG_THAI = "trangThai";
    private static final String COLUMN_GHI_CHU = "ghiChu";
    public String idLichHen;
    public String idKhachHang;
    public String idNhanVien;
    public String idDichVu;
    public Date ngayHen;
    public Time thoiGianHen;
    public String trangThai;
    public String ghiChu;
    private DataBase myDatabase;

    public LichHen() {
    }

//    public LichHen(String idLichHen, String idKhachHang, String idNhanVien, String idDichVu, Date ngayHen, Time thoiGianHen, String trangThai, String ghiChu) {
//        this.idLichHen = idLichHen;
//        this.idKhachHang = idKhachHang;
//        this.idNhanVien = idNhanVien;
//        this.idDichVu = idDichVu;
//        this.ngayHen = ngayHen;
//        this.thoiGianHen = thoiGianHen;
//        this.trangThai = trangThai;
//        this.ghiChu = ghiChu;
//    }
    public LichHen(String idLichHen, String idKhachHang, String idNhanVien, String idDichVu, Date ngayHen, Time thoiGianHen, String trangThai, String ghiChu) {
        this.idLichHen = idLichHen;
        this.idKhachHang = idKhachHang;
        this.idNhanVien = idNhanVien;
        this.idDichVu = idDichVu;
        this.ngayHen = ngayHen;
        this.thoiGianHen = thoiGianHen;
        this.trangThai = trangThai;
        this.ghiChu = ghiChu;
    }

    public LichHen(String idLichHen, String idKhachHang, String idNhanVien, String idDichVu, Date ngayHen, Timestamp thoiGianHenSql, String trangThai, String ghiChu) {
    }

    public String getIdLichHen() {
        return idLichHen;
    }

    public void setIdLichHen(String idLichHen) {
        this.idLichHen = idLichHen;
    }

    public String getIdKhachHang() {
        return idKhachHang;
    }

    public void setIdKhachHang(String idKhachHang) {
        this.idKhachHang = idKhachHang;
    }

    public String getIdNhanVien() {
        return idNhanVien;
    }

    public void setIdNhanVien(String idNhanVien) {
        this.idNhanVien = idNhanVien;
    }

    public String getIdDichVu() {
        return idDichVu;
    }

    public void setIdDichVu(String idDichVu) {
        this.idDichVu = idDichVu;
    }

    public Date getNgayHen() {
        return ngayHen;
    }

    public void setNgayHen(Date ngayHen) {
        this.ngayHen = ngayHen;
    }

    public Time getThoiGianHen() {
        return thoiGianHen;
    }

    public void setThoiGianHen(Time thoiGianHen) {
        this.thoiGianHen = thoiGianHen;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public DataBase getMyDatabase() {
        return myDatabase;
    }

    public void setMyDatabase(DataBase myDatabase) {
        this.myDatabase = myDatabase;
    }
    public List<LichHen> getAll() {
        List<LichHen> lichHenList = new ArrayList<>();
        Cursor cursor = myDatabase.selectData("SELECT * FROM tblLichHen");
        Date ngayHen = null;
        Time gioHen = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        while (cursor.moveToNext())
        {
            String idLichHen = cursor.getString(0);
            String idKhachHang = cursor.getString(1);
            String idNhanVien = cursor.getString(2);
            String idDichVu = cursor.getString(3);
            if (cursor.moveToFirst()) {
                String ngayHenStr = cursor.getString(4); // Lấy giá trị ngày hẹn từ cột thứ 2
                try {
                    ngayHen = dateFormat.parse(ngayHenStr); // Chuyển đổi chuỗi thành đối tượng Date
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            if (cursor.moveToFirst()) {
                String gioHenStr = cursor.getString(5); // Lấy giá trị thời gian từ cột thứ 2
                gioHen = Time.valueOf(gioHenStr); // Chuyển đổi chuỗi thành đối tượng Time
            }
            String trangThai = cursor.getString(6);
            String ghiChu = cursor.getString(7);

            lichHenList.add(new LichHen(idLichHen,idKhachHang,idNhanVien,idDichVu,ngayHen,gioHen,trangThai,ghiChu));
        }
        return lichHenList;
    }
}

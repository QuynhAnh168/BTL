package com.example.baitaplon;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.baitaplon.Model.LichHen;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
public class QuanLyLichHen extends AppCompatActivity {
    ListView lichHenListView;
    private LichHenAdapter lichHenAdapter;
    private ArrayList<LichHen> lichHenList;
    private DataBase dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_ly_lich_hen);

        Button btnThem = findViewById(R.id.btnThem);
        Button btnTimKiem = findViewById(R.id.btnTimKiem);
        Button btnXuatVatTu = findViewById(R.id.btnXuatVatTu);
        EditText edtTenVatTu = findViewById(R.id.edtTenVatTu);
        EditText edtIDVatTu = findViewById(R.id.edtIDVatTu);
        lichHenListView = findViewById(R.id.lichHenListView);

        dataBase = new DataBase(this);
        lichHenList = new ArrayList<>();
        lichHenAdapter = new LichHenAdapter(this, lichHenList);
        lichHenListView.setAdapter(lichHenAdapter);

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QuanLyLichHen.this, ThemVatTu.class);
                startActivity(intent);
            }
        });

        btnTimKiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String idVatTu = edtIDVatTu.getText().toString();
                String tenVatTu = edtTenVatTu.getText().toString();

                timKiem(idVatTu, tenVatTu);
            }
        });

        lichHenAdapter.setOnEditClickListener(new LichHenAdapter.OnEditClickListener() {
            @Override
            public void onEditClick(int position) {
                LichHen selectedLichHen = lichHenList.get(position);
                suaLichHen(selectedLichHen);
            }
        });

        loadData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadData();
    }

    private void loadData() {
        lichHenList.clear();

        Cursor cursor = dataBase.selectData("SELECT * FROM tblLichHen");
        while (cursor.moveToNext()) {
            String idLichHen = cursor.getString(0);
            String idKhachHang = cursor.getString(1);
            String idNhanVien = cursor.getString(2);
            String idDichVu = cursor.getString(3);
            String ngayHenString = cursor.getString(4);
            String thoiGianHenString = cursor.getString(5);
            String trangThai = cursor.getString(6);
            String ghiChu = cursor.getString(7);

            Date ngayHen = null;
            try {
                ngayHen = new SimpleDateFormat("yyyy-MM-dd").parse(ngayHenString);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Time thoiGianHen = Time.valueOf(thoiGianHenString);
            Timestamp thoiGianHenSql = new Timestamp(thoiGianHen.getTime());

            LichHen lichHen = new LichHen(idLichHen, idKhachHang, idNhanVien, idDichVu, ngayHen, thoiGianHenSql, trangThai, ghiChu);
            lichHenList.add(lichHen);
        }

        cursor.close();

        lichHenAdapter.notifyDataSetChanged();
    }

    private void timKiem(String idVatTu, String tenVatTu) {
        // Thực hiện tìm kiếm và hiển thị kết quả vào ListView
        // ...
    }

    private void suaLichHen(LichHen lichHen) {
        // Thực hiện sửa lịch hẹn
        // ...
    }
}
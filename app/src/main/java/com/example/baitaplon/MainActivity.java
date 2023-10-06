package com.example.baitaplon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnQLVatTu, btnQLLichHen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnQLVatTu = findViewById(R.id.btnQLVatTu);
        btnQLLichHen = findViewById(R.id.btnQLLichHen);
        btnQLVatTu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, QuanLyVatTu.class);
                startActivity(intent);
            }
        });
        btnQLLichHen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, QuanLyLichHen.class);
                startActivity(intent);
            }
        });
    }
}
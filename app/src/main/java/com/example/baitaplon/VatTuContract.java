package com.example.baitaplon;

import android.provider.BaseColumns;

public class VatTuContract {

    private VatTuContract() {}

    public static class VatTuEntry implements BaseColumns {
        public static final String TABLE_NAME = "vat_tu";
        public static final String COLUMN_TEN_VAT_TU = "ten_vat_tu";
        public static final String COLUMN_SO_LUONG = "so_luong";
    }
}
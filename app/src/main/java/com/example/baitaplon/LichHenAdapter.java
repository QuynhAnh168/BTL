package com.example.baitaplon;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.baitaplon.Model.LichHen;
import com.example.baitaplon.Model.VatTu;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
public class LichHenAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<LichHen> lichHenList;
    private OnDeleteClickListener onDeleteClickListener;
    private OnEditClickListener onEditClickListener;

    public LichHenAdapter(Context context, ArrayList<LichHen> lichHenList) {
        this.context = context;
        this.lichHenList = lichHenList;
    }

    public interface OnDeleteClickListener {
        void onDeleteClick(int position);
    }

    public interface OnEditClickListener {
        void onEditClick(int position);
    }

    public void setOnDeleteClickListener(OnDeleteClickListener listener) {
        this.onDeleteClickListener = listener;
    }

    public void setOnEditClickListener(OnEditClickListener listener) {
        this.onEditClickListener = listener;
    }

    @Override
    public int getCount() {
        return lichHenList.size();
    }

    @Override
    public Object getItem(int i) {
        return lichHenList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View convertView, ViewGroup viewGroup) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.lich_hen_item, null);
        }

        TextView tvIdLichHen = view.findViewById(R.id.tvIdLichHen);
        TextView tvIdKhachHang = view.findViewById(R.id.tvIdKhachHang);
        TextView tvIdNhanVien = view.findViewById(R.id.tvIdNhanVien);
        TextView tvIdDichVu = view.findViewById(R.id.tvIdDichVu);
        TextView tvNgayHen = view.findViewById(R.id.tvNgayHen);
        TextView tvGioHen = view.findViewById(R.id.tvGioHen);
        TextView tvTrangThai = view.findViewById(R.id.tvTrangThai);
        TextView tvGhiChu = view.findViewById(R.id.tvGhiChu);
        Button btnXoa = view.findViewById(R.id.btnXoa);
        Button btnSua = view.findViewById(R.id.btnSua);

        final LichHen lichHen = lichHenList.get(i);

        Date ngayHen = lichHen.getNgayHen();
        Time thoiGianHen = lichHen.getThoiGianHen();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        String chuoiThoiGianHen = timeFormat.format(thoiGianHen);
        String chuoiNgayHen = dateFormat.format(ngayHen);

        tvIdLichHen.setText(lichHen.getIdLichHen());
        tvIdKhachHang.setText(lichHen.getIdKhachHang());
        tvIdNhanVien.setText(lichHen.getIdNhanVien());
        tvIdDichVu.setText(lichHen.getIdDichVu());
        tvNgayHen.setText(chuoiNgayHen);
        tvGioHen.setText(chuoiThoiGianHen);
        tvTrangThai.setText(lichHen.getTrangThai());
        tvGhiChu.setText(lichHen.getGhiChu());

        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onDeleteClickListener != null) {
                    onDeleteClickListener.onDeleteClick(i);
                }
            }
        });

        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onEditClickListener != null) {
                    onEditClickListener.onEditClick(i);
                }
            }
        });

        return view;
    }
}
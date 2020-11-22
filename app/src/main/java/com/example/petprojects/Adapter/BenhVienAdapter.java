package com.example.petprojects.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.petprojects.ModelThuCung.BenhVien;
import com.example.petprojects.R;

import java.util.List;

public class BenhVienAdapter extends RecyclerView.Adapter<BenhVienAdapter.ViewHolder> {
    private Context context;
    private List<BenhVien> benhVienList;

    public BenhVienAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<BenhVien> benhVienList) {
        this.benhVienList = benhVienList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hospital, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BenhVien benhVien = benhVienList.get(position);
        if (benhVien == null) {
            return;
        }
        holder.imgBenhVien.setImageResource(benhVien.getResouceImages());
        holder.tvTenBenhVien.setText(benhVien.getTenBenhVien());
    }

    @Override
    public int getItemCount() {
        if (benhVienList != null) {
            return benhVienList.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgBenhVien;
        TextView tvTenBenhVien;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgBenhVien = itemView.findViewById(R.id.imgBenhVien);
            tvTenBenhVien = itemView.findViewById(R.id.tvTenBenhVien);
        }

    }
}

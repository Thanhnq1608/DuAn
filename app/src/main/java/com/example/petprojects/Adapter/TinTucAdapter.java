package com.example.petprojects.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.petprojects.ModelThuCung.TinTuc;
import com.example.petprojects.R;

import java.util.List;

public class TinTucAdapter extends RecyclerView.Adapter<TinTucAdapter.ViewHolder> {
    private Context context;
    List<TinTuc> tinTucList;

    public TinTucAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<TinTuc> tinTucList) {
        this.tinTucList = tinTucList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tintuc, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        TinTuc tinTuc = tinTucList.get(position);
        if (tinTuc == null) {
            return;
        }
        holder.imgTinTuc.setImageResource(tinTuc.getResouceImages());
        holder.tvTenTinTuc.setText(tinTuc.getTenTinTuc());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "This is Positon: " + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        if (tinTucList != null) {
            return tinTucList.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgTinTuc;
        TextView tvTenTinTuc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgTinTuc = itemView.findViewById(R.id.imgTinTuc);
            tvTenTinTuc = itemView.findViewById(R.id.tvTinTuc);
        }
    }
}

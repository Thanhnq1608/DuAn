package com.example.myapplication.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.SQLite.MySQLite;
import com.example.myapplication.SQLite.UserDAO;
import com.example.myapplication.model.NguoiDung;

import java.util.List;

public class NguoiDungAdapter extends BaseAdapter {
    public NguoiDungAdapter(List<NguoiDung> nguoiDungList){this.nguoiDungList=nguoiDungList;}
    private List<NguoiDung> nguoiDungList;
    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int i, View view, final ViewGroup viewGroup) {
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.nguoi_dung_layout,
                viewGroup,false);

        TextView tvName = view.findViewById(R.id.tvName);
        tvName.setText(nguoiDungList.get(i).getUsername()+" - "+nguoiDungList.get(i).getTen());

        view.findViewById(R.id.btnDel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserDAO userDAO =new UserDAO(new MySQLite(viewGroup.getContext()));
                String username = nguoiDungList.get(i).getUsername();

boolean ketQua =userDAO.delUser(username);
if (ketQua){
    Toast.makeText(viewGroup.getContext(), "Xóa Thành Công!!", Toast.LENGTH_LONG).show();

    nguoiDungList.remove(i);
notifyDataSetChanged();
}else {
    Toast.makeText(viewGroup.getContext(), "Xóa không thành công", Toast.LENGTH_LONG).show();
}
            }
        });

//        TextView
        return view;
    }
}

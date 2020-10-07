package com.example.myapplication.Login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myapplication.Adapter.NguoiDungAdapter;
import com.example.myapplication.R;
import com.example.myapplication.SQLite.MySQLite;
import com.example.myapplication.SQLite.UserDAO;
import com.example.myapplication.model.NguoiDung;

import java.util.ArrayList;
import java.util.List;

public class QLNguoiDungActivity extends AppCompatActivity {
    ListView listView;
    private MySQLite mySQLite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q_l_nguoi_dung);
        listView = findViewById(R.id.lvQLNguoiDung);

        mySQLite = new MySQLite(this);
        final UserDAO userDAO = new UserDAO(mySQLite);
        List<NguoiDung> nguoiDungList = userDAO.getAllUsers();
        NguoiDungAdapter nguoiDungAdapter = new NguoiDungAdapter(nguoiDungList);
        listView.setAdapter(nguoiDungAdapter);
        EditText edTim = findViewById(R.id.txtSearch);

        edTim.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() == 0) {
                    List<NguoiDung> nguoiDungList = userDAO.getAllUsers();
                    NguoiDungAdapter nguoiDungAdapter = new NguoiDungAdapter(nguoiDungList);
                    listView.setAdapter(nguoiDungAdapter);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_user, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.add) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View view = LayoutInflater.from(this).inflate(R.layout.add_user_dialog, null);
            builder.setView(view);

            final EditText userdangki = view.findViewById(R.id.userDangKi);
            final EditText passDangKi = view.findViewById(R.id.passDangKi);
            final EditText phoneDangKi = view.findViewById(R.id.phoneDangKi);
            final EditText nameDangKi = view.findViewById(R.id.nameDangKi);
            Button luuDangKi = view.findViewById(R.id.luuDangKi);
            Button cancelDangKi = view.findViewById(R.id.cancelDangKi);
            final AlertDialog alertDialog = builder.show();
            luuDangKi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    NguoiDung nguoiDung = new NguoiDung();
                    nguoiDung.setUsername(userdangki.getText().toString().trim());
                    nguoiDung.setTen(nameDangKi.getText().toString().trim());
                    nguoiDung.setPassword(passDangKi.getText().toString().trim());
                    nguoiDung.setSdt(phoneDangKi.getText().toString().trim());

                    checkEmpty(nguoiDung.getUsername(), userdangki);
                    checkEmpty(nguoiDung.getPassword(), passDangKi);
                    checkEmpty(nguoiDung.getSdt(), phoneDangKi);
                    checkEmpty(nguoiDung.getTen(), nameDangKi);

                    UserDAO userDAO = new UserDAO(mySQLite);

                    boolean ketQua = userDAO.addUser(nguoiDung);
                    if (ketQua) {
                        Toast.makeText(QLNguoiDungActivity.this,
                                "THANH CONG!!!", Toast.LENGTH_SHORT).show();
                        alertDialog.dismiss();

                        List<NguoiDung> nguoiDungList = userDAO.getAllUsers();
                        NguoiDungAdapter nguoiDungAdapter = new NguoiDungAdapter(nguoiDungList);
                        listView.setAdapter(nguoiDungAdapter);
                    } else {
                        Toast.makeText(QLNguoiDungActivity.this,
                                "KHONG THANH CONG!!!", Toast.LENGTH_SHORT).show();
                    }

                }
            });


            cancelDangKi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    alertDialog.dismiss();
                }
            });
        }
        return super.onOptionsItemSelected(item);
    }
    public void checkEmpty(String data, EditText edt) {
        if (data.isEmpty()) {
            edt.setError("Nhap du thong tin...");
            return;
        }
    }

    public void searchUserName(View view) {
        EditText edtTim = findViewById(R.id.txtSearch);
        String username = edtTim.getText().toString().trim();
        if (username.isEmpty()) {
            edtTim.setError("NHAP DU LIEU TRC");
            return;
        }
        UserDAO userDAO = new UserDAO(mySQLite);
        List<NguoiDung> nguoiDungList = userDAO.timKiemUsername(username);

        if (nguoiDungList.size() == 0) {
            edtTim.setError("KHONG TIM THAY USER NAO!!!!");
        } else {
            NguoiDungAdapter nguoiDungAdapter = new NguoiDungAdapter(nguoiDungList);
            listView.setAdapter(nguoiDungAdapter);
        }

    }
}
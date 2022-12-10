package com.example.datvephim;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.datvephim.Database.JDBCController;

public class RegisterActivity extends AppCompatActivity {
    EditText edtHoTen, edtTaiKhoan, edtPass, edtNgaySinh, edtEmail, edtSDT, edtCMND, edtDiaCHi;
    Button btnRegis, btnBaoMat, btnDichVu;
    Boolean isSuccess = false;
    private JDBCController jdbcController = new JDBCController();
    private Connection connection;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        anhxa();
    }
    private void SignIn(){
//        String HoTen = edtHoTen.getText().toString().trim();
//        String TaiKhoan = edtTaiKhoan.getText().toString().trim();
//        String MatKhau = edtPass.getText().toString().trim();
//        String NgaySinh = edtNgaySinh.getText().toString().trim();
//        String Email = edtEmail.getText().toString().trim();
//        String SDT = edtSDT.getText().toString().trim();
//        String CMND = edtCMND.getText().toString().trim();
//        String DiaChi = edtDiaCHi.getText().toString().trim();
        try {
            connection = jdbcController.ConnnectionData(); // Tạo kết nối tới database
            if(connection!=null){
                String query = "insert into KhachHang(username, password, ho_ten, sdt, email, dia_chi, ngay_sinh, cmnd) values ('" + edtTaiKhoan.getText() + "','" + edtPass.getText() + "','" + edtHoTen.getText() + "','" +
                        edtSDT.getText() + "','" + edtEmail.getText() + "','" + edtDiaCHi.getText() + "'," + edtNgaySinh.getText() + "," + edtCMND.getText() +"');";
                Statement st = connection.createStatement();
                ResultSet rs = st.executeQuery(query);
                while (rs.next()){
                    Toast.makeText(RegisterActivity.this, "Đăng nhập thành công",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
                Toast.makeText(RegisterActivity.this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
            }else {
                isSuccess = false;
                Toast.makeText(RegisterActivity.this, "Kiểm tra kết nối", Toast.LENGTH_SHORT).show();
            }
//            if(isSuccess == true){
//                Intent intent= new Intent(RegisterActivity.this, LoginActivity.class);
//                startActivity(intent);
//            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void anhxa() {
        edtHoTen = (EditText)findViewById(R.id.HoTentxt);
        edtTaiKhoan = (EditText)findViewById(R.id.TaiKhoantxt);
        edtPass = (EditText)findViewById(R.id.matkhautxt);
        edtNgaySinh = (EditText)findViewById(R.id.Date_Edittext);
        edtEmail = (EditText)findViewById(R.id.Emailtxt);
        edtSDT = (EditText)findViewById(R.id.SDTtxt);
        edtCMND = (EditText)findViewById(R.id.cmndtxt);
        edtDiaCHi = (EditText)findViewById(R.id.DiaChitxt);
    }

}

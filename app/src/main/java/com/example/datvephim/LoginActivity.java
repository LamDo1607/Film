package com.example.datvephim;

import android.app.DownloadManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.os.AsyncTask;
import android.widget.TextView;
import android.util.Log;
import android.widget.Toast;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.example.datvephim.Database.HASH;
import com.example.datvephim.Database.JDBCController;
import com.example.datvephim.Database.JDBCModel;
import com.example.datvephim.Database.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginActivity extends AppCompatActivity {
    EditText edtUser, edtPass;
    Button btnLogin, btnRegister, btnExit;
    Boolean isSuccess = false;
    private JDBCController jdbcController = new JDBCController();
    private Connection connection;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Anhxa();
    }

    public void Register(View view){
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intent);
    }
    public void Exit(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this, android.R.style.Theme_DeviceDefault_Light_Dialog);
        builder.setTitle("Bạn có muốn thoát");
        builder.setIcon(android.R.drawable.ic_dialog_alert);
        builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                onBackPressed();
            }
        });
        builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.show();
    }

    public void Login(View view){
        //String userid = edtUser.getText().toString();
        //String password = edtPass.getText().toString();
        try {
            connection = jdbcController.ConnnectionData(); // Tạo kết nối tới database
            if(connection!=null){
                String query = "select * from KhachHang where username='" + edtUser.getText() + "' and password='" + edtPass.getText() + "'";
                Statement st = connection.createStatement();
                ResultSet rs = st.executeQuery(query);
                isSuccess = true;
                if(rs.next()){
                    Toast.makeText(LoginActivity.this, "Đăng nhập thành công",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(LoginActivity.this, "Vui lòng kiểm tra lại tài khoản và mật khẩu",
                            Toast.LENGTH_SHORT).show();
                    edtUser.setText("");
                    edtPass.setText("");
                }
            }else {
                isSuccess = false;
                Toast.makeText(LoginActivity.this, "Kiểm tra kết nối", Toast.LENGTH_SHORT).show();
            }
//            if(isSuccess == true){
//                Intent intent= new Intent(LoginActivity.this, MainActivity.class);
//                startActivity(intent);
//            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void Anhxa() {
        edtUser = (EditText)findViewById(R.id.TaiKhoan);
        edtPass = (EditText)findViewById(R.id.MatKhau);
        btnLogin = (Button)findViewById(R.id.loginbtn);
        btnRegister = (Button)findViewById(R.id.registerbtn);
        btnExit =(Button)findViewById(R.id.exitbtn);
    }
}

package com.example.datvephim.Database;

import android.telecom.ConnectionRequest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListMovieItem {
    private JDBCController jdbcController = new JDBCController();
    Connection connect;
    String connectResult="";
    boolean isSuccess = false;
    public List<Map<String,String>>getlist(){
        List<Map<String,String>> data = null;
        data = new ArrayList<Map<String,String>>();
        try{
            connect = jdbcController.ConnnectionData();
            if (connect != null){
                String query = "select * from Phim";
                Statement st = connect.createStatement();
                ResultSet resultSet = st.executeQuery(query);
                while (resultSet.next())
                {
                    Map<String,String> dtname = new HashMap<String, String>();
                    dtname.put("id", resultSet.getString("id"));
                    dtname.put("MoviePosterMini",resultSet.getString("Banner"));
                    dtname.put("MovieNameMini",resultSet.getString("ten_phim"));
                    dtname.put("MovieTimeMini",resultSet.getString("thoi_luong"));
                    dtname.put("NgayChieuMini",resultSet.getString("ngay_cong_chieu"));
                    data.add(dtname);
                }
                connectResult ="Success";
                isSuccess = true;
                connect.close();
            }
            else{
                connectResult ="Failed";
                isSuccess = false;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return data;
    }
}

package com.example.datvephim.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListNewsItem {

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
                String query = "select * from TinTuc";
                Statement st = connect.createStatement();
                ResultSet resultSet = st.executeQuery(query);
                while (resultSet.next())
                {
                    Map<String,String> dtname = new HashMap<String, String>();
                    dtname.put("idNews",resultSet.getString("id"));
                    dtname.put("TieuDe",resultSet.getString("tieu_de"));
                    dtname.put("Anh",resultSet.getString("anh"));
                    dtname.put("NoiDung",resultSet.getString("noi_dung"));
                    dtname.put("ThoiGian",resultSet.getString("thoi_gian_dang"));
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

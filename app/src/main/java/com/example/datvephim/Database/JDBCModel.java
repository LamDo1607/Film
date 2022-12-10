package com.example.datvephim.Database;

import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.util.Log;

//import com.example.datvephim.Database.JDBCObject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Administrator on 8/18/2017.
 */
@SuppressLint("NewApi")
public class JDBCModel {

    public Connection getConnectionOf() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection objConn = null;
        String sConnURL;
        JDBCObject objEntity = new JDBCObject("192.168.127.2", "sa", "123",
                "DatVeXemPhim1", "1433");
        try {
            Class.forName(objEntity.getsClass());
            sConnURL = "jdbc:jtds:sqlserver://"
                    + objEntity.getsServerName() + ":" + objEntity.getsPrort() + ";"
                    + "databaseName=" + objEntity.getsDatabase()
                    + ";user=" + objEntity.getsUserId()
                    + ";password=" + objEntity.getsPwd() + ";";
            objConn = DriverManager.getConnection(sConnURL);
        } catch (SQLException se) {
            Log.e("ERRO", se.getMessage());
        } catch (ClassNotFoundException e) {
            Log.e("ERRO", e.getMessage());
        } catch (Exception e) {
            Log.e("ERRO", e.getMessage());
        }
        return objConn;
    }
}

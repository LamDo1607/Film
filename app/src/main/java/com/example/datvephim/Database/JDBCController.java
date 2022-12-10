package com.example.datvephim.Database;
import java.sql.Connection;
import com.example.datvephim.Database.JDBCModel;
public class JDBCController {
    JDBCModel JdbcModel = new JDBCModel();

    public Connection ConnnectionData() {
        return JdbcModel.getConnectionOf();
    }
}

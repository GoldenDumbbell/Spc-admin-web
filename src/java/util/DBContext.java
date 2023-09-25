/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.Year;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sun
 */
public class DBContext {

    private Connection conn = null;

    public DBContext() {
        try {
            String user = "adminsps";
            String password = "Sps@12345";
            String url = "jdbc:sqlserver://smartpackingsystem.database.windows.net:1433;database=SPSDB;user=adminsps@smartpackingsystem;password=Sps@12345;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }
    
    public void close() throws SQLException{
        if(conn != null){
            conn.close();
        }
    }
}

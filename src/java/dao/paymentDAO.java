/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Payment;
import model.Users;
import util.DBContext;

/**
 *
 * @author TADAR
 */
public class paymentDAO {
    private DBContext db;
    private userDAO udao;
    private Payment payment;
    
    public DBContext getDb() {
        return db;
    }

    public void setDb(DBContext db) {
        this.db = db;
    }
    private Payment dm;
    
    
    List<Payment> listPayment;
    public paymentDAO(){
        listPayment = new ArrayList<>();
        db = new DBContext();
        udao = new userDAO();
        
    
    }
    public paymentDAO(List<Payment> listPayment) {
        this.listPayment=listPayment;
    }
    
    public List<Payment> getListPayment() {
        return listPayment;
    }

    public void setListPayment(List<Payment> listPayment) {
        this.listPayment = listPayment;
    }
    
    public List<Payment> readPayment(){
        listPayment.clear();
        try {
            String sql = "select * from tb_Payment";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String paymentID = rs.getString("paymentID");
                Timestamp time = rs.getTimestamp("paymentdate");
                boolean status = rs.getBoolean("status");
                int amount = rs.getInt("amount");
                Users userId = udao.details(rs.getString("userID"));
                String purpose = rs.getString("purpose");
                dm = new Payment(paymentID, time, status, amount, userId, purpose);
                listPayment.add(dm);
        }
            return listPayment;
        } catch (SQLException e) {
            Logger.getLogger(paymentDAO.class.getName()).log(Level.ALL.SEVERE, null, e);
        }
        return null;
    }
}


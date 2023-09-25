/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ApartmentBlock;
import model.Car;
import model.History;

import model.Users;
import util.DBContext;

/**
 *
 * @author TADAR
 */
public class historyDAO {

    private DBContext db;
    carDAO car;
    History history;

    public DBContext getDb() {
        return db;
    }

    public void setDb(DBContext db) {
        this.db = db;
    }

    List<History> listHistory;
    History dm;

    public historyDAO() {
        listHistory = new ArrayList<>();
        db = new DBContext();
        car = new carDAO();
        
    }

    public historyDAO(List<History> listHistory) {
        this.listHistory = listHistory;
    }

    public List<History> getListHistory() {
        return listHistory;
    }

    public void setListHistory(List<History> listHistory) {
        this.listHistory = listHistory;
    }
    
    public History details(String historyID) {
        try {
            String sql = "select * from tb_History where historyID=?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, historyID);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String historyIDs = rs.getString("historyID");
                Timestamp timeIn = rs.getTimestamp("time_In");
                 Timestamp timeOut = rs.getTimestamp("time_Out");
                Car CarId = car.details(rs.getString("carID"));
                int amount = rs.getInt("amount");
                String CarPlate = rs.getString("carPlate");
                
                dm = new History(historyIDs, timeIn, timeOut, CarPlate, amount, CarId);

            }
            return history;
        } catch (SQLException e) {
            Logger.getLogger(userDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
    public List<History> read() {
        listHistory.clear();
        try {
            String sql = "select * from tb_History ";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String historyID = rs.getString("historyID");
               Timestamp timeIn = rs.getTimestamp("time_In");
                Timestamp timeOut = rs.getTimestamp("time_Out");
                String carplate = rs.getString("carPlate");
                Car CarId = car.details(rs.getString("carID"));
                int amount = rs.getInt("amount");
                dm = new History(historyID, timeIn, timeOut, carplate, amount);
                listHistory.add(dm);
        }
            return listHistory;
        } catch (SQLException e) {
            Logger.getLogger(carDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
     public List<History> readOut() {
        listHistory.clear();
        try {
            String sql = "select * from tb_History where time_In is not null and time_Out is not null";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String historyID = rs.getString("historyID");
                Timestamp timeIn = rs.getTimestamp("time_In");
                Timestamp timeOut = rs.getTimestamp("time_Out");
                String carPlate = rs.getString("carPlate");
                int amount = rs.getInt("amount");
                dm = new History(historyID, timeIn, timeOut, carPlate, amount);
                listHistory.add(dm);
        }
            return listHistory;
        } catch (SQLException e) {
            Logger.getLogger(carDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
     
     public  List<History> search(String search){
        try {
            String sql = "select * from tb_History where carPlate like ?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, search);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String historyID = rs.getString("historyID");
                Timestamp timeIn = rs.getTimestamp("time_In");
                 Timestamp timeOut = rs.getTimestamp("time_Out");
                String carPlate = rs.getString("carPlate");
                int amount = rs.getInt("amount");
                dm = new History(historyID, timeIn, timeOut, carPlate, amount);
                listHistory.add(dm);
        }
            return listHistory;
        } catch (SQLException e) {
            Logger.getLogger(carDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
     
}

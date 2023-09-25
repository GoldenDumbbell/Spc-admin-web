/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Date;
import java.sql.Time;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.DBContext;
import model.Users;
import model.Booking;
import model.Spot;

/**
 *
 * @author TADAR
 */
public class bookingDAO {
    userDAO userdao;
    private DBContext db;
    Booking booking;
    spotDAO spotdao;
    
     public DBContext getDb() {
        return db;
    }
     public void setDb(DBContext db) {
        this.db = db;
    }

    List<Booking> listbooking;
    Booking dm;
    
     public bookingDAO() {
        listbooking = new ArrayList<>();
        db = new DBContext();
        userdao = new userDAO();
        spotdao = new spotDAO();
        
    }

    public bookingDAO(List<Booking> listbooking) {
        this.listbooking = listbooking;
    }

    public List<Booking> getListbooking() {
        return listbooking;
    }

    public void setListbooking(List<Booking> listbooking) {
        this.listbooking = listbooking;
    }
    
    public List<Booking> read() {
        listbooking.clear();
        try {
            String sql = "select * from tb_booking";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                
                String bookingID = rs.getString("bookingID");
                String carPlate = rs.getString("carPlate");
                String carColor = rs.getString("carColor");
                Timestamp bookingDate = rs.getTimestamp("dateTime");
                Users userID = userdao.details(rs.getString("userID"));
                Spot spotID = spotdao.details(rs.getString("sensorID"));
                dm = new Booking(bookingID, carPlate, carColor, bookingDate , userID, spotID);
                listbooking.add(dm);
                
        }
            return listbooking;
        } catch (SQLException e) {
            Logger.getLogger(bookingDAO.class.getName()).log(Level.ALL.SEVERE, null, e);
        }
        return null;
    }
    public List<Booking> Search(String booking){
        listbooking.clear();
        try {
            String sql = "select * from tb_booking where carPlate like ? ";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, booking);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                
                String bookingID = rs.getString("bookingID");
                String carPlate = rs.getString("carPlate");
                String carColor = rs.getString("carColor");
                Timestamp bookingDate = rs.getTimestamp("dateTime");
                Users userID = userdao.details(rs.getString("userID"));
                Spot spotID = spotdao.details(rs.getString("sensorID"));
                dm = new Booking(bookingID, carPlate, carColor, bookingDate , userID, spotID);
               listbooking.add(dm);
        }
            return listbooking;
        } catch (SQLException e) {
            Logger.getLogger(bookingDAO.class.getName()).log(Level.ALL.SEVERE, null, e);
        }
        return null;
    }
    public void delete(String bookingID) {
        try {
            String sql = "delete tb_booking where bookingID=?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, bookingID);
            stmt.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(carDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ApartmentBlock;
import model.Car;
import model.Employee;
import model.Spot;
import model.Spot;
import model.Users;
import util.DBContext;

/**
 *
 * @author TADAR
 */
public class spotDAO{

    
    private DBContext db;
    ApartmentBlockDAO Ablock;
    carDAO cardao;

    public DBContext getDb() {
        return db;
    }

    public void setDb(DBContext db) {
        this.db = db;
    }

    List<Spot> listSpot;
    Spot dm;

    public spotDAO() {
        listSpot = new ArrayList<>();
        db = new DBContext();
        Ablock = new ApartmentBlockDAO();
        cardao = new carDAO();
    }

    public spotDAO(List<Spot> listSpot) {
        this.listSpot = listSpot;
    }

    public List<Spot> getListSpot() {
        return listSpot;
    }

    public void setListSpot(List<Spot> listSpot) {
        this.listSpot = listSpot;
    }

    public List<Spot> read() {
       listSpot.clear();
        try {
            String sql = "select * from tb_Spot";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String spotID = rs.getString("sensorID");
                boolean available = rs.getBoolean("available");
                String location = rs.getString("location");
                ApartmentBlock AblockID = Ablock.details(rs.getString("AblockID"));
                String car = rs.getString("carID");
                boolean owned = rs.getBoolean("owned");
                if (car == ""){
                    dm = new Spot(spotID, available, location, AblockID, "null" ,owned);
                }
                else{
                dm = new Spot(spotID, available, location, AblockID, car,owned);
                }
                listSpot.add(dm);
            }
            return listSpot;
        } catch (SQLException e) {
            Logger.getLogger(employeeDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
    
      public int NoSpot() {
       listSpot.clear();
        try {int no= 0;
            String sql = "select * from tb_Spot";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String spotID = rs.getString("sensorID");
                boolean available = rs.getBoolean("available");
                String location = rs.getString("location");
                ApartmentBlock AblockID = Ablock.details(rs.getString("AblockID"));
                String car = rs.getString("carID");
                boolean owned = rs.getBoolean("owned");
                if (owned != true){
                    if(available == false){
                        no++;
                    }
                }
            }
            return no;
        } catch (SQLException e) {
            Logger.getLogger(employeeDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return 0;
    }
      
      public int NoAvailable() {
       listSpot.clear();
        try {int no= 0;
            String sql = "select * from tb_Spot";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String spotID = rs.getString("sensorID");
                boolean available = rs.getBoolean("available");
                String location = rs.getString("location");
                ApartmentBlock AblockID = Ablock.details(rs.getString("AblockID"));
                String car = rs.getString("carID");
                boolean owned = rs.getBoolean("owned");
                if (available == true){
                        no++;
                    
                }
            }
            return no;
        } catch (SQLException e) {
            Logger.getLogger(employeeDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return 0;
    }
    

    public Spot details(String spotId) {
         try {
            String sql = "select * from tb_Spot where sensorID=?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, spotId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String spotID = rs.getString("sensorID");
                boolean available = rs.getBoolean("available");
                String location = rs.getString("location");
                ApartmentBlock AblockID = Ablock.details(rs.getString("AblockID"));
               dm = new Spot(spotID, available, location, AblockID);

            }
            return dm;
        } catch (SQLException e) {
            Logger.getLogger(userDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    
}

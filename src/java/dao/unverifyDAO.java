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
import model.Car;
import model.Family;
import util.DBContext;

/**
 *
 * @author TADAR
 */
public class unverifyDAO {
    
    private DBContext db;
    familyDAO familyDAO;
     int noUnverify;

    private List<Car> listItems;

    public DBContext getDb() {
        return db;
    }

    public void setDb(DBContext db) {
        this.db = db;
    }
    
    Car dm;

    public unverifyDAO() {
        listItems = new ArrayList<>();
        db = new DBContext();
        familyDAO = new familyDAO();
        int noUnverify;
    }


      public unverifyDAO(List<Car> listItems) {
        this.listItems = listItems;
    }

    public List<Car> getListItems() {
        return listItems;
    }

    public void setListItems(List<Car> listItems) {
        this.listItems = listItems;
    }

     public List<Car> readUnverify(){
        listItems.clear();
        try {
            String sql = "select * from tb_Car where verifyState1 IS NULL and carPaperFront IS NOT NULL and carPaperBack IS NOT NULL";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String carID = rs.getString("carID");
                String carname = rs.getString("carName");
                String carPlate = rs.getString("carPlate");
                String carColor = rs.getString("carColor");
                String carPaperFront = rs.getString("carPaperFront");
                String carPaperBack = rs.getString("carPaperBack");
                boolean verifyState1 = rs.getBoolean("verifyState1");
                boolean verifyState2 = rs.getBoolean("verifyState2");
              
               
                dm = new Car(carID, carname, carPlate, carColor, carPaperFront, carPaperBack, verifyState1, verifyState2);
                listItems.add(dm);
                
                
                
            }
            return listItems;
        } catch (SQLException e) {
            Logger.getLogger(carDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
     
     public int noUnverify(){
        
        try {
            String sql = "select * from tb_Car where verifyState1 IS NULL and carPaperFront IS NOT NULL and carPaperBack IS NOT NULL";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();
            
            noUnverify = 0;
            while (rs.next()) {
                String carID = rs.getString("carID");
                String carname = rs.getString("carName");
                String carPlate = rs.getString("carPlate");
                String carColor = rs.getString("carColor");
                String carPaperFront = rs.getString("carPaperFront");
                String carPaperBack = rs.getString("carPaperBack");
                boolean verifyState1 = rs.getBoolean("verifyState1");
                boolean verifyState2 = rs.getBoolean("verifyState2");
                
                dm = new Car(carID, carname, carPlate, carColor, carPaperFront, carPaperBack, verifyState1, verifyState2);
                noUnverify++;
                
                
                
            }
            return noUnverify;
        } catch (SQLException e) {
            Logger.getLogger(carDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return 0;
    }
}

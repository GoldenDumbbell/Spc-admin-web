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
import model.Bundle;
import model.Car;
import model.Users;
import util.DBContext;

/**
 *
 * @author TADAR
 */
public class bundleDAO {
    private DBContext db;

    private List<Bundle> listItems;

    public DBContext getDb() {
        return db;
    }

    public void setDb(DBContext db) {
        this.db = db;
    }
    
    Bundle dm;

    public bundleDAO() {
        listItems = new ArrayList<>();
        db = new DBContext();
    }


      public bundleDAO(List<Bundle> listItems) {
        this.listItems = listItems;
    }

    public List<Bundle> getListItems() {
        return listItems;
    }

    public void setListItems(List<Bundle> listItems) {
        this.listItems = listItems;
    }
    public List<Bundle> read(){
        listItems.clear();
        try {
            String sql = "select * from tb_Bundle ";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String bundleID = rs.getString("bundleID");
                String bundleName = rs.getString("bundleName");
                int price = rs.getInt("price");
                dm = new Bundle(bundleID, bundleName, price);
                listItems.add(dm);
            }
            return listItems;
        } catch (SQLException e) {
            Logger.getLogger(carDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
    
     public Bundle detail(String ID){
        listItems.clear();
        try {
            String sql = "select * from tb_Bundle where bundleID=?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, ID);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String bundleID = rs.getString("bundleID");
                String bundleName = rs.getString("bundleName");
                int price = rs.getInt("price");
                dm = new Bundle(bundleID, bundleName, price);
                
            }
            return dm;
        } catch (SQLException e) {
            Logger.getLogger(carDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
    public void update(Bundle bundle) {
        try {
            String sql = "update tb_Bundle set price=? where bundleID=?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(2, bundle.getBundleID());
            stmt.setInt(1, bundle.getPrice());
           
            stmt.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(employeeDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

}

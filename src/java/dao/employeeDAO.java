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
import util.DBContext;
import model.Employee;

/**
 *
 * @author TADAR
 */
public class employeeDAO implements ICrud<String, Employee> {

    private DBContext db;
    ApartmentBlockDAO Ablock;

    public DBContext getDb() {
        return db;
    }

    public void setDb(DBContext db) {
        this.db = db;
    }

    List<Employee> listItems;
    Employee dm;

    public employeeDAO() {
        listItems = new ArrayList<>();
        db = new DBContext();
        Ablock = new ApartmentBlockDAO();
 
    }

      public employeeDAO(List<Employee> listItems) {
        this.listItems = listItems;
    }

    public List<Employee> getListItems() {
        return listItems;
    }

    public void setListItems(List<Employee> listItems) {
        this.listItems = listItems;
    }

    @Override
    public List<Employee> read(){
        listItems.clear();
        try {
            String sql = "select * from tb_Employee";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String email = rs.getString("email");
                String pass = rs.getString("password");
                String fullname = rs.getString("fullname");    
                String identity = rs.getString("identityNumber");
                ApartmentBlock AblockID = Ablock.details(rs.getString("AblockID")); 
                dm = new Employee(email, fullname, pass, identity ,AblockID);
                listItems.add(dm);
            }
            return listItems;
        } catch (SQLException e) {
            Logger.getLogger(employeeDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    @Override
    public Employee details(String id) {
        try {
            String sql = "select * from tb_Employee where email=?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String email = rs.getString("email");
                String fullname = rs.getString("fullname");
                String pass = rs.getString("password");
                String identity = rs.getString("identityNumber");
                ApartmentBlock AblockID = Ablock.details(rs.getString("AblockID"));
               
                dm = new Employee(email, fullname, pass, identity,AblockID);
            }
            return dm;
        } catch (SQLException e) {
            Logger.getLogger(employeeDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    @Override
    public void create(Employee newItem) {
        try {
            String sql = "insert into tb_Employee(email, password, fullname, identityNumber, AblockID) values(?, ?, ?, ?, ?)";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, newItem.getEmail());
            stmt.setString(2, newItem.getPassword());
            stmt.setString(3, newItem.getFullName());
            stmt.setString(4, newItem.getIdentityNumber());
            stmt.setString(5, newItem.getAblockID().getAblockID());
            stmt.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(employeeDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void update(Employee edittedItem) {
        try {
            String sql = "update tb_Employee set password=?, fullname=?, identityNumber=? ,AblockID=?  where email=?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(5, edittedItem.getEmail());
            stmt.setString(1, edittedItem.getPassword());
            stmt.setString(2, edittedItem.getFullName());
            stmt.setString(3, edittedItem.getIdentityNumber());
            stmt.setString(4, edittedItem.getAblockID().getAblockID());
            stmt.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(employeeDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void delete(String email) {
        try {
            String sql = "delete tb_Employee where email=?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, email);
            stmt.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(employeeDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    public  List<Employee> search(String search){
        try {
            String sql = "select * from tb_Employee where fullname like ? or email like ?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, search);
            stmt.setString(2, search);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                String email = rs.getString("email");
                String pass = rs.getString("password");
                String fullname = rs.getString("fullname");    
                String identity = rs.getString("identityNumber");
                ApartmentBlock AblockID = Ablock.details(rs.getString("AblockID")); 
                dm = new Employee(email, fullname, pass, identity ,AblockID);
                listItems.add(dm);
            }

            return listItems;
            
        } catch (SQLException e) {
            Logger.getLogger(employeeDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
    
     

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author TADAR
 */
import java.sql.Date;
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
import model.ApartmentBlock;
import model.Family;
import model.Users;
import util.DBContext;

public class userDAO implements ICrud<String, Users> {
    private DBContext db;
    familyDAO familyID;

    private List<Users> listItems;

    public DBContext getDb() {
        return db;
    }

    public void setDb(DBContext db) {
        this.db = db;
    }
    Users dm;

    public userDAO() {
        listItems = new ArrayList<>();
        db = new DBContext();
        familyID = new familyDAO();
    }


      public userDAO(List<Users> listItems) {
        this.listItems = listItems;
    }

    public List<Users> getListItems() {
        return listItems;
    }

    public void setListItems(List<Users> listItems) {
        this.listItems = listItems;
    }


    @Override
    public List<Users> read() {
     listItems.clear();
        try {
            String sql = "select * from tb_Users";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String useID = rs.getString("userID");
                String email = rs.getString("email");
                String phoneNo = rs.getString("phoneNumber");
                String fullname = rs.getString("fullname");
                String pass = rs.getString("pass");
                String identitynumber = rs.getString("identitiCard");
                Family family = familyID.details(rs.getString("familyId"));
               
                dm = new Users(useID, email, phoneNo, fullname, pass, identitynumber, family);
                listItems.add(dm);
            }
            return listItems;
        } catch (SQLException e) {
            Logger.getLogger(employeeDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
    public List<Users> readWallet() {
     listItems.clear();
        try {
            String sql = "select * from tb_Users";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String useID = rs.getString("userID");
                String email = rs.getString("email");
                String fullname = rs.getString("fullname");
                String wallet = rs.getString("wallet");
               
                dm = new Users(useID, email, fullname, wallet);
                listItems.add(dm);
            }
            return listItems;
        } catch (SQLException e) {
            Logger.getLogger(employeeDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    @Override
    public Users details(String userID) {
       try {
            String sql = "select * from tb_Users where userID=?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, userID);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String useID = rs.getString("userID");
                String email = rs.getString("email");
                String phoneNo = rs.getString("phoneNumber");
                String fullname = rs.getString("fullname");
                String pass = rs.getString("pass");
                String identitynumber = rs.getString("identitiCard");
                 Family family = familyID.details(rs.getString("familyId"));
               
                dm = new Users(useID, email, phoneNo, fullname, pass, identitynumber, family);

            }
            return dm;
        } catch (SQLException e) {
            Logger.getLogger(userDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    @Override
    public void create(Users newUser) {
         try {
            String sql = "insert into tb_Users(userID, email, phoneNumber, fullname, pass, wallet, identitiCard) values(?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, newUser.getUserID());
            stmt.setString(2, newUser.getEmail());
            stmt.setString(3, newUser.getPhoneNumber());
            stmt.setString(4, newUser.getFullName());
            stmt.setString(5, newUser.getPass());
            stmt.setString(6, "0");
            stmt.setString(7, newUser.getIdentityNumber());        
            stmt.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(employeeDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void update(Users edittedUser) {
        try {
            String sql = "update tb_Users set email=?, phoneNumber=?, fullname=?, pass=?, identitiCard=? where userID=?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(6, edittedUser.getUserID());
            stmt.setString(1, edittedUser.getEmail());
            stmt.setString(2, edittedUser.getPhoneNumber());
            stmt.setString(3, edittedUser.getFullName());
            stmt.setString(4, edittedUser.getPass());
            stmt.setString(5, edittedUser.getIdentityNumber());
            stmt.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(employeeDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    public void updateWallet(Users edittedUser) {
        try {
            String sql = "update tb_Users set wallet=? where email=?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(2, edittedUser.getEmail());
            stmt.setString(1, edittedUser.getWallet());
            stmt.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(employeeDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void delete(String id) {
        try {
            String sql = "delete tb_Users where userID=?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql); 
            stmt.setString(1,id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(userDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }
     public List<Users> search(String search) {
     listItems.clear();
        try {
            String sql = "select * from tb_Users where fullname like ? or email like ? or phoneNumber like ?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, search);
            stmt.setString(2, search);
            stmt.setString(3, search);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String useID = rs.getString("userID");
                String email = rs.getString("email");
                String phoneNo = rs.getString("phoneNumber");
                String fullname = rs.getString("fullname");
                String pass = rs.getString("pass");
                String identitynumber = rs.getString("identitiCard");
                Family family = familyID.details(rs.getString("familyId"));
               
                dm = new Users(useID, email, phoneNo, fullname, pass, identitynumber, family);
                listItems.add(dm);
            }
            return listItems;
        } catch (SQLException e) {
            Logger.getLogger(employeeDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
      public List<Users> searchWallet(String search) {
     listItems.clear();
        try {
            String sql = "select * from tb_Users where fullname like ? or email like ?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, search);
            stmt.setString(2, search);
            
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String useID = rs.getString("userID");
                String email = rs.getString("email");
                String fullname = rs.getString("fullname");
                String waller = rs.getString("wallet");
               
                dm = new Users(useID, email, fullname, waller);

         
                listItems.add(dm);
            }
            return listItems;
        } catch (SQLException e) {
            Logger.getLogger(employeeDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
     public List<Users> readFamily(String fID) {
     listItems.clear();
        try {
            String sql = "select * from tb_Users where familyId like ?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, fID);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String useID = rs.getString("userID");
                String email = rs.getString("email");
                String fullname = rs.getString("fullname");
                String phone = rs.getString("phoneNumber");
                boolean role = rs.getBoolean("roleUser");
                boolean familyVerify = rs.getBoolean("roleUser");
                Family family = familyID.details(rs.getString("familyId"));
                dm = new Users(useID, email, fullname, phone,  role, familyVerify, family);
                listItems.add(dm);
            }
            return listItems;
        } catch (SQLException e) {
            Logger.getLogger(employeeDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
     public Users detailsWaller(String uID) {
       try {
           dm = new Users();
            String sql = "select * from tb_Users where userID=?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, uID);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String useID = rs.getString("userID");
                String email = rs.getString("email");
                String fullname = rs.getString("fullname");
                String waller = rs.getString("wallet");
               
                dm = new Users(useID, email, fullname, waller);

            }
            return dm;
        } catch (SQLException e) {
            Logger.getLogger(userDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

     public Users detailsOwner(String fID) {
       try {
           dm = new Users();
            String sql = "select * from tb_Users where familyId=? and roleUser=1 and roleUser is not null";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, fID);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String useID = rs.getString("userID");
                String email = rs.getString("email");
                String phoneNo = rs.getString("phoneNumber");
                String fullname = rs.getString("fullname");
                String pass = rs.getString("pass");
                String identitynumber = rs.getString("identitiCard");
                 Family family = familyID.details(rs.getString("familyId"));
               
                dm = new Users(useID, email, phoneNo, fullname, pass, identitynumber, family);

            }
            return dm;
        } catch (SQLException e) {
            Logger.getLogger(userDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

   
}
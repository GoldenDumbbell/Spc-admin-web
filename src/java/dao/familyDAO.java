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
import model.Family;
import model.Users;
import util.DBContext;

/**
 *
 * @author TADAR
 */
public class familyDAO {
     private DBContext db;
    ApartmentBlockDAO AblockID;
    Users user;

    private List<Family> listItems;
    private List<Users> listUser;

    public DBContext getDb() {
        return db;
    }

    public void setDb(DBContext db) {
        this.db = db;
    }
    
    public ApartmentBlockDAO getADao() {
        return AblockID;
    }

    public void setADao(ApartmentBlockDAO AblockID) {
        this.AblockID = this.AblockID;
    }

    Family dm;

    public familyDAO() {
        listItems = new ArrayList<>();
        listUser = new ArrayList<>();
        db = new DBContext();
        AblockID = new ApartmentBlockDAO();
    }


      public familyDAO(List<Family> listItems) {
        this.listItems = listItems;
    }

    public List<Family> getListItems() {
        return listItems;
    }

    public void setListItems(List<Family> listItems) {
        this.listItems = listItems;
    }
    
    public List<Family> read() {
     listItems.clear();
        try {
            String sql = "select * from tb_Family";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String familyID = rs.getString("familyId");
                String familyName = rs.getString("familyName");
                ApartmentBlock apartmentBlock = AblockID.details(rs.getString("AblockID"));
               
                dm = new Family(familyID, familyName, apartmentBlock);
                listItems.add(dm);
            }
            return listItems;
        } catch (SQLException e) {
            Logger.getLogger(familyDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    public Family details(String familyID) {
       try {
            String sql = "select * from tb_Family where familyId=?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, familyID);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String familyI = rs.getString("familyId");
                String familyName = rs.getString("familyName");
                ApartmentBlock apartmentBlock = AblockID.details(rs.getString("AblockID"));
               
                dm = new Family(familyI, familyName, apartmentBlock);

            }
            return dm;
        } catch (SQLException e) {
            Logger.getLogger(userDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
    
    public List<Family> search(String FamilyID) {
     listItems.clear();
        try {
            String sql = "select * from tb_Family where familyId like ?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, FamilyID);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String familyID = rs.getString("familyId");
                String familyName = rs.getString("familyName");
                ApartmentBlock apartmentBlock = AblockID.details(rs.getString("AblockID"));
                dm = new Family(familyID, familyName, apartmentBlock);
                listItems.add(dm);
            }
            return listItems;
        } catch (SQLException e) {
            Logger.getLogger(familyDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
    public Family addOwner(String familyID, String UserID) {
       try {
            String sql = "update tb_Users set familyId=?, familyVerify=1, roleUser=1 where userID=?";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            stmt.setString(1, familyID);
            stmt.setString(2, UserID);
            stmt.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(familyDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
     public List<Users> readOwner() {
     listUser.clear();
        try {
            String sql = "select * from tb_Users where familyId is null";
            PreparedStatement stmt = db.getConn().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String useID = rs.getString("userID");
                String email = rs.getString("email");
                String phoneNo = rs.getString("phoneNumber");
                String fullname = rs.getString("fullname");
                String identitynumber = rs.getString("identitiCard");
               
                 user = new Users(useID, email, phoneNo, fullname, identitynumber);
                listUser.add(user);
            }
            return listUser;
        } catch (SQLException e) {
            Logger.getLogger(employeeDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
}

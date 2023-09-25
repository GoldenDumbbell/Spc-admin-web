/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author TADAR
 */
public class Admin {
   private String ademail;
   private String adpassword;
   private boolean roleAdmin;

    public Admin() {
    }

    public Admin(String ademail, String adpassword, boolean roleAdmin) {
        this.ademail = ademail;
        this.adpassword = adpassword;
        this.roleAdmin = roleAdmin;
    }

    public boolean isRoleAdmin() {
        return roleAdmin;
    }

    public void setRoleAdmin(boolean roleAdmin) {
        this.roleAdmin = roleAdmin;
    }



    public String getAdemail() {
        return ademail;
    }

    public void setAdemail(String ademail) {
        this.ademail = ademail;
    }

    public String getAdpassword() {
        return adpassword;
    }

    public void setAdpassword(String adpassword) {
        this.adpassword = adpassword;
    }
    
}

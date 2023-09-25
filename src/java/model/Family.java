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
public class Family {
    String familyID;
    String familyName;
    ApartmentBlock AblockID;

    public Family() {
    }

    public Family(String familyID, String familyName, ApartmentBlock AblockID) {
        this.familyID = familyID;
        this.familyName = familyName;
        this.AblockID = AblockID;
    }

    public String getFamilyID() {
        return familyID;
    }

    public void setFamilyID(String familyID) {
        this.familyID = familyID;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public ApartmentBlock getAblockID() {
        return AblockID;
    }

    public void setAblockID(ApartmentBlock AblockID) {
        this.AblockID = AblockID;
    }
    
}

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
public class Employee {
    private String email;
    private String fullName;
    private String password;
    private String identityNumber;
    private ApartmentBlock AblockID;

    public Employee() {
    }

    public Employee(String email, String fullName, String password, String identityNumber) {
        this.email = email;
        this.fullName = fullName;
        this.password = password;
        this.identityNumber = identityNumber;
    }

    public Employee(String email, String fullName, String password, String identityNumber, ApartmentBlock AblockID) {
        this.email = email;
        this.fullName = fullName;
        this.password = password;
        this.identityNumber = identityNumber;
        this.AblockID = AblockID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public ApartmentBlock getAblockID() {
        return AblockID;
    }

    public void setAblockID(ApartmentBlock AblockID) {
        this.AblockID = AblockID;
    }



}

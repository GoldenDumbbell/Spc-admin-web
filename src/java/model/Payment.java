/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Timestamp;

/**
 *
 * @author TADAR
 */
public class Payment {
     private String paymentID;
     private Timestamp paymentDate;     
     private boolean status;
     private int amount;
     private Users userID;
     private String purpose; 

    public Payment(String paymentID, Timestamp paymentDate, boolean status, int amount, Users userID, String purpose) {
        this.paymentID = paymentID;
        this.paymentDate = paymentDate;
        this.status = status;
        this.amount = amount;
        this.userID = userID;
        this.purpose = purpose;
    }

    public String getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(String paymentID) {
        this.paymentID = paymentID;
    }

    public Timestamp getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Timestamp paymentDate) {
        this.paymentDate = paymentDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Users getUserID() {
        return userID;
    }

    public void setUserID(Users userID) {
        this.userID = userID;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }
         
}

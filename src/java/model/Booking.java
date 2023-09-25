/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

/**
 *
 * @author TADAR
 */
public class Booking {
    String bookingID;
    String carPlate;
    String carColor;
    
    Timestamp date;
    Users userID;
    Spot sensorID;

    public Booking(String bookingID, String carPlate, String carColor, Timestamp date, Users userID, Spot sensorID) {
        this.bookingID = bookingID;
        this.carPlate = carPlate;
        this.carColor = carColor;
        this.date = date;
        this.userID = userID;
        this.sensorID = sensorID;
    }

    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    public String getCarPlate() {
        return carPlate;
    }

    public void setCarPlate(String carPlate) {
        this.carPlate = carPlate;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Users getUserID() {
        return userID;
    }

    public void setUserID(Users userID) {
        this.userID = userID;
    }

    public Spot getSensorID() {
        return sensorID;
    }

    public void setSensorID(Spot sensorID) {
        this.sensorID = sensorID;
    }
    
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author TADAR
 */
public class History {
    private String historyID ;
    private Timestamp time_In;
    private Timestamp time_Out;
    private String carPlate;
    private int amount;
    private Car carID;

    public History() {
    }

    public History(String historyID, Timestamp time_In, Timestamp time_Out) {
        this.historyID = historyID;
        this.time_In = time_In;
        this.time_Out = time_Out;
    }

    public History(String historyID, Timestamp time_In, Timestamp time_Out, String carPlate, int amount) {
        this.historyID = historyID;
        this.time_In = time_In;
        this.time_Out = time_Out;
        this.carPlate = carPlate;
        this.amount = amount;
    }

    public History(String historyID, Timestamp time_In, Timestamp time_Out, Car carID,int amount) {
        this.historyID = historyID;
        this.time_In = time_In;
        this.time_Out = time_Out;
        this.carID = carID;
        this.amount =amount;
    }

    public History(String historyID, Timestamp time_In, Timestamp time_Out, String carPlate, int amount, Car carID) {
        this.historyID = historyID;
        this.time_In = time_In;
        this.time_Out = time_Out;
        this.carPlate = carPlate;
        this.amount = amount;
        this.carID = carID;
    }
  
    public String getCarPlate() {
        return carPlate;
    }

    public void setCarPlate(String carPlate) {
        this.carPlate = carPlate;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getHistoryID() {
        return historyID;
    }

    public void setHistoryID(String historyID) {
        this.historyID = historyID;
    }

    public Timestamp getTime_In() {
        return time_In;
    }

    public void setTime_In(Timestamp time_In) {
        this.time_In = time_In;
    }

    public Timestamp getTime_Out() {
        return time_Out;
    }

    public void setTime_Out(Timestamp time_Out) {
        this.time_Out = time_Out;
    }

    public Car getCarID() {
        return carID;
    }

    public void setCarID(Car carID) {
        this.carID = carID;
    }
    
}

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
public class Bundle {
    String bundleID;
    String bundleName;
    int price;

    public Bundle(String bundleID, String bundleName, int price) {
        this.bundleID = bundleID;
        this.bundleName = bundleName;
        this.price = price;
    }

    public Bundle(String bundleID, int price) {
        this.bundleID = bundleID;
        this.price = price;
    }

    public Bundle() {
    }
    
    

    public String getBundleID() {
        return bundleID;
    }

    public void setBundleID(String bundleID) {
        this.bundleID = bundleID;
    }

    public String getBundleName() {
        return bundleName;
    }

    public void setBundleName(String bundleName) {
        this.bundleName = bundleName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
}

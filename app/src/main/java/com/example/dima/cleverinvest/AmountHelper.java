package com.example.dima.cleverinvest;

/**
 * Created by Dmitrijs Nesterenko on 05.10.17.
 */

public class AmountHelper {

    private double giroAmount;
    private double visaAmount;
    private double depotAmount;


    public static AmountHelper instance;

    public AmountHelper() {
        this.giroAmount = 8174.12;
        this.visaAmount = 2213.54;
        this.depotAmount = 8212.17;
    }

    public static AmountHelper getInstance() {

        if (instance == null) {
            instance = new AmountHelper();
            return instance;
        } else {
            return instance;
        }
    }

    public double getGiroAmount() {
        return giroAmount;
    }

    public void setGiroAmount(double giroAmount) {
        this.giroAmount = giroAmount;
    }

    public double getVisaAmount() {
        return visaAmount;
    }

    public void setVisaAmount(double visaAmount) {
        this.visaAmount = visaAmount;
    }

    public double getDepotAmount() {
        return depotAmount;
    }

    public void setDepotAmount(double depotAmount) {
        this.depotAmount = depotAmount;
    }

    public double getSumme() {
        return giroAmount + visaAmount + depotAmount;
    }
}

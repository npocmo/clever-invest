package com.example.dima.cleverinvest;

/**
 * Created by Dmitrijs Nesterenko on 05.10.17.
 */

public class AmountHelper {

    private double giroAmount;
    private double visaAmount;
    private double depotAmount;

    private double threeMonthsBeforeSaldo;
    private double twoMonthsBeforeSaldo;
    private double oneMonthsBeforeSaldo;

    private double[] income = {3000,3000,3000};
    private double[] fixCost = {1300,1300,1300};
    private double[] other = {1000,900,700};

    private double reserve = 0;

    public double getReserve() {
        return reserve;
    }

    public void setReserve(double reserve) {
        this.reserve = reserve;
    }

    public static AmountHelper instance;

    public AmountHelper() {
        this.giroAmount = 8174.12;
        this.visaAmount = 2213.54;
        this.depotAmount = 8212.17;

        calcSaldos();
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

    public double getMoneyToInvest() {
        return ((threeMonthsBeforeSaldo + twoMonthsBeforeSaldo + oneMonthsBeforeSaldo))/3  - reserve ;
    }

    public double getAvgIncome() {
        return (income[0]+income[1]+income[2])/3;
    }

    public double getAvgFixCost() {
        return (fixCost[0]+fixCost[1]+fixCost[2])/3;
    }

    public double getAvgOtherCost() {
        return (other[0]+other[1]+other[2])/3;
    }


    public double getMoneyYouCouldHave() {
        return getMoneyToInvest() * 1.3;
    }

    public void calcSaldos() {

        oneMonthsBeforeSaldo = income[0]-fixCost[0]-other[0];
        twoMonthsBeforeSaldo = income[1]-fixCost[1]-other[1];
        threeMonthsBeforeSaldo = income[2]-fixCost[2]-other[2];
    }
}

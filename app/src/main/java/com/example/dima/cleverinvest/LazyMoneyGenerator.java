package com.example.dima.cleverinvest;

/**
 * Created by u6351605 on 05.10.17.
 */

public class LazyMoneyGenerator {

    Integer income = 3000;
    Integer fixCost = 1300;
    Integer other = 1000;
    Integer maxReserve = income-(fixCost+other);
    Integer reserve = income-(fixCost+other);

    public Integer getIncome() {
        return income;
    }

    public Integer getFixCost() {
        return fixCost;
    }

    public Integer getOther() {
        return other;
    }

    public Integer getMaxReserve() {
        return maxReserve;
    }

    public Integer getReserve() {
        return reserve;
    }

    public LazyMoneyGenerator() {}

    public Integer calculateLazyMoney() {
        return maxReserve-reserve;
    }



}

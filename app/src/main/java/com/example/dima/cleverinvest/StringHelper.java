package com.example.dima.cleverinvest;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Created by Dmitrijs Nesterenko on 05.10.17.
 */

public class StringHelper {
    public static String formatDecimal(double number) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.GERMANY);
        return formatter.format(number);
    }
}

package com.jade.factory;

import com.jade.domain.Sales;
import com.jade.util.Miscellaneous;

public class SalesFactory {
    public static Sales getSales(double salesTotal){
        return new Sales.Builder().salesTotal(salesTotal).salesId(Miscellaneous.generateRandomId()).build();
    }
}
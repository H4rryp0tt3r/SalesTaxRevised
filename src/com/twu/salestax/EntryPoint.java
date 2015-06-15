package com.twu.salestax;

import java.util.ArrayList;

public class EntryPoint {
    public static void main(String args[]) {
        ArrayList<String> exemptionalItemsList = new ArrayList<>();
        exemptionalItemsList.add("book");
        exemptionalItemsList.add("pill");
        exemptionalItemsList.add("chocolate");
        exemptionalItemsList.add("food");
        exemptionalItemsList.add("medicine");
        ExemptionItems exemptionItems = new ExemptionItems(exemptionalItemsList);
        SalesTaxCalculator salesTaxCalculator = new SalesTaxCalculator(exemptionItems);
        salesTaxCalculator.printReceipt();
    }
}

package com.twu.salestax;

import java.util.ArrayList;
import java.util.Scanner;

// This class will initilize all the required classes and invokes printreceipt on SalesTaxCalculator
public class EntryPoint {
    public static void main(String args[]) {
        ArrayList<String> exemptionalItemsList = new ArrayList<>();
        exemptionalItemsList.add("book");
        exemptionalItemsList.add("pill");
        exemptionalItemsList.add("chocolate");
        exemptionalItemsList.add("food");
        exemptionalItemsList.add("medicine");
        Scanner inputReader = new Scanner(System.in);
        IOModule ioModule = new IOModule(inputReader, System.out);
        ExemptionItems exemptionItems = new ExemptionItems(exemptionalItemsList);
        SalesTaxCalculator salesTaxCalculator = new SalesTaxCalculator(exemptionItems, ioModule);
        salesTaxCalculator.printReceipt();
    }
}

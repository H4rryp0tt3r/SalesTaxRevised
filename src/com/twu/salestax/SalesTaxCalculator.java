package com.twu.salestax;

import java.io.BufferedInputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class SalesTaxCalculator {
    private ExemptionItems exemptionItems;

    public SalesTaxCalculator(ExemptionItems exemptionItems) {
        this.exemptionItems = exemptionItems;
    }


    public void printReceipt() {
        Scanner inputReader = new Scanner(new BufferedInputStream(System.in));
        double totalSalesTaxes = 0.0;
        double totalAmount = 0.0;
        while (inputReader.hasNext()) {
            String item = inputReader.nextLine();
            ArrayList<String> itemDetails = Util.parseString(item);
            int noOfItems = getItemQuantity(itemDetails);
            String itemName = getItemName(itemDetails);
            double actualPrice = getItemPriceAsDouble(itemDetails);
            double itemPriceWithAddedTaxes = 0.0;
            itemPriceWithAddedTaxes += actualPrice;
            if (!exemptionItems.isExemptionalItem(itemName)) {
                double taxOfItem = Util.calculateTax(itemPriceWithAddedTaxes, 10);
                itemPriceWithAddedTaxes += taxOfItem;
                totalSalesTaxes += taxOfItem;
            }
            if (Util.isImported(itemName)) {
                double importTaxOnItem = Util.calculateTax(actualPrice, 5);
                itemPriceWithAddedTaxes += importTaxOnItem;
                totalSalesTaxes += importTaxOnItem;
            }
            totalAmount += noOfItems * itemPriceWithAddedTaxes;
            System.out.println(noOfItems + " " + itemName + ": " + round(noOfItems * itemPriceWithAddedTaxes));
        }
        System.out.println("Sales Taxes: " + round(totalSalesTaxes));
        System.out.println("Total: " + round(totalAmount));
    }

    private String round(double number) {
        DecimalFormat formatter = new DecimalFormat("#0.00");
        return formatter.format(number);
    }

    private double getItemPriceAsDouble(ArrayList<String> itemDetails) {
        return Double.parseDouble(itemDetails.get(2));
    }

    private String getItemName(ArrayList<String> itemDetails) {
        return itemDetails.get(1);
    }

    private int getItemQuantity(ArrayList<String> itemDetails) {
        return Integer.parseInt(itemDetails.get(0));
    }
}

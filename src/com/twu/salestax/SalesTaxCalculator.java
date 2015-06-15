package com.twu.salestax;

import java.util.ArrayList;

import static com.twu.salestax.Util.*;

// This class will print the Receipt of Items by adding imported and normal taxes to the prices
public class SalesTaxCalculator {
    private ExemptionItems exemptionItems;
    private IOModule ioModule;

    public SalesTaxCalculator(ExemptionItems exemptionItems, IOModule ioModule) {
        this.exemptionItems = exemptionItems;
        this.ioModule = ioModule;
    }


    public void printReceipt() {
        double totalSalesTaxes = 0.0;
        double totalAmount = 0.0;
        while (ioModule.hasNextLine()) {
            String item = ioModule.readInput();
            ArrayList<String> itemDetails = parseString(item);
            int noOfItems = getItemQuantity(itemDetails);
            String itemName = getItemName(itemDetails);
            double actualPrice = getItemPriceAsDouble(itemDetails);
            double itemPriceWithAddedTaxes = 0.0;
            itemPriceWithAddedTaxes += actualPrice;
            if (!exemptionItems.isExemptionalItem(itemName)) {
                double taxOfItem = calculateTax(itemPriceWithAddedTaxes, 10);
                itemPriceWithAddedTaxes += taxOfItem;
                totalSalesTaxes += taxOfItem;
            }
            if (isImported(itemName)) {
                double importTaxOnItem = calculateTax(actualPrice, 5);
                itemPriceWithAddedTaxes += importTaxOnItem;
                totalSalesTaxes += importTaxOnItem;
            }
            totalAmount += noOfItems * itemPriceWithAddedTaxes;
            ioModule.println(noOfItems + " " + itemName + ": " + round(noOfItems * itemPriceWithAddedTaxes));
        }
        ioModule.println("Sales Taxes: " + round(totalSalesTaxes));
        ioModule.println("Total: " + round(totalAmount));
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

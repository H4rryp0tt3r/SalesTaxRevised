package com.twu.salestax;

import java.text.DecimalFormat;
import java.util.ArrayList;

// This is a Utility class with Parsing & Number Rounding & ArrayToString & isImported? methods
public class Util {

    public static double calculateTax(double amount, int taxPercentage) {
        double taxValue = (amount / 100.0) * taxPercentage;
        return Math.round(taxValue * 100.0) / 100.0;
    }

    public static ArrayList<String> parseString(String inputString) {
        ArrayList<String> resultList = new ArrayList<>();
        String[] data = inputString.split(" at ");
        String[] anotherData = data[0].split(" ");
        resultList.add(anotherData[0]);
        resultList.add(arrayToString(anotherData));
        resultList.add(data[1]);
        return resultList;
    }

    private static String arrayToString(String[] itemDetails) {
        String resultData = "";
        for (int i = 1; i < itemDetails.length; i++) {
            resultData += itemDetails[i] + " ";
        }
        return resultData.replaceAll("\\s+$", "");
    }

    public static Boolean isImported(String itemName) {
        if (itemName.contains("imported"))
            return true;
        return false;
    }

    public static String round(Double number) {
        DecimalFormat formatter = new DecimalFormat("#0.00");
        return formatter.format(number);
    }
}

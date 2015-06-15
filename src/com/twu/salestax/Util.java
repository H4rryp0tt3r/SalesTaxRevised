package com.twu.salestax;

import java.util.ArrayList;

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
}

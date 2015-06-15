package com.twu.salestax;

import java.util.ArrayList;

// This class will hold the Exemption items list And Has a method to check wether an item is exemptional or not
public class ExemptionItems {
    private ArrayList<String> exemptionalItems;

    public ExemptionItems(ArrayList<String> exemptionalItems) {
        this.exemptionalItems = exemptionalItems;
    }

    public Boolean isExemptionalItem(String itemName) {
        for (int index = 0; index < exemptionalItems.size(); index++) {
            String exemptionalItem = exemptionalItems.get(index);
            if (itemName.contains(exemptionalItem))
                return true;
        }
        return false;
    }
}

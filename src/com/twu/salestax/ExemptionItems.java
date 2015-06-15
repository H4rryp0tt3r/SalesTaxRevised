package com.twu.salestax;

import java.util.ArrayList;

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

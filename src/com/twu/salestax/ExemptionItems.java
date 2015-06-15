package com.twu.salestax;

import java.util.ArrayList;

public class ExemptionItems {
    private ArrayList<String> exemptionalItems;

    public ExemptionItems() {
        exemptionalItems = new ArrayList<>();
        exemptionalItems.add("book");
        exemptionalItems.add("pill");
        exemptionalItems.add("chocolate");
        exemptionalItems.add("food");
        exemptionalItems.add("medicine");
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

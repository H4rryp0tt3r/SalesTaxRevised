package com.twu.salestax;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ExemptionItemsTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @Test
    public void shouldBeAbleToFindExemptionalItems() {
        ArrayList<String> exemptionalItemsList = new ArrayList<>();
        exemptionalItemsList.add("book");
        exemptionalItemsList.add("pill");
        exemptionalItemsList.add("chocolate");
        exemptionalItemsList.add("food");
        exemptionalItemsList.add("medicine");
        ExemptionItems items = new ExemptionItems(exemptionalItemsList);

        Boolean actualResult = items.isExemptionalItem("packet of headache pills");

        assertThat(actualResult, is(true));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }
}
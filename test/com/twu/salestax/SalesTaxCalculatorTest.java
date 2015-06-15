package com.twu.salestax;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SalesTaxCalculatorTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final ByteArrayInputStream inContent = new ByteArrayInputStream("1 imported box of chocolates at 10.00\n1 imported bottle of perfume at 47.50".getBytes());

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        System.setIn(inContent);
    }

    @Test
    public void shouldBeAbleToPrintFinalReceiptWithTaxDetails() {
        ArrayList<String> exemptionalItemsList = new ArrayList<>();
        exemptionalItemsList.add("book");
        exemptionalItemsList.add("pill");
        exemptionalItemsList.add("chocolate");
        exemptionalItemsList.add("food");
        exemptionalItemsList.add("medicine");
        Scanner inputReader = new Scanner(System.in);
        IOModule ioModule = new IOModule(inputReader, System.out);
        SalesTaxCalculator salesTaxProblem = new SalesTaxCalculator(new ExemptionItems(exemptionalItemsList), ioModule);

        salesTaxProblem.printReceipt();

        String actualResponse = outContent.toString();

        assertThat(actualResponse, is("1 imported box of chocolates: 10.50\n" +
                "1 imported bottle of perfume: 54.63\n" +
                "Sales Taxes: 7.63\n" +
                "Total: 65.13\n"));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
        System.setIn(null);
    }
}
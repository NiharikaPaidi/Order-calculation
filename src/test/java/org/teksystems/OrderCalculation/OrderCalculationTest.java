package org.teksystems.OrderCalculation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Test;

public class OrderCalculationTest
{

    @Test
    public void testCalculateTaxForLocalGoods()
    {
        final float price = 250f;
        final Item localItem = new Item("Perfume", price);
        final double taxOfPerfume = calculator.getTaxforItem(localItem);
        // Making sure that a 10% tax is levied.
        assertTrue(25 == taxOfPerfume);
    }

    @Test
    public void testCalculateTaxForImportedGoods()
    {
        final float price = 500f;
        final Item importedItem = new Item("Imported jewellery", price);
        final double taxOfjewellery = calculator.getTaxforItem(importedItem);
        // Making sure that a 15% tax is levied.
        assertTrue(75 == taxOfjewellery);
    }

    @Test
    public void testCalculateOrders_EmptyMap()
    {

        final Map<String, Order> orders = new LinkedHashMap<String, Order>();
        final double grandTotal = calculator.calculate(orders);
        // Verifies it receives grandTotal as 0 --> for Empty orders
        assertEquals(0, grandTotal, 0.0);
    }

}

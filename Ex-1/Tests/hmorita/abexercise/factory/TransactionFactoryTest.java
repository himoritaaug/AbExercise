package hmorita.abexercise.factory;

import hmorita.abexercise.data.TransactionData;
import hmorita.abexercise.entity.TransType;
import hmorita.abexercise.entity.Transaction;
import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class TransactionFactoryTest extends TransactionFactory {

    @Test
    public void testConvertTransType() {
        TransactionFactory f = new TransactionFactory();
        String p = "p";
        f.convertTransType(p);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalException() {
        TransactionFactory f = new TransactionFactory();
        String x1 = "x";
        f.convertTransType(x1);
    }

    @Test
    public void testTransDate() {
        TransactionFactory f = new TransactionFactory();
        String s1 = "113016";
        assertEquals(f.convertTransDate(s1), 113016);

        String s2 = "113116"; // Current it is valid date
        assertEquals(f.convertTransDate(s2), 113116);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalTransDateLessThan6() {
        TransactionFactory f = new TransactionFactory();
        String s1 = "11301"; // less than 6 characters
        f.convertTransDate(s1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalTransDateInValidNumeric() {
        TransactionFactory f = new TransactionFactory();
        String s1 = "11301s";
        f.convertTransDate(s1);
    }

    @Test
    public void testTransQuantity() {
        TransactionFactory f = new TransactionFactory();
        String s1 = "100";
        assertEquals(f.convertQuantity(s1), 100);

        String s2 = "99";
        assertEquals(f.convertQuantity(s2), 99);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalTransQuantity() {
        TransactionFactory f = new TransactionFactory();
        String s1 = "2000";
        assertEquals(f.convertQuantity(s1), 2000); // should be less than 1000
    }

    @Test
    public void testTransPrice() {
        TransactionFactory f = new TransactionFactory();
        String s1 = "10000";
        assertEquals(f.convertPrice(s1), 10000);

        String s2 = "99999";
        assertEquals(f.convertPrice(s2), 99999);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalTransPrice() {
        TransactionFactory f = new TransactionFactory();
        String s1 = "200000000";
        assertEquals(f.convertPrice(s1), 200000000); // should be less than 1000
    }


    @Test
    public void testCalculateSalesAmount() {
        // 20161102000001,P,110216,18673,End Table,3,80000,20,,
        TransactionData d = new TransactionData();
        d.transId = "20161102000001";
        d.transType = "P";
        d.transDateMDY = "110216";
        d.customerId = "18673";
        d.quantity = "3000";
        d.price = "80000";
        d.discount = "20";

        TransactionFactory f = new TransactionFactory();
        Transaction tx = f.create(d);

        int salesAmount = tx.calculateSalesAmount();
        assertEquals(salesAmount, 240000);

    }
}
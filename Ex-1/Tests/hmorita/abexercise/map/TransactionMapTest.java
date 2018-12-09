package hmorita.abexercise.map;

import hmorita.abexercise.entity.TransType;
import hmorita.abexercise.entity.Transaction;
import hmorita.abexercise.factory.TransactionFactory;
import hmorita.abexercise.loader.TransactionLoader;
import org.junit.Test;

import java.math.BigDecimal;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class TransactionMapTest {

    @Test
    public void addToMap() {
        TransactionMap m = new TransactionMap();

        Transaction tx1 = new Transaction();
        tx1.setTransid(1234);
        tx1.setTransType(TransType.P);
        tx1.setCustomerId(111);
        tx1.setQuantity((short)10);
        tx1.setPrice(3000);

        Transaction tx2 = new Transaction();
        tx2.setTransid(1235);
        tx2.setTransType(TransType.P);
        tx2.setCustomerId(111);
        tx2.setQuantity((short)40);
        tx2.setPrice(2000);

        Transaction tx3 = new Transaction();
        tx3.setTransid(1237);
        tx3.setTransType(TransType.R);
        tx3.setCustomerId(111);
        tx3.setQuantity((short)25);
        tx3.setPrice(2000);

        m.addToMap(tx1);
        m.addToMap(tx2);
        m.addToMap(tx3);

        BigDecimal v = m.getMapValue(111);
        System.out.println(v);
        assertEquals(v, BigDecimal.valueOf(60000)); // 10x3000 + 40x2000 - 25x2000 = 30,000 + 80,000 - 50,000
    }

    @Test
    public void loadAndAddToMap() {
        String fileName = "C:\\work\\AbInitioExercise\\data\\TestOut\\2016\\11\\";
        TransactionFactory f = new TransactionFactory();

        Path path = FileSystems.getDefault().getPath(fileName, "transaction_110216.dat");

        TransactionLoader loader = new TransactionLoader();
        TransactionMap map = new TransactionMap();
        ArrayList<Transaction> txs = loader.load(f, path);
        txs.forEach( tx -> {
            map.addToMap(tx);
        });

        BigDecimal val1 = map.getMapValue(12883);
        System.out.println("Customer 12883 bought " + val1);
        assertEquals(val1, BigDecimal.valueOf(210000));

        BigDecimal val2 = map.getMapValue(9881);
        System.out.println("Customer 9881 bought " + val2);
        assertEquals(val2, BigDecimal.valueOf(830000));

        BigDecimal val3 = map.getMapValue(3333); // no customer
        System.out.println("Customer 3333 bought " + val3);
        assertNull(val3);


    }

}
package hmorita.abexercise.loader;

import hmorita.abexercise.data.TransactionData;
import hmorita.abexercise.entity.Keyable;
import hmorita.abexercise.entity.Transaction;
import hmorita.abexercise.factory.EntityFactory;
import hmorita.abexercise.factory.TransactionFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.Key;
import java.util.ArrayList;

public class TransactionEntityLoader implements EntityLoader<Transaction, TransactionFactory> {

    private TransactionFactory factory;
    private Path fileToParh;

    public TransactionEntityLoader(TransactionFactory ef, Path f) {
        factory = ef;
        fileToParh = f;
    }


    @Override
    public ArrayList<Transaction> load() {
        // TODO : 10000 is not ligical.
        ArrayList<Transaction> txs = new ArrayList<>(10000);
        try {
            Files.readAllLines(fileToParh).forEach( line -> {
                if(line != null && !line.isEmpty()) { // Skip null line.
                    Transaction tx = factory.create(line);
                    System.out.println(tx.toString());
                    txs.add(tx);
                }
            });
        } catch (IllegalArgumentException iae) {
            iae.printStackTrace();
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }

        return txs;
    }


}

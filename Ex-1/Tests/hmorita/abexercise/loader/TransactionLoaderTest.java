package hmorita.abexercise.loader;

import hmorita.abexercise.entity.Transaction;
import hmorita.abexercise.factory.TransactionFactory;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TransactionLoaderTest {

    @Test
    public void load() {
        String fileName = "C:\\work\\AbInitioExercise\\data\\TestOut\\2016\\11\\";
        TransactionFactory f = new TransactionFactory();

        Path path = FileSystems.getDefault().getPath(fileName, "transaction_110216.dat");

        //TransactionLoader loader = new TransactionLoader(f, path);
        TransactionLoader loader = new TransactionLoader();
        //ArrayList<Transaction> txs = loader.load();
        ArrayList<Transaction> txs = loader.load(f, path);
        System.out.println(txs.size());

    }

    @Test
    public void loadAllTestData() {
        String dirToTraverse = "C:\\work\\AbInitioExercise\\data\\TestOut\\2017\\02\\";
        TransactionFactory f = new TransactionFactory();

        try {
            Files.list(Paths.get(dirToTraverse)).forEach( file -> {
                System.out.println(file);
                TransactionLoader loader = new TransactionLoader();
                ArrayList<Transaction> txs = loader.load(f, file);
                System.out.println(txs.size());
            });

        } catch(IOException ioe) {
            ioe.printStackTrace();
        }

    }

    @Test
    public void loadAllTransactions() {
        String txRootDir = "C:\\work\\AbInitioExercise\\data\\TestOut\\";
        List<String> txSubDirs = Arrays.asList(
          "2016\\11\\", "2016\\12", "2017\\01\\", "2017\\02\\"
        );

        TransactionFactory f = new TransactionFactory();

        txSubDirs.forEach(dir -> {
            try {
                String dirToTraverse = txRootDir + dir;
                Files.list(Paths.get(dirToTraverse)).forEach( file -> {
                    System.out.println(file);
                    TransactionLoader loader = new TransactionLoader();
                    ArrayList<Transaction> txs = loader.load(f, file);
                    System.out.println(txs.size());
                });
            } catch(IOException ioe) {
                ioe.printStackTrace();
            }
        });

    }


}
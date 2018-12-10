package hmorita.abexercise;

import hmorita.abexercise.entity.Customer;
import hmorita.abexercise.entity.Transaction;
import hmorita.abexercise.factory.CustomerFactory;
import hmorita.abexercise.factory.TransactionFactory;
import hmorita.abexercise.loader.CustomerLoader;
import hmorita.abexercise.loader.TransactionLoader;
import hmorita.abexercise.map.CustomerMap;
import hmorita.abexercise.map.TransactionMap;
import hmorita.abexercise.report.SalesAmountReport;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String args[]) {
        long t1 = System.currentTimeMillis();
        System.out.println("Start.. ");
        CustomerMap custMap = getCustomerMap(); // Create CustomerMap
        TransactionMap tranMap = getTransactionMap(); // Create TrasactionMap
        createReport(custMap, tranMap); // create Report
        long t2 = System.currentTimeMillis();
        System.out.println("End : Time elapsed : " + (t2 - t1) + " (ms)");
    }


    static private CustomerMap getCustomerMap() {
        String fileName = "C:\\work\\AbInitioExercise\\data\\";
        CustomerFactory f = new CustomerFactory();
        Path path = FileSystems.getDefault().getPath(fileName, "customer-dec.csv");
        ArrayList<Customer> custs = new CustomerLoader().load(f, path);
        CustomerMap map = new CustomerMap();
        custs.forEach( cust -> {
            map.addToMap(cust);
        });
        return map;
    }

    static private TransactionMap getTransactionMap() {

        String txRootDir = "C:\\work\\AbInitioExercise\\data\\TestOut\\";
        List<String> txSubDirs = Arrays.asList(
                "2016\\11\\", "2016\\12", "2017\\01\\", "2017\\02\\"
        );

        TransactionFactory f = new TransactionFactory();
        TransactionMap map = new TransactionMap();

        txSubDirs.forEach(dir -> {
            try {
                String dirToTraverse = txRootDir + dir;
                Files.list(Paths.get(dirToTraverse)).forEach( file -> {
                    TransactionLoader loader = new TransactionLoader();
                    ArrayList<Transaction> txs = loader.load(f, file);
                    txs.forEach( tx -> {
                        map.addToMap(tx);
                    });
                });
            } catch(IOException ioe) {
                ioe.printStackTrace();
            }
        });

        return map;
    }

    static private void createReport(CustomerMap custMap, TransactionMap txMap) {
        String outFileDir = "C:\\work\\AbInitioExercise\\data\\";
        String outFile = "rep-all.csv";
        Path outPath = FileSystems.getDefault().getPath(outFileDir, outFile);
        BufferedWriter bw;
        SalesAmountReport rep = new SalesAmountReport(custMap, txMap);
        try {
            bw = Files.newBufferedWriter(outPath);
            rep.createReport(str -> {
                try {
                    bw.write(str);
                    bw.newLine();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            });
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }

    }


}

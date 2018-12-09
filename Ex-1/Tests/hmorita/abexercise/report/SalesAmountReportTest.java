package hmorita.abexercise.report;

import hmorita.abexercise.entity.Customer;
import hmorita.abexercise.entity.Transaction;
import hmorita.abexercise.factory.CustomerFactory;
import hmorita.abexercise.factory.TransactionFactory;
import hmorita.abexercise.loader.CustomerLoader;
import hmorita.abexercise.loader.TransactionLoader;
import hmorita.abexercise.map.CustomerMap;
import hmorita.abexercise.map.TransactionMap;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class SalesAmountReportTest {

    @Test
    public void createReport() {

        String custFilePath = "C:\\work\\AbInitioExercise\\data\\";
        CustomerFactory custFactory = new CustomerFactory();
        Path custPath = FileSystems.getDefault().getPath(custFilePath, "customer-dec.csv");

        CustomerLoader custLoader = new CustomerLoader();
        ArrayList<Customer> custList = custLoader.load(custFactory, custPath);
        CustomerMap custMap = new CustomerMap();
        custList.forEach( cust -> {
            custMap.addToMap(cust);
        });

        String txFilePath = "C:\\work\\AbInitioExercise\\data\\TestOut\\2016\\11\\";
        TransactionFactory txFactory = new TransactionFactory();
        Path txPath = FileSystems.getDefault().getPath(txFilePath, "transaction_110216.dat");

        TransactionLoader txLoader = new TransactionLoader();
        ArrayList<Transaction> txList = txLoader.load(txFactory, txPath);
        TransactionMap txMap = new TransactionMap();
        txList.forEach( tx -> {
            txMap.addToMap(tx);
        });


        String outFileDir = "C:\\work\\AbInitioExercise\\data\\";
        String outFile = "rep-2016-11.csv";
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
package hmorita.abexercise;

import hmorita.abexercise.entity.Customer;
import hmorita.abexercise.factory.CustomerFactory;
import hmorita.abexercise.loader.CustomerLoader;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String args[]) {
        System.out.println("Start..");
        ArrayList<Customer> custs = getCustomer();
        custs.forEach(cust -> {
            System.out.println(cust.getCustomerid() + " " + cust.getName());
        });
    }


    static public ArrayList<Customer> getCustomer() {
        String fileName = "C:\\work\\AbInitioExercise\\data\\";
        CustomerFactory f = new CustomerFactory();
        Path path = FileSystems.getDefault().getPath(fileName, "customer-dec.csv");
        return new CustomerLoader().load(f, path);
    }
}

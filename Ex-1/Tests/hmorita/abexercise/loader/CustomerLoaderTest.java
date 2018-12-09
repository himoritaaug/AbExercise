package hmorita.abexercise.loader;

import hmorita.abexercise.entity.Customer;
import hmorita.abexercise.factory.CustomerFactory;
import org.junit.Test;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class CustomerLoaderTest {

    @Test
    public void testLoad() {
        String fileName = "C:\\work\\AbInitioExercise\\data\\";
        CustomerFactory f = new CustomerFactory();

        Path path = FileSystems.getDefault().getPath(fileName, "customer-dec.csv");

        CustomerLoader loader = new CustomerLoader();
        ArrayList<Customer> custs = loader.load(f, path);
        System.out.println(custs.size());

    }

}
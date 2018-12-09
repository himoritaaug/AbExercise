package hmorita.abexercise.map;

import hmorita.abexercise.entity.Customer;
import hmorita.abexercise.factory.CustomerFactory;
import hmorita.abexercise.loader.CustomerLoader;
import org.junit.Test;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class CustomerMapTest {

    @Test
    public void testAddToMap() {

        CustomerMap m = new CustomerMap();
        Customer c1 = new Customer();
        c1.setCustomerid(7670);
        c1.setName("川井 瞳");
        m.addToMap(c1);

        String n1 = m.getMapValue(7670);
        System.out.println(n1);
        assertEquals(n1, "川井 瞳");

        Customer c2 = new Customer();
        c2.setCustomerid(7671);
        c2.setName("坂下 克実");
        m.addToMap(c2);

        String n2 = m.getMapValue(7671);
        System.out.println(n2);
        assertEquals(n2, "坂下 克実");

        Customer c3 = new Customer();
        c3.setCustomerid(7671);
        c3.setName("坂下 克也"); // Updated new name
        m.addToMap(c3);
        String n3 = m.getMapValue(7671);
        System.out.println(n3);
        assertEquals(n3, "坂下 克也");
    }

    @Test
    public void loadAndAddToMap() {
        String fileName = "C:\\work\\AbInitioExercise\\data\\";
        CustomerFactory f = new CustomerFactory();

        Path path = FileSystems.getDefault().getPath(fileName, "customer-dec.csv");

        CustomerLoader loader = new CustomerLoader();
        CustomerMap map = new CustomerMap();
        ArrayList<Customer> custs = loader.load(f, path);
        custs.forEach( cust -> {
            map.addToMap(cust);
        });

        String val1 = map.getMapValue(7602);
        System.out.println("Customer 7602 " + val1);
        assertEquals(val1, "角田 三郎");

        String val2 = map.getMapValue(19078);
        System.out.println("Customer 19078 " + val2);
        assertEquals(val2, "青柳 誠治");

        String val3 = map.getMapValue(3333); // no customer
        System.out.println("Customer 3333 " + val3);
        assertNull(val3);

    }


}
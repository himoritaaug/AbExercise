package hmorita.abexercise.entity;


import hmorita.abexercise.entity.Customer;

import static org.junit.Assert.*;

public class CustomerTest {

    @org.junit.Test
    public void unique() {

        Customer c1 = new Customer(7602, "角田 三郎");
        Customer c2 = new Customer(7603, "柴咲 里奈");
        Customer c3 = new Customer(7603, "柴咲 里奈");

        assertEquals(c1.key(), 7602);
        assertEquals(c2.key(), 7603);

    }
}
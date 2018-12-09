package hmorita.abexercise.map;

import hmorita.abexercise.entity.Customer;

import java.util.HashMap;

public class CustomerMap extends EntityMap<Customer, String> {

    public CustomerMap() {
        // 100000 is the row number of customer.csv.
        entityMap = new HashMap<>(10000);
    }

    @Override
    public void addToMap(Customer customer) {
        long id = customer.key();
        String name = customer.getName();
        entityMap.put(id, name); // New name updates old name.
    }
}

package hmorita.abexercise.factory;

import hmorita.abexercise.data.CustomerData;
import hmorita.abexercise.entity.Customer;

import java.util.Arrays;
import java.util.List;

public class CustomerFactory implements EntityFactory<CustomerData, Customer>{

    @Override
    public Customer create(CustomerData data) throws IllegalArgumentException {
        Customer cust = new Customer();
        cust.setCustomerid(convertKey(data.customerId));
        cust.setName(data.kanjiName);
        return cust;
    }

    @Override
    public Customer create(String line) throws IllegalArgumentException {
        CustomerData d = new CustomerData();
        String[] els = line.split(",");
        for(int i = 0; i < els.length; i++) {
            if(skipColumnNumbers().contains(i)) continue;
            if(i == 0) d.customerId = els[i];
            else if(i == 1) d.kanjiName = els[i];
        }
        return create(d);
    }

    @Override
    public List<Integer> skipColumnNumbers() {
        return Arrays.asList(
                2, // Furigana
                3, // Gender
                4, // Age
                5, // Date of birth
                6, // Maturial Status
                7  // Pefecture
        );
    }
}

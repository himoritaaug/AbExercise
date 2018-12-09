package hmorita.abexercise.loader;

import hmorita.abexercise.entity.Customer;
import hmorita.abexercise.entity.Transaction;
import hmorita.abexercise.factory.CustomerFactory;

public class CustomerLoader implements EntityLoader<Customer, CustomerFactory>{

    @Override
    public boolean isSkipLine(String line) {
        // startsWith="cust" means header line.
        return EntityLoader.super.isSkipLine(line) || line.startsWith("custid");
    }

}

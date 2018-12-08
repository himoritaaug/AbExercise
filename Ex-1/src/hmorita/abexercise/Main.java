package hmorita.abexercise;

import hmorita.abexercise.entity.Customer;
import hmorita.abexercise.provider.DummyCustomerProvider;

import java.util.Arrays;

public class Main {
    public static void main(String args[]) {
        System.out.println("Start..");
        Customer[] custs = getCustomer();
        Arrays.stream(custs).forEach(cust -> {
            System.out.println(cust.getCustomerid() + " " + cust.getNname());
        });
    }


    static public Customer[] getCustomer() {
        return new DummyCustomerProvider().provide();
    }
}

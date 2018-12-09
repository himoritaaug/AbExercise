package hmorita.abexercise.report;

import hmorita.abexercise.map.CustomerMap;
import hmorita.abexercise.map.TransactionMap;

import java.util.function.Consumer;
import java.util.function.Function;

public class SalesAmountReport {

    private CustomerMap customerMap;
    private TransactionMap transactionMap;

    public SalesAmountReport(CustomerMap customerMap, TransactionMap transactionMap) {
        this.customerMap = customerMap;
        this.transactionMap = transactionMap;
    }

    public void createReport(Consumer<String> disp) {
        transactionMap.getMap().forEach((key, amount) -> {
            String name = customerMap.getMapValue(key);
            disp.accept(key + "," + name + "," + amount);
        });
    }

}

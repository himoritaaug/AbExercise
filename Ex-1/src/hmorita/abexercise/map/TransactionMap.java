package hmorita.abexercise.map;

import hmorita.abexercise.entity.Transaction;

import java.math.BigDecimal;
import java.util.HashMap;

public class TransactionMap extends EntityMap<Transaction, BigDecimal> {

    public TransactionMap() {
        // TODO: 10000 is not logical.
        entityMap = new HashMap<>(10000);
    }

    @Override
    public void addToMap(Transaction tx) {
        long id = tx.getCustomerId();
        BigDecimal val = BigDecimal.valueOf(tx.calculateSalesAmount());
        if(entityMap.containsKey(id)) {
            val = val.add(entityMap.get(id));
        }
        entityMap.put(id, val);
    }

}

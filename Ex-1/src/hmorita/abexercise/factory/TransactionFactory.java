package hmorita.abexercise.factory;

import hmorita.abexercise.data.TransactionData;
import hmorita.abexercise.entity.TransType;
import hmorita.abexercise.entity.Transaction;
import hmorita.abexercise.validation.FieldValidateMDY;
import hmorita.abexercise.validation.FieldValidatePrice;
import hmorita.abexercise.validation.FieldValidateQty;

import java.util.Arrays;
import java.util.List;


public class TransactionFactory implements EntityFactory<TransactionData, Transaction> {

    @Override
    public Transaction create(TransactionData data) throws IllegalArgumentException {

        Transaction tx = new Transaction();
        tx.setTransid(convertLongId(data.customerId));
        tx.setTransType(data.transType);
        tx.setTransDateMDY(convertTransDate(data.transDateMDY));
        tx.setCustomerId(convertLongId(data.customerId));
        tx.setQuantity(convertQuantity(data.quantity));
        tx.setPrice(convertPrice(data.price));
        tx.setDiscount(convertDiscount(data.discount));
        tx.setReturnTranId(convertLongId(data.returnTranId));

        return tx;
    }

    @Override
    public Transaction create(String line) throws IllegalArgumentException {
        TransactionData d = new TransactionData();
        String[] els = line.split(",");
        for(int i = 0; i < els.length; i++) {
            if(skipColumnNumbers().contains(i)) continue;
            if(i == 0) d.transId = els[i];
            else if(i == 1) d.transType = els[i];
            else if(i == 2) d.transDateMDY = els[i];
            else if(i == 3) d.customerId = els[i];
            else if(i == 5) d.quantity = els[i];
            else if(i == 6) d.price = els[i];
            else if(i == 7) d.discount = els[i];
            else if(i == 8) d.returnTranId = els[i];
        }
        return create(d);

    }

    @Override
    public List<Integer> skipColumnNumbers() {
        return Arrays.asList(
                4, // Poduct Description
                9  // Return reason
        );
    }


    protected long convertLongId(String s) {
        if(s == null || s.isEmpty()) return 0;
        return Long.valueOf(s);
    }

    protected TransType convertTransType(String s) throws IllegalArgumentException {
        return TransType.valueOf(s.toUpperCase());
    }

    protected int convertTransDate(String s) throws IllegalArgumentException {
        FieldValidateMDY fv = new FieldValidateMDY(s);
        return fv.validate();
    }

    protected short convertQuantity(String s) throws IllegalArgumentException {
        return new FieldValidateQty(s, (short)1000).validate(); // Max Qty is supposed to be 1000
    }

    protected int convertPrice(String s) throws IllegalArgumentException {
        return new FieldValidatePrice(s, 1000000).validate(); // Max price is supposed to 1000000
    }

    protected short convertDiscount(String s) throws IllegalArgumentException {
        return new FieldValidateQty(s, (short)100).validate(); // Max Discount is less than 100
    }

}

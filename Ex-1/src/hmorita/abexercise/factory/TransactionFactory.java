package hmorita.abexercise.factory;

import hmorita.abexercise.data.TransactionData;
import hmorita.abexercise.entity.TransType;
import hmorita.abexercise.entity.Transaction;
import hmorita.abexercise.validation.FieldValidateMDY;
import hmorita.abexercise.validation.FieldValidatePrice;
import hmorita.abexercise.validation.FieldValidateQty;
import org.apache.poi.util.StringUtil;
import scala.Int;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TransactionFactory implements EntityFactory<TransactionData, Transaction> {

    @Override
    public Transaction create(TransactionData data) throws IllegalArgumentException {

        Transaction tx = new Transaction();
        tx.setTransid(convertId(data.customerId));
        tx.setTransDateMDY(convertTransDate(data.transDateMDY));
        tx.setCustomerId(convertId(data.customerId));
        tx.setQuantity(convertQuantity(data.quantity));
        tx.setPrice(convertPrice(data.price));
        tx.setDiscount(convertDiscount(data.discount));
        tx.setReturnTranId(convertId(data.returnTranId));

        return tx;

    }


    protected int convertId(String s) {
        if(s == null || s.isEmpty()) return 0;
        return Integer.valueOf(s);
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

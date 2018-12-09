package hmorita.abexercise.entity;

import java.math.BigDecimal;

public class ReportElement implements Keyable {

    private long customerId;
    private String name;
    private BigDecimal amount;

    public long getCustomerid() {
        return customerId;
    }

    public void setCustomerId(long customerid) {
        this.customerId = customerid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public long key() {
        return customerId;
    }

    @Override
    public String toString() {
        return new StringBuilder()
            .append("Customer Id:" + customerId)
            .append(" " + name)
            .append(" " + amount).toString();

    }

}

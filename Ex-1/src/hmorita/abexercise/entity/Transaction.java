package hmorita.abexercise.entity;

public class Transaction implements Keyable {

    private long transId;
    private TransType transType;
    private int transDateMDY;
    private long customerId;
    private short quantity;
    private int price;
    private short discount;
    private long returnTranId;

    public long getTransid() {
        return transId;
    }

    public void setTransid(long transid) {
        this.transId = transid;
    }

    public TransType getTransType() {
        return transType;
    }

    public void setTransType(TransType transtype) {
        this.transType = transtype;
    }

    public int getTransDateMDY() {
        return transDateMDY;
    }

    public void setTransDateMDY(int transsdateMDY) {
        this.transDateMDY = transsdateMDY;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerid) {
        this.customerId = customerid;
    }

    public short getQuantity() {
        return quantity;
    }

    public void setQuantity(short quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public short getDiscount() {
        return discount;
    }

    public void setDiscount(short discount) {
        this.discount = discount;
    }

    public long getReturnTranId() {
        return returnTranId;
    }

    public void setReturnTranId(long returnTranId) {
        this.returnTranId = returnTranId;
    }

    /*
     * Calculate sales amount for each order.
     * Quantity max is supposed to 100 and price is 1000000, so max sale amount is less than 100,000,000. (1 oku)
     */
    public int calculateSalesAmount() throws IllegalArgumentException {
        int sign = transType == TransType.R ? -1 : 1;
        return getQuantity() * getPrice() * sign;
    }

    @Override
    public long key() {
        return transId;
    }

    @Override
    public String toString() {
        return new StringBuilder()
         .append("Transaction Id:" + transId)
         .append(" " + transType)
         .append(" " + customerId)
         .append(" " + quantity)
         .append(" " + price)
         .append(" " + discount)
         .append(" " + returnTranId).toString();

    }
}

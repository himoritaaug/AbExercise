package hmorita.abexercise.entity;

public class Transaction {

    private int transId;
    private String transType;
    private int transDateMDY;
    private int customerId;
    private short quantity;
    private int price;
    private short discount;
    private int returnTranId;

    public int getTransid() {
        return transId;
    }

    public void setTransid(int transid) {
        this.transId = transid;
    }

    public String getTransType() {
        return transType;
    }

    public void setTransType(String transtype) {
        this.transType = transtype;
    }

    public int getTransDateMDY() {
        return transDateMDY;
    }

    public void setTransDateMDY(int transsdateMDY) {
        this.transDateMDY = transsdateMDY;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerid) {
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

    public int getReturnTranId() {
        return returnTranId;
    }

    public void setReturnTranId(int returnTranId) {
        this.returnTranId = returnTranId;
    }

    /*
     * Calculate sales amount for each order.
     * Quantity max is supposed to 100 and price is 1000000, so max sale amount is less than 100,000,000. (1 oku)
     */
    public int calculateSalesAmount() throws IllegalArgumentException {
        return getQuantity() * getPrice();
    }

}

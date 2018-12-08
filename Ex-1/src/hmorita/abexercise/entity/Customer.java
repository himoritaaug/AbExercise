package hmorita.abexercise.entity;

public class Customer implements Keyable, LogicalMatcher {

    private int _customerid;
    private String _name;

    public Customer(int _customerid, String name) {
        this._customerid = _customerid;
        this._name = name;
    }

    public int getCustomerid() {
        return _customerid;
    }

    public void setCustomerid(int _customerid) {
        this._customerid = _customerid;
    }

    public String getNname() {
        return _name;
    }

    public void setNname(String _name) {
        this._name = _name;
    }

    @Override
    public int key() {
        return _customerid;
    }

    @Override
    public boolean isLogicalMatch(Keyable el) {
        return key() == el.key();
    }

    //@Override
    //public boolean isLogicalMatch(CustomerData c) {
    //    return _customerid == c._customerid;
    //}

}
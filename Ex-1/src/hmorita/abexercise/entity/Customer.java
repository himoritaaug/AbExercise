package hmorita.abexercise.entity;

public class Customer implements Keyable {

    private long _customerid;
    private String _name;

    public Customer() {}
    public Customer(int _customerid, String name) {
        this._customerid = _customerid;
        this._name = name;
    }

    public long getCustomerid() {
        return _customerid;
    }

    public void setCustomerid(long _customerid) {
        this._customerid = _customerid;
    }

    public String getName() {
        return _name;
    }

    public void setName(String _name) {
        this._name = _name;
    }

    @Override
    public long key() {
        return _customerid;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("Customer Id:" + _customerid)
                .append(" " + _name).toString();

    }

}

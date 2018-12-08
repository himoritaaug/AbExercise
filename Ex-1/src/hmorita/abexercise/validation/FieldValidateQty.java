package hmorita.abexercise.validation;

public class FieldValidateQty implements FieldValidate<Short> {
    private String validatee;
    private short atMax;

    public FieldValidateQty(String val) {
        validatee = val;
        atMax = 1000; // Default is 1000
    }

    public FieldValidateQty(String val, short max) {
        validatee = val;
        atMax = max;
    }

    public Short validate() throws IllegalArgumentException {
        return validate(validatee);
    }

    @Override
    public Short validate(String s) throws IllegalArgumentException {
        short validatedShort = 0;
        try {
            validatedShort = Short.valueOf(s);
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
            throw new IllegalArgumentException("Illegal number - Qty should be number :" + s);
        }

        // Check if it is under max number.
        if(validatedShort >= atMax) {
            throw new IllegalArgumentException("Illegal number - Qty should be less than " + atMax);
        }

        return validatedShort;

    }
}

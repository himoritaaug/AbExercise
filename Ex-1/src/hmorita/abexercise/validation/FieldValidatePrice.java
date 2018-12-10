package hmorita.abexercise.validation;

public class FieldValidatePrice implements FieldValidate<Integer> {

    private String validatee;
    private int atMax;

    public FieldValidatePrice(String val) {
        validatee = val;
        atMax = 100000; // Default is 1000
    }

    public FieldValidatePrice(String val, int max) {
        validatee = val;
        atMax = max;
    }

    public Integer validate() throws IllegalArgumentException {
        return validate(validatee);
    }

    @Override
    public Integer validate(String s) throws IllegalArgumentException {
        int validatedInt = 0;
        try {
            validatedInt = Integer.valueOf(s);
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
            throw new IllegalArgumentException("Illegal number - Price should be number :" + s);
        }

        // Check if it is under max number.
        if(validatedInt >= atMax) {
            throw new IllegalArgumentException("Illegal number - Price should be less than " + atMax);
        }

        return validatedInt;

    }
}

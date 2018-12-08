package hmorita.abexercise.validation;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * Check if it is valid date format.
 *  TODO : 1. This validation does not validate precisely if the date coming is "such like 113116".
 *  In this case, "November 32" should be invalid but currently it is regarded as "December 1st".
 *  TODO : 2. Should be consider year when it is earlier than 2000.
 */
public class FieldValidateMDY implements FieldValidate<Integer> {

    private String validatee;

    public FieldValidateMDY(String val) {
        validatee = val;
    }


    public Integer validate() throws IllegalArgumentException {
        return validate(validatee);
    }

    @Override
    public Integer validate(String s) throws IllegalArgumentException {
        int validatedDate = 0;

        // Date should be 6 characters.
        if(s.length() != 6) {
            throw new IllegalArgumentException("MDY Date should be 6 characters");
        }

        // Check if s is valid number
        try {
            validatedDate = Integer.valueOf(s);
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
            throw new IllegalArgumentException("Illegal MDY Date - Date should be number :" + s);
        }

        // Check if it is parsed correctly.
        String mmdd = s.substring(0,4);
        DateFormat df = new SimpleDateFormat("MMdd");
        try {
            Date validDate = df.parse(mmdd);
        } catch (ParseException pe) {
            pe.printStackTrace();
            throw new IllegalArgumentException("Illegal MDY Date ${s} could not parse- :" + mmdd);
        }

        return validatedDate;
    }
}

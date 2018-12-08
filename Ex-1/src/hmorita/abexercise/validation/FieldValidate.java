package hmorita.abexercise.validation;

public interface FieldValidate<T> {
    public T validate(String s) throws IllegalArgumentException;
}

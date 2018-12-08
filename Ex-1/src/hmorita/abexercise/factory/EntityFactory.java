package hmorita.abexercise.factory;

public interface EntityFactory<D, T> {
    public T create(D data) throws IllegalArgumentException;
}

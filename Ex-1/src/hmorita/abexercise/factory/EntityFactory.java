package hmorita.abexercise.factory;

import java.util.List;

public interface EntityFactory<D, T> {
    public T create(D data) throws IllegalArgumentException;
    public T create(String line) throws IllegalArgumentException;
    public List<Integer> skipColumnNumbers();
}

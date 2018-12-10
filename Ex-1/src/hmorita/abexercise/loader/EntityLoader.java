package hmorita.abexercise.loader;

import hmorita.abexercise.entity.Keyable;
import hmorita.abexercise.factory.EntityFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public interface EntityLoader<E extends Keyable, F extends EntityFactory> {

    default boolean isSkipLine(String line) {
        return line == null || line.isEmpty();
    }

    default public ArrayList<E> load(F factory, Path fileToPath) {

        ArrayList<E> entities = new ArrayList<>(10000); // 10,000 is row count of customer.csv
        try {
            Files.readAllLines(fileToPath).forEach(line -> {
                if(!isSkipLine(line)) {
                    E c = (E)factory.create(line); // TODO : Revist to consider type safe.
                    //System.out.println(c.toString());
                    entities.add(c);
                }
            });
        } catch (IllegalArgumentException iae) {
            iae.printStackTrace();
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }

        return entities;
    }

}

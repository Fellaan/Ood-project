package g1.application;

import java.io.IOException;
import java.util.List;


public interface Repository <T>  {

    void save() throws IOException;

    public void loadFromFile() throws IOException, ClassNotFoundException;

    T findByName(String name);

    void add(T t);

    List<T> findAll();
}
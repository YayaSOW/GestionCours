package core;

import java.util.List;

public interface Service<T> {
    boolean add(T objet);
    List<T> show();
    T getBy(String critere);
}

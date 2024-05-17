package views;

import java.util.List;

public interface View<T> {
    T saisi();
    void affiche(List<T> objet);
}

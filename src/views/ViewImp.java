package views;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class ViewImp<T> implements View<T> {
    protected Scanner scanner;

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public T saisi() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saisi'");
    }

    @Override
    public void affiche(List<T> objet) {
        for (T obj : objet) {
            System.out.println(obj);
        }
    }

    public static LocalDate formatDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return LocalDate.parse(date, formatter);
    }

    public static LocalTime formatHeure(String heure) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return LocalTime.parse(heure, formatter);
    }

}

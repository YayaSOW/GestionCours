package services;

import java.util.ArrayList;
import java.util.List;

import core.Service;
import entities.Cours;

public class CoursService implements Service<Cours> {
    List <Cours> cours = new ArrayList<>();
    @Override
    public boolean add(Cours cour) {
        return cours.add(cour);
    }
    @Override
    public List<Cours> show() {
        return cours;
    }
    @Override
    public Cours getBy(String critere) {
        for (Cours cour : cours) {
            if (cour.getModule().compareToIgnoreCase(critere)==0) {
                return cour;
            }
        }
        return null;
    }
    
}

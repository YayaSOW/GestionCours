package services;

import java.util.ArrayList;
import java.util.List;

import core.Service;
import entities.Classe;

public class ClasseService implements Service<Classe> {
    List <Classe> classes = new ArrayList<>();
    @Override
    public boolean add(Classe classe) {
        return classes.add(classe) ;
    }
    @Override
    public List<Classe> show() {
        return classes;
    }
    @Override
    public Classe getBy(String critere) {
        for (Classe classe : classes) {
            if (classe.getNomClasse().compareToIgnoreCase(critere)==0) {
                return classe;
            }
        }
        return null;
    }
    
    
}

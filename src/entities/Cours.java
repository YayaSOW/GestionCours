package entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import enums.Statut;

public class Cours {
    private int id;
    private String module;
    private String professeur;
    private Statut statut;
    private static int nbCours;

    //Attribut navigable
    //OneToMany (Cour => Seance)
    private List<Seance> seances = new ArrayList<>();
    //ManyToMany (Cour => Classe)
    private List<Classe> classes = new ArrayList<>();

    public Cours(String module, String professeur, Statut statut) {
        this.id = ++nbCours;
        this.module = module;
        this.professeur = professeur;
        this.statut = statut;
    }
    public Cours() {
        id = ++nbCours;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getModule() {
        return module;
    }
    public void setModule(String module) {
        this.module = module;
    }
    public String getProfesseur() {
        return professeur;
    }
    public void setProfesseur(String professeur) {
        this.professeur = professeur;
    }
    public Statut getStatut() {
        return statut;
    }
    public void setStatut(Statut statut) {
        this.statut = statut;
    }
    public List<Seance> getSeances() {
        return seances;
    }
    public void add(Seance seance) {
        seances.add(seance);
    }
    public List<Classe> getClasses() {
        return classes;
    }
    public void add(Classe classe) {
        this.classes.add(classe);
    }
    @Override
    public String toString() {
        return "Cours [id=" + id + ", module=" + module + ", professeur=" + professeur + ", statut=" + statut
                + ", seances=" + seances + ", classes=" + classes + "]";
    }
}

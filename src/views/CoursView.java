package views;

import entities.Cours;
import enums.Statut;

public class CoursView extends ViewImp<Cours> {

    @Override
    public Cours saisi() {
        String module;
        String professeur;
        Statut statut;
        scanner.nextLine();
        System.out.print("Le Module :");
        module = scanner.nextLine();
        System.out.print("Le Professeur :");
        professeur = scanner.nextLine();
        statut=Statut.Planifier;
        return new Cours(module,professeur,statut);
    }
    
}

package views;

import entities.Classe;
import enums.Filiere;
import enums.Niveau;

public class ClasseView extends ViewImp<Classe> {

    @Override
    public Classe saisi() {
        String nomClasse;
        Filiere filiere;
        Niveau niveau;
        filiere=choixFiliere();
        niveau=choixNiveau();
        nomClasse=String.valueOf(niveau) + String.valueOf(filiere);
        return new Classe(nomClasse,filiere,niveau);
    }

    public Filiere choixFiliere() {
        int choix;
        do {
            System.out.println("1-GLRS");
            System.out.println("2-ETSE");
            System.out.println("3-IAGE");
            System.out.println("4-MAE");
            System.out.println("5-MOSIEF");
            System.out.print("Choix de la Filiere ? : ");
            choix = scanner.nextInt();
        } while (choix < 1 || choix > 5);
        return Filiere.values()[choix - 1];
    }

    public Niveau choixNiveau() {
        int choix;
        do {
            System.out.println("1-L1");
            System.out.println("2-L2");
            System.out.println("3-L3");
            System.out.println("4-M1");
            System.out.println("5-M2");
            System.out.print("Choix du Niveau ? : ");
            choix = scanner.nextInt();
        } while (choix < 1 || choix > 5);
        return Niveau.values()[choix - 1];
    }

}

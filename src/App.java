import java.util.Scanner;

import core.Service;
import entities.Classe;
import entities.Cours;
import entities.Seance;
import enums.Statut;
import services.ClasseService;
import services.CoursService;
import views.ClasseView;
import views.CoursView;

public class App {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        ClasseView classeView = new ClasseView();
        CoursView coursView = new CoursView();
        Service<Classe> classeService = new ClasseService();
        Service<Cours> coursService = new CoursService();

        classeView.setScanner(scanner);
        coursView.setScanner(scanner);
        int choice;
        do {
            choice = menu();
            switch (choice) {
                case 1 -> {
                    Classe classe = classeView.saisi();
                    classeService.add(classe);
                }
                case 2 -> {
                    classeView.affiche(classeService.show());
                }
                case 3 -> {
                    Cours cours = coursView.saisi();
                    String nom;
                    int rep;
                    do {
                        System.out.print("Quel est le Nom de la Classe du Cours?: ");
                        nom = scanner.nextLine();
                        Classe classe = classeService.getBy(nom);
                        if (classe != null) {
                            // Cours => Classe
                            cours.add(classe);
                            // Classe => Cours
                            classe.add(cours);
                            System.out.println("la classe " + classe.getNomClasse() +
                                    " a été ajouter a la liste des cours de " + cours.getModule());
                        } else {
                            System.out.println("Classe inexistant!!!");
                        }
                        rep = result();
                    } while (rep != 2);
                    // Ajout du cours
                    coursService.add(cours);
                }
                case 4 -> {
                    coursView.affiche(coursService.show());
                }
                case 5 -> {
                    scanner.nextLine();
                    String nom;
                    System.out.print("Quel est le Nom de la Classe des Cours?: ");
                    nom = scanner.nextLine();
                    Classe classe = classeService.getBy(nom);
                    if (classe != null) {
                        for (Cours cours : classe.getCours()) {
                            System.out.println(cours);
                        }
                    } else {
                        System.out.println("Classe inexistant!!!");
                    }
                }
                case 6 -> {
                    scanner.nextLine();
                    String module;
                    System.out.print("Quel est le Module du Cours?: ");
                    module = scanner.nextLine();
                    Cours cours = coursService.getBy(module);
                    if (cours != null) {
                        for (Classe classe : cours.getClasses()) {
                            System.out.println(classe);
                        }
                    } else {
                        System.out.println("Cours inexistant!!!");
                    }
                }
                case 7 -> {
                    scanner.nextLine();
                    Seance seance = new Seance();
                    System.out.println("Heure de Debut de la Seance [HH:mm] ?:");
                    seance.setHeureDebut(CoursView.formatHeure(scanner.nextLine()));
                    System.out.println("Heure de Fin de la Seance [HH:mm] ?:");
                    seance.setHeureFin(CoursView.formatHeure(scanner.nextLine()));
                    seance.setStatut(Statut.Planifier);
                    String module;
                    System.out.print("Quel est le Module du Cours?: ");
                    module = scanner.nextLine();
                    Cours cours = coursService.getBy(module);
                    if (cours != null) {
                        // Cours => Seance
                        cours.add(seance);
                        // Seance => Cours
                        seance.setCours(cours);
                    } else {
                        System.out.println("Cours inexistant!!!");
                    }
                }
                case 8 ->{
                    System.out.println();
                }
                default -> {
                }
            }
            System.out.println("----------------------------------");
        } while (choice != 10);
    }

    public static int menu() {
        System.out.println("1-Créer une classe");
        System.out.println("2-Lister les Classe");
        System.out.println("3-Créer un Cours");
        System.out.println("4-Lister Tous les cours");
        System.out.println("5-Lister Tous les cours d’une classe");
        System.out.println("6-Lister La  ou les  classes d’un cours");
        System.out.println("7-Créer une ou des Séance à un cours");
        System.out.println("8-Changer le statut d’une séance de cours");
        System.out.println("9-Lister les séances d’un cours par Statut");
        System.out.println("9-Lister Les séances de cours de la journée");
        System.out.println("10-Les séances de cours d’une classe de la journée");
        System.out.print("Votre choix : ");
        return scanner.nextInt();
    }

    public static int result() {
        int rep;
        do {
            System.out.println("1-Oui");
            System.out.println("2-Non");
            System.out.println("Voulez Ajoutez une autre classe ?: ");
            rep = scanner.nextInt();
        } while (rep != 1 && rep != 2);
        scanner.nextLine();
        return rep;
    }
}

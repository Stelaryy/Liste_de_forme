// Auteur : Ahmed Boukra Bettayeb
// GestionFormes - Menu principal (option B demandée)
// Version: 1.0
// Date : 2025-11-xx

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestionFormes {
    private static final int TAILLE_MAX = 100;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Forme> tableaux = new ArrayList<>();
        int choix = -1;

        while (choix != 0) {
            afficherMenu();
            choix = lireInt(sc);
            switch (choix) {
                case 1: ajouterForme(sc, tableaux, "Rectangle"); break;
                case 2: ajouterForme(sc, tableaux, "Carre"); break;
                case 3: ajouterForme(sc, tableaux, "Ellipse"); break;
                case 4: ajouterForme(sc, tableaux, "Cercle"); break;
                case 5: ajouterForme(sc, tableaux, "Losange"); break;
                case 6: ajouterForme(sc, tableaux, "Triangle"); break;
                case 7: ajouterForme(sc, tableaux, "Hexagone"); break;
                case 8: supprimerForme(sc, tableaux); break;
                case 9: afficherTableau(tableaux); break;
                case 10: afficherCompteurs(tableaux); break;
                case 0: System.out.println("Au revoir."); break;
                default: System.out.println("Choix invalide."); break;
            }
            if (tableaux.size() > TAILLE_MAX) {
                System.out.println("ATTENTION : nb formes > " + TAILLE_MAX + " (dépassement).");
            }
        }
        // libération
        for (Forme f : tableaux) {
            if (f != null) f.detruire();
        }
        sc.close();
    }

    private static void afficherMenu() {
        System.out.println("\n======= MENU DES FORMES =======");
        System.out.println("1 Rectangle");
        System.out.println("2 Carre");
        System.out.println("3 Ellipse");
        System.out.println("4 Cercle");
        System.out.println("5 Losange");
        System.out.println("6 Triangle quelconque");
        System.out.println("7 Hexagone irregulier");
        System.out.println("8 Supprimer une forme (par index)");
        System.out.println("9 Afficher tableau");
        System.out.println("10 Afficher compteurs");
        System.out.println("0 Quitter");
        System.out.print("Votre choix : ");
    }

    private static int lireInt(Scanner sc) {
        while (!sc.hasNextInt()) {
            sc.next(); // skip
            System.out.print("Entrez un entier : ");
        }
        return sc.nextInt();
    }

    private static void ajouterForme(Scanner sc, List<Forme> tab, String type) {
        if (tab.size() >= TAILLE_MAX) {
            System.out.println("Tableau plein, impossible d'ajouter.");
            return;
        }
        Forme f = null;
        try {
            switch (type) {
                case "Rectangle":
                    System.out.print("Longueur = "); double L = sc.nextDouble();
                    System.out.print("Largeur = "); double l = sc.nextDouble();
                    f = new Rectangle(L, l);
                    break;
                case "Carre":
                    System.out.print("Cote = "); double cote = sc.nextDouble();
                    f = new Carre(cote);
                    break;
                case "Ellipse":
                    System.out.print("Grand axe = "); double ga = sc.nextDouble();
                    System.out.print("Petit axe = "); double pa = sc.nextDouble();
                    f = new ellipse(ga, pa);
                    break;
                case "Cercle":
                    System.out.print("Rayon = "); double r = sc.nextDouble();
                    f = new cercle(r);
                    break;
                case "Losange":
                    // Le constructeur de Losange gère la saisie interactive
                    f = new Losange();
                    break;
                case "Triangle":
                    System.out.println("1: 3 cotes  2: 2 cotes + angle");
                    int t = lireInt(sc);
                    if (t == 1) {
                        // constructeur sans argument demande les cotes
                        f = new TriangleQuelconque();
                    } else {
                        System.out.print("a = "); double a = sc.nextDouble();
                        System.out.print("b = "); double b = sc.nextDouble();
                        System.out.print("angle (deg) = "); double ang = sc.nextDouble();
                        // calcul du 3e cote par loi du cosinus
                        double c3 = Math.sqrt(Math.max(0.0, a*a + b*b - 2*a*b*Math.cos(Math.toRadians(ang))));
                        f = new TriangleQuelconque(a, b, c3);
                    }
                    break;
                case "Hexagone":
                    // le constructeur interactif gère la saisie des sommets
                    f = new HexagoneIrregulier();
                    break;
                default:
                    System.out.println("Type inconnu");
            }
        } catch (Exception ex) {
            System.out.println("Erreur lors de la creation/saisie : " + ex.getMessage());
            if (f != null) f.detruire();
            return;
        }
        if (f != null) {
            tab.add(f);
            System.out.printf("Forme ajoutee. Surface=%.3f Perimetre=%.3f\n", f.getSurface(), f.getPerimetre());
        }
    }

    private static void supprimerForme(Scanner sc, List<Forme> tab) {
        if (tab.isEmpty()) { System.out.println("Tableau vide."); return; }
        System.out.print("Indice a supprimer (0.." + (tab.size()-1) + ") : ");
        int idx = lireInt(sc);
        if (idx < 0 || idx >= tab.size()) { System.out.println("Indice invalide."); return; }
        Forme f = tab.get(idx);
        f.detruire(); // décrémente compteurs
        tab.remove(idx);
        System.out.println("Forme supprimee.");
    }

    private static void afficherTableau(List<Forme> tab) {
        System.out.println("\n--- Contenu du tableau ---");
        for (int i=0;i<tab.size();i++){
            Forme f = tab.get(i);
            String type = f.getClass().getSimpleName();
            System.out.printf("%3d : %s | Surface=%.3f | Perimetre=%.3f\n", i, type, f.getSurface(), f.getPerimetre());
        }
        if (tab.isEmpty()) System.out.println("Vide.");
    }

    private static void afficherCompteurs(List<Forme> tab) {
        int rect=0, carre=0, ell=0, cer=0, los=0, tri=0, hex=0;
        for (Forme f : tab) {
            if (f instanceof Carre) carre++;
            else if (f instanceof Rectangle) rect++;
            else if (f instanceof cercle) cer++;
            else if (f instanceof ellipse) ell++;
            else if (f instanceof Losange) los++;
            else if (f instanceof TriangleQuelconque) tri++;
            else if (f instanceof HexagoneIrregulier) hex++;
        }
        System.out.println("=== Compteurs dynamiques (par liste) ===");
        System.out.printf("Rectangles (non carre)=%d, Carres=%d, Ellipses(non cercle)=%d, Cercles=%d, Losanges=%d, Triangles=%d, Hexagones=%d\n",
                rect, carre, ell, cer, los, tri, hex);
        System.out.println("Total formes (global) = " + Forme.getCompteurFormes());
    }
}

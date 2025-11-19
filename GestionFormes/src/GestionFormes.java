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
            if (f != null) f.dispose();
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
                    f = new Rectangle();
                    f.saisirDimension(sc);
                    break;
                case "Carre":
                    f = new Carre();
                    f.saisirDimension(sc);
                    break;
                case "Ellipse":
                    f = new ellipse();
                    f.saisirDimension(sc);
                    break;
                case "Cercle":
                    f = new cercle();
                    f.saisirDimension(sc);
                    break;
                case "Losange":
                    System.out.println("1: via diagonales, 2: via cote+angle, autre: cote+angle");
                    int c = lireInt(sc);
                    f = new Losange();
                    if (c == 1) {
                        System.out.print("d1 = "); double d1 = sc.nextDouble();
                        System.out.print("d2 = "); double d2 = sc.nextDouble();
                        f.saisirDimension(sc, d1, d2);
                    } else {
                        f.saisirDimension(sc);
                    }
                    break;
                case "Triangle":
                    System.out.println("1: 3 cotes  2: 2 cotes + angle");
                    int t = lireInt(sc);
                    if (t == 1) {
                        f = new TriangleQuelconque();
                        f.saisirDimension(sc);
                    } else {
                        System.out.print("a = "); double a = sc.nextDouble();
                        System.out.print("b = "); double b = sc.nextDouble();
                        System.out.print("angle (deg) = "); double ang = sc.nextDouble();
                        f = new TriangleQuelconque();
                        f.saisirDimension(sc, a, b, ang);
                    }
                    break;
                case "Hexagone":
                    f = new HexagoneIrregulier();
                    f.saisirDimension(sc);
                    break;
                default:
                    System.out.println("Type inconnu");
            }
        } catch (Exception ex) {
            System.out.println("Erreur lors de la creation/saisie : " + ex.getMessage());
            if (f != null) f.dispose();
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
        f.dispose(); // décrémente compteurs
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

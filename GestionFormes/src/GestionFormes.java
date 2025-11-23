// Auteur : Ahmed Boukra Bettayeb
// GestionFormes - Menu principal (option B demandée)
// Version: 1.0
// Date : 2025-11-xx

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestionFormes {
    private static final int TAILLE_MAX = 100;
    private static final int TAILLE_PAR_TYPE = 10;
    // Les listes sont gérées par chaque classe (chaque classe possède sa liste statique de taille 10)

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Les listes par type sont gérées statiquement dans chaque classe (instances limitées à 10)
        int choix = -1;

        while (choix != 0) {
            afficherMenu();
            choix = lireInt(sc);
            switch (choix) {
                case 1: ajouterForme(sc, "Rectangle"); break;
                case 2: ajouterForme(sc, "Carre"); break;
                case 3: ajouterForme(sc, "Ellipse"); break;
                case 4: ajouterForme(sc, "Cercle"); break;
                case 5: ajouterForme(sc, "Losange"); break;
                case 6: ajouterForme(sc, "Triangle"); break;
                case 7: ajouterForme(sc, "Hexagone"); break;
                case 8: supprimerForme(sc); break;
                case 9: afficherTableau(); break;
                case 10: afficherCompteurs(); break;
                case 0: System.out.println("Au revoir."); break;
                default: System.out.println("Choix invalide."); break;
            }
            // vérification globale non nécessaire ; contrôle par-type lors de l'ajout
            
        }
        // libération : détruire toutes les formes des listes gérées par les classes
        // Prendre un snapshot puis appeler detruire() — évite ConcurrentModification
            // Pas de destruction explicite ici : les classes gardent leurs instances statiques;
            // le processus se termine et le GC libérera la mémoire. Fermer le scanner.
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

    private static void ajouterForme(Scanner sc, String type) {
        Forme f = null;
        try {
            switch (type) {
                case "Rectangle":
                    if (Rectangle.isFullRect()) { System.out.println("Liste Rectangle pleine (max 10)"); break; }
                    System.out.print("Longueur = "); double L = sc.nextDouble();
                    System.out.print("Largeur = "); double l = sc.nextDouble();
                    f = new Rectangle(L, l);
                    break;
                case "Carre":
                    if (Carre.isFullCarre()) { System.out.println("Liste Carre pleine (max 10)"); break; }
                    System.out.print("Cote = "); double cote = sc.nextDouble();
                    f = new Carre(cote);
                    break;
                case "Ellipse":
                    if (ellipse.isFullEllipse()) { System.out.println("Liste Ellipse pleine (max 10)"); break; }
                    System.out.print("Grand axe = "); double ga = sc.nextDouble();
                    System.out.print("Petit axe = "); double pa = sc.nextDouble();
                    f = new ellipse(ga, pa);
                    break;
                case "Cercle":
                    if (cercle.isFullCercle()) { System.out.println("Liste Cercle pleine (max 10)"); break; }
                    System.out.print("Rayon = "); double r = sc.nextDouble();
                    f = new cercle(r);
                    break;
                case "Losange":
                    if (Losange.isFullLosange()) { System.out.println("Liste Losange pleine (max 10)"); break; }
                    f = new Losange();
                    break;
                case "Triangle":
                    if (TriangleQuelconque.isFullTriangle()) { System.out.println("Liste Triangle pleine (max 10)"); break; }
                    System.out.println("1: 3 cotes  2: 2 cotes + angle");
                    int t = lireInt(sc);
                    if (t == 1) {
                        f = new TriangleQuelconque();
                    } else {
                        System.out.print("a = "); double a = sc.nextDouble();
                        System.out.print("b = "); double b = sc.nextDouble();
                        System.out.print("angle (deg) = "); double ang = sc.nextDouble();
                        double c3 = Math.sqrt(Math.max(0.0, a*a + b*b - 2*a*b*Math.cos(Math.toRadians(ang))));
                        f = new TriangleQuelconque(a, b, c3);
                    }
                    break;
                case "Hexagone":
                    if (HexagoneIrregulier.isFullHexagone()) { System.out.println("Liste Hexagone pleine (max 10)"); break; }
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
            System.out.printf("Forme ajoutee. Surface=%.3f Perimetre=%.3f\n", f.getSurface(), f.getPerimetre());
        }
    }

    private static void supprimerForme(Scanner sc) {
        System.out.println("Quel type supprimer ? (1 Rectangle,2 Carre,3 Ellipse,4 Cercle,5 Losange,6 Triangle,7 Hexagone)");
        int type = lireInt(sc);
        switch (type) {
            case 1:
                if (Rectangle.getRectangles().isEmpty()) { System.out.println("Liste Rectangle vide."); break; }
                System.out.print("Indice Rectangle a supprimer (0.." + (Rectangle.getRectangles().size()-1) + ") : ");
                int ir = lireInt(sc);
                if (ir < 0 || ir >= Rectangle.getRectangles().size()) { System.out.println("Indice invalide."); break; }
                Rectangle rr = Rectangle.removeRectangleAt(ir);
                if (rr != null) rr.detruire();
                System.out.println("Rectangle supprime.");
                break;
            case 2:
                if (Carre.getCarres().isEmpty()) { System.out.println("Liste Carre vide."); break; }
                System.out.print("Indice Carre a supprimer (0.." + (Carre.getCarres().size()-1) + ") : ");
                int ic = lireInt(sc);
                if (ic < 0 || ic >= Carre.getCarres().size()) { System.out.println("Indice invalide."); break; }
                Carre cc = Carre.removeCarreAt(ic);
                if (cc != null) cc.detruire();
                System.out.println("Carre supprime.");
                break;
            case 3:
                if (ellipse.getEllipses().isEmpty()) { System.out.println("Liste Ellipse vide."); break; }
                System.out.print("Indice Ellipse a supprimer (0.." + (ellipse.getEllipses().size()-1) + ") : ");
                int ie = lireInt(sc);
                if (ie < 0 || ie >= ellipse.getEllipses().size()) { System.out.println("Indice invalide."); break; }
                ellipse ee = ellipse.removeEllipseAt(ie);
                if (ee != null) ee.detruire();
                System.out.println("Ellipse supprime.");
                break;
            case 4:
                if (cercle.getCercles().isEmpty()) { System.out.println("Liste Cercle vide."); break; }
                System.out.print("Indice Cercle a supprimer (0.." + (cercle.getCercles().size()-1) + ") : ");
                int icr = lireInt(sc);
                if (icr < 0 || icr >= cercle.getCercles().size()) { System.out.println("Indice invalide."); break; }
                cercle cr = cercle.removeCercleAt(icr);
                if (cr != null) cr.detruire();
                System.out.println("Cercle supprime.");
                break;
            case 5:
                if (Losange.getLosanges().isEmpty()) { System.out.println("Liste Losange vide."); break; }
                System.out.print("Indice Losange a supprimer (0.." + (Losange.getLosanges().size()-1) + ") : ");
                int il = lireInt(sc);
                if (il < 0 || il >= Losange.getLosanges().size()) { System.out.println("Indice invalide."); break; }
                Losange ll = Losange.removeLosangeAt(il);
                if (ll != null) ll.detruire();
                System.out.println("Losange supprime.");
                break;
            case 6:
                if (TriangleQuelconque.getTriangles().isEmpty()) { System.out.println("Liste Triangle vide."); break; }
                System.out.print("Indice Triangle a supprimer (0.." + (TriangleQuelconque.getTriangles().size()-1) + ") : ");
                int it = lireInt(sc);
                if (it < 0 || it >= TriangleQuelconque.getTriangles().size()) { System.out.println("Indice invalide."); break; }
                TriangleQuelconque tt = TriangleQuelconque.removeTriangleAt(it);
                if (tt != null) tt.detruire();
                System.out.println("Triangle supprime.");
                break;
            case 7:
                if (HexagoneIrregulier.getHexagones().isEmpty()) { System.out.println("Liste Hexagone vide."); break; }
                System.out.print("Indice Hexagone a supprimer (0.." + (HexagoneIrregulier.getHexagones().size()-1) + ") : ");
                int ih = lireInt(sc);
                if (ih < 0 || ih >= HexagoneIrregulier.getHexagones().size()) { System.out.println("Indice invalide."); break; }
                HexagoneIrregulier hh = HexagoneIrregulier.removeHexagoneAt(ih);
                if (hh != null) hh.detruire();
                System.out.println("Hexagone supprime.");
                break;
            default:
                System.out.println("Type invalide.");
        }
    }

    private static void afficherTableau() {
        System.out.println("\n--- Contenu des listes par type ---");
        System.out.println("Rectangles :");
        java.util.List<Rectangle> rectangles = Rectangle.getRectangles();
        if (rectangles.isEmpty()) System.out.println("  (vide)");
        for (int i=0;i<rectangles.size();i++) {
            Rectangle r = rectangles.get(i);
            System.out.printf("  %d : Rectangle | Surface=%.3f | Perimetre=%.3f\n", i, r.getSurface(), r.getPerimetre());
        }
        System.out.println("Carres :");
        java.util.List<Carre> carres = Carre.getCarres();
        if (carres.isEmpty()) System.out.println("  (vide)");
        for (int i=0;i<carres.size();i++) {
            Carre c = carres.get(i);
            System.out.printf("  %d : Carre | Surface=%.3f | Perimetre=%.3f\n", i, c.getSurface(), c.getPerimetre());
        }
        System.out.println("Ellipses :");
        java.util.List<ellipse> ellipses = ellipse.getEllipses();
        if (ellipses.isEmpty()) System.out.println("  (vide)");
        for (int i=0;i<ellipses.size();i++) {
            ellipse e = ellipses.get(i);
            System.out.printf("  %d : ellipse | Surface=%.3f | Perimetre=%.3f\n", i, e.getSurface(), e.getPerimetre());
        }
        System.out.println("Cercles :");
        java.util.List<cercle> cercles = cercle.getCercles();
        if (cercles.isEmpty()) System.out.println("  (vide)");
        for (int i=0;i<cercles.size();i++) {
            cercle c = cercles.get(i);
            System.out.printf("  %d : cercle | Surface=%.3f | Perimetre=%.3f\n", i, c.getSurface(), c.getPerimetre());
        }
        System.out.println("Losanges :");
        java.util.List<Losange> losanges = Losange.getLosanges();
        if (losanges.isEmpty()) System.out.println("  (vide)");
        for (int i=0;i<losanges.size();i++) {
            Losange l = losanges.get(i);
            System.out.printf("  %d : Losange | Surface=%.3f | Perimetre=%.3f\n", i, l.getSurface(), l.getPerimetre());
        }
        System.out.println("Triangles :");
        java.util.List<TriangleQuelconque> triangles = TriangleQuelconque.getTriangles();
        if (triangles.isEmpty()) System.out.println("  (vide)");
        for (int i=0;i<triangles.size();i++) {
            TriangleQuelconque t = triangles.get(i);
            System.out.printf("  %d : Triangle | Surface=%.3f | Perimetre=%.3f\n", i, t.getSurface(), t.getPerimetre());
        }
        System.out.println("Hexagones :");
        java.util.List<HexagoneIrregulier> hexagones = HexagoneIrregulier.getHexagones();
        if (hexagones.isEmpty()) System.out.println("  (vide)");
        for (int i=0;i<hexagones.size();i++) {
            HexagoneIrregulier h = hexagones.get(i);
            System.out.printf("  %d : Hexagone | Surface=%.3f | Perimetre=%.3f\n", i, h.getSurface(), h.getPerimetre());
        }
    }

    private static void afficherCompteurs() {
        int rect = Rectangle.getRectangles().size();
        int carre = Carre.getCarres().size();
        int ell = ellipse.getEllipses().size();
        int cer = cercle.getCercles().size();
        int los = Losange.getLosanges().size();
        int tri = TriangleQuelconque.getTriangles().size();
        int hex = HexagoneIrregulier.getHexagones().size();
        System.out.println("=== Compteurs (par listes par type) ===");
        System.out.printf("Rectangles=%d, Carres=%d, Ellipses=%d, Cercles=%d, Losanges=%d, Triangles=%d, Hexagones=%d\n",
                rect, carre, ell, cer, los, tri, hex);
        System.out.println("Total formes (global) = " + Forme.getCompteurFormes());
    }
}

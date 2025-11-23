// Auteur : Ahmed Boukra Bettayeb (adaptation)
// Carre extends Rectangle

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Carre extends Rectangle {
    private static int compteurCarre = 0;
    private double cote;
    private static final int MAX_INSTANCES = 10;
    private static final List<Carre> instances = new ArrayList<>();

    public Carre(double cote) {
        super(cote, cote); // Rectangle constructor handles surface/perim
        this.cote = cote;
        incrementerCompteur();
        // ajouter a la liste de Carre
        if (!addCarre(this)) {
            decrementerCompteur();
            detruireFormeGlobale();
            throw new IllegalStateException("Liste Carre pleine (max=" + MAX_INSTANCES + ")");
        }
        System.out.println("Creation d'un Carre. Compteur Carre : " + compteurCarre +
                           ", total formes : " + Forme.getCompteurFormes());
    }

    public Carre() {
        this(1.0);
    }

    public static void incrementerCompteur() { compteurCarre++; }
    public static void decrementerCompteur() { if (compteurCarre>0) compteurCarre--; }
    public static int getCompteurCarre() { return compteurCarre; }

    // gestion instances
    public static boolean isFullCarre() { return instances.size() >= MAX_INSTANCES; }
    public static boolean addCarre(Carre c) { if (instances.size()>=MAX_INSTANCES) return false; instances.add(c); return true; }
    public static Carre removeCarreAt(int idx) { return instances.remove(idx); }
    public static List<Carre> getCarres() { return instances; }
    public static int getCarreCount() { return instances.size(); }

    @Override
    public void saisirDimensions() {
        Scanner sc = new Scanner(System.in);
        double c;
        do {
            System.out.print("Entrez le cote du carre (>0) : ");
            c = sc.nextDouble();
        } while (c <= 0);
        this.cote = c;
        setLongueur(c);
        setLargeur(c);
    }

    @Override
    public void saisirDimensions(double a) {
        this.cote = a;
        setLongueur(a);
        setLargeur(a);
    }

    // override optional signatures because Forme declares them
    @Override
    public void saisirDimensions(double a, double b) {
        // ignored, use a only
        saisirDimensions(a);
    }

    @Override
    public void saisirDimensions(double a, double b, double c) {
        // unused
    }

    public void detruire() {
        decrementerCompteur();
        detruireFormeGlobale();
        System.out.println("Suppression d'un Carre. Restants Carre : " + compteurCarre +
                           ", total formes : " + Forme.getCompteurFormes());
    }
}

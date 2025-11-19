// Auteur : Ahmed Boukra Bettayeb (adaptation)
// Carre extends Rectangle

import java.util.Scanner;

public class Carre extends Rectangle {
    private static int compteurCarre = 0;
    private double cote;

    public Carre(double cote) {
        super(cote, cote); // Rectangle constructor handles surface/perim
        this.cote = cote;
        incrementerCompteur();
        System.out.println("Creation d'un Carre. Compteur Carre : " + compteurCarre +
                           ", total formes : " + Forme.getCompteurFormes());
    }

    public Carre() {
        this(1.0);
    }

    public static void incrementerCompteur() { compteurCarre++; }
    public static void decrementerCompteur() { if (compteurCarre>0) compteurCarre--; }
    public static int getCompteurCarre() { return compteurCarre; }

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

// Auteur : Ahmed Boukra Bettayeb (adaptation)

import java.util.Scanner;

public class TriangleQuelconque extends Forme {
    private static int compteur = 0;

    private double a, b, c;
    private double surface, perimetre;

    public TriangleQuelconque(double a, double b, double c) {
        super();
        if (!estValide(a,b,c)) throw new IllegalArgumentException("Cotes invalides");
        this.a = a; this.b = b; this.c = c;
        incrementerCompteur();
        calculer();
        System.out.println("Creation d'un Triangle. Compteur Triangle : " + compteur +
                           ", total formes : " + Forme.getCompteurFormes());
    }

    public TriangleQuelconque() { // saisie interactive
        super();
        saisirDimensions();
        incrementerCompteur();
        calculer();
        System.out.println("Creation d'un Triangle. Compteur Triangle : " + compteur +
                           ", total formes : " + Forme.getCompteurFormes());
    }

    public static void incrementerCompteur() { compteur++; }
    public static void decrementerCompteur() { if (compteur>0) compteur--; }

    private void calculer() {
        perimetre = a + b + c;
        double p = perimetre / 2.0;
        surface = Math.sqrt(Math.max(0.0, p * (p-a) * (p-b) * (p-c)));
    }

    private boolean estValide(double A, double B, double C) {
        return (A>0 && B>0 && C>0 && A+B>C && A+C>B && B+C>A);
    }

    @Override
    public void saisirDimensions() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Entrez cote a : "); a = sc.nextDouble();
        System.out.print("Entrez cote b : "); b = sc.nextDouble();
        System.out.print("Entrez cote c : "); c = sc.nextDouble();
        if (!estValide(a,b,c)) throw new IllegalArgumentException("Triagle invalide");
        calculer();
    }

    @Override
    public void saisirDimensions(double _a, double _b, double _c) {
        if (!estValide(_a,_b,_c)) throw new IllegalArgumentException("Triangle invalide");
        this.a = _a; this.b = _b; this.c = _c;
        calculer();
    }

    @Override
    public double getSurface() { return surface; }

    @Override
    public double getPerimetre() { return perimetre; }

    public void detruire() {
        decrementerCompteur();
        detruireFormeGlobale();
        System.out.println("Suppression d'un Triangle. Restants Triangle : " + compteur +
                           ", total formes : " + Forme.getCompteurFormes());
    }
}

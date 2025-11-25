// Auteur : Ahmed Boukra Bettayeb
// Class TriangleQuelconque
// date : 2025-11-25

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TriangleQuelconque extends Forme {
    private static int compteur = 0;

    private static final int MAX_INSTANCES = 10;
    private static final List<TriangleQuelconque> instances = new ArrayList<>();

    private double a, b, c;
    private double surface, perimetre;

    public TriangleQuelconque(double a, double b, double c) {
        super();
        if (!estValide(a,b,c)) throw new IllegalArgumentException("Cotes invalides");
        this.a = a; this.b = b; this.c = c;
        incrementerCompteur();
        if (!addTriangle(this)) {
            decrementerCompteur();
            detruireFormeGlobale();
            throw new IllegalStateException("Liste Triangle pleine (max=" + MAX_INSTANCES + ")");
        }
        calculer();
        System.out.println("Creation d'un Triangle. Compteur Triangle : " + compteur +
                           ", total formes : " + Forme.getCompteurFormes());
    }

    public TriangleQuelconque() { // saisie interactive
        super();
        saisirDimensions();
        incrementerCompteur();
        if (!addTriangle(this)) {
            decrementerCompteur();
            detruireFormeGlobale();
            throw new IllegalStateException("Liste Triangle pleine (max=" + MAX_INSTANCES + ")");
        }
        calculer();
        System.out.println("Creation d'un Triangle. Compteur Triangle : " + compteur +
                           ", total formes : " + Forme.getCompteurFormes());
    }

    public static void incrementerCompteur() { compteur++; }
    public static void decrementerCompteur() { if (compteur>0) compteur--; }

    // gestion instances
    public static boolean isFullTriangle() { return instances.size() >= MAX_INSTANCES; }
    public static boolean addTriangle(TriangleQuelconque t) { if (instances.size()>=MAX_INSTANCES) return false; instances.add(t); return true; }
    public static TriangleQuelconque removeTriangleAt(int idx) { return instances.remove(idx); }
    public static List<TriangleQuelconque> getTriangles() { return instances; }
    public static int getTriangleCount() { return instances.size(); }

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

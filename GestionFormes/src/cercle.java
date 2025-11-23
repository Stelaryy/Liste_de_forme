// Auteur : Ahmed Boukra Bettayeb (adaptation)

public class cercle extends ellipse {
    private static int compteurCercle = 0;
    private double rayon;

    public cercle(double rayon) {
        super(rayon, rayon); // appelle Forme constructor; ellipse compteur suppressed for subclasses
        this.rayon = rayon;
        // incrémente compteur propre au cercle
        compteurCercle++;
        System.out.println("Creation d'un Cercle. Compteur Cercle : " + compteurCercle + ", total formes : " + Forme.getCompteurFormes());
    }

    public cercle() { this(1.0); }

    public static void decrementerCompteur() { if (compteurCercle>0) compteurCercle--; }

    @Override
    public double getSurface() {
        return Math.PI * rayon * rayon;
    }

    @Override
    public double getPerimetre() {
        return 2 * Math.PI * rayon;
    }

    @Override
    public void detruire() {
        decrementerCompteur();
        detruireFormeGlobale();
        System.out.println("Suppression d'un Cercle. Restants Cercle : " + compteurCercle + ", total formes : " + Forme.getCompteurFormes());
    }
}

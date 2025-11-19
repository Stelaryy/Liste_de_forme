// Auteur : Ahmed Boukra Bettayeb (adaptation)

public class cercle extends ellipse {
    private double rayon;

    public cercle(double rayon) {
        super(rayon, rayon); // Ellipse constructor will increment global and ellipse compteur
        this.rayon = rayon;
        System.out.println("Creation d'un Cercle, rayon = " + rayon);
    }

    public cercle() { this(1.0); }

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
        // Ellipse::decrementerCompteur doit déjà décrementer ellipse compteur.
        // On appelera Ellipse.decrementerCompteur + forme global decrement
        ellipse.decrementerCompteur();
        detruireFormeGlobale();
        System.out.println("Suppression d'un Cercle. total formes : " + Forme.getCompteurFormes());
    }
}

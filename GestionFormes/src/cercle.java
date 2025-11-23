// Auteur : Ahmed Boukra Bettayeb (adaptation)

public class cercle extends ellipse {
    private static int compteurCercle = 0;
    private double rayon;

    private static final int MAX_INSTANCES = 10;
    private static final java.util.List<cercle> instances = new java.util.ArrayList<>();

    public cercle(double rayon) {
        super(rayon, rayon); // appelle Forme constructor; ellipse compteur suppressed for subclasses
        this.rayon = rayon;
        // incrémente compteur propre au cercle
        compteurCercle++;
        if (!addCercle(this)) {
            decrementerCompteur();
            detruireFormeGlobale();
            throw new IllegalStateException("Liste Cercle pleine (max=" + MAX_INSTANCES + ")");
        }
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
        // retirer de la liste si présent
        instances.remove(this);
        System.out.println("Suppression d'un Cercle. Restants Cercle : " + compteurCercle + ", total formes : " + Forme.getCompteurFormes());
    }

    // gestion instances
    public static boolean isFullCercle() { return instances.size() >= MAX_INSTANCES; }
    public static boolean addCercle(cercle c) { if (instances.size()>=MAX_INSTANCES) return false; instances.add(c); return true; }
    public static cercle removeCercleAt(int idx) { return instances.remove(idx); }
    public static java.util.List<cercle> getCercles() { return instances; }
    public static int getCercleCount() { return instances.size(); }
}

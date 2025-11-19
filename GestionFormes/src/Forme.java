// Auteur : Ahmed Boukra Bettayeb (adaptation)
// Version : 1.0
// Date : 2025-11-18
// Classe abstraite Forme : compteur global + contrat pour les formes

public abstract class Forme {
    // compteur global de toutes les formes
    protected static int compteurFormes = 0;

    protected Forme() {
        incrementerFormes();
    }

    protected static void incrementerFormes() {
        compteurFormes++;
    }

    protected static void decrementerFormes() {
        if (compteurFormes > 0) compteurFormes--;
    }

    // Methode appelee lorsque l utilisateur supprime explicitement la forme
    // Chaque sous-classe DOIT appeler super.detruireFormeGlobale() pour decrementer
    public void detruireFormeGlobale() {
        decrementerFormes();
    }

    public static int getCompteurFormes() {
        return compteurFormes;
    }

    // Contrat que doivent implementer les formes concretes
    public abstract double getSurface();
    public abstract double getPerimetre();

    // methode optionnelle de saisie ; les classes concretes proposeront
    public abstract void saisirDimensions();              // saisie interactive
    public void saisirDimensions(double a) { /* optional */ }
    public void saisirDimensions(double a, double b) { /* optional */ }
    public void saisirDimensions(double a, double b, double c) { /* optional */ }

    // Retourne le nom de la classe (pour affichage)
    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}


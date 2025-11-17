
public class cercle {
	//proprieter de mon constructeur
    private double rayon;

    //proprieter de mon compteur
    private static int compteur = 0;
    
    //Constructeur
    public cercle(double rayon) {
        if (rayon > 0) {
            this.rayon = rayon;
        } else {
            throw new IllegalArgumentException("Le rayon doit être positif.");
        }
        
        compteur++;
        System.out.println("Creation dun objet de type Cercle.");
        System.out.println("valeur du rayon = " + this.rayon);
        System.out.println("Nombre de Cercle en memoire =  " + compteur);
    }
    
    //destructeur 
    public static void decrementerCompteur() {
    	if(compteur > 0) compteur--;
    	System.out.println("Cercle supprimer");
    	System.out.println("Nombre de Cercle apres suppression = " + compteur);
    }
    //Getter
    public double getRayon() {
        return rayon;
    }

    //Surface
    public double getSurface() {
        return Math.PI * rayon * rayon;  // πr²
    }

    //Périmètre
    public double getPerimetre() {
        return 2 * Math.PI * rayon;  // 2πr
    }
}

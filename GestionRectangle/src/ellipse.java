public class ellipse {
    private double a; //semi-grand axe
    private double b; //semi-petit axe

    private static int compteur = 0;
    //Constructeur
    public ellipse(double a, double b) {
        if (a > 0 && b > 0) {
            this.a = a;
            this.b = b;
        } else {
            throw new IllegalArgumentException("Les axes doivent être positifs.");
        }
        compteur++;
        System.out.println("Creation dun objet de type Ellipse");
        System.out.println("valeur du grand axe a = " + this.a);
        System.out.println("valeur du petit axe b = " + this.b);
        System.out.println("Nombre dEllipse en memoire : " + compteur);
    }

    //destructeur
    public static void decrementerCompteur() {
    	if(compteur > 0) compteur--;
    	System.out.println("Ellipse supprimer");
    	System.out.println("Nombre dEllipse en memoire apres suppression = " + compteur);
    }
    //Getters
    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    //Surface
    public double getSurface() {
        return Math.PI * a * b;
    }

    //Périmètre 
    public double getPerimetre() {
        return Math.PI * (3 * (a + b) - Math.sqrt((3 * a + b) * (a + 3 * b)));
    }
}

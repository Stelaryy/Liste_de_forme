public class TriangleQuelconque {
    private double a, b, c; // les trois côtés
    
    private static int compteur = 0;

    //Constructeur a 3 côtés
    public TriangleQuelconque(double a, double b, double c) {
        if (estValide(a, b, c)) {
            this.a = a;
            this.b = b;
            this.c = c;
        } else {
            throw new IllegalArgumentException("Les côtés ne forment pas un triangle valide !");
        }
        compteur++;
		System.out.println("Creation dun objet de type Triangle");
		System.out.println("valeur du cote A = " + this.a);
		System.out.println("valeur du cote b = " + this.b);
		System.out.println("valeur du cote c = " + this.c);
		System.out.println("Nombre dobjet de type Triangle en memoire : " + compteur);
    }

    // deuxieme constructeur a 2 côtés + angle (en degrés)
    public void TriangleQuelconque1(double a, double b, double angleDegres) {
        if (a <= 0 || b <= 0 || angleDegres <= 0 || angleDegres >= 180) {
            throw new IllegalArgumentException("Paramètres invalides pour construire le triangle !");
        }
        double angleRad = Math.toRadians(angleDegres);
        // Formule du cosinus : c² = a² + b² - 2ab cos(γ)
        double c = Math.sqrt(a*a + b*b - 2*a*b*Math.cos(angleRad));
        if (estValide(a, b, c)) {
            this.a = a;
            this.b = b;
            this.c = c;
        } else {
            throw new IllegalArgumentException("Impossible de former un triangle avec ces valeurs !");
        }
        compteur++;
		System.out.println("Creation dun objet de type Triangle");
		System.out.println("valeur du cote A = " + this.a);
		System.out.println("valeur du cote b = " + this.b);
		System.out.println("valeur de langle = " + this.c);
		System.out.println("Nombre dobjet de type Triangle en memoire : " + compteur);
    }

    // Vérification validité triangle
    private boolean estValide(double a, double b, double c) {
        return (a > 0 && b > 0 && c > 0 &&
                a + b > c &&
                a + c > b &&
                b + c > a);
    }
  //destructeur 
  	public static void decrementerCompteur() {
  		if(compteur > 0) compteur--;
  		System.out.println("triangle supprime !");
  		System.out.println("Nombre dobjet de type triangle restant : " + compteur);
  	}

    // Périmètre
    public double getPerimetre() {
        return a + b + c;
    }

    // Surface
    public double getSurface() {
        double p = getPerimetre() / 2.0; 
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    // Getters
    public double getA() { return a; }
    public double getB() { return b; }
    public double getC() { return c; }
}


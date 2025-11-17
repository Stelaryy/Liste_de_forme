import clavier.In;

public class Losange {
    private double d1;
    private double d2;
    private double cote;
    private double angle; // en radians
    
    private static int compteur = 0;

    //saisie des diagonales
    public Losange(boolean fromDiagonales) {
        if (fromDiagonales) {
            do {
                System.out.print("Entrer la première diagonale (d1 > 0) : ");
                d1 = In.readDouble();
                if (d1 <= 0) System.out.println("Valeur invalide !");
            } while (d1 <= 0);

            do {
                System.out.print("Entrer la deuxième diagonale (d2 > 0) : ");
                d2 = In.readDouble();
                if (d2 <= 0) System.out.println("Valeur invalide !");
            } while (d2 <= 0);

            //calcul du côté avec Pythagore
            cote = Math.sqrt(Math.pow(d1 / 2, 2) + Math.pow(d2 / 2, 2));
            //angle entre les côtés 
            angle = 2 * Math.atan(d1 / d2);
        }
        compteur++;
		System.out.println("Creation dun objet de type Losange");
		System.out.println("valeur de la diagonale 1 = " + this.d1);
		System.out.println("valeur de la diagonale 2 = " + this.d2);
		System.out.println("Nombre dobjet de type Losange en memoire : " + compteur);
    }

    //saisie côté + angle
    public Losange() {
        do {
            System.out.print("Entrer la longueur du côté (c > 0) : ");
            cote = In.readDouble();
            if (cote <= 0) System.out.println("Valeur invalide !");
        } while (cote <= 0);

        double angleDeg;
        do {
            System.out.print("Entrer l’angle en degrés (entre 0 et 180) : ");
            angleDeg = In.readDouble();
            if (angleDeg <= 0 || angleDeg >= 180) {
                System.out.println("Valeur invalide !");
            }
        } while (angleDeg <= 0 || angleDeg >= 180);

        angle = Math.toRadians(angleDeg);

        // diagonales à partir du côté et de l’angle
        d1 = 2 * cote * Math.sin(angle / 2);
        d2 = 2 * cote * Math.cos(angle / 2);
        
        compteur++;
		System.out.println("Creation dun objet de type Losange");
		System.out.println("valeur du cote = " + this.cote);
		System.out.println("valeur de langle = " + this.angle);
		System.out.println("Nombre dobjet de type Losange en memoire : " + compteur);
    }
    //destructeur 
  	public static void decrementerCompteur() {
  		if(compteur > 0) compteur--;
  		System.out.println("Losange supprime !");
  		System.out.println("Nombre dobjet de type Losange restant : " + compteur);
  	}
    //Périmètre
    public double perimetre() {
        return 4 * cote;
    }

    //Surface via diagonales
    public double surfaceParDiagonales() {
        return (d1 * d2) / 2;
    }

    //Surface via côté + angle
    public double surfaceParCoteEtAngle() {
        return cote * cote * Math.sin(angle);
    }

    //Getters
    public double getCote() { return cote; }
    public double getD1() { return d1; }
    public double getD2() { return d2; }
    public double getAngleDeg() { return Math.toDegrees(angle); }
}

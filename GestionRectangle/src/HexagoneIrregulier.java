public class HexagoneIrregulier {
    private double[][] sommets; //tableau [][] pour stocker les coordonnées (x,y)
    
    //proprieter du compteur
    public static int compteur = 0;

    //Constructeur prend un tableau de 6 sommets
    public HexagoneIrregulier(double[][] sommets) {
        if (sommets.length != 6) {
            throw new IllegalArgumentException("Un hexagone doit avoir exactement 6 sommets !");
        }
        this.sommets = sommets;
        compteur++;
        System.out.println("Creation dun objet de type Hexagone");
		System.out.println("valeur des sommets = " + this.sommets);
		System.out.println("Nombre dobjet de type hexagone en memoire : " + compteur);
    }
    //destructeur
    public static void decrementerCompteur() {
    	if(compteur > 0) compteur--;
    	System.out.println("hexagone supprime !");
		System.out.println("Nombre dobjet de type hexagone restant : " + compteur);
    }

    //Calcul du périmètre
    public double getPerimetre() {
        double perimetre = 0;
        for (int i = 0; i < 6; i++) {
            int j = (i + 1) % 6; // sommet suivant (le dernier revient au premier)
            double dx = sommets[j][0] - sommets[i][0];
            double dy = sommets[j][1] - sommets[i][1];
            perimetre += Math.sqrt(dx*dx + dy*dy);
        }
        return perimetre;
    }

    //Calcul de la surface 
    public double getSurface() {
        double somme = 0;
        for (int i = 0; i < 6; i++) {
            int j = (i + 1) % 6;
            somme += (sommets[i][0] * sommets[j][1]) - (sommets[j][0] * sommets[i][1]);
        }
        return Math.abs(somme) / 2.0;
    }
}

import clavier.In;

public class Rectangle {

	//Propriétés
	private double longueur;
	private double largeur;
	
	private static int compteur = 0;
		
	// Constructeur
	public Rectangle(double Long, double Large)
	{
		if(Long > 0 && Large > 0) {
			this.longueur = Long;
			this.largeur = Large;
		}else {
			System.out.println("valeur invalide, veuiller rentrer des valeur valide");
			this.longueur = 1;
			this.largeur = 1;
			
		}
		compteur++;
		System.out.println("Creation dun objet de type Rectangle");
		System.out.println("valeur de la Longueur = " + this.longueur);
		System.out.println("valeur de la Largeur = " + this.largeur);
		System.out.println("Nombre dobjet de type Rectangle en memoire : " + compteur);
	}
	//destructeur 
		public static void decrementerCompteur() {
			if(compteur > 0) compteur--;
			System.out.println("rectangle supprime !");
			System.out.println("Nombre dobjet de type Rectangle restant : " + compteur);
		}
	//Calcule du perimetre
	public double calculPerimetre() {
	    return 2 * (longueur + largeur);
	}
	//Calcul de la surface
    public double calculSurface() {
        return longueur * largeur;
    }
	//Methodes....
		public void setLargeur() {
        double temp;
        do {
            System.out.print("Entrez la largeur (>0) : ");
            temp = In.readDouble(); // saisie au clavier
        } while (temp <= 0);
        largeur = temp;
    }

	public double getLargeur(){
			//retourne la longueur
	        return largeur;
	    }

	public void setLongueur() {
	        double temp;
	        do {
	            System.out.print("Entrez la longueur (>0) : ");
	            temp = In.readDouble(); // saisie au clavier
	        } while (temp <= 0);
	        longueur = temp;
	   }
	
	public double getLongueur()
	{
		//retour de la longueur
		return longueur;
	}

	/*public double //Methode Calcul du perimetre
	{
		// Calcul du perimetre

		//Retour du perimetre
	}

	public double //Methode calcul de la surface
	{
		//Calcul de la surface

		//Retour de la surface
	}*/


}

import clavier.In;


public class Carre {
	
	//proprieter du cote pour le carre
	private double cote;
	//prorpieter du compteur
	private static int compteur = 0;
	
	//methode 
		public void setcote() {
			double temp;
			do {
				System.out.println("Entrez la valeur du cote de votre carrer : ");
				temp = In.readDouble();
			}while(temp <= 0);
			cote = temp;
		}

	//constructeur du carrer
	public Carre(double Cote) {
		
		if(cote > 0) {
			this.cote = Cote;
		}else {
			System.out.println("valeur invalide, veuiller entrer une valeur correcte");
			this.cote = Cote;
		}
		
		compteur++;
		System.out.println("Creation dun objet de type Carrer");
		System.out.println("valeur du cote = " + this.cote);
		System.out.println("Nombre dobjet de type carrer en memoire : " + compteur);
	}
	
	//destructeur 
	public static void decrementerCompteur() {
		if(compteur > 0) compteur--;
		System.out.println("Carrer supprime !");
		System.out.println("Nombre dobjet de type Carrer restant : " + compteur);
	}
	//calcul du perimetre 
	public double perimetre() {
		return 4 * cote;
	}
	
	//calcul de la surface
	public double surface() {
		return cote * cote;
	}
	
	public double getcote() {
		return cote;
	}
}

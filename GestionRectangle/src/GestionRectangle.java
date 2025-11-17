// Auteur : Ahmed Boukra Bettayeb
//version : 1.0
//date : 30/09/2025
//TP programmation objet BTS SN

import clavier.In;

public class GestionRectangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Rectangle MonRectangle; // Declaration de la variable MonRectangle
		MonRectangle = new Rectangle(0,0); //Initialisation instantiation du rectangle
		double Longueur = 0;
		double Largeur = 0;
		
		int choix;

		do {
            // --- Menu ---
            System.out.println("\n================ MENU RECTANGLE ================");
            System.out.println("1 - Saisir la longueur");
            System.out.println("2 - Saisir la largeur");
            System.out.println("3 - Afficher les dimensions");
            System.out.println("4 - Calculer et afficher le périmètre");
            System.out.println("5 - Calculer et afficher la surface");
            System.out.println("6 - Supprimer le rectangle");
            System.out.println("0 - Quitter le menu");
            System.out.print("Votre choix : ");
            choix = In.readInteger();

            switch (choix) {
                case 1:
                    MonRectangle.setLongueur();
                    break;
                case 2:
                    MonRectangle.setLargeur();
                    break;
                case 3:
                    System.out.println("Longueur : " + MonRectangle.getLongueur());
                    System.out.println("Largeur  : " + MonRectangle.getLargeur());
                    break;
                case 4:
                    System.out.println("Périmètre = " + MonRectangle.calculPerimetre());
                    break;
                case 5:
                    System.out.println("Surface = " + MonRectangle.calculSurface());
                    break;
                case 6:
                	if (MonRectangle != null) {
    	            	Rectangle.decrementerCompteur();
    	            	MonRectangle = null;
    	            }else {
    	            	System.out.println("Aucun Rectangle a supprimer");
    	            }
    	            break;
                case 0:
                    System.out.println("Fin du programme. Au revoir !");
                    break;
                default:
                    System.out.println("Choix invalide !");
            }

        } while (choix != 0);  // Sortie quand on tape 0

    }

}

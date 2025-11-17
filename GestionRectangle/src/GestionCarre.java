// Auteur : Ahmed Boukra Bettayeb
//version : 1.0
//date : 30/09/2025
//TP programmation objet BTS SN

import clavier.In;

public class GestionCarre {
	
	//declaration de mon carrer
	private static Carre MonCarre;
	//declaration de mon losange 
	private static Losange MonLosange = null;
	//declaration de mon cercle 
	private static cercle MonCercle = null;
	//declaration de mon Ellipse
	private static ellipse MonEllipse = null;
	//declaration de mon Ellipse
	private static TriangleQuelconque MonTriangleQuelconque = null;
	//declaration de mon HexagoneIrregulier
	private static HexagoneIrregulier MonHexagoneIrregulier = null;
	
	
	public static void main(String[] args) {
		
		int choix;
		
		do {
			//menu
			System.out.println("\n================ MENU FORME ================");
			System.out.println("1 - Faire un Carrer : ");
			System.out.println("2 - Faire un Lossange");
			System.out.println("3 - Faire un Cercle");
			System.out.println("4 - Faire une Ellipse");
			System.out.println("5 - Faire un Triangle quelconque");
			System.out.println("6 - Faire un Hexagone irregulier");
			System.out.println("7 - Quitter le menu");
			System.out.println("Votre choix : ");
			choix = In.readInteger();
			
			switch (choix) {
				case 1: 
					FaireUnCarre();
					break;
				case 2: 
					FaireUnLosange();
					break;
				case 3:
					FaireUnCercle();
					break;
				case 4:
					FaireUnEllipse();
					break;
				case 5:
					FaireUnTriangleQuelconque();
					break;
				case 6:
					FaireUnHexagoneIrregulier();
					break;
				case 7:
					System.out.println("a bientot dans la Fabrique a forme de Ahmed !!!!!!");
					break;
				default:
					System.out.println("choix invalide !");
			}
		}while(choix != 7); // on sort du programme quand on tape 7
		
		
	}
	public static void FaireUnCarre() {
		
		int choix;
		do {
		//menu
		System.out.println("\n================ MENU CARRER ================");
		System.out.println("1 - Definir un Cote :  ");
		System.out.println("2 - Calculer le perimetre : ");
		System.out.println("3 - calculer la surface : ");
		System.out.println("4 - afficher la dimension du cote : ");
		System.out.println("5 - Supprimer le Carrer");
		System.out.println("6 - Quitter le menu");
		System.out.println("Votre choix : ");
		choix = In.readInteger();
		
		switch (choix) {
	        case 1:
	        	MonCarre = new Carre(0);
	            MonCarre.setcote();
	            break;
	        case 2:
	            MonCarre.perimetre();
	            System.out.println("Le perimetre du carre est : " + MonCarre.perimetre());
	            break;
	        case 3:
	            MonCarre.surface();
	            System.out.println("La surface du carre est : " + MonCarre.surface());
	            break;
	        case 4:
	            System.out.println("La longueur du cote est : " + MonCarre.getcote());
	            break;
	        case 5:
	            if (MonCarre != null) {
	            	Carre.decrementerCompteur();
	            	MonCarre = null;
	            }else {
	            	System.out.println("Aucun carre a supprimer");
	            }
	            break;
	        case 6:
	        	System.out.println("Fin du Programme a la prochaine chez la fabrique a carrer de Ahmed !!!! ");
	        	break;
	        default:
	            System.out.println("Choix invalide !");
			}
		}while(choix != 6); // sort de la categorie quand on tape 6
	}
	
	public static void FaireUnLosange() {
		
		int choix;
		do {
		//menu
			System.out.println("\n================ MENU LOSANGE ================");
			System.out.println("1 - Definir un Losange par les Diagonales :  ");
			System.out.println("2 - Definir un losange par un cote + angle :  ");
			System.out.println("3 - afficher la dimension du cote : ");
			System.out.println("4 - afficher la dimension des diagonales : ");
			System.out.println("5 - Calculer le perimetre : ");
			System.out.println("6 - calculer la surface par diagonale : ");
			System.out.println("7 - calculer la surface par le cote ainsi que l'angle : ");
			System.out.println("8 - Supprimer le losange");
			System.out.println("9 - Quitter le menu");
			System.out.println("Votre choix : ");
			choix = In.readInteger();
		
		switch (choix) {
	        case 1:
	            MonLosange = new Losange(true);
	            break;
	        case 2:
	            MonLosange = new Losange();
	            break;
	        case 3:
	            if(MonLosange != null) {
	            	System.out.println("la longueur du cote est : " + MonLosange.getCote());
	            	System.out.println("La valeur de l'angle et de : " + MonLosange.getAngleDeg());
	            }else {
	            	System.out.println("aucun Losange na etait créer !!! ");
	            }
	            break;
	        case 4:
	            if(MonLosange != null) {
	            	System.out.println("La longueur de la diagonal D1 est : " + MonLosange.getD1());
	            	System.out.println("La longueur de la diagonal D2 est : " + MonLosange.getD2());
	            }else {
	            	System.out.println("aucun Losange na etait créer !!! ");
	            }
	            break;
	        case 5:
	            if(MonLosange != null) {
	            	System.out.println("Le perimetre de votre Losange est : " + MonLosange.perimetre());
	            }else {
	            	System.out.println("aucun losange na etait créer !!! ");
	            }
	            break;
	        case 6:
	        	if(MonLosange != null) {
	        		System.out.println("La surface de votre losange avec les diagonal est : " + MonLosange.surfaceParDiagonales());
	        	}else {
	        		System.out.println("aucun Losange na etait créer !!! ");
	        	}
	        	break;
	        case 7 : 
	        	if(MonLosange != null) {
	        		System.out.println("La surface de votre rectangle avec les cotés et l'angle est : " + MonLosange.surfaceParCoteEtAngle());
	        	}else {
	        		System.out.println("aucun losange na etait créer !!! ");
	        	}
	        	break;
	        case 8:
	        	if (MonLosange != null) {
	            	Losange.decrementerCompteur();
	            	MonLosange = null;
	            }else {
	            	System.out.println("Aucun Losange a supprimer");
	            }
	            break;
	        	
	        case 9 :
	        	System.out.println("a bientot dans la fabrique a Losange de Ahmed !!!!!!");
	        	break;
	        default:
	            System.out.println("Choix invalide !");
			}
		}while(choix <= 9); // sort de la categorie quand on tape 9
	}
	public static void FaireUnCercle() {
		
		int choix;
		do {
		//menu
			System.out.println("\n================ MENU CERCLE ================");
			System.out.println("1 - Créer un cercle :  ");
			System.out.println("2 - Calculer la surface :  ");
			System.out.println("3 - Calculer le périmètre : ");
			System.out.println("4 - Supprimer le cercle ");
			System.out.println("5 - Quitter le menu : ");
			System.out.println("Votre choix : ");
			choix = In.readInteger();
			
			switch (choix) {
	        case 1:
	        	System.out.print("Entrez le rayon du cercle : ");
                double rayon = In.readInteger();
                try {
                    MonCercle = new cercle(rayon);
                    System.out.println("Cercle créé avec succès !");
                } catch (IllegalArgumentException e) {
                    System.out.println("Erreur : " + e.getMessage());
                }
                break;
	        case 2:
	        	 if (MonCercle != null) {
                     System.out.println("Surface = " + MonCercle.getSurface());
                 } else {
                     System.out.println("Veuillez d'abord créer un cercle.");
                 }
                 break;
	        case 3:
	        	if (MonCercle != null) {
                    System.out.println("Périmètre = " + MonCercle.getPerimetre());
                } else {
                    System.out.println("Veuillez d'abord créer un cercle.");
                }
                break;
	        case 4:
	        	if (MonCercle != null) {
	        		MonCercle.decrementerCompteur();
	        		MonCercle = null;
	        	}else {
	        		System.out.println("Aucun Cercle a supprimer");
	        	}
                break;
	        case 5:
	        	System.out.println("a bientot dans la fabrique a Cercle de Ahmed !!!!!!");
	        	break;
	        default:
	            System.out.println("Choix invalide !");
			}
		}while(choix != 5); // sort de la categorie quand on tape 5
	}
	public static void FaireUnEllipse() {
		
		int choix;
		do {
		//menu
			System.out.println("\n================ MENU ELLIPSE ================");
			System.out.println("1 - Créer une ellipse :  ");
			System.out.println("2 - Calculer la surface :  ");
			System.out.println("3 - Calculer le périmètre : ");
			System.out.println("4 - Supprimer l Ellipse : ");
			System.out.println("5 - Quitter le menu :");
			System.out.println("Votre choix : ");
			choix = In.readInteger();
			
			switch (choix) {
	        case 1:
	        	 System.out.print("Entrez le demi-grand axe (a) : ");
                 double a = In.readInteger();
                 System.out.print("Entrez le demi-petit axe (b) : ");
                 double b = In.readInteger();
                 try {
                     MonEllipse = new ellipse(a, b);
                     System.out.println("Ellipse créée avec succès !");
                 } catch (IllegalArgumentException e) {
                     System.out.println("Erreur : " + e.getMessage());
                 }
                 break;
	        case 2:
	        	if (MonEllipse != null) {
                    System.out.println("Surface = " + MonEllipse.getSurface());
                } else {
                    System.out.println("Veuillez d'abord créer une ellipse.");
                }
                break;
	        case 3:
	        	 if (MonEllipse != null) {
                     System.out.println("Périmètre (approx) = " + MonEllipse.getPerimetre());
                 } else {
                     System.out.println("Veuillez d'abord créer une ellipse.");
                 }
                 break;
	        case 4:
	        	if(MonEllipse != null) {
	        		ellipse.decrementerCompteur();
	        		MonEllipse = null;
	        	}else {
	        		System.out.println("Aucune Ellipse a supprimer");
	        	}
	        	break;
	        case 5:
	        	System.out.println("a bientot dans la fabrique a Ellipse de Ahmed !!!!!!");
                break;
	        default:
	            System.out.println("Choix invalide !");
			}
		}while(choix <= 5); // sort de la categorie quand on tape 5
		
	}
	public static void FaireUnTriangleQuelconque() {
		
		int choix;
		do {
		//menu
			System.out.println("\n================ MENU TRIANGLEQUELCONQUE ================");
			System.out.println("1 - Créer un triangle avec 3 côtés :  ");
			System.out.println("2 - Créer un triangle avec 2 côtés + 1 angle :  ");
			System.out.println("3 - Calculer le périmètre : ");
			System.out.println("4 - Calculer la surface : ");
			System.out.println("5 - Supprimer le triangle : ");
			System.out.println("6 - Quitter le menu : ");
			System.out.println("Votre choix : ");
			choix = In.readInteger();
			
			switch (choix) {
	        case 1:
	        	 System.out.print("Entrez le côté a : ");
                 double a = In.readInteger();
                 System.out.print("Entrez le côté b : ");
                 double b = In.readInteger();
                 System.out.print("Entrez le côté c : ");
                 double c = In.readInteger();
                 try {
                	 MonTriangleQuelconque = new TriangleQuelconque(a, b, c);
                     System.out.println("Triangle créé avec succès !");
                 } catch (IllegalArgumentException e) {
                     System.out.println("Erreur : " + e.getMessage());
                 }
                 break;
	        case 2:
	        	System.out.print("Entrez le côté a : ");
                double a2 = In.readInteger();
                System.out.print("Entrez le côté b : ");
                double b2 = In.readInteger();
                System.out.print("Entrez l'angle (en degrés) : ");
                double angle = In.readInteger();
                try {
                    MonTriangleQuelconque = new TriangleQuelconque(a2, b2, angle);
                    System.out.println("Triangle créé avec succès !");
                } catch (IllegalArgumentException e) {
                    System.out.println("Erreur : " + e.getMessage());
                }
                break;
	        case 3:
	        	 if (MonTriangleQuelconque != null) {
                     System.out.println("Périmètre = " + MonTriangleQuelconque.getPerimetre());
                 } else {
                     System.out.println("Veuillez d'abord créer un triangle.");
                 }
                 break;
	        case 4:
	        	if (MonTriangleQuelconque != null) {
                    System.out.println("Surface = " + MonTriangleQuelconque.getSurface());
                } else {
                    System.out.println("Veuillez d'abord créer un triangle.");
                }
                break;
	        case 5:
	        	if(MonTriangleQuelconque != null) {
	        		TriangleQuelconque.decrementerCompteur();
	        		MonTriangleQuelconque = null;
	        	}else {
	        		System.out.println("Aucun Triangle a supprimer");
	        	}
	        	break;
	        case 6:
	        	System.out.println("a bientot dans la fabrique a TriangleQuelconque de Ahmed !!!!!!");
	        	break;
	        default:
	            System.out.println("Choix invalide !");
			}
		}while(choix <= 6); // sort de la categorie quand on tape 6
		
	}
	public static void FaireUnHexagoneIrregulier() {
		
		int choix;
		do {
		//menu
			System.out.println("\n================ MENU EXAGONEIRREGULIER ================");
			System.out.println("1 - Créer l'hexagone (entrer 6 sommets) :  ");
			System.out.println("2 - Calculer le périmètre : ");
			System.out.println("3 - Calculer la surface : ");
			System.out.println("4 - Supprimer LHexagone : ");
			System.out.println("Votre choix : ");
			choix = In.readInteger();
			
			switch (choix) {
	        case 1:
	        	double[][] sommets = new double[6][2];
                for (int i = 0; i < 6; i++) {
                    System.out.print("Sommet " + (i+1) + " - x : ");
                    sommets[i][0] = In.readInteger();
                    System.out.print("Sommet " + (i+1) + " - y : ");
                    sommets[i][1] = In.readInteger();
                }
                MonHexagoneIrregulier = new HexagoneIrregulier(sommets);
                System.out.println("Hexagone créé avec succès !");
                break;
	        case 2:
	        	if (MonHexagoneIrregulier != null) {
                    System.out.println("Périmètre = " + MonHexagoneIrregulier.getPerimetre());
                } else {
                    System.out.println("Veuillez d'abord créer un hexagone.");
                }
                break;
	        case 3:
	        	if (MonHexagoneIrregulier != null) {
                    System.out.println("Surface = " + MonHexagoneIrregulier.getSurface());
                } else {
                    System.out.println("Veuillez d'abord créer un hexagone.");
                }
                break;
	        case 4:
	        	if(MonHexagoneIrregulier != null) {
	        		HexagoneIrregulier.decrementerCompteur();
	        		MonHexagoneIrregulier = null;
	        	}else {
	        		System.out.println("Aucun Exagoneirregulier a supprimer");
	        	}
	        	break;
	        case 5:
	        	System.out.println("a bientot dans la fabrique a Exagoneirregulier de Ahmed !!!!!!");
	        	break;
	        default:
	        	System.out.println("Choix invalide !");
			}
		}while(choix <= 5); // sort de la categorie quand on tape 5
		
		
	}
}

package Main;

import java.util.Scanner;

import Jeu.Plateau;
import Personage.Personage;




public class Game {

	
	public static  Integer menuPrincipale()
		{
			Scanner sc = new Scanner(System.in);
			Integer retour=0;
			
			while (retour<1 || retour>3)
				{
					System.out.println("Que voulez vous faire?");
					System.out.println("1) Jouer");
					System.out.println("2) Voire les scores");
					System.out.println("3) Créer votre propre carte");
					retour = Integer.parseInt(sc.next());
				}
			
			return retour;
			
		}
	public static Integer lancementApplication (Integer choix, Personage joueur)
		{
			Scanner sc = new Scanner(System.in);
			
			switch (choix) {
			case 1:
				sokoban();
				break;
			case 2:
				score();
				break;

			case 3:
				creerSonProporeNiveau();
				break;


			default:
				break;
			}
			
			Integer quitter=0;
			while (quitter<1 || quitter>3)
				{
					System.out.println("Quitter?");
					System.out.println("1) Oui");
					System.out.println("2) Non");
					quitter = Integer.parseInt(sc.next());
				}
			return quitter;
		}
	public static void sokoban()
		{
			Plateau plat = new Plateau();
			plat.chargerPlateauDepuisFichier("lv1.txt");
			plat.afficherPlateau();
			plat.jeu();
		}
	public static void score()
		{
			
		}
	public static void creerSonProporeNiveau()
		{
			
		}
	
}

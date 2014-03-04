package Main;

import java.util.Scanner;

import Jeu.ListeScore;
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
					System.out.println("3) Cr�er votre propre carte");
					retour = Integer.parseInt(sc.next());
				}
			
			return retour;
			
		}
	public static Integer lancementApplication (Integer choix, Personage joueur)
		{
			Scanner sc = new Scanner(System.in);
			
			switch (choix) {
			case 1:
				sokoban(joueur);
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
	public static void sokoban(Personage joueur)
		{
			
			boolean resteDansJeu= true;
			System.out.println("Les services de Sa Majest� la reine ont perdu dans leur entrepot l'arche bien nom�.");
			System.out.println("Les responsables ont appel� Indiana Jones � la rescousse, se disant que si il l'avait d�ja retrouv�e une fois, il pourait bien la retrouver une seconde fois");
			System.out.println("Ce pendant, ce dernier est un peut trop occup� en ce moment avec les extra-terrestre (ou sa blonde). Il vous a donc mandat� pour le remplacer.");
			System.out.println("Vous montrerez vous � la hauteur d'un h�ros tels que lui?");
			while(joueur.getLevel()<11 && resteDansJeu)
				{
					Plateau plat = new Plateau();
					plat.chargerPlateauDepuisFichier("lv"+(joueur.getLevel()).toString()+".txt");
					resteDansJeu=plat.jeu(joueur);
					
					
				}
			if (joueur.getLevel().equals(10))
				{
					System.out.println("Bravo, vous avez retrouv� l'arche qui n'est plus perdu.");
				}
		}
	public static void score()
		{
			Integer niveau;
			niveau = menuDesScores();
			ListeScore liste = new ListeScore(niveau);
			//liste.genererListeAPartirDuFichier(1);
			liste.genererListeAPartirDesFichier();
			liste.afficherLesScores();
			

		
		}
	public static void creerSonProporeNiveau()
		{
			
		}
	public static Integer menuDesScores()
		{
			Integer niveau=0;
			Scanner sc = new Scanner(System.in);
			while (niveau<1 || niveau>10)
				{
					System.out.println("De quel niveau souhaitez vous voire les scores? (entre 1 et 10)");
					
					niveau = Integer.parseInt(sc.next());
				}
			return niveau;
		}
	
}


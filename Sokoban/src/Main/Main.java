package Main;

/*
 *development team:
 *	Salim R�da-Said
 *	S�bastien Boulanger 
 *	Simon Hoggart
 *	S�bastien de Beauffort
 *
 *Dans le cadre du projet Java de 2em bac de Supinfo
 * 
 * 
 *
 */

import Personage.Personage;
//� faire: main(--level, --score, --create), loader fichier (classe table), 
public class Main {

	public static void main(String[] args) {
		
		Personage joueur = new Personage();
		Integer quitter=0;
		while (quitter!=1)
			{
				Integer choixMenu=0;
				if (args.length!=0)
					{
						if (args[0]=="level")
							{
								choixMenu=1;
									if (args[1]!=null)
										{
											joueur.setLevel(Integer.parseInt(args[1]));
										}		
							}
						else if (args[0]=="score")
							{
								choixMenu=2;
							}
						else if (args[0]=="create")
							{
								choixMenu=3;
							}
						else
							{
								choixMenu= Game.menuPrincipale();
							}
					}
				else
				{
					choixMenu= Game.menuPrincipale();
				}
				
				
				quitter=Game.lancementApplication (choixMenu, joueur); //cette ligne lance l'application choisie et retourne le choix de l'utilisateur si il a d�cid� de quitter l'application � la fin
			}
		

	}

}

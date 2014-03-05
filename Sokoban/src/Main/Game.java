package Main;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import Jeu.ListeScore;
import Jeu.Plateau;
import Personage.Personage;




public class Game {

	
	public static  Integer menuPrincipale()
		{
			Scanner sc = new Scanner(System.in);
			Integer retour=0;
			
			while (retour<1 || retour>4)
				{
					System.out.println("Que voulez vous faire?");
					System.out.println("1) Jouer");
					System.out.println("2) Voire les scores");
					System.out.println("3) Cr�er votre propre carte");
					System.out.println("4) Lancer le jeu sur une de vos propres cartes");
					retour = Integer.parseInt(sc.next());
				}
			
			return retour;
			
		}
	public static Integer lancementApplication (Integer choix, Personage joueur) throws IOException
		{
			Scanner sc = new Scanner(System.in);
			Scanner scan = new Scanner(System.in);
			Integer quitter=0;
			
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
			case 4:
				sokobanCustom(joueur);
				
				break;


			default:
				break;
			}
			
			
			while (quitter<1 || quitter>3)
			{
				System.out.println("Quitter?");
				System.out.println("1) Oui");
				System.out.println("2) Non");
				quitter = Integer.parseInt(scan.next());
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
					plat.chargerPlateauDepuisFichier("lv"+(joueur.getLevel()).toString()+".sok");
					resteDansJeu=plat.jeu(joueur);
					
					
				}
			if (joueur.getLevel().equals(11))
				{
					System.out.println("Bravo, vous avez retrouv� l'arche qui n'est plus perdu.");
					joueur.setLevel(1);
				}
		}
	public static void sokobanCustom(Personage joueur)
		{
			String[] listePlateauCustom;
			//this.setTailleDuTableauPlateauCustom();
			System.out.println("Quel niveau souhaitez vous lancer.");
			Scanner sc = new Scanner(System.in);
			Integer choix;
			boolean resteDansJeu= true;
			
			try
				{      
		         
					File dossier = new File("custom//");
			         
			         
					listePlateauCustom = dossier.list();
			         
			         Integer i=0;
			         Integer n;
			         
			         
			         for (String fichier : listePlateauCustom)
			         	{
			        	 	
			        	 	n=i+1;
			        	 	System.out.println(n+". "+fichier);
			        	 	i++;
			         	}
			         choix = Integer.parseInt(sc.next());
			         String niveauChoisi=listePlateauCustom[choix-1];
			         
			         Plateau plat = new Plateau();
			         plat.chargerPlateauDepuisFichier("custom//"+niveauChoisi);
			         resteDansJeu=plat.jeu(joueur);
			         
			         
				}
			catch (Exception e)
			{
				System.out.println(e.toString());
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
	public static void creerSonProporeNiveau() throws IOException
		{
			mapCreator();
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
	public static void mapCreator() {
		
		
		Scanner sc = new Scanner(System.in); //Scanner les touches entr�es
		Integer cpt =0;
		Integer lgmax =0;
		String niveau;
		boolean enreg=true;
		boolean terminator = false; //Permet de savoir si l'utilisateur fini ou pas de cr�er la map
		System.out.println("Bienvenue sur le map creator !\n");
		System.out.println("Convention de Nommage :\n = -> mur\n X -> joueur\n B -> boite\nO -> emplacement\n. -> espace vide");
		System.out.println("Si vous voulez retourner � la ligne, pressez Enter.\nPour arreter la saisie du niveau, appuyez sur P sur une ligne unique.\n");
		System.out.println("Veuillez donner un nom a votre niveau : ");
		niveau = "custom//"+sc.nextLine()+".sok";
		PrintWriter writer = null;
		Integer choix=2;
		File fichier =new File(niveau);
		
		System.out.println("Vous pouvez maintenant editer votre map.\n");
		
		
		try{
			
				writer = new PrintWriter(niveau);
				
				
				
				
			while(terminator == false){
				
				
				char[] line = sc.next().toCharArray();
				
				boolean marqueur = true;
				System.out.println("Ligne inscrite");//ok
				System.out.println(line);//ok
				String ligne="";
				String separator = System.getProperty("line.separator");
			
				for(int i =0; i<line.length; i++){
					//prise en charge des minuscules
					switch (line[i]) 
		    		{
		    			case 'p':
		    				line[i]='P';
		    				break;
						case 'o':
							line[i]='O';
							break;
						case 'b':
							line[i]='B';
							break;
						case 'x':
							line[i]='X';
							break;
						default:
							break;
					}
					//pour pr�parer la mise dans le fichier
					ligne = ligne + Character.toString(line[i]);
				}							
				ligne= ligne+separator;
				//System.out.println("String "+ligne);
				
				//verifiction que la premiere ligne contiens que des �gales
				if(cpt.equals(0)){
					cpt++;
					for(int i=0;i<line.length-1;i++){
						if(line[i]!='='){
							System.out.println("La premiere ne peut contenir que des \"=\".\nRecommencez la ligne.\n");
				    		enreg=false;
						}
					}
				}
				//verification qu'il y a bien un �gale au debut et � la fin de la ligne
				else if((line[0]!='=' || line[line.length-1]!='=')&&line[0]!='P'){
					System.out.println("Vous avez fait une erreur aux extremites du tableau.\nRecommencez la ligne.\n");
					enreg=false;
				}
				
			    
			    for(int i=0; i<line.length-1; i++){
			    	//l'on stoque dans lgmax la longeur de la plus grande ligne (pour pouvoire fabriquer la derniere ligne
			    	if (i>lgmax)
			    	{
			    		lgmax=i;
			    	}
			    	//verification que la ligne ne contiens que des caracteres valides
			    	if(line[i]!='X'&&line[i]!='B'&&line[i]!='.'&&line[i]!= '='&&line[i]!='O'){
			    		System.out.println("Vous avez une erreur. "+line[i]+" n'est pas un caractere correct.\nRecommencez la ligne.\n");
			    		marqueur = false;
			    		break;
			    	}
			    	
		    	
			    	
			    
			    }	
			    if(line[0]=='P'){
			    	//sortie de boucle
		    		terminator= true;
		    		ligne="";
		    		//mise en place de la derniere ligne avec que des =
		    		for (int j=0; j<=lgmax;j++)
		    		{
		    			ligne=ligne+"=";
		    		}
		    		
		    		System.out.println("Votre niveau est pret. Bon jeu !");}
				if(marqueur && enreg){
			    writer.append(ligne);
				}
			}
			
			
		}catch (IOException e){
			e.printStackTrace();
		} 
		finally{
			if (writer != null){writer.close();}
			//sc.close();
		}
		
	}
	
}


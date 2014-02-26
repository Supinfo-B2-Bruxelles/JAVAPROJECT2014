package Jeu;

import java.lang.reflect.Array;

public class Plateau {
	private Case tabCases [][];

	public Case getTabCases(Integer x, Integer y) {
		return tabCases[x][y];
	}

	//x et y représentent les dimentions du tableau
	public void setTabCases(Integer x, Integer y) {
		
		for (int i = 0; i < y; i++) { //verticale
			for (int j = 0; j < x; j++) { //horizontale
				
				tabCases[i][j] = new Case(" ");
			}
		}
		this.tabCases = tabCases;
	}
	
	public Plateau()
	{
		
	}
	
	

}

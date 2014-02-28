package Jeu;

import Personage.Personage;

public class Score {
	
	private Integer nombreDeplacement;
	private long timeStampDebut;
	private long timeStampFin;
	private String nom;
	private Integer level;
	
	public Integer getNombreDeplacement() {
		return nombreDeplacement;
	}
	public void setNombreDeplacement(Integer nombreDeplacement) {
		this.nombreDeplacement = nombreDeplacement;
	}
	public long getTimeStampDebut() {
		return timeStampDebut;
	}
	public void setTimeStampDebut(long timeStampDebut) {
		this.timeStampDebut = timeStampDebut;
	}
	public long getTimeStampFin() {
		return timeStampFin;
	}
	public void setTimeStampFin(long timeStampFin) {
		this.timeStampFin = timeStampFin;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	
	public Score(Personage joueur, Plateau plat) 
		{
			this.setLevel(joueur.getLevel());
			this.setNom(joueur.getNom());
			this.setNombreDeplacement(plat.getNombreDeplacement());
			this.setTimeStampDebut(plat.getTimeStampDebut());
			this.setTimeStampFin(plat.getTimeStampFin());
		}

}

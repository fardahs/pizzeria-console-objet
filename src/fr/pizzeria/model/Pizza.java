package fr.pizzeria.model;

public class Pizza {
	int id;
	String code;
	String libelle;
	double prix;

	//Constructeur
	public Pizza(int id, String code, String libelle, double prix){
		this.id = id;
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
		
	}
	
	
	public Pizza(String code, String libelle, double prix) {
		this.id++;
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
	}


	public void affiche(){
		System.out.println(code + " -> " + libelle + "(" + prix + "€)");
	}
	
	public void ajoutPizza(){
		
	}
}

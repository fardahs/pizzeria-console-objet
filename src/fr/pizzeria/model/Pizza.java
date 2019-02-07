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
	
	//Constructeur
	public Pizza(String code, String libelle, double prix) {
		this.id++;
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
	}

	//Formatage sur de l'affichage des pizzas
	public void affiche(){
		System.out.println(code + " -> " + libelle + "(" + prix + "€)");
	}

	//Récupère valeur du code
	public String getCode() {
		return code;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	
	
}

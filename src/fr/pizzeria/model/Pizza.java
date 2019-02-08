package fr.pizzeria.model;

public class Pizza {
	public static int id; 
	String code;
	String libelle;
	double prix;

	//Constructeur
	public Pizza(int id, String code, String libelle, double prix){
		Pizza.id = id;
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
		
	}
	
	//Constructeur
	public Pizza(String code, String libelle, double prix) {
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
	}

	//Formatage sur l'affichage des pizzas
	public void affiche(){
		System.out.println(code + " -> " + libelle + "(" + prix + "€)");
	}

//	********** Récuppère ou modifie la valeur ************
	
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

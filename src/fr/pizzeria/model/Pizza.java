package fr.pizzeria.model;
/**
 * Model de la pizza
 * @author Farda
 *
 */

public class Pizza {
	public static int id; 
	String code;
	String libelle;
	double prix;
	CategoriePizza categoriePizza;

	//Constructeur
	public Pizza(int id, String code, String libelle, double prix, CategoriePizza categoriePizza){
		Pizza.id = id;
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
		this.categoriePizza = categoriePizza;
		
	}
	
	//Constructeur
	public Pizza(String code, String libelle, double prix, CategoriePizza categoriePizza) {
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
	}

	//Formatage sur l'affichage des pizzas
	public void affiche(){
		System.out.println(code + " -> " + libelle + "(" + prix + "€)" + " " +categoriePizza.getCategorie());
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

	public CategoriePizza getCategoriePizza() {
		return categoriePizza;
	}

	public void setCategoriePizza(CategoriePizza categoriePizza) {
		this.categoriePizza = categoriePizza;
	}
	
	
	
}

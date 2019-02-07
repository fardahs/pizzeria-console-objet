package fr.pizzeria.dao;

import com.sun.xml.internal.bind.v2.model.util.ArrayInfoUtil;

import fr.pizzeria.model.Pizza;

public class PizzaMemDao implements IPizzaDao {

	

	//Tableau des pizzas
	private Pizza[] arrayPizza = new Pizza[0];
	
			
	@Override
	public Pizza[] findAllPizzas() {
		//Affiche tout les pizzas dans le tableau
		for(int i=0; i< arrayPizza.length; i++){
			arrayPizza[i].affiche();
		}
		return arrayPizza;
	}

	@Override
	public void saveNewPizza(Pizza pizza) {
		//On agrandi la taille du tableau
		Pizza tempArray[] = new Pizza[arrayPizza.length + 1];
		
		//Copie du tableau initial au tableau temporaire
		for (int i = 0; i<arrayPizza.length; i++){
			tempArray[i] = arrayPizza[i];
		}
		
		tempArray[arrayPizza.length] = pizza;
		arrayPizza = tempArray;

	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza) {
		
		for(int i = 0; i<arrayPizza.length;i++){
			
			if(arrayPizza[i].getCode().equals(codePizza)){
				
				arrayPizza[i].setCode(pizza.getCode());
				arrayPizza[i].setLibelle(pizza.getLibelle());
				arrayPizza[i].setPrix(pizza.getPrix());
				
				
			}
			
		}
	}

	@Override
	public void deletePizza(String codePizza) {
		// On afiiche la liste des pizzas
		findAllPizzas();
		
		//Définition d'un tableau temporaire avec une plus petite taille
		Pizza tempArray[] = new Pizza[arrayPizza.length-1];
		
		//variable compteur temporaire
		int compteur = 0;
		
		for (int i = 0; i<arrayPizza.length; i++){
			//On ajoute tout les pizzas différents au codePizza rechercher, dans le tableau temporaire
			if(!arrayPizza[i].getCode().equals(codePizza)){
				tempArray[compteur] = arrayPizza[i];
				compteur ++;
			}
		}
		//liste pizza avec élément supprimer
		arrayPizza = tempArray;

	}

	@Override
	public Pizza findPizzaByCode(String codePizza) {
		Pizza pizza = null;
		
		for (int i = 0; i<arrayPizza.length; i++){
			//Test sur le codePizza
			if(pizzaExists(codePizza) == true){
				pizza = arrayPizza[i];
			}
		}
		return pizza;
	}

	@Override
	public boolean pizzaExists(String codePizza) {
		//vrai si la pizza existe
		boolean existe = false;
		
		for (int i = 0; i<arrayPizza.length; i++){
			//Test sur le codePizza
			if(arrayPizza[i].getCode().equals(codePizza)){
				existe = true;
			}
		}
		return existe;
	}

}

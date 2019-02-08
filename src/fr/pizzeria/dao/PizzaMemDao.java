package fr.pizzeria.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.Pizza;

/**
 * Gestion stockage des informations
 * @author Diginamic
 * La classe implémente l'interface IPizzaDao dans laquelle on implémente toute les opérations du CRUD du tableau
 */
public class PizzaMemDao implements IPizzaDao {

	//Tableau des pizzas
	private List<Pizza> arrayPizza = new ArrayList<Pizza>();

	/**
	 * La méthode liste toute les pizzas
	 */
	@Override
	public List<Pizza> findAllPizzas() {
		//Trouve tout les pizzas
		for(Pizza p:arrayPizza){
			p.affiche();
		}
		return arrayPizza;
	}

	/**
	 * La méthode enregistre une nouvelle pizza
	 * @param Pizza
	 * @throws SavePizzaException 
	 */
	@Override
	public void saveNewPizza(Pizza pizza) throws SavePizzaException {
		//Retourne une exception si le prix 
		if (pizza.getPrix() < 0){
			throw new SavePizzaException("Le prix doit être supérieur à 0");
		}
		
		//Ajout d'une nouvelle pizza
		arrayPizza.add(pizza);
	}
	
	
	/**
	 * La méthode met à jour une pizza
	 * @param codePizza pizza
	 * @throws UpdatePizzaException
	 */
	@Override
	public void updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException{
		

		//Parcours sur la liste de pizza
		Iterator<Pizza> iterator = arrayPizza.iterator();
		
		while (iterator.hasNext()) {
			//Le pizza suivant
			pizza = (Pizza) iterator.next();

			//Si le code du pizza est égale au code rechercher
			if(pizza.getCode().equals(codePizza)){

				//On modifie les valeurs
				pizza.setCode(pizza.getCode());
				pizza.setLibelle(pizza.getLibelle());
				pizza.setPrix(pizza.getPrix());
				
				return;
			}
			
			
		}
		
		

	}
	/**
	 * La méthode surpprime une pizza
	 * @param codePizza
	 */

	@Override
	public void deletePizza(String codePizza) throws DeletePizzaException {
		if(!pizzaExists(codePizza)){
			throw new DeletePizzaException("Ce code n'existe pas");
		}
		//Parcours sur la liste de pizza
		Iterator<Pizza> iterator = arrayPizza.iterator();
		while (iterator.hasNext()) {
			
			//Le pizza suivant
			Pizza pizza = (Pizza) iterator.next();
			
			//Si le code du pizza est égale au code rechercher
			if(pizza.getCode().equals(codePizza)){
				//Supprime la pizza
				iterator.remove();
			}

		}
	}
	
	/**
	 * La méthode trouve une pizza à partir de son code
	 * @param codePizza
	 */
	@Override
	public Pizza findPizzaByCode(String codePizza) {
		Pizza pizza = null;

		for (Pizza p:arrayPizza){
			
			//Si le pizza rechercher par le code existe
			if(pizzaExists(codePizza) == true){
				//Pizza trouve
				pizza = p;
			}
		}
		return pizza;
	}

	/**
	 * La méthode vérifie si une pizza existe à partir du code 
	 * @param codePizza
	 */
	@Override
	public boolean pizzaExists(String codePizza) {
		//vrai si la pizza existe
		boolean existe = false;

		//Parcours sur la liste de pizza
		Iterator<Pizza> iterator = arrayPizza.iterator();

		while (iterator.hasNext()) {

			//Le pizza suivant
			Pizza pizza = (Pizza) iterator.next();

			//Si le code du pizza est égale au code rechercher
			if(pizza.getCode().equals(codePizza)){
				//On retourne vrai
				existe = true;
			}

		}


		return existe;
	}

}

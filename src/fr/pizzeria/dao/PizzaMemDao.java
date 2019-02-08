package fr.pizzeria.dao;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import fr.pizzeria.model.Pizza;

public class PizzaMemDao implements IPizzaDao {

	//Tableau des pizzas
	private List<Pizza> arrayPizza = new ArrayList<Pizza>();

	@Override
	public List<Pizza> findAllPizzas() {
		//Trouve tout les pizzas
		for(Pizza p:arrayPizza){
			p.affiche();
		}
		return arrayPizza;
	}

	@Override
	public void saveNewPizza(Pizza pizza) {
		//Ajout d'une nouvelle pizza
		arrayPizza.add(pizza);
	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza) {

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
			}

		}

	}

	@Override
	public void deletePizza(String codePizza) {

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

	@Override
	public Pizza findPizzaByCode(String codePizza) {
		Pizza pizza = null;

		for (Pizza p:arrayPizza){
			
			//Si le pizza rechercher par le code existe
			if(pizzaExists(codePizza) == true){
				//Pizza trouve
				pizza = p;
			}else{
				System.out.println("Le pizza avec le code "+ codePizza + " n'existe pas");
			}
		}
		return pizza;
	}

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

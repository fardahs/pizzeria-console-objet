package fr.pizzeria.service;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class ModifierPizzaService extends MenuService{

	@Override
	public void executeUC(Scanner questionUser, IPizzaDao pizzaDao) throws UpdatePizzaException {
		
		System.out.println("Mise à jour d’une pizza \n");
		//Afffiche tout les pizzas
		pizzaDao.findAllPizzas();
		
		questionUser.nextLine();
		System.out.println("Saisir le code du pizza a modifier \n");
		String modifCode = questionUser.next();
		
		//Recherche pizza par le code 
		Pizza pizzaTrouver = pizzaDao.findPizzaByCode(modifCode);
		
		if(!pizzaDao.pizzaExists(modifCode)){
			throw new UpdatePizzaException("Ce code n'existe pas");
		}
		
		//Si le pizza existe alors on demande à l'utilisateur de saisir les nouveaux informations
		if(pizzaDao.pizzaExists(modifCode)){
			System.out.println("Saisir le nouveau code");
			 pizzaTrouver.setCode(questionUser.next());
			 
			 System.out.println("Saisir le nouveau libelle");
			 pizzaTrouver.setLibelle(questionUser.next());
			 
			 System.out.println("Saisir le nouveau prix");
			 pizzaTrouver.setPrix(questionUser.nextDouble());
			 
			 System.out.println("Saisir la nouvelle catégorie");
			 CategoriePizza typePizza = CategoriePizza.valueOf(questionUser.next());
			 
			 //Parcours sur les categories pizzas
			 for (CategoriePizza cat : CategoriePizza.values()) {
				 
				 //On test la catégorie de la pizza et on modifie sa valeur
					if(cat.equals(typePizza.POISSON)){
						pizzaTrouver.setCategoriePizza(typePizza);
						
					}else if(cat.equals(typePizza.VIANDE)){
						
						pizzaTrouver.setCategoriePizza(typePizza);
						
					}else if(cat.equals(typePizza.SANS_VIANDE)){
						pizzaTrouver.setCategoriePizza(typePizza);
					}
				}
			 
			 
			 if(pizzaTrouver.getPrix() < 0){
				 throw new UpdatePizzaException("Le prix doit être suppérieur à 0");
			 }
			 //Mise à jour du pizza		
			 pizzaDao.updatePizza(modifCode, pizzaTrouver);
		}
	}

}

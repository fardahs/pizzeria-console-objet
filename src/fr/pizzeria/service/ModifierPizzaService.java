package fr.pizzeria.service;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.model.Pizza;

public class ModifierPizzaService extends MenuService{

	@Override
	public void executeUC(Scanner questionUser, IPizzaDao pizzaDao) {
		
		System.out.println("Mise à jour d’une pizza \n");
		//Afffiche tout les pizzas
		pizzaDao.findAllPizzas();
		
		questionUser.nextLine();
		System.out.println("Saisir le code du pizza a modifier \n");
		String modifCode = questionUser.next();
		
		//Recherche pizza par le code 
		Pizza pizzaTrouver = pizzaDao.findPizzaByCode(modifCode);
		
		//Si le pizza existe alors on demande à l'utilisateur de saisir les nouveaux informations
		if(pizzaDao.pizzaExists(modifCode)){
			System.out.println("Saisir le nouveau code");
			 pizzaTrouver.setCode(questionUser.next());
			 
			 System.out.println("Saisir le nouveau libelle");
			 pizzaTrouver.setLibelle(questionUser.next());
			 
			 System.out.println("Saisir le nouveau prix");
			 pizzaTrouver.setPrix(questionUser.nextDouble());
			 
			 //Mise à jour du pizza
			 pizzaDao.updatePizza(modifCode, pizzaTrouver);
		}
	}

}

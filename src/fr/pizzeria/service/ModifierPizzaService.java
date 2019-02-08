package fr.pizzeria.service;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.Pizza;

public class ModifierPizzaService extends MenuService{

	@Override
	public void executeUC(Scanner questionUser, IPizzaDao pizzaDao) throws UpdatePizzaException {
		
		System.out.println("Mise � jour d�une pizza \n");
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
		
		//Si le pizza existe alors on demande � l'utilisateur de saisir les nouveaux informations
		if(pizzaDao.pizzaExists(modifCode)){
			System.out.println("Saisir le nouveau code");
			 pizzaTrouver.setCode(questionUser.next());
			 
			 System.out.println("Saisir le nouveau libelle");
			 pizzaTrouver.setLibelle(questionUser.next());
			 
			 System.out.println("Saisir le nouveau prix");
			 pizzaTrouver.setPrix(questionUser.nextDouble());
			 
			 if(pizzaTrouver.getPrix()<0){
				 throw new UpdatePizzaException("Le prix doit �tre supp�rieur � 0");
			 }
			 //Mise � jour du pizza		
			 pizzaDao.updatePizza(modifCode, pizzaTrouver);
		}
	}

}

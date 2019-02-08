package fr.pizzeria.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.model.Pizza;

public class AjouterPizzaService extends MenuService {

	@Override
	public void executeUC(Scanner questionUser, IPizzaDao pizzaDao) {
		System.out.println("Ajout d’une nouvelle pizza \n");
		System.out.println("Veuillez saisir le code :");
		String saisiCode = questionUser.next();
		
		System.out.println("Veuillez saisir le nom (sans espace) :");
		String saisiNom = questionUser.next();

		System.out.println("Veuillez saisir le prix :");
		double saisiPrix = questionUser.nextDouble();
		
		 
		//Initialisation du nouveau pizza
		Pizza userPizza = new Pizza(saisiCode, saisiNom, saisiPrix);
		//Ajout du nouveau pizza
		pizzaDao.saveNewPizza(userPizza);
		
	}

}

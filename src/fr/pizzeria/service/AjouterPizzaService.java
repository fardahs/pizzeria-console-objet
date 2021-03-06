package fr.pizzeria.service;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;
/**
 * 
 * @author Farda
 *
 */

public class AjouterPizzaService extends MenuService {

	@Override
	public void executeUC(Scanner questionUser, IPizzaDao pizzaDao) throws SavePizzaException {
		System.out.println("Ajout d�une nouvelle pizza \n");
		System.out.println("Veuillez saisir le code :");
		String saisiCode = questionUser.next();

		System.out.println("Veuillez saisir le nom (sans espace) :");
		String saisiNom = questionUser.next();

		System.out.println("Veuillez saisir le prix :");
		double saisiPrix = questionUser.nextDouble();

		System.out.println("Veuillez saisir la cat�gorie (Viande, Sans viande, Poisson) : " );
		String categoriePizza = questionUser.next();
		CategoriePizza typePizza = CategoriePizza.valueOf(categoriePizza);

		//Initialisation du nouveau pizza
		Pizza userPizza = new Pizza(saisiCode, saisiNom, saisiPrix, typePizza);
		//Ajout du nouveau pizza

		pizzaDao.saveNewPizza(userPizza);	




	}

}

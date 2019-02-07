package service;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;

public class ListerPizzasService extends MenuService {

	@Override
	public void executeUC(Scanner questionUser, IPizzaDao pizzaDao) {
		
		System.out.println("Liste des pizzas \n ");
		//Affiche tout les pizzas
		pizzaDao.findAllPizzas();
	}

}

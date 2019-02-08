package fr.pizzeria.console;
import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.PizzaMemDao;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.*;
import fr.pizzeria.service.*;

import java.util.Scanner;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {
		boolean propositionMenu = true;

		IPizzaDao pizzaDao = new PizzaMemDao();

		//Donne la main à l'utilisateur pour la saisie
		Scanner questionUser = new Scanner(System.in);

		try {
			//Initialisation des pizzas
			Pizza maPizza1 = new Pizza(0,"PEP","Pépéroni",12.50);
			Pizza maPizza2 = new Pizza(1,"MAR","Margherita",14.00);
			Pizza maPizza3 = new Pizza(2,"REIN","La Reine",11.50);
			Pizza maPizza4 = new Pizza(3,"FRO","La 4 fromages",12.00);
			Pizza maPizza5 = new Pizza(4,"CAN","La cannibale",12.50);
			Pizza maPizza6 = new Pizza(5,"SAV","La savoyarde",13.00);
			Pizza maPizza7 = new Pizza(6,"ORI","L’orientale",13.50);
			Pizza maPizza8 = new Pizza(7,"IND","L’indienne",14.00);

			//Tableau des pizzas
			pizzaDao.saveNewPizza(maPizza1);
			pizzaDao.saveNewPizza(maPizza2);
			pizzaDao.saveNewPizza(maPizza3);
			pizzaDao.saveNewPizza(maPizza4);
			pizzaDao.saveNewPizza(maPizza5);
			pizzaDao.saveNewPizza(maPizza6);
			pizzaDao.saveNewPizza(maPizza7);
			pizzaDao.saveNewPizza(maPizza8);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		

		while(propositionMenu){

			//Liste menu
			System.out.println("***** Pizzeria Administration *****");
			System.out.println("1. Lister les pizzas \n" + 
					"2. Ajouter une nouvelle pizza \n" + 
					"3. Mettre à jour une pizza \n" +
					"4. Supprimer une pizza \n"+
					"99. Sortir \n");

			int choixUser = questionUser.nextInt();

			//Recupere les services
			MenuService service = MenuServiceFactory.getService(choixUser);
			//S'il est différent de null alors on exécute le service correspondant
			
				
				if (service != null){
					
					try {
						service.executeUC(questionUser, pizzaDao);
						
					} catch (StockageException e) {
						System.out.println(e.getMessage());
					}
					
				} else if (choixUser == 99) {
					System.out.println("Au revoir :( \n");
					propositionMenu = false;
				} else {
					System.out.println("Je n'ai pas compris votre choix");
				}
				
			
			

		}

	}

}






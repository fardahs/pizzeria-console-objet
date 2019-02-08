package fr.pizzeria.service;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.DeletePizzaException;

public class SupprimerPizzaService extends MenuService {


	@Override
	public void executeUC(Scanner questionUser, IPizzaDao dao) throws DeletePizzaException {
		
		questionUser.nextLine();
		System.out.println("Suppression d�une pizza \n");
		dao.findAllPizzas();
		
		System.out.println("Saisir le code du pizza � supprimer \n ");
		String codeSupp = questionUser.nextLine();
		
		//Suppression de la pizza
		dao.deletePizza(codeSupp);
		System.out.println();
	}

}

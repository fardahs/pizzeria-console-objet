package fr.pizzeria.service;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.StockageException;

public abstract class MenuService {
	//Methode abstraite pour exécuté les use case
	public abstract void executeUC(Scanner questionUser, IPizzaDao pizzaDao) throws StockageException;
	
}

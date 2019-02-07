package service;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;

public abstract class MenuService {
	abstract void executeUC(Scanner questionUser, IPizzaDao pizzaDao);
	
}

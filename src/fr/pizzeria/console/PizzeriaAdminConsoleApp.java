package fr.pizzeria.console;
import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.PizzaMemDao;
import fr.pizzeria.model.*;

import java.util.Arrays;
import java.util.Scanner;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {
		boolean propositionMenu = true;
		//
		IPizzaDao pizzaDao = new PizzaMemDao();
		
		//Donne la main à l'utilisateur
		Scanner questionUser = new Scanner(System.in);
		
		
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
		
		while(propositionMenu){
			
			//Liste menu
			System.out.println("***** Pizzeria Administration *****");
			System.out.println("1. Lister les pizzas \n" + 
								"2. Ajouter une nouvelle pizza \n" + 
								"3. Mettre à jour une pizza \n" +
								"4. Supprimer une pizza \n"+
								"99. Sortir \n");
			
			int choixUser = questionUser.nextInt();
			
			
			switch (choixUser) {
			case 1:
				System.out.println("Liste des pizzas \n ");
				//Affiche tout les pizzas
				pizzaDao.findAllPizzas();
				System.out.println();			
				break;
				
			case 2:
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
				break;
				
			case 3:
				
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
				
				break;
				
			case 4:
				
				questionUser.nextLine();
				System.out.println("Suppression d’une pizza \n");
				pizzaDao.findAllPizzas();
				
				System.out.println("Saisir le code du pizza à supprimer");
				String codeSupp = questionUser.nextLine();
				
				//Suppression de la pizza
				pizzaDao.deletePizza(codeSupp);
				break;
			
			case 99:
				System.out.println("Au revoir :( \n");
				propositionMenu = false;
				break;

			default:
				break;
			}
			
		}
	}
	
	
	

}

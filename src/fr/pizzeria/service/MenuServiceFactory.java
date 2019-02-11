package fr.pizzeria.service;
/**
 * param int choixUtilisateur
 * @author Farda
 *
 */

public class MenuServiceFactory {
	
	
	public static MenuService getService(int choixUser){
		
		switch(choixUser){
		case 1 :
			return new ListerPizzasService();
			
		case 2 :
			return new AjouterPizzaService();
			
		case 3 :
			return new ModifierPizzaService();
		
		case 4 :
			return new SupprimerPizzaService();
		
		}

		return null;
		
	}
}

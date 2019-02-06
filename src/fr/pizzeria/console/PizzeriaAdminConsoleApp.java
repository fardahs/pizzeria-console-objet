package fr.pizzeria.console;

import java.util.Scanner;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner questionUser = new Scanner(System.in);
		boolean propositionMenu = true;
		
		while(propositionMenu){
			
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
				break;
				
			case 2:
				System.out.println("Ajout d’une nouvelle pizza \n");
				break;
				
			case 3:
				System.out.println("Mise à jour d’une pizza \n");
				break;
				
			case 4:
				System.out.println("Mise à jour d’une pizza \n");
				break;
				
			case 99:
				System.out.println("Aurevoir :( \n");
				propositionMenu = false;
				break;

			default:
				break;
			}
			
		}
	}
	
	
	

}

package fr.pizzeria.console;
import fr.pizzeria.model.*;

import java.util.Arrays;
import java.util.Scanner;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean propositionMenu = true;
		//Demande à l'utilisateur 
		Scanner questionUser = new Scanner(System.in);
		
		
		//Instanciation des pizzas
		Pizza maPizza1 = new Pizza(0,"PEP","Pépéroni",12.50);
		Pizza maPizza2 = new Pizza(1,"MAR","Margherita",14.00);
		Pizza maPizza3 = new Pizza(2,"REIN","La Reine",11.50);
		Pizza maPizza4 = new Pizza(3,"FRO","La 4 fromages",12.00);
		Pizza maPizza5 = new Pizza(4,"CAN","La cannibale",12.50);
		Pizza maPizza6 = new Pizza(5,"SAV","La savoyarde",13.00);
		Pizza maPizza7 = new Pizza(6,"ORI","L’orientale",13.50);
		Pizza maPizza8 = new Pizza(7,"IND","L’indienne",14.00);
		
		//Tableau des pizzas
		Pizza mesPizza[] = {maPizza1, maPizza2, maPizza3, maPizza4, 
										maPizza5, maPizza6, maPizza7, maPizza8};
		
		
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
				for(int i=0; i< mesPizza.length; i++){
					mesPizza[i].affiche();
				}
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
				
				 
				//instanciation du pizza
				Pizza userPizza = new Pizza(saisiCode, saisiNom, saisiPrix);
				
				Pizza tempArray[] = new Pizza[mesPizza.length + 1];
				
				//copie du tableau initial au tableau temporaire
				for (int i = 0; i<mesPizza.length; i++){
					tempArray[i] = mesPizza[i];
				}
				
				System.out.println(tempArray.length);
				tempArray[mesPizza.length] = userPizza;
				mesPizza = tempArray;
				
				
				break;
				
			case 3:
				System.out.println("Mise à jour d’une pizza \n");
				
				for(int i = 0; i<mesPizza.length; i++){
					mesPizza[i].affiche();
				}
				
				questionUser.nextLine();
				System.out.println("Saisir le code du pizza a modifier \n");
				String modifCode = questionUser.next();
				
				//Pacours la liste des pizzaq
				for(int i = 0; i<mesPizza.length; i++){
					
					//Test si le code est égale au codeuser
					if(mesPizza[i].getCode().equals(modifCode)){
						System.out.println("Saisir le nouveau code");
						String codeNouveau = questionUser.next();
						
						System.out.println("Saisir le nouveau libelle");
						String libelleNouveau = questionUser.next();
						
						System.out.println("Saisir le nouveau prix");
						double prixNouveau = questionUser.nextDouble();
						//Enregistre les mis à jour
						mesPizza[i] = new Pizza(codeNouveau, libelleNouveau, prixNouveau);
					}
				
				}
				
				break;
				
			case 4:
				questionUser.nextLine();
				System.out.println("Mise à jour d’une pizza \n");
				for(int i = 0; i<mesPizza.length; i++){
					mesPizza[i].affiche();
				}
				
				System.out.println("Saisir le code du pizza à supprimer");
				String codeSupp = questionUser.nextLine();
				//Tableau temporaire plus petite
				Pizza tempArray1[] = new Pizza[mesPizza.length-1];
				//variable temporaire
				int compteur = 0;
				
				for (int i = 0; i<mesPizza.length; i++){
					//On met tout les pizzas qui ne correspond pas au code courrant dans le tableau temporaire
					if(!mesPizza[i].getCode().equals(codeSupp)){
						tempArray1[compteur] = mesPizza[i];
						compteur ++;
					}
				}
				//liste pizza avec élément supprimer
				mesPizza = tempArray1;
				
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
